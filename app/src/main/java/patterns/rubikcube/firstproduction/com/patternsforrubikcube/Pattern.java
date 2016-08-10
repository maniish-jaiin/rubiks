package patterns.rubikcube.firstproduction.com.patternsforrubikcube;

/**
 * Created by Manish on 19-09-2015.
 */
public class Pattern {

    private int mId;
    private String mName;
    private String algorithm;

    private int[] mimg;

    public int[] getMimg() {
        return mimg;
    }

    public void setMimg(int[] mimg) {
        this.mimg = mimg;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public int getmId() {
        return mId;
    }



    public void setmId(int mId) {
        this.mId = mId;
    }





    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public String toString() {
        return mName;
    }



}
