package patterns.rubikcube.firstproduction.com.patternsforrubikcube;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

/**
 * Created by Manish on 01-01-2015.
 */
public class AdFreeFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final Context context = getActivity().getApplicationContext();
        LayoutInflater inflater = getActivity().getLayoutInflater();


        builder.setView(inflater.inflate(R.layout.adfree, null))
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        TextView textadfree = (TextView) AdFreeFragment.this.getDialog().findViewById(R.id.textadfree);


                    }


                })

                .setNegativeButton("Download", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("market://details?id=patterns.rubikcube.firstproduction.com.coolrubikcubepatternpro"));
                        startActivity(intent);

                    }
                });


        return builder.create();
    }
}
