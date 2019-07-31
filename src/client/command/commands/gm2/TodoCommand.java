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
package client.command.commands.gm2;

import client.MapleCharacter;
import client.MapleClient;
import client.command.Command;
import tools.FilePrinter;

/**
 * Adds something to the to do list
 * @author Vanilla
 */
public class TodoCommand extends Command {
    {
        setDescription("");
    }

    @Override
    public void execute(MapleClient client, String[] params) {
        MapleCharacter source = client.getPlayer();
        
        StringBuilder content = new StringBuilder();
        for (String str : params) {
            content.append(str);
            content.append(" ");
        }
        
        String characterName = source.getName();
        
        FilePrinter.printTODO(characterName + ".txt", content.toString(), true);
    }
}
