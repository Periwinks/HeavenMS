/*
 * This file is part of the HeavenMS Maple Story Server
 *
 * Copyright (C) 2019 Kelder
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package client.command.commands.gm0;

import client.MapleCharacter;
import client.MapleClient;
import client.command.Command;
import client.command.CommandsExecutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.maps.MapleMap;
import tools.DatabaseConnection;
import tools.MaplePacketCreator;


/**
 *
 * @author Kelder
 */
public class DPSCommand extends Command {
    {
//        setDescription("Test your DPS over 60 seconds");
        setDescription("");
    }
    
    protected long accumulatedDpsScore = 0;     // set a global long to measure the received damage
    private int iterationCounter = 0;           // [Ductape solution] set a counter for total iterations to stop at 1 minute
    private final int timerInSeconds = 60;      // Set the total duration of the timer for the dps check
    MapleCharacter player = null;               // Init the player object
    
    MapleMonster dummy = MapleLifeFactory.getMonster(9001007);  //set the dummy as mob
    
    @Override
    public void execute(MapleClient c, String[] params) {
        DPSCommand _this = this; //create a variable for the current class instance

        player = c.getPlayer(); // assign the current player to the player model
        Timer timer = new Timer(); // start a new Java timer
        
        if(player.getMap().isDojoMap()){
            player.yellowMessage("This command is disabled while you are in the Dojo");
            CommandsExecutor.getInstance().allowCommand = true;
            return;
        }else if(player.isActiveBuffedValue(20001011)){
            player.yellowMessage("This command is disabled when you have Power Explosion active");
            CommandsExecutor.getInstance().allowCommand = true;
            return;
        }
        
                
        
        this.prepareMob(dummy); // Prepare the mob so it will act accordingly
        if(this.setTimer(player, timerInSeconds)){ //If the timer is set correctly continue on
            player.getMap().spawnMonsterOnGroundBelow(dummy, player.getPosition()); // Spawn the Mob underneath the player
            
            //heal the mob every half second
            timer.scheduleAtFixedRate(new TimerTask(){
                @Override
                public void run(){
                    
                    //This function gets called every 500 millisecs (0.5 seconds)
                    //Every half a second i check if the iteration counter is smaller than the expected counter (*2 because of half seconds)
                    //If the time iteration isnt done yet we want to calculate the current DPS done to the mob and heal the mob for that damage
                    //After that we up the iteration and the cycle repeats
                    if(_this.iterationCounter < (timerInSeconds * 2)){ 
                        _this.addCurrentDamageDoneToMob(_this.dummy);
                        _this.healDPSMob(_this.dummy);
                    
                        _this.iterationCounter++;
                    }else{
                        //if the timer hit the preferred time for the DPS counter we want to stop healing the mob and actually want to kill it
                        _this.onTimerCompleted(_this.player, _this.dummy);
                        timer.cancel(); //actually stops the timer 
                    } 
                }
            }, 0, 500);
        }
        
    }
    
    private void prepareMob(MapleMonster mob){
        mob.setLevel(1);                // Set the Mob level to 1 so it can be hit by most players
        mob.disableDrops();             // Stop the Mob from being able to drop items
        mob.setStartingHp(99999999);    // Set the Mob's health to a high number to be sure that it won't die whilst the damage calculations are done
    }
    
    private boolean setTimer(MapleCharacter player, int sec){
        //Check if a player exists or if the supplied seconds aren't a negative or 0
        if (player == null || sec <= 0){
            return false;
        }    
        player.announce(MaplePacketCreator.getClock(sec)); // Set the clock for the player with the appropriate time
        return true;
    }
    
    private void onTimerCompleted(MapleCharacter player, MapleMonster mob){      
        player.announce(MaplePacketCreator.removeClock()); // Remove the clock from the player's screen
        MapleMap map = player.getMap(); // set a new MapleMap object
        map.damageMonster(player, dummy, Integer.MAX_VALUE); // Remove the dummy from the map
        player.yellowMessage("Total of damage dealt to the Dummy: " + Long.toString(this.accumulatedDpsScore));
        if(this.accumulatedDpsScore > player.getDpsScore()){ // Is the current Dps score higher than the one that is saved in the DB?
            player.yellowMessage("Current player DPS score: " + Long.toString(player.getDpsScore()));
            if(player.getDpsScore() > 0){
                player.yellowMessage("You've beaten your previous highscore!");
            }else{
                player.yellowMessage("You've set your DPS highscore!");
            }
            player.setDpsScore(this.accumulatedDpsScore);
            this.saveDpsScore();        
        }else{
            player.yellowMessage("Current best: " + Long.toString(player.getDpsScore()));
        }
        
        
        this.clearDpsCommand();
    }
    
    //save the accumilated DPS to the DB
    private void saveDpsScore(){
        try{
            Connection con = DatabaseConnection.getConnection(); //get the current connection to the DB
            //prepare a statement with variables to send to the DB
            try(PreparedStatement ps = con.prepareStatement("UPDATE characters SET dpsScore = ? WHERE id = ?")){
                ps.setLong(1, this.accumulatedDpsScore);
                ps.setInt(2, player.getId());
                ps.executeUpdate();
            }
            con.close(); //close the connection with the DB
            
        }catch (SQLException e) {
            e.printStackTrace();
            player.yellowMessage("[" + e.getErrorCode() + "] Failed to save your DPS score to the DB.");
            player.yellowMessage("Please contact a staff member with the supplied error code above");
        }
        
    }
    
    //get the current difference between damage done and max HP to determine the damage the player did
    private void addCurrentDamageDoneToMob(MapleMonster mob){
        if(mob.getHp() < mob.getMaxHp()){
            int difference = mob.getMaxHp() - mob.getHp();
            this.accumulatedDpsScore += difference;
        }
    }
    
    //heal the mob for the damage that it received
    private void healDPSMob(MapleMonster mob){
        if(mob.getHp() < mob.getMaxHp()){
            int difference = mob.getMaxHp() - mob.getHp();
            mob.addHp(difference);
        }
    }
    
    //clear both the iterationCounter and accumulatedDpsScore to be able to start a fresh command again 
    private void clearDpsCommand(){
        accumulatedDpsScore = 0;
        iterationCounter = 0;
    }
}
