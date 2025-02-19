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
package client.command.commands.gm2;

import client.MapleStat;
import client.command.Command;
import client.MapleClient;
import client.MapleCharacter;
import constants.ServerConstants;

public class MaxStatCommand extends Command {
    {
        setDescription("");
    }

    @Override
    public void execute(MapleClient c, String[] params) {
        MapleCharacter player = c.getPlayer();
        player.loseExp(player.getExp(), false, false);
        player.setLevel(200);
        player.resetPlayerRates();
        if (ServerConstants.USE_ADD_RATES_BY_LEVEL) player.setPlayerRates();
        player.setWorldRates();
        player.updateStrDexIntLuk(Short.MAX_VALUE);
        player.updateMaxHpMaxMp(30000, 30000);
        player.updateSingleStat(MapleStat.LEVEL, 200);
        player.yellowMessage("Stats maxed out.");
    }
}
