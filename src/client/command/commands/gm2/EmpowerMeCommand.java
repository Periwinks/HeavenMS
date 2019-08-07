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

import client.SkillFactory;
import client.command.Command;
import client.MapleClient;
import client.MapleCharacter;

public class EmpowerMeCommand extends Command {
    {
        setDescription("");
    }

    @Override
    public void execute(MapleClient c, String[] params) {
        MapleCharacter player = c.getPlayer();
        // 2311003 Holy Symbol
        // 2301004 Bless
        // 1301007 Hyper Body
        // 4101004 Haste
        // 1101007 Power Guard
        // 1005    Echo of Hero
        // 2301003 Invincible
        // 5121009 Speed Infusion
        // 1111002 Combo Attack
        // 4111002 Shadow Partner
        // 4211005 Meso Guard
        // 1321000 Maple Warrior
        // 2321004 Infinity
        // 3121002 Sharp Eyes
        // 1121002 Power Stance
        // 2321005 Holy Shield
        
        final int[] array = {2311003, 2301004, 1301007, 4101004, 1101007, 1005, 2301003, 5121009, 1111002, 4111002, 4211005, 1321000, 2321004, 3121002, 1121002, 2321005};
        for (int i : array) {
            SkillFactory.getSkill(i).getEffect(SkillFactory.getSkill(i).getMaxLevel()).applyTo(player);
        }
    }
}
