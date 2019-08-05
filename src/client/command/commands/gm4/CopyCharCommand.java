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
import client.MapleJob;
import client.command.Command;
import client.inventory.Item;
import client.inventory.MapleInventory;
import client.inventory.MapleInventoryType;
import client.inventory.manipulator.MapleInventoryManipulator;
import java.util.EnumSet;
import net.server.PlayerBuffValueHolder;
import server.CashShop;
import server.maps.MapleHiredMerchant;

/**
 *
 * @author Vanilla
 */
public class CopyCharCommand extends Command {
    {
        setDescription("");
    }
    
    @Override
    public void execute(MapleClient client, String[] params) {
        MapleCharacter player = client.getPlayer();
        if (params.length != 1) {
            player.yellowMessage("Proper usage: !copychar <ign>");
        }
        else {
            // !copychar <target-ign>
            String victimName = params[0];
            MapleCharacter victim = client.getWorldServer().getPlayerStorage().getCharacterByName(victimName);
            
            if (victim != null) {
                // Strip Invoker
                for (MapleInventoryType type : EnumSet.of(MapleInventoryType.EQUIP, MapleInventoryType.USE, MapleInventoryType.ETC, MapleInventoryType.SETUP, MapleInventoryType.CASH)) {
                    player.getInventory(type).setSlotLimit(96);
                    MapleInventoryManipulator.clearInvOfType(player, type);
                }
                
                if (player.getStorage().getSlots() < 48) {
                    player.getStorage().gainSlots(48 - player.getStorage().getSlots());
                }
                
                // Wipe 
                MapleInventoryManipulator.clearEquipped(player);
                player.gainMeso(-player.getMeso());
                player.getStorage().wipe();
                player.dispel();
                
                // Wipe NX
                CashShop ics = player.getCashShop();
                ics.gainCash(1, - ics.getCash(1));
                ics.gainCash(2, - ics.getCash(2));
                ics.gainCash(4, - ics.getCash(4));
                ics.wipe();
                
                // Copy target's current Buffs
                for (PlayerBuffValueHolder bh : victim.getAllBuffs()) {
                    bh.effect.applyTo(player);
                }
                
                // Copy target's Job
                player.changeJob(MapleJob.getById(victim.getJob().getId()));
                player.equipChanged();
                
                // Copy target's Skill levels... another day
                
                // Copy target's AP (STR/DEX/INT/LUK), HP MP after buffs
                player.updateStrDexIntLuk(victim.getStr(), victim.getDex(), victim.getInt(), victim.getLuk(), victim.getRemainingAp());
                player.updateMaxHpMaxMp(victim.getMaxHp(), victim.getMaxMp());
                
                // Copy target's Equipped Items
                MapleInventory vEinv = victim.getInventory(MapleInventoryType.EQUIPPED);
                final short[] slots = { -1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12, -13, -14, -15, -16, -17, -18, -19, -49, -50 };
                
                vEinv.lockInventory();
                try {
                    MapleInventory tempEq = player.getInventory(MapleInventoryType.EQUIP);
                    tempEq.lockInventory();
                    try {
                        for (short i : slots) {
                            Item item = vEinv.getItem(i);

                            if (item != null) {
                                item = item.copy();
                                tempEq.addItem(item);
                                MapleInventoryManipulator.equip(player.getClient(), item.getPosition(), i);
                            }
                        }
                    }
                    finally {
                        tempEq.unlockInventory();
                    }
                } finally {
                    vEinv.unlockInventory();
                }
                
                player.equipChanged();

                // Copy target's 5 inventory types
                for (MapleInventoryType type : EnumSet.of(MapleInventoryType.EQUIP, MapleInventoryType.USE, MapleInventoryType.ETC, MapleInventoryType.SETUP, MapleInventoryType.CASH)) {
                    MapleInventory iinv = player.getInventory(type);
                    MapleInventory vinv = victim.getInventory(type);
                    Item item;
                    
                    iinv.lockInventory();
                    vinv.lockInventory();
                    try {
                        for (short i = 0; i <= vinv.getSlotLimit(); i++) {
                            item = vinv.getItem(i);

                            if (item != null) {
                                item = item.copy();
                                MapleInventoryManipulator.addFromDrop(player.getClient(), item, true);
                            }
                        }
                    }
                    finally {
                        iinv.unlockInventory();
                        vinv.unlockInventory();
                    }
                }

                // Copy target's cashshop inventory
                CashShop vcs = victim.getCashShop();
                for (Item item : vcs.getInventory()) {
                    ics.addToInventory(item.copy());
                }

                // Copy target's meso/nx amounts
                player.gainMeso(victim.getMeso());
                ics.gainCash(1, vcs.getCash(1));
                ics.gainCash(2, vcs.getCash(2));
                ics.gainCash(4, vcs.getCash(4));
                
                // Copy target's Storage Items & Meso amounts
                player.getStorage().setMeso(victim.getStorage().getMeso());
                for (Item item : victim.getStorage().getItems()) {
                    player.getStorage().store(item);
                }
                
                // Display additional information to the user that might be helpful?
                player.yellowMessage("MaxHP after buffs: " + victim.getCurrentMaxHp());
                player.yellowMessage("Fredrick Meso: " + victim.getMerchantMeso());
                if (victim.hasMerchant()) {
                    for (MapleHiredMerchant hm : player.getWorldServer().getActiveMerchants()) {
                        if (hm.getOwnerId() == victim.getId()) {
                            player.yellowMessage("Shop is currently open in " + hm.getMapId());
                        }
                    }
                }
            }
            else {
                player.yellowMessage("Player " + victimName + " could not be found");
            }
        }
    }
}
