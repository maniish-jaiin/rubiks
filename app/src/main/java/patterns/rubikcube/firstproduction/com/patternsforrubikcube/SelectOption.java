package patterns.rubikcube.firstproduction.com.patternsforrubikcube;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SelectOption extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option);

        ImageButton learn = (ImageButton) findViewById(R.id.learn);
        ImageButton patterns = (ImageButton) findViewById(R.id.patterns);

        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectOption.this, PatternsActivity.class);
                startActivity(intent);
            }
        });

        patterns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectOption.this, PatternsActivity.class);
                startActivity(intent);
            }
        });
    }

}
