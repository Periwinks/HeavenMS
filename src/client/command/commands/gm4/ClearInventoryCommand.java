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
import client.inventory.Equip;
import client.inventory.Item;
import client.inventory.MapleInventory;
import client.inventory.MapleInventoryType;
import client.inventory.ModifyInventory;
import java.util.ArrayList;
import tools.MaplePacketCreator;

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
     * @return 
     */
    private void clearInventory(MapleCharacter victim, String type) {
        switch (type.toLowerCase()) {
            case "all":
                clearEquipped(victim);
                for (MapleInventoryType invType : MapleInventoryType.values()) {
                    clear(victim, invType);
                }
                break;
            case "equipped":
                clearEquipped(victim);
                break;
            case "eqp": // not equipped
                clear(victim, MapleInventoryType.EQUIP);
                break;
            case "use":
                clear(victim, MapleInventoryType.USE);
                break;
            case "ins": // install, chairs, setup
                clear(victim, MapleInventoryType.SETUP);
                break;
            case "etc":
                clear(victim, MapleInventoryType.ETC);
                break;
            case "cash": // Player Cash Item Inventory
                clear(victim, MapleInventoryType.CASH);
                break;
            default:
                break;
        }
    }
    
    private void clear(MapleCharacter victim, MapleInventoryType type) {
        MapleInventory inv = victim.getInventory(type);
        ArrayList<ModifyInventory> mods = new ArrayList<>();
        
        inv.lockInventory();
        try {
            for (short slot = 0; slot <= inv.getSlotLimit(); slot++) {
                Item item = inv.getItem(slot);
                
                if (item != null) {
                    inv.removeItem(slot, item.getQuantity(), false);
                    mods.add(new ModifyInventory(3, item));
                }
            }
        }
        finally {
            inv.unlockInventory();
        }
        
        victim.getClient().announce(MaplePacketCreator.modifyInventory(false, mods));
    }
    
    private void clearEquipped(MapleCharacter victim) {
        MapleInventory inv = victim.getInventory(MapleInventoryType.EQUIPPED);
        ArrayList<ModifyInventory> mods = new ArrayList<>();
        
        // equip slots
        final short[] slots = {
          -1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11,
            -12, -13, -14, -15, -16, -17, -18, -19, -49, -50
        };
        
        inv.lockInventory();
        try {
            for (short i : slots) {
                Item item = inv.getItem(i);
                
                if (item != null) {
                    victim.unequippedItem((Equip) item);
                    inv.removeItem(i);
                    mods.add(new ModifyInventory(3, item));
                }
            }
        } finally {
            inv.unlockInventory();
        }

        victim.getClient().announce(MaplePacketCreator.modifyInventory(false, mods));
    }
}
