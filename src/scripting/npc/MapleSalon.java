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
package scripting.npc;

/**
 *
 * @author Vanilla
 */
class MapleSalon {
    private static final MapleSalon INSTANCE = new MapleSalon();
    private static final int UBIQUITOUS = 2;
    
    private static final int[][][] henesys = {
        {// VIP
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        },
        {// REG
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        }
    };
    private static final int[][][] kerning = {
        {// VIP
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        },
        {// REG
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        }
    };
    private static final int[][][] orbis = {
        {// VIP
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        },
        {// REG
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        }
    };
    private static final int[][][] ludi = {
        {// VIP
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        },
        {// REG
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        }
    };
    private static final int[][][] mulung = {
        {// VIP
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        },
        {// REG
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        }
    };
    private static final int[][][] ariant = {
        {// VIP
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        },
        {// REG
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        }
    };
    private static final int[][][] cbd = {
        {// VIP
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        },
        {// REG
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        }
    };
    private static final int[][][] nlc = {
        {// VIP
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        },
        {// REG
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        }
    };
    private static final int[][][] amoria = {
        {// VIP
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        },
        {// REG
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        }
    };
    private static final int[][][] showa = {
        {// VIP
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        },
        {// REG
            // male
            {30000, 30010, 30020, 30030},
            // female
            {31000, 31010, 31020, 31030},
            // ubiquitous
            {32000, 32010}
        }
    };
    private static final int[][] royal = {
        // male
        {30000, 30010, 30020, 30030},
        // female
        {31000, 31010, 31020, 31030},
        // ubiquitous
        {32000, 32010}
    };
    private static final int[][] claudia = {
        // male
        {30000, 30010, 30020, 30030},
        // female
        {31000, 31010, 31020, 31030},
        // ubiquitous
        {32000, 32010}
    };
    
    private MapleSalon() { }
    
    static MapleSalon instance() {
        return INSTANCE;
    }
    
    /**
     * Gets hairstyle list including ubiq styles if any
     * @param isRegCoupon Is the coupon regular as opposed to VIP?
     * @param mapid
     * @param gender player gender value
     * @return gender's styles + ubiq styles; or all 3 if gender is neither 0 or 1
     */
    final int[] getHairstyles(boolean isRegCoupon, int mapid, int gender) {
        int regStatus = isRegCoupon ? 1 : 0;
        int[][] salon = getSalonByMapid(mapid)[regStatus];
        return isKnownGender(gender) ? getHairstyles(salon, gender) : getHairstyles(salon);
    }
    
    /**
     * Gets royal styles including ubiq styles if any
     * @param gender player's gender
     * @return gender's styles + ubiq styles; or all 3 if gender is neither 0 or 1
     */
    final int[] getRoyalHairstyles(int gender) {
        if (isKnownGender(gender))
            return getHairstyles(royal, gender);
        
        return getHairstyles(royal);
    }
    
    /**
     * Gets hairstyles for claudia's quest; includes ubiq styles if any
     * @param gender player's gender
     * @return gender's styles + ubiq styles; or all 3 if gender is neither 0 or 1
     */
    final int[] getClaudiaHairstyles(int gender) {
        if (isKnownGender(gender))
            return getHairstyles(claudia, gender);
        
        return getHairstyles(claudia);
    }
    
    private int[][][] getSalonByMapid(int mapid) {
        switch(mapid) {
            case 100000104:
                return henesys;
            case 103000005:
                return kerning;
            case 200000202:
                return orbis;
            case 220000004:
                return ludi;
            case 250000003:
                return mulung;
            case 260000000:
                return ariant;
            case 540000000:
                return cbd;
            case 600000001:
                return nlc;
            case 680000002:
                return amoria;
            default:
                return showa;
        }
    }
    
    private boolean isKnownGender(int gender) {
        return (gender == 0 || gender == 1);
    }
    
    // An array consisting of the values from all 3 gender possibilities
    private int[] getHairstyles(int[][] salon) {
        // Simply merges all 3 style lists together: M/F/ubiquitous
        return mergeArrays(salon[0], mergeArrays(salon[1], salon[UBIQUITOUS]));
    }
    
    private int[] getHairstyles(int[][] salon, int gender) {
        if (salon[UBIQUITOUS].length < 1)
            // the salon only contains male & female styles
            return salon[gender];
        
        // Merges styles of gender + ubiquitous
        return mergeArrays(salon[gender], salon[UBIQUITOUS]);
    }
    
    /**
     * Assumes a & b are not length 0
     * @param a
     * @param b
     * @return merged array with duplicates if there existed any
     */
    private int[] mergeArrays(int[] a, int[] b) {
        int[] ret = new int[a.length + b.length];
        System.arraycopy(a, 0, ret, 0, a.length);
        System.arraycopy(b, 0, ret, a.length, b.length);
        return ret;
    }
}