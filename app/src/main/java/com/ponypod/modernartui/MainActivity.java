package com.ponypod.modernartui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SeekBar seekBar;
    private FrameLayout square1;
    private FrameLayout square2;
    private FrameLayout square3;
    private FrameLayout square4;
    private FrameLayout square5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        square1 = (FrameLayout) findViewById(R.id.square_1);
        square2 = (FrameLayout) findViewById(R.id.square_2);
        square3 = (FrameLayout) findViewById(R.id.square_3);
        square4 = (FrameLayout) findViewById(R.id.square_4);
        square5 = (FrameLayout) findViewById(R.id.square_5);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                square1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.square1) + progress);
                square2.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.square2) + progress);
                square3.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.square3) + progress);
                square5.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.square5) + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.more_info:
                showMoreInfo();
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }
    }

    public void showMoreInfo() {
        DialogFragment more = MoreInfoDialog.newInstance();
        more.show(getSupportFragmentManager(), "MoreInfo");
    }

    public static class MoreInfoDialog extends DialogFragment {

        public static MoreInfoDialog newInstance() {
            return new MoreInfoDialog();
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new AlertDialog.Builder(getActivity())
                    .setMessage(R.string.dialog_title)
                    .setPositiveButton(R.string.dialog_visit_moma, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.i(TAG, "Going to MOMA");
                        }
                    })
                    .setNegativeButton(R.string.dialog_not_now, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.i(TAG, "Clicked not now");
                        }
                    })
                    .create();
        }
    }
}




























