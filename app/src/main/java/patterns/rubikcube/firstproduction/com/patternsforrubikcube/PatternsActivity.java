package patterns.rubikcube.firstproduction.com.patternsforrubikcube;

/**
 * Created by Manish on 20-09-2015.
 */


import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class PatternsActivity extends ActionBarActivity {

    private static final String DIALOG_HELP = "help";
    private static final String DIALOG_ABOUT = "about";
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    GridAdapter mAdapter;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern);

        // Calling the RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2360690894907135/3579201604");
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("YOUR_DEVICE_HASH").build();

        mInterstitialAd.loadAd(adRequest);
        AdView adView = (AdView) this.findViewById(R.id.adView);


        adView.loadAd(adRequest);


        // Prepare an Interstitial Ad Listener
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                displayInterstitial();
            }
        });

        // The number of Columns
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));

        int actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        if (actionBarTitleId > 0) {
            TextView title = (TextView) findViewById(actionBarTitleId);
            if (title != null) {
                title.setTextColor(Color.WHITE);
            }
        }

        mRecyclerView.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mLayoutManager = new GridLayoutManager(this, 2);
        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mLayoutManager = new GridLayoutManager(this, 2);
        }

        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new GridAdapter(getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new GridAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {


                Intent i = new Intent(view.getContext(), ProcedureActivity.class);
                i.putExtra(ProcedureActivity.EXTRA_PATTERN_ID, position);


                startActivity(i);


            }
        });


    }

    public void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd
                    .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pattern_name, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();
        if (id == R.id.home) {
            if (NavUtils.getParentActivityName(this) != null) {
                NavUtils.navigateUpFromSameTask(this);
            }
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.notations) {
            FragmentManager fm1 = this.getFragmentManager();
            HelpFragment dialog1 = new HelpFragment();
            dialog1.show(fm1, DIALOG_HELP);

        }
        if (id == R.id.action_about) {
            FragmentManager fm2 = this.getFragmentManager();
            AboutFragment dialog2 = new AboutFragment();
            dialog2.show(fm2, DIALOG_ABOUT);


        }

        if (id == R.id.adfree) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=patterns.rubikcube.firstproduction.com.coolrubikcubepatternpro"));

            startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }


}