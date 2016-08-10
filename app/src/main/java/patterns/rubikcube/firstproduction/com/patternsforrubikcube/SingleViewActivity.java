package patterns.rubikcube.firstproduction.com.patternsforrubikcube;

/**
 * Created by Manish on 20-09-2015.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SingleViewActivity extends ActionBarActivity {

    public static final String EXTRA_PATTERN_ARRAY = "com.rubikcubepattern.patternid";
    int[] mPatterns;
    int pposition;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_view);

        final Button next = (Button) findViewById(R.id.next);
        Button previous = (Button) findViewById(R.id.previous);



        // Get intent data
       Intent i = getIntent();


        // Selected image id
       final int position = i.getExtras().getInt("id");
       pposition=i.getExtras().getInt("pid");
        mPatterns = i.getIntArrayExtra(EXTRA_PATTERN_ARRAY);
        int pos=position+1;
        setTitle("Preview " + pos );


         ImageView imageView = (ImageView) findViewById(R.id.SingleView);
        imageView.setImageResource(mPatterns[position]);

        if(position==mPatterns.length - 1){
            next.setClickable(false);
            next.setEnabled(false);

        }
        if(position==0){
            previous.setClickable(false);
            previous.setEnabled(false);

        }

if(next.isEnabled()) {
    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            Intent i = new Intent(getApplicationContext(), SingleViewActivity.class);

            // Pass image index
            i.putExtra("id", position + 1);
            i.putExtra(SingleViewActivity.EXTRA_PATTERN_ARRAY, mPatterns);
            i.putExtra("pid", pposition);
            startActivity(i);
            SingleViewActivity.this.overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);


        }
    });
}
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i = new Intent(getApplicationContext(), SingleViewActivity.class);

                // Pass image index
                i.putExtra("id", position - 1);
                i.putExtra(SingleViewActivity.EXTRA_PATTERN_ARRAY, mPatterns);
                i.putExtra("pid", pposition);
                startActivity(i);
                SingleViewActivity.this.overridePendingTransition( R.anim.slide_in_up1, R.anim.slide_out_up1 );


            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(getApplicationContext(),ProcedureActivity.class);
        intent.putExtra(ProcedureActivity.EXTRA_PATTERN_ID,pposition);
        startActivity(intent);


    }
}