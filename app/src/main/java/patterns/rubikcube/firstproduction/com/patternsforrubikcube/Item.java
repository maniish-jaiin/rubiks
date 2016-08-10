package patterns.rubikcube.firstproduction.com.patternsforrubikcube;

/**
 * Created by Manish on 20-09-2015.
 */
public class Item {
    private String mName;
    private int mThumbnail;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.mThumbnail = thumbnail;
    }
}
