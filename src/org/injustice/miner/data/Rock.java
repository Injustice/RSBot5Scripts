/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.injustice.miner.data;

import org.injustice.framework.api.IMethodContext;
import org.powerbot.script.lang.BasicNamedQuery;
import org.powerbot.script.wrappers.GameObject;

/**
 * Created with IntelliJ IDEA.
 * User: Injustice
 * Date: 17/06/13
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
public enum Rock {
    TIN(
            438,

            2094, 2095,
            3038, 3038, 3245,
            5776, 5776, 5777, 5778,
            9714, 9715, 9716, 11554, 11933,
            11933, 11934, 11935,
            11957, 11957, 11958, 11959, 11993,
            14856, 14857, 14858, 14902, 14903, 21293,
            21293, 21294, 21295,
            72075, 72076, 72077, 72092, 72093,
            72094, 72094

    ),

    COPPER(
            436,

            2090, 2091, 2097,
            3027, 3027, 3229, 3329, 5779,
            5779, 5780, 5781, 9079,
            9708, 9709, 9710, 11936,
            11936, 11937, 11938, 11960,
            11960, 11961, 11962,
            14906, 14907,
            21284, 21284, 21285, 21286,
            72098, 72098, 72099, 72100,
            72100
    ),

    CLAY(
            434,

            2108, 2109,
            5766, 5766, 5767,
            9711, 9712, 9713,
            10577, 10577, 10578, 10579,
            11189, 11190, 11191, 11503, 11504, 11505,
            15503, 15503, 15504, 15505,
            15505, 67006, 67007, 67008, 72075,
            72075, 72076, 72077,
            72077
    ),

    IRON(
            440,

            2092, 2093, 5773,
            5773, 5774, 5775,
            6943, 6944,
            9717, 9717,
            9718, 9718, 9719, 11954,
            11954, 11955, 11956,
            14099, 14107, 14856, 14857, 14858, 14913, 14914,
            21281, 21281,
            21282, 21282, 21283, 31071, 31072, 31073,
            37307, 37307, 37308, 37309, 72081,
            72081, 72082, 72083
    ),
    COAL(
            453,

            2096, 2097, 3032,
            3032, 3233,
            5770, 5770, 5771, 5772, 10577, 10578,
            10579,
            10948, 11930,
            11930, 11931, 11932,
            11932, 14850,
            14850, 14851, 14852, 21287,
            20410, 20411, 20412, 20413,
            21287, 21288, 21289, 25770,
            25770,
            29215, 29216, 29217, 31068, 31069, 31070, 31167,
            31167, 31168,
            31168,
            32426, 32426, 32427, 32428, 32432, 32433, 32434, 37307, 37309
    ),

    LIMESTONE(
            3211,

            4027, 4028, 4029
    ),

    //    SANDSTONE(),
    GRANITE(
            0,
            6979, 6981, 6983
    ),
    //    LIMESTONE(),
//    BLURITE(),
//    ELEMENTAL(),
    SILVER(
            442,

            2100, 2101,
            2311, 11186,
            6945, 6946,
            11186, 11187, 11188, 11948, 11949,
            11949, 11950, 15579,
            15579, 15580,
            15581, 15581, 16998, 16999, 17000, 29224,
            29224, 29225, 29226, 32444,
            32444, 32445, 32446, 37304,
            37304, 37305, 37306
    ),
    GOLD(
            444,

            2098, 2099, 5768,
            5768, 5769, 5989,
            9720, 9720, 9721, 9722,
            10574, 10575, 10576, 11183,
            11183,
            11184, 11184, 11185, 11943, 15576,
            15576, 15577, 15578,
            17001, 17002, 17003, 31065, 31066, 31067, 32432,
            32432, 32433, 32434, 34976, 34977,
            37212, 37310, 37311, 37312,
            45067, 45068,
            72087, 72088
    ),

    MITHRIL(
            447,

            2102, 2103, 3041,
            3041, 3280,
            3280,
            5784, 5784, 5785, 5786, 11942,
            11942,
            11943, 11943, 11944,
            20418, 20419, 20420, 20421,
            21278, 21278, 21279,
            21280, 21280, 31086, 31087, 31088, 31170, 32438,
            32438, 32439, 32440
    ),

    ADAMANT(
            449,

            2104, 2105,
            3040, 3040,
            3273, 3273, 5781,
            5782, 5782, 5783, 11939,
            11939,
            11940, 11941,
            14862, 14864, 14963,
            20414, 20415, 20417,
            21275, 21275, 21276, 21277,
            29233, 29235, 31083, 31084, 31085, 31173,
            31173, 32435,
            32435, 32436, 32437
    ),

    RUNE(
            451,

            14859, 14860,
            33078, 33079,
            45069, 45070
    ),

    GEM_ROCK(
            1621, 1621, // Gem IInventory IDs: 1621, 1617, 1619, 1623, 1625, 1627, 1629, 1631, 21345
            3040, 3273,
            11194, 11195, 11364, 11365
    );

/*    EMPTY_ROCK_DONT_USE(
            5763, 5764, 5765,
            11557,
            15582,
            33400, 33401, 33402,
            72084, 72085, 72086
    ),    */

/*    GOLD_DEPOSIT_DONT_USE(
            45076
    ),

    COAL_DEPOSIT_DONT_USE(
            5999
    ),

    COLLAPSED_DEPOSIT_DONT_USE(
            5990
    );       */

    private final int[] ids;
    private final int invId;

    Rock(int invId, int... ids) {
        this.ids = ids;
        this.invId = invId;
    }

    public int[] getIds() {
        return this.ids;
    }

    public int getInvId() {
        return this.invId;
    }
    
    public BasicNamedQuery<GameObject> getRocks(IMethodContext ctx) {
        return ctx.objects.select().id(ids);
    }
    
    public BasicNamedQuery<GameObject> getRocksWithin(int radius, IMethodContext ctx) {
        return ctx.objects.select().within(radius).id(ids);
    }
    
    public BasicNamedQuery<GameObject> getNearestRock(IMethodContext ctx) {
        return ctx.objects.select().id(ids).first();
    }
    
    public static Rock selected;
    public static int[] depletedGemRocks = {11365, 11366, 11367};
    public static final int[] gems = {1621, 1617, 1619, 1623, 1625, 1627, 1629, 1631, 21345};
    public static int[] strangeRocks = {15532, 15533};
}

