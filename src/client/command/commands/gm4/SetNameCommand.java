/*
    This file is part of the HeavenMS MapleStory Server, commands OdinMS-based
    Copyleft (L) 2016 - 2018 RonanLana
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation version 3 as published by
    the Free Software Foundation. You may not use, modify or distribute
    this program under any other version of the GNU Affero General Public
    License.
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.
    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package client.command.commands.gm4;

import client.command.Command;
import client.MapleClient;
import client.MapleCharacter;

/**
 * Sets name of a player or self
 * @author Vanilla
 */
public class SetNameCommand extends Command {
    {
        setDescription("");
    }

    @Override
    public void execute(MapleClient c, String[] params) {
        MapleCharacter player = c.getPlayer();
        if (params.length < 1) {
            player.yellowMessage("Syntax: !setname [<oldname>] <new>");
            return;
        }

        try {
            String newName;
            
            if (params.length == 1) {
                // setName <newName>
                newName = params[0];
                changeName(player, newName);
            } else {
                // setName <victimName> <newName>
                String victimName = params[0];
                newName = params[1];
                
                MapleCharacter victim = c.getChannelServer().getPlayerStorage().getCharacterByName(victimName);
                
                if (victim != null) {
                    changeName(player, victim, newName);
                } else {
                    player.yellowMessage("Player '" + victim + "' has not been found on this channel.");
                }
            }
        } catch (Exception e) {
        }
    }
    
    private void changeName(MapleCharacter c, String newName) {
        changeName(c, c, newName);
    }
    
    private void changeName(MapleCharacter source, MapleCharacter victim, String newName) {
        if (MapleCharacter.canCreateChar(newName)) {
            victim.changeName(newName);
            victim.equipChanged();
            source.yellowMessage("Victim's name has been successfully changed to " + newName);
        }
        else {
            source.yellowMessage("The name " + newName + " is already in use f4");
        }
    }
}