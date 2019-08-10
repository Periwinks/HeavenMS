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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import net.server.Server;
import tools.DatabaseConnection;
import tools.MaplePacketCreator;
import tools.Pair;

/**
 *
 * @author Kelder
 */
public class DPSRanks extends Command {
    {
        setDescription("");
    }
    
    @Override
    public void execute(MapleClient client, String[] params) {
        MapleCharacter player = client.getPlayer();

        List<Pair<String, Long>> dpsRanking = Server.getInstance().getWorldDpsRanking(player.getWorld());
        player.announce(MaplePacketCreator.showDpsRanks(9010000, dpsRanking));
    }
}
