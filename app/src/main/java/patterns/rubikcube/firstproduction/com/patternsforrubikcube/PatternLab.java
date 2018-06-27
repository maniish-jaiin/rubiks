package patterns.rubikcube.firstproduction.com.patternsforrubikcube;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Manish on 19-09-2015.
 */
public class PatternLab {

    private static PatternLab sPatternLab;
    private ArrayList<Pattern> mPatterns;


    private PatternLab(Context appContext) {
        Context mAppContext = appContext;
        mPatterns = new ArrayList<Pattern>();


        int[] mth1 = {R.drawable.hole_1_min,
                R.drawable.hole_2_min,
                R.drawable.hole_3_min,
                R.drawable.hole_4_min,
                R.drawable.hole_5_min,
                R.drawable.hole_6_min,
                R.drawable.hole_7_min,
                R.drawable.hole_8_min,
                R.drawable.hole_9_min,


        };
        Pattern p1 = new Pattern();
        p1.setmId(0);
        p1.setmName("Four Hole");
        p1.setMimg(mth1);
        p1.setAlgorithm("F² B² U D' L² R² U D' ");

        mPatterns.add(p1);

        int[] mth2 = {R.drawable.sixhole_1_min,
                R.drawable.sixhole_2_min,
                R.drawable.sixhole_3_min,
                R.drawable.sixhole_4_min,
                R.drawable.sixhole_5_min,
                R.drawable.sixhole_6_min,
                R.drawable.sixhole_7_min,
                R.drawable.sixhole_8_min,
                R.drawable.sixhole_9_min,

        };


        Pattern p2 = new Pattern();
        p2.setmId(1);
        p2.setmName("Six Hole");
        p2.setAlgorithm("U D' B F' R L' U D'");
        p2.setMimg(mth2);
        mPatterns.add(p2);

        int[] mth3 = {R.drawable.cb_1_min,
                R.drawable.cb_2_min,
                R.drawable.cb_3_min,
                R.drawable.cb_4_min,
                R.drawable.cb_5_min,
                R.drawable.cb_6_min,
                R.drawable.cb_7_min,

        };

        Pattern p3 = new Pattern();
        p3.setmId(2);
        p3.setmName("Checker Board");
        p3.setMimg(mth3);
        p3.setAlgorithm("R² L² U² D² F² B²");
        mPatterns.add(p3);

        int[] mth4 = {R.drawable.sixt_1_min,
                R.drawable.sixt_2_min,
                R.drawable.sixt_3_min,
                R.drawable.sixt_4_min,
                R.drawable.sixt_5_min,
                R.drawable.sixt_6_min,
                R.drawable.sixt_7_min,
                R.drawable.sixt_8_min,
                R.drawable.sixt_9_min,
                R.drawable.sixt_10_min
        };


        Pattern p4 = new Pattern();
        p4.setmId(3);
        p4.setmName("Six T's");
        p4.setMimg(mth4);
        p4.setAlgorithm("F² R² U² F' B D² L² F B");
        mPatterns.add(p4);


        int[] mth5 = {R.drawable.cic_1_min,
                R.drawable.cic_2_min,
                R.drawable.cic_3_min,
                R.drawable.cic_4_min,
                R.drawable.cic_5_min,
                R.drawable.cic_6_min,
                R.drawable.cic_7_min,
                R.drawable.cic_8_min,
                R.drawable.cic_9_min,
                R.drawable.cic_10_min,
                R.drawable.cic_11_min,
                R.drawable.cic_12_min,
                R.drawable.cic_13_min,
                R.drawable.cic_14_min,
                R.drawable.cic_15_min,
                R.drawable.cic_16_min


        };


        Pattern p5 = new Pattern();
        p5.setmId(4);
        p5.setmName("Cube In Cube");
        p5.setMimg(mth5);
        p5.setAlgorithm("F L F U' R U F² L² U' L' B D' B' L² U");
        mPatterns.add(p5);


        int[] mth6 = {R.drawable.zz_1_min,
                R.drawable.zz_2_min,
                R.drawable.zz_3_min,
                R.drawable.zz_4_min,
                R.drawable.zz_5_min,
                R.drawable.zz_6_min,
                R.drawable.zz_7_min,
                R.drawable.zz_8_min,
                R.drawable.zz_9_min,
                R.drawable.zz_10_min,
                R.drawable.zz_11_min,
                R.drawable.zz_12_min,
                R.drawable.zz_13_min,
        };


        Pattern p6 = new Pattern();
        p6.setmId(5);
        p6.setmName("Zig Zag");
        p6.setAlgorithm("R L B F R L B F R L B F");
        p6.setMimg(mth6);
        mPatterns.add(p6);


    }


    public static PatternLab get(Context c) {
        if (sPatternLab == null) {
            sPatternLab = new PatternLab(c.getApplicationContext());

        }

        return sPatternLab;

    }


    public ArrayList<Pattern> getPatterns() {
        return mPatterns;
    }

    public Pattern getPattern(int id) {
        for (Pattern p : mPatterns) {
            if (p.getmId() == id)
                return p;
        }
        return null;
    }

}
