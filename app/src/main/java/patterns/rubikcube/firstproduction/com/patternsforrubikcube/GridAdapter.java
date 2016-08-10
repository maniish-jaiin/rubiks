package patterns.rubikcube.firstproduction.com.patternsforrubikcube;

/**
 * Created by Manish on 20-09-2015.
 */
    import android.content.Context;
    import android.graphics.Bitmap;
    import android.graphics.BitmapFactory;
    import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
     * Created by Edwin on 28/02/2015.
     */
    public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

      List<Item> mItems;
Context mContext;
        OnItemClickListener mItemClickListener;

        public GridAdapter(Context c) {
            super();
            mContext=c;
            mItems =new ArrayList<Item>();
            Item pattern = new Item();
            pattern.setName("Four Hole");
            pattern.setThumbnail(R.drawable.four_hole_main_min);
            mItems.add(pattern);

            Item pattern1 = new Item();
            pattern1.setName("Six Hole");
            pattern1.setThumbnail(R.drawable.sixhole_main_min);
            mItems.add(pattern1);

            Item pattern2 = new Item();
            pattern2.setName("Checker Board");
            pattern2.setThumbnail(R.drawable.cb_main_min);
            mItems.add(pattern2);

            Item pattern3 = new Item();
            pattern3.setName("Six T's");
            pattern3.setThumbnail(R.drawable.sixt_main_min);
            mItems.add(pattern3);

            Item pattern4 = new Item();
            pattern4.setName("Cube In Cube");
            pattern4.setThumbnail(R.drawable.cic_main_min);
            mItems.add(pattern4);

            Item pattern5 = new Item();
            pattern5.setName("Zig Zag");
            pattern5.setThumbnail(R.drawable.zz_main_min);
            mItems.add(pattern5);


        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.grid_item, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            Item nature = mItems.get(i);

            viewHolder.tvspecies.setText(nature.getName());
            Bitmap bm=decodeSampledBitmapFromUri(nature.getThumbnail(),300,300);
            viewHolder.imgThumbnail.setImageBitmap(bm);




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

        @Override
        public int getItemCount() {

            return mItems.size();
        }

        public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
            this.mItemClickListener = mItemClickListener;
        }
        public interface OnItemClickListener {
            void onItemClick(View view, int position);
        }

        class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            public ImageView imgThumbnail;


            public TextView tvspecies;

            public ViewHolder(final View itemView) {
                super(itemView);
                imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
                tvspecies = (TextView)itemView.findViewById(R.id.tv_species);

                itemView.setOnClickListener(this);
              //  Animation animation = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.card_animation);
                //itemView.startAnimation(animation);







            }

            @Override
            public void onClick(View v) {

                if(mItemClickListener!=null) {
                    mItemClickListener.onItemClick(v,getPosition());


                }

            }

        }
    }
