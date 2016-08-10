package patterns.rubikcube.firstproduction.com.patternsforrubikcube;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;

/**
 * Created by Manish on 01-01-2015.
 */
public class HelpFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
       AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final Context context = getActivity().getApplicationContext();
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.help, null))
        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                ImageView img=(ImageView) HelpFragment.this.getDialog().findViewById(R.id.imgHelp);
                img.setImageResource(R.drawable.notation2);


            }


        });



                return builder.create();    }
}
