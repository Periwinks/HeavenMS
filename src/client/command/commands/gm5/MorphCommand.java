/*
 * This file is part of the HeavenMS Maple Story Server
 *
 * Copyright (C) 2019 Vanilla
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
package client.command.commands.gm5;

import client.MapleBuffStat;
import client.command.Command;
import client.MapleClient;
import client.MapleCharacter;
import java.util.Collections;
import java.util.List;
import tools.MaplePacketCreator;
import tools.Pair;

/**
 *
 * @author Vanilla
 */
public class MorphCommand extends Command {
    {
        setDescription("");
    }

    @Override
    public void execute(MapleClient c, String[] params) {
        MapleCharacter player = c.getPlayer();
        if (params.length < 1) {
            player.yellowMessage("Proper usage is !morph [<target>] <morphid>");
        }
        
        else if (params.length == 1) {
            // morph <morphid>
            int morphid = Integer.parseInt(params[0]);
            
            morphPlayer(player, morphid);
        }
        else {
            // morph <target> <morphid>
            String victimName = params[0];
            int morphid = Integer.parseInt(params[1]);
            
            MapleCharacter victim = c.getChannelServer().getPlayerStorage().getCharacterByName(victimName);
            
            if (victim != null) {
                morphPlayer(victim, morphid);
            }
            else {
                player.yellowMessage("Player " + victimName + " could not be found on this channel");
            }
        }
    }
    
    private void morphPlayer(MapleCharacter victim, int morphid) {
        List<Pair<MapleBuffStat, Integer>> stat = Collections.singletonList(new Pair<>(MapleBuffStat.MORPH, morphid));
        victim.announce(MaplePacketCreator.giveBuff(-5300001, 600, stat)); // Negative id for non-skill? 10 minutes?
    }
}
