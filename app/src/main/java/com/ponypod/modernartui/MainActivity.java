package com.ponypod.modernartui;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
}
