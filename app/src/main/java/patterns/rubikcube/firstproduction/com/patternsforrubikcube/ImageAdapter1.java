package patterns.rubikcube.firstproduction.com.patternsforrubikcube;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter1 extends BaseAdapter {
    private static LayoutInflater inflater = null;
    LruCache<Integer, Bitmap> imageCache;
    Context mContext;
    private int[] mPatterns;
    private ArrayList<String> mNumbers;


    public ImageAdapter1(Context c, int[] m) {
        mContext = c;
        mPatterns = m;
        mNumbers = new ArrayList<>();


        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int casheSize = maxMemory / 8;
        imageCache = new LruCache<>(casheSize);

    }

    public int getCount() {
        return mPatterns.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        View rowView;


        ViewHolder holder;
        for (int i = 1; i <= mPatterns.length; i++) {

            mNumbers.add("Step " + i);

        }


        if (convertView == null) {
            rowView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.program_list, parent, false);
        } else {
            rowView = convertView;
        }


        holder = new ViewHolder();
        holder.tv = (TextView) rowView.findViewById(R.id.textView1);
        holder.tv.setText(mNumbers.get(position));
        holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
        Bitmap bm = decodeSampledBitmapFromUri(mPatterns[position], 300, 300);

        holder.img.setImageBitmap(bm);


        return rowView;
    }


    public Bitmap decodeSampledBitmapFromUri(int img, int reqWidth,
                                             int reqHeight) {

        Bitmap bm = null;
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(mContext.getResources(), img, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth,
                reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeResource(mContext.getResources(), img, options);

        return bm;
    }

    public int calculateInSampleSize(

            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round((float) height
                        / (float) reqHeight);
            } else {
                inSampleSize = Math.round((float) width / (float) reqWidth);
            }
        }

        return inSampleSize;
    }

    public class ViewHolder {
        TextView tv;
        ImageView img;
    }
}

