package patterns.rubikcube.firstproduction.com.patternsforrubikcube;

/**
 * Created by Manish on 20-09-2015.
 */

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;



public class ProcedureActivity extends ActionBarActivity{

    public static final String EXTRA_PATTERN_ID =
            "com.rubikcubepattern.patternid";
    public static final String EXTRA_PATTERN_ID1=
            "com.rubikcubepattern.patternid1";
    private static final String DIALOG_HELP = "help";
    private static final String DIALOG_ADFREE   = "adfree";
    SharedPreferences prefs = null;

    //AsyncTaskLoadFiles myAsyncTaskLoadFiles;


    int id;
    private int[] mpatterns;

   Pattern p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedure);

        id=getIntent().getIntExtra(EXTRA_PATTERN_ID,1);

        p= PatternLab.get(getApplication()).getPattern(id);
        mpatterns=p.getMimg();
        GridView gridview = (GridView) findViewById(R.id.gridview);
        Button algoTv=(Button) findViewById(R.id.algorithm);

               View view = this.getWindow().getDecorView();
        view.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));

        gridview.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));


        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            gridview.setNumColumns(2);
        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            gridview.setNumColumns(4);
        }
        algoTv.setText("Algorithm : " + p.getAlgorithm());




gridview.setPadding(1, 1, 1, 1);
        gridview.setAdapter(new ImageAdapter1(this,mpatterns));


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){

                Intent i = new Intent(getApplicationContext(), SingleViewActivity.class);

                // Pass image index
                i.putExtra("id", position);
              i.putExtra("pid",p.getmId());
                i.putExtra(SingleViewActivity.EXTRA_PATTERN_ARRAY, mpatterns);

                startActivity(i);
            }
        });
    }
    private MenuItem mItem = null;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_pattern_name_procedure, menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.home){
            if (NavUtils.PARENT_ACTIVITY != null) {
                NavUtils.navigateUpFromSameTask(this);
            }
        }

        if(id == R.id.notations){
            FragmentManager fm1 = this.getFragmentManager();
            HelpFragment dialog1 = new HelpFragment();
            dialog1.show(fm1, DIALOG_HELP);

        }
        if(id==R.id.action_animations){
            FragmentManager fm1 = this.getFragmentManager();
            AdFreeFragment dialog1 = new AdFreeFragment();
            dialog1.show(fm1, DIALOG_ADFREE);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(getApplicationContext(),PatternsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);


    }
}

