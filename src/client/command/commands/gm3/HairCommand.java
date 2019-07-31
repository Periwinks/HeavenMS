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

/*
   @Author: Arthur L - Refactored command content into modules
*/
package client.command.commands.gm3;

import client.MapleStat;
import client.command.Command;
import client.MapleClient;
import client.MapleCharacter;
import constants.ItemConstants;
import server.MapleItemInformationProvider;

public class HairCommand extends Command {
    {
        setDescription("");
    }

    @Override
    public void execute(MapleClient c, String[] params) {
        MapleCharacter player = c.getPlayer();
        if (params.length < 1) {
            player.yellowMessage("Syntax: !hair [<playername>] <hairid>");
            return;
        }

        try {
            if (params.length == 1) {
                // hair <id>
                int id = Integer.parseInt(params[0]);
                
                if (!ItemConstants.isHair(id) || MapleItemInformationProvider.getInstance().getName(id) == null) {
                    player.yellowMessage("Hair id '" + id + "' does not exist.");
                    return;
                }
                
                changeHair(player, id);
            }
            else {
                // hair <target> <id>
                String targetName = params[0];
                int id = Integer.parseInt(params[1]);
                
                if (!ItemConstants.isHair(id) || MapleItemInformationProvider.getInstance().getName(id) == null) {
                    player.yellowMessage("Hair id '" + id + "' does not exist.");
                    return;
                }
                
                MapleCharacter victim = c.getChannelServer().getPlayerStorage().getCharacterByName(targetName);
                
                if (victim != null) {
                    changeHair(victim, id);
                }
                else {
                    player.yellowMessage("Player " + targetName + " could not be found");
                }
            }
        } catch (Exception e) {
        }
    }
    
    private void changeHair(MapleCharacter player, int id) {
        player.setHair(id);
        player.updateSingleStat(MapleStat.HAIR, id);
        player.equipChanged();
    }
}
