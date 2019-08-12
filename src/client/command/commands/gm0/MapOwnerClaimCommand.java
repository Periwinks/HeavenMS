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
   @Author: Ronan
*/
package client.command.commands.gm0;

import client.command.Command;
import client.MapleCharacter;
import client.MapleClient;
import constants.ServerConstants;
import server.maps.MapleMap;

public class MapOwnerClaimCommand extends Command {
    {
        setDescription("Claim or release a map as a measure of preventing killstealing");
    }

    @Override
    public void execute(MapleClient c, String[] params) {
        if (c.tryacquireClient()) {
            try {
                MapleCharacter chr = c.getPlayer();
                
                if (ServerConstants.USE_MAP_OWNERSHIP_SYSTEM) {
                    if (chr.getEventInstance() == null) {
                        MapleMap ownedMap = chr.getOwnedMap();  // thanks Conrad for suggesting not unlease a map as soon as player exits it
                        if (ownedMap != null) {
                            ownedMap.unclaimOwnership(chr);
                            ownedMap.dropMessage(5, chr.getName() + " has manually forfeit the map. Use @mapowner to claim the map.");
                            
                            if (chr.getMap() == ownedMap) {
                                chr.dropMessage(5, "You forfeit ownership of the map. If this was a mistake, use @mapowner to reclaim it.");
                                return;
                            }
                        }
                        
                        if (chr.getMap().claimOwnership(chr)) {
                            chr.dropMessage(5, "You have claimed this map until 1 minute of inactivity within the map.");
                        } else {
                            // mapowner is not null
                            chr.dropMessage(5, chr.getMap().getMapOwner().getName() + " has already claimed this map.");
                        }
                    } else {
                        chr.dropMessage(5, "Event instance maps cannot be claimed.");
                    }
                } else {
                    chr.dropMessage(5, "Mapowner command feature unavailable.");
                }
            } finally {
                c.releaseClient();
            }
        }
    }
}
