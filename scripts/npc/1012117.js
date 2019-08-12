/*
	This file is part of the OdinMS Maple Story Server
    Copyright (C) 2008 Patrick Huy <patrick.huy@frz.cc>
		       Matthias Butz <matze@odinms.de>
		       Jan Christian Meyer <vimes@odinms.de>

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
	NPC Name: 		Big Headward
        Map(s): 		Victoria Road : Henesys Hair Salon (100000104)
	Description: 		Random haircut

        GMS-like revised by Ronan. Contents found thanks to Mitsune (GamerBewbs), Waltzing, AyumiLove
*/

var status = 0;

var hair = Array();
var hairnew = Array();

function pushIfItemExists(array, itemid) {
    if ((itemid = cm.getCosmeticItem(itemid)) != -1 && !cm.isCosmeticEquipped(itemid)) {
        array.push(itemid);
    }
}
function start() {
    status = -1;
    action(1, 0, 0);
}

function action(mode, type, selection) {
    if (mode < 1) {  // disposing issue with stylishs found thanks to Vcoc
        cm.dispose();
    } else {
        if (mode == 1)
            status++;
        else
            status--;
        
        if (status == 0) {
            cm.sendSimple("Hi, I'm #p1012117#, the most charming and stylish stylist around. If you're looking for the best looking hairdos around, look no further!\r\n\#L0##i5150040##t5150040##l");
        } else if (status == 1) {
            beauty = 1;
            cm.sendYesNo("If you use this REGULAR coupon, your hair may transform into a random new look...do you still want to do it using #b#t5150040##k, I will do it anyways for you. But don't forget, it will be random!");
            
        } else if (status == 2) {
            if (cm.haveItem(5150040) == true){
                hairnew = Array();
                hair = cm.getRoyalHairIds();
                for (var i = 0; i < hair.length; i++)
                    pushIfItemExists(hairnew, hair[i] + parseInt(cm.getPlayer().getHair() % 10));
                
                cm.gainItem(5150040, -1);
                cm.setHair(hairnew[Math.floor(Math.random() * hairnew.length)]);
                cm.sendOk("Enjoy your new and improved hairstyle!");
            } else {
                cm.sendOk("Hmmm...it looks like you don't have our designated coupon...I'm afraid I can't give you a haircut without it. I'm sorry...");
            }
            
            cm.dispose();
        }
    }
}
