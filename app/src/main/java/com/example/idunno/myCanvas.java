package com.example.idunno;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import yuku.ambilwarna.AmbilWarnaDialog;


public class myCanvas extends AppCompatActivity {

    /*PaintView and FingerPath code from https://medium.com/@ssaurel/learn-to-create-a-paint-application-for-android-5b16968063f8*/
    private static PaintView myPaintView;
    private int newSize;
    private final SeekbarAlert seekbarAlert = new SeekbarAlert(this, "Select a size", R.style.myAlertStyle);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_canvas);
        myPaintView = (PaintView) findViewById(R.id.paintView);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        myPaintView.init(metrics);
    }

    public void changeColor(View view) {
        int initialColor = myPaintView.getColor();

        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, initialColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                // color is the color selected by the user.
                myPaintView.setColor(color);
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                // cancel was selected by the user
            }

        });

        dialog.show();
    }

    public void clearCanvas(View view) {
        myPaintView.clear();
    }

    public void changeBrushSize(View view) {
        /**
         * Still working on implementing the seekbar class
         * current error: it changes the size to the previous progress change on the seekbar, not the current
         * issue looks like it is because the size change call doesn't happen in the onStopTrackingTouch func
         */
//        newSize = myPaintView.getSize();
////        seekbarAlert.setCurrentProgress(newSize);
//        seekbarAlert.build();
//        newSize = seekbarAlert.getSeekbarProgress();
//        myPaintView.setSize(newSize);
//
//        myPaintView.setSize(seekbarAlert.getSeekbarProgress());

        /**Creating an alert dialog using the builder and myAlertStyle defined in styles.xml**/
        AlertDialog.Builder builder = new AlertDialog.Builder(myCanvas.this, R.style.myAlertStyle);
        builder.setTitle(R.string.alert_mess);

        final SeekBar seekbar = new SeekBar(this);
        /**Setting the current seekbar progress to the current size of the brush**/
        seekbar.setProgress(myPaintView.getSize());
//        seekbar.setMax(200);
        /**Setting the view of the alert dialog to the seekbar**/
        builder.setView(seekbar);

        /**Setting the seekbar listener to capture when the user changes the progress to change the brush size**/
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                newSize = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                myPaintView.setSize(newSize);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
