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
package client.command.commands.gm4;

import client.MapleCharacter;
import client.MapleClient;
import client.command.Command;
import client.inventory.MapleInventoryType;
import client.inventory.manipulator.MapleInventoryManipulator;

/**
 *
 * @author Vanilla
 */
public class ClearInventoryCommand extends Command {
    {
        setDescription("");
    }

    @Override
    public void execute(MapleClient client, String[] params) {
        MapleCharacter player = client.getPlayer();
        if (params.length < 1) {
            player.yellowMessage("Proper usage: !clearinv [<IGN>] <all | eqp | use | ins | etc | cash | equipped>");
        }
        
        if (params.length == 1) {
            // !clearinv <type>
            String type = params[0];
            
            clearInventory(player, type);
        }
        else {
            // !clearinv <IGN> <type>
            String victimName = params[0];
            String type = params[1];
            MapleCharacter victim = client.getWorldServer().getPlayerStorage().getCharacterByName(victimName);
            
            if (victim != null) {
                clearInventory(victim, type);
            }
            else {
                player.yellowMessage("Player " + victimName + " could not be found");
            }
        }
    }
    
    /**
     * Clears an inventory for victim if valid type
     * @param victim
     * @param type Inventory type to be cleared
     */
    private void clearInventory(MapleCharacter victim, String type) {
        switch (type.toLowerCase()) {
            case "all":
                MapleInventoryManipulator.clearEquipped(victim);
                for (MapleInventoryType invType : MapleInventoryType.values()) {
                    MapleInventoryManipulator.clearInvOfType(victim, invType);
                }
                break;
            case "equipped":
                MapleInventoryManipulator.clearEquipped(victim);
                break;
            case "eqp": // not equipped
                MapleInventoryManipulator.clearInvOfType(victim, MapleInventoryType.EQUIP);
                break;
            case "use":
                MapleInventoryManipulator.clearInvOfType(victim, MapleInventoryType.USE);
                break;
            case "ins": // install, chairs, setup
                MapleInventoryManipulator.clearInvOfType(victim, MapleInventoryType.SETUP);
                break;
            case "etc":
                MapleInventoryManipulator.clearInvOfType(victim, MapleInventoryType.ETC);
                break;
            case "cash": // Player Cash Item Inventory
                MapleInventoryManipulator.clearInvOfType(victim, MapleInventoryType.CASH);
                break;
            default:
                break;
        }
    }
}
