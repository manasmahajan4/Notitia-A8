package adnyey.notitia.a8;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;

import java.util.LinkedList;
import java.util.List;

public class CarDBAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static CarDBAccess instance;
    private Context mContext;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private CarDBAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
        mContext = context;
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static CarDBAccess getInstance(Context context) {
        if (instance == null) {
            instance = new CarDBAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    private static final String TABLE_CARDS = "newcard";
    private static final String TABLE_MAIN = "main_table";
    private static final String KEY_CLASS = "class";
    private static final String KEY_RANK = "rank";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_A1 = "a1";
    private static final String KEY_A2 = "a2";
    private static final String KEY_A3 = "a3";
    private static final String KEY_A4 = "a4";
    private static final String KEY_T1 = "t1";
    private static final String KEY_T2 = "t2";
    private static final String KEY_T3 = "t3";
    private static final String KEY_T4 = "t4";
    private static final String KEY_H1 = "h1";
    private static final String KEY_H2 = "h2";
    private static final String KEY_H3 = "h3";
    private static final String KEY_H4 = "h4";
    private static final String KEY_N1 = "n1";
    private static final String KEY_N2 = "n2";
    private static final String KEY_N3 = "n3";
    private static final String KEY_N4 = "n4";
    private static final String KEY_R1 = "r1";
    private static final String KEY_R2 = "r2";
    private static final String KEY_R3 = "r3";
    private static final String KEY_R4 = "r4";
    private static final String KEY_TYPE = "typep";
    private static final String KEY_L1A = "l1a";
    private static final String KEY_L1T = "l1t";
    private static final String KEY_L1N = "l1n";
    private static final String KEY_L2A = "l2a";
    private static final String KEY_L2T = "l2t";
    private static final String KEY_L2N = "l2n";
    private static final String KEY_L3A = "l3a";
    private static final String KEY_L3T = "l3t";
    private static final String KEY_L3N = "l3n";
    private static final String KEY_L4A = "l4a";
    private static final String KEY_L4T = "l4t";
    private static final String KEY_L4N = "l4n";
    private static final String KEY_L5A = "l5a";
    private static final String KEY_L5T = "l5t";
    private static final String KEY_L5N = "l5n";
    private static final String KEY_ENG = "eng";
    private static final String KEY_ENGN = "engn";
    private static final String KEY_PL1P = "pl1p";
    private static final String KEY_PL1TECH1 = "pl1tech1";
    private static final String KEY_PL1TECH2 = "pl1tech2";
    private static final String KEY_PL1ENGN = "pl1engn";
    private static final String KEY_PL1TECHN = "pl1techn";
    private static final String KEY_PL1TPR = "pl1tpr";
    private static final String KEY_PL1SPR = "pl1spr";
    private static final String KEY_PL1EPR = "pl1epr";

    private static final String KEY_PL2P = "pl2p";
    private static final String KEY_PL2TECH1 = "pl2tech1";
    private static final String KEY_PL2TECH2 = "pl2tech2";
    private static final String KEY_PL2ENGN = "pl2engn";
    private static final String KEY_PL2TECHN = "pl2techn";
    private static final String KEY_PL2TPR = "pl2tpr";
    private static final String KEY_PL2SPR = "pl2spr";
    private static final String KEY_PL2EPR = "pl2epr";

    private static final String KEY_PL3P = "pl3p";
    private static final String KEY_PL3TECH1 = "pl3tech1";
    private static final String KEY_PL3TECH2 = "pl3tech2";
    private static final String KEY_PL3ENGN = "pl3engn";
    private static final String KEY_PL3TECHN = "pl3techn";
    private static final String KEY_PL3TPR = "pl3tpr";
    private static final String KEY_PL3SPR = "pl3spr";
    private static final String KEY_PL3EPR = "pl3epr";

    private static final String KEY_PL4P = "pl4p";
    private static final String KEY_PL4TECH1 = "pl4tech1";
    private static final String KEY_PL4TECH2 = "pl4tech2";
    private static final String KEY_PL4ENGN = "pl4engn";
    private static final String KEY_PL4TECHN = "pl4techn";
    private static final String KEY_PL4TPR = "pl4tpr";
    private static final String KEY_PL4SPR = "pl4spr";
    private static final String KEY_PL4EPR = "pl4epr";

    private static final String KEY_PL5P = "pl5p";
    private static final String KEY_PL5TECH1 = "pl5tech1";
    private static final String KEY_PL5TECH2 = "pl5tech2";
    private static final String KEY_PL5ENGN = "pl5engn";
    private static final String KEY_PL5TECHN = "pl5techn";
    private static final String KEY_PL5TPR = "pl5tpr";
    private static final String KEY_PL5SPR = "pl5spr";
    private static final String KEY_PL5EPR = "pl5epr";

    private static final String KEY_CARCLASS = "carclass";
    private static final String KEY_PRICE = "price";
    private static final String KEY_IMG = "img";

    private static final String KEY_WIN = "win";
    private static final String KEY_MODI = "modi";

    private static final String KEY_PRIC = "pric";
    private static final String KEY_PRIT = "prit";

    private static final String KEY_UT1 = "uptype1";
    private static final String KEY_UT2 = "uptype2";
    private static final String KEY_UT3 = "uptype3";
    private static final String KEY_UT4 = "uptype4";
    private static final String KEY_UT5 = "uptype5";

    private static final String[] BASICCOL = {KEY_ID, KEY_NAME,
            KEY_RANK, KEY_CLASS, "type", KEY_IMG,
            KEY_WIN, KEY_MODI, KEY_PRIC, KEY_PRIT, "eng", "engn", "prib", "tk_bonus"
    };
    private static final String[] PROCOL = {"part1", "tech11", "tech21", "eng1", "tech1", "tire1", "susp1", "drive1", "exha1",
            "part2", "tech12", "tech22", "eng2", "tech2", "tire2", "susp2", "drive2", "exha2",
            "part3", "tech13", "tech23", "eng3", "tech3", "tire3", "susp3", "drive3", "exha3",
            "part4", "tech14", "tech24", "eng4", "tech4", "tire4", "susp4", "drive4", "exha4",
            "part5", "tech15", "tech25", "eng5", "tech5", "tire5", "susp5", "drive5", "exha5"
    };

    private static final String[] STATSCOLS = {
            KEY_A1, KEY_A2, KEY_A3, KEY_A4,
            KEY_T1, KEY_T2, KEY_T3, KEY_T4,
            KEY_H1, KEY_H2, KEY_H3, KEY_H4,
            KEY_N1, KEY_N2, KEY_N3, KEY_N4,
            KEY_R1, KEY_R2, KEY_R3, KEY_R4,};

    private static final String[] COLUMNS = {KEY_ID, KEY_NAME,
            KEY_A1, KEY_A2, KEY_A3, KEY_A4,
            KEY_T1, KEY_T2, KEY_T3, KEY_T4,
            KEY_H1, KEY_H2, KEY_H3, KEY_H4,
            KEY_N1, KEY_N2, KEY_N3, KEY_N4,
            KEY_R1, KEY_R2, KEY_R3, KEY_R4,
            KEY_TYPE,
            KEY_L1A, KEY_L1T, KEY_L1N,
            KEY_L2A, KEY_L2T, KEY_L2N,
            KEY_L3A, KEY_L3T, KEY_L3N,
            KEY_L4A, KEY_L4T, KEY_L4N,
            KEY_L5A, KEY_L5T, KEY_L5N,
            KEY_ENG, KEY_ENGN,

            KEY_PL1P, KEY_PL1TECH1, KEY_PL1TECH2, KEY_PL1ENGN, KEY_PL1TECHN, KEY_PL1TPR, KEY_PL1SPR, KEY_PL1EPR,
            KEY_PL2P, KEY_PL2TECH1, KEY_PL2TECH2, KEY_PL2ENGN, KEY_PL2TECHN, KEY_PL2TPR, KEY_PL2SPR, KEY_PL2EPR,
            KEY_PL3P, KEY_PL3TECH1, KEY_PL3TECH2, KEY_PL3ENGN, KEY_PL3TECHN, KEY_PL3TPR, KEY_PL3SPR, KEY_PL3EPR,
            KEY_PL4P, KEY_PL4TECH1, KEY_PL4TECH2, KEY_PL4ENGN, KEY_PL4TECHN, KEY_PL4TPR, KEY_PL4SPR, KEY_PL4EPR,
            KEY_PL5P, KEY_PL5TECH1, KEY_PL5TECH2, KEY_PL5ENGN, KEY_PL5TECHN, KEY_PL5TPR, KEY_PL5SPR, KEY_PL5EPR,
            KEY_CARCLASS, KEY_PRICE, KEY_IMG, KEY_UT1, KEY_UT2, KEY_UT3, KEY_UT4, KEY_UT5
    };

    public BasicInfo getBasic(int id) {

        // 1. get reference to readable DB

        // 2. build query
        Cursor cursor =
                database.query(TABLE_MAIN, // a. table
                        BASICCOL, // b. column names
                        " id = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit
        BasicInfo card = new BasicInfo();
        try {
            // 3. if we got results get the first one
            if (cursor != null) {
                cursor.moveToFirst();

                // 4. build book object
                card = new BasicInfo(cursor.getInt(0), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(6), cursor.getInt(8), cursor.getInt(9), cursor.getInt(12), cursor.getString(1), cursor.getString(5), cursor.getDouble(7), cursor.getString(10), cursor.getInt(11), cursor.getInt(13));
            }
        } finally {
            // this gets called even if there is an exception somewhere above
            if (cursor != null)
                cursor.close();
        }
        return card;
    }

    public StatsObj getStats(int id) {

        // 1. get reference to readable DB

        // 2. build query
        Cursor cursor =
                database.query("stats_table", // a. table
                        STATSCOLS, // b. column names
                        " id = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit
        StatsObj card = new StatsObj();
        try {
            // 3. if we got results get the first one
            if (cursor != null)
                cursor.moveToFirst();

            // 4. build book object
            card = new StatsObj(
                    cursor.getFloat(0), cursor.getFloat(1), cursor.getFloat(2), cursor.getFloat(3),
                    cursor.getFloat(4), cursor.getFloat(5), cursor.getFloat(6), cursor.getFloat(7),
                    cursor.getFloat(8), cursor.getFloat(9), cursor.getFloat(10), cursor.getFloat(11),
                    cursor.getFloat(12), cursor.getFloat(13), cursor.getFloat(14), cursor.getFloat(15),
                    cursor.getInt(16), cursor.getInt(17), cursor.getInt(18), cursor.getInt(19)
            );
        } finally {
            // this gets called even if there is an exception somewhere above
            if (cursor != null)
                cursor.close();
        }

        return card;
    }

    public ProNObj getProNInfo(int cid) {


        // 1. build the query
        String query = "SELECT "
                + "accel1,top1,hand1,nitro1,"
                + "accel2,top2,hand2,nitro2,"
                + "accel3,top3,hand3,nitro3,"
                + "accel4,top4,hand4,nitro4,"
                + "accel5,top5,hand5,nitro5,"
                + "part1,tech11,tech21,tech1,eng1,tire1,susp1,drive1,exha1,"
                + "part2,tech12,tech22,tech2,eng2,tire2,susp2,drive2,exha2,"
                + "part3,tech13,tech23,tech3,eng3,tire3,susp3,drive3,exha3,"
                + "part4,tech14,tech24,tech4,eng4,tire4,susp4,drive4,exha4,"
                + "part5,tech15,tech25,tech5,eng5,tire5,susp5,drive5,exha5"
                + " FROM " + "normal_upgrades" + " WHERE " + "id = " + cid;

        // 2. get reference to writable DB
        Cursor cursor = database.rawQuery(query, null);
        ProNObj cards = new ProNObj();
        try {
            if (cursor != null)
                cursor.moveToFirst();

            int[][] max_table = new int[5][4];
            for(int i=0;i<5;i++)
            {
                for(int j=0;j<4;j++)
                {
                    try {
                        max_table[i][j] = cursor.getInt(((5 - 1) * i) + j);
                    }catch(NullPointerException e)
                    {
                        e.printStackTrace();
                        max_table[i][j] = 0;
                    }
                }
            }

            // 3. go over each row, build book and add it to list
            cards = new ProNObj(
                    cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getInt(3),
                    cursor.getInt(4), cursor.getInt(5), cursor.getInt(6), cursor.getInt(7),
                    cursor.getInt(8), cursor.getInt(9), cursor.getInt(10), cursor.getInt(11),
                    cursor.getInt(12), cursor.getInt(13), cursor.getInt(14), cursor.getInt(15),
                    cursor.getInt(16), cursor.getInt(17), cursor.getInt(18), cursor.getInt(19),max_table,

                    cursor.getInt(20), cursor.getInt(21), cursor.getInt(22), cursor.getInt(23), cursor.getInt(24), cursor.getInt(25), cursor.getInt(26), cursor.getInt(27), cursor.getInt(28),
                    cursor.getInt(29), cursor.getInt(30), cursor.getInt(31), cursor.getInt(32), cursor.getInt(33), cursor.getInt(34), cursor.getInt(35), cursor.getInt(36), cursor.getInt(37),
                    cursor.getInt(38), cursor.getInt(39), cursor.getInt(40), cursor.getInt(41), cursor.getInt(42), cursor.getInt(43), cursor.getInt(44), cursor.getInt(45), cursor.getInt(46),
                    cursor.getInt(47), cursor.getInt(48), cursor.getInt(49), cursor.getInt(50), cursor.getInt(51), cursor.getInt(52), cursor.getInt(53), cursor.getInt(54), cursor.getInt(55),
                    cursor.getInt(56), cursor.getInt(57), cursor.getInt(58), cursor.getInt(59), cursor.getInt(60), cursor.getInt(61), cursor.getInt(62), cursor.getInt(63), cursor.getInt(64)
            );
        } finally {
            // this gets called even if there is an exception somewhere above
            if (cursor != null)
                cursor.close();
        }
        // return books
        return cards;
    }

    public ProNBObj getProNBInfo(int cid) {

        ProNBObj cards;
        // 1. build the query
        String query1 = "SELECT "
                + "a1,t1,h1,n1,"
                + "a2,t2,h2,n2,"
                + "a3,t3,h3,n3,"
                + "a4,t4,h4,n4,"
                + "a5,t5,h5,n5,"
                + "a6,t6,h6,n6,"
                + "a7,t7,h7,n7,"
                + "a8,t8,h8,n8,"
                + "a9,t9,h9,n9,"
                + "a10,t10,h10,n10"
                + " FROM " + "bike_upgrades" + " WHERE " + "id = " + cid;

        String query2 = "SELECT "
                + "part1,tech11,tech21,tech1,eng1,tire1,susp1,drive1,exha1,"
                + "part2,tech12,tech22,tech2,eng2,tire2,susp2,drive2,exha2,"
                + "part3,tech13,tech23,tech3,eng3,tire3,susp3,drive3,exha3,"
                + "part4,tech14,tech24,tech4,eng4,tire4,susp4,drive4,exha4,"
                + "part5,tech15,tech25,tech5,eng5,tire5,susp5,drive5,exha5"
                + " FROM " + "normal_upgrades" + " WHERE " + "id = " + cid;

        // 2. get reference to writable DB
        Cursor cursor1 = database.rawQuery(query1, null);
        Cursor cursor2 = database.rawQuery(query2, null);
        try {
            if (cursor1 != null)
                cursor1.moveToFirst();

            if (cursor2 != null)
                cursor2.moveToFirst();

            // 3. go over each row, build book and add it to list
            cards = new ProNBObj(
                    cursor1.getInt(0), cursor1.getInt(1), cursor1.getInt(2), cursor1.getInt(3),
                    cursor1.getInt(4), cursor1.getInt(5), cursor1.getInt(6), cursor1.getInt(7),
                    cursor1.getInt(8), cursor1.getInt(9), cursor1.getInt(10), cursor1.getInt(11),
                    cursor1.getInt(12), cursor1.getInt(13), cursor1.getInt(14), cursor1.getInt(15),
                    cursor1.getInt(16), cursor1.getInt(17), cursor1.getInt(18), cursor1.getInt(19),
                    cursor1.getInt(20), cursor1.getInt(21), cursor1.getInt(22), cursor1.getInt(23),
                    cursor1.getInt(24), cursor1.getInt(25), cursor1.getInt(26), cursor1.getInt(27),
                    cursor1.getInt(28), cursor1.getInt(29), cursor1.getInt(30), cursor1.getInt(31),
                    cursor1.getInt(32), cursor1.getInt(33), cursor1.getInt(34), cursor1.getInt(35),
                    cursor1.getInt(36), cursor1.getInt(37), cursor1.getInt(38), cursor1.getInt(39),

                    cursor2.getInt(0), cursor2.getInt(1), cursor2.getInt(2), cursor2.getInt(3), cursor2.getInt(4), cursor2.getInt(5), cursor2.getInt(6), cursor2.getInt(7), cursor2.getInt(8),
                    cursor2.getInt(9), cursor2.getInt(10), cursor2.getInt(11), cursor2.getInt(12), cursor2.getInt(13), cursor2.getInt(14), cursor2.getInt(15), cursor2.getInt(16), cursor2.getInt(17),
                    cursor2.getInt(18), cursor2.getInt(19), cursor2.getInt(20), cursor2.getInt(21), cursor2.getInt(22), cursor2.getInt(23), cursor2.getInt(24), cursor2.getInt(25), cursor2.getInt(26),
                    cursor2.getInt(27), cursor2.getInt(28), cursor2.getInt(29), cursor2.getInt(30), cursor2.getInt(31), cursor2.getInt(32), cursor2.getInt(33), cursor2.getInt(34), cursor2.getInt(35),
                    cursor2.getInt(36), cursor2.getInt(37), cursor2.getInt(38), cursor2.getInt(39), cursor2.getInt(40), cursor2.getInt(41), cursor2.getInt(42), cursor2.getInt(43), cursor2.getInt(44)
            );
        } finally {
            // this gets called even if there is an exception somewhere above
            if (cursor2 != null)
                cursor2.close();

            if (cursor1 != null)
                cursor1.close();
        }
        // return books
        return cards;
    }

    public ProCObj getProCInfo(int cid) {
        ProCObj cards = new ProCObj();
        Cursor cursor = null;
        try {
            // 1. build the query
            String query = "SELECT "
                    + "part1,tech11,tech21,tech1,eng1,tire1,susp1,drive1,exha1,"
                    + "part2,tech12,tech22,tech2,eng2,tire2,susp2,drive2,exha2,"
                    + "part3,tech13,tech23,tech3,eng3,tire3,susp3,drive3,exha3,"
                    + "part4,tech14,tech24,tech4,eng4,tire4,susp4,drive4,exha4,"
                    + "part5,tech15,tech25,eng5,eng5,tire5,susp5,drive5,exha5,"
                    + "part6,tech16,tech26,tech5,eng6,tire6,susp6,drive6,exha6,"
                    + "part7,tech17,tech27,tech7,eng7,tire7,susp7,drive7,exha7,"
                    + "part8,tech18,tech28,tech8,eng8,tire8,susp8,drive8,exha8,"
                    + "part9,tech19,tech29,tech9,eng9,tire9,susp9,drive9,exha9,"
                    + "part10,tech110,tech210,tech10,eng10,tire10,susp10,drive10,exha10"
                    + " FROM " + "champ_upgrades" + " WHERE " + "id = " + cid;

            // 2. get reference to writable DB
            cursor = database.rawQuery(query, null);

            if (cursor != null) {
                cursor.moveToFirst();

                // 3. go over each row, build book and add it to list
                cards = new ProCObj(
                        cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5), cursor.getInt(6), cursor.getInt(7), cursor.getInt(8),
                        cursor.getInt(9), cursor.getInt(10), cursor.getInt(11), cursor.getInt(12), cursor.getInt(13), cursor.getInt(14), cursor.getInt(15), cursor.getInt(16), cursor.getInt(17),
                        cursor.getInt(18), cursor.getInt(19), cursor.getInt(20), cursor.getInt(21), cursor.getInt(22), cursor.getInt(23), cursor.getInt(24), cursor.getInt(25), cursor.getInt(26),
                        cursor.getInt(27), cursor.getInt(28), cursor.getInt(29), cursor.getInt(30), cursor.getInt(31), cursor.getInt(32), cursor.getInt(33), cursor.getInt(34), cursor.getInt(35),
                        cursor.getInt(36), cursor.getInt(37), cursor.getInt(38), cursor.getInt(39), cursor.getInt(40), cursor.getInt(41), cursor.getInt(42), cursor.getInt(43), cursor.getInt(44),
                        cursor.getInt(45), cursor.getInt(46), cursor.getInt(47), cursor.getInt(48), cursor.getInt(49), cursor.getInt(50), cursor.getInt(51), cursor.getInt(52), cursor.getInt(53),
                        cursor.getInt(54), cursor.getInt(55), cursor.getInt(56), cursor.getInt(57), cursor.getInt(58), cursor.getInt(59), cursor.getInt(60), cursor.getInt(61), cursor.getInt(62),
                        cursor.getInt(63), cursor.getInt(64), cursor.getInt(65), cursor.getInt(66), cursor.getInt(67), cursor.getInt(68), cursor.getInt(69), cursor.getInt(70), cursor.getInt(71),
                        cursor.getInt(72), cursor.getInt(73), cursor.getInt(74), cursor.getInt(75), cursor.getInt(76), cursor.getInt(77), cursor.getInt(78), cursor.getInt(79), cursor.getInt(80),
                        cursor.getInt(81), cursor.getInt(82), cursor.getInt(83), cursor.getInt(84), cursor.getInt(85), cursor.getInt(86), cursor.getInt(87), cursor.getInt(88), cursor.getInt(89)
                );
            }
        } finally {
            // this gets called even if there is an exception somewhere above
            if (cursor != null)
                cursor.close();
        }
        // return books
        return cards;
    }

    public MastObj getMastInfo(int cid) {


        // 1. build the query
        String query = "SELECT " + "rew1" + "," + "rew2" + "," + "rew3 " + "FROM " + "mastery_table" + " WHERE " + "id = " + cid;

        // 2. get reference to writable DB
        Cursor cursor = database.rawQuery(query, null);
        MastObj cards = new MastObj();
        try {
            if (cursor != null) {
                cursor.moveToFirst();

                // 3. go over each row, build book and add it to list
                cards = new MastObj(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // this gets called even if there is an exception somewhere above
            if (cursor != null)
                cursor.close();
        }
        // return books
        return cards;
    }

    public double getSCNitro(int id) {
        Cursor cursor = null;
        // 1. build the query
        String query = "SELECT nitro_sc FROM bike_speed WHERE id = " + id;
        double value = 0;
        try {
            // 2. get reference to writable DB
            cursor = database.rawQuery(query, null);

            if (cursor != null) {
                cursor.moveToFirst();

                // 3. go over each row, build book and add it to list
                value = cursor.getDouble(0);
            }
        } finally {
            // this gets called even if there is an exception somewhere above
            if (cursor != null)
                cursor.close();
        }
        // return books
        return value;
    }

    public EliteObj getEliteInfo(int cid) {
        EliteObj cards = new EliteObj();
        Cursor cursor = null;
        // 1. build the query
        String query = "SELECT " + "a5,t5,h5,n5,r5 FROM elite_stats WHERE id =" + cid;
        try {
            // 2. get reference to writable DB
            cursor = database.rawQuery(query, null);

            if (cursor != null) {
                cursor.moveToFirst();

                // 3. go over each row, build book and add it to list
                cards = new EliteObj(cursor.getFloat(0), cursor.getFloat(1), cursor.getFloat(2), cursor.getFloat(3), cursor.getInt(4));
            }
        } finally {
            // this gets called even if there is an exception somewhere above
            if (cursor != null)
                cursor.close();
        }
        // return books
        return cards;
    }

    public List<GItem> getOListerInput(int start, int end) {
        List<GItem> cards = new LinkedList<>();
        String query = "";
        String name = "";
        String drawablee = "";
        int idr = 0, id = 0, type = 0;
        Cursor cursor = null;
        try {
            // 1. build the query
            for (int i = start; i <= end; i++) {
                query = "SELECT " + KEY_NAME + "," + KEY_IMG + "," + KEY_ID + ",type,win FROM " + TABLE_MAIN + " WHERE " + KEY_ID + "=" + i;
                cursor = database.rawQuery(query, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    name = cursor.getString(0);
                    drawablee = cursor.getString(1);
                    idr = cursor.getInt(2);
                    type = cursor.getInt(3);
                }
                try {
                    id = mContext.getResources().getIdentifier(drawablee, "drawable", mContext.getPackageName());

                    Drawable drawable = mContext.getResources().getDrawable(id);

                    GItem e = new GItem(name, drawable, idr, type, cursor.getInt(4));
                    cards.add(e);
                } catch (Resources.NotFoundException e) {
                    id = mContext.getResources().getIdentifier("d_dart", "drawable", mContext.getPackageName());
                    Drawable drawable = mContext.getResources().getDrawable(id);
                    GItem ittem = new GItem(name, drawable, idr, type, cursor.getInt(4));
                    cards.add(ittem);
                }
                if (cursor != null)
                    cursor.close();

            }
            if (cursor != null)
                cursor.close();
        } finally {
            // this gets called even if there is an exception somewhere above
            if (cursor != null)
                cursor.close();
        }
        // return books
        return cards;
    }


    public List<GItem> getListerInput(int cid) {
        List<GItem> cards = new LinkedList<>();
        Cursor cursor = null;
        try {
            // 1. build the query
            String query = "SELECT " + KEY_NAME + "," + KEY_IMG + "," + KEY_ID + ",type,win FROM " + TABLE_MAIN + " WHERE " + KEY_CLASS + "=" + cid + " ORDER BY " + KEY_RANK;

            // 2. get reference to writable DB
            cursor = database.rawQuery(query, null);

            // 3. go over each row, build book and add it to list
            String name;
            String drawablee;
            int idr, id, type;
            if (cursor.moveToFirst()) {
                do {
                    name = cursor.getString(0);
                    drawablee = cursor.getString(1);
                    idr = cursor.getInt(2);
                    type = cursor.getInt(3);
                    try {

                        id = mContext.getResources().getIdentifier(drawablee, "drawable", mContext.getPackageName());
                        Drawable drawable = mContext.getResources().getDrawable(id);
                        GItem e = new GItem(name, drawable, idr, type, cursor.getInt(4));
                        cards.add(e);
                    } catch (Resources.NotFoundException e) {
                        id = mContext.getResources().getIdentifier("d_dart", "drawable", mContext.getPackageName());
                        Drawable drawable = mContext.getResources().getDrawable(id);
                        GItem ittem = new GItem(name, drawable, idr, type, cursor.getInt(4));
                        cards.add(ittem);
                    }

                } while (cursor.moveToNext());
            }
        } finally {
            // this gets called even if there is an exception somewhere above
            if (cursor != null)
                cursor.close();
        }
        // return books
        return cards;
    }

    public List<EngObj> getEListerInput(String eng) {
        List<EngObj> cards = new LinkedList<>();
        Cursor cursor = null;
        try {
            // 1. build the query
            String query = "SELECT id,name,engn,eng" + " FROM " + TABLE_MAIN + " WHERE " + "eng" + "= '" + eng + "' ORDER BY " + "engn";

            // 2. get reference to writable DB
            cursor = database.rawQuery(query, null);

            // 3. go over each row, build book and add it to list
            String name, eng1;
            int id, engn;
            if (cursor.moveToFirst()) {
                do {


                    id = cursor.getInt(0);
                    name = cursor.getString(1);
                    eng1 = cursor.getString(3);
                    engn = cursor.getInt(2);
                    EngObj e = new EngObj(id, name, engn, eng1);
                    cards.add(e);
                } while (cursor.moveToNext());
            }
        } finally {
            // this gets called even if there is an exception somewhere above
            if (cursor != null)
                cursor.close();
        }
        // return books
        return cards;
    }
}