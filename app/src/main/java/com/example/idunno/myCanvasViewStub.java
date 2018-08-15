package com.example.idunno;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.widget.SeekBar;

import yuku.ambilwarna.AmbilWarnaDialog;


public class myCanvasViewStub extends AppCompatActivity {

    /*Paint code from https://medium.com/@ssaurel/learn-to-create-a-paint-application-for-android-5b16968063f8*/
    private static PaintView myPaintView;
    private int newSize;
    private boolean stubIsInflated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_canvas_viewstub);
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
        if (!stubIsInflated) {


            ViewStub stub = findViewById(R.id.seekbarStub);

            final SeekBar seekbar = findViewById(R.id.seekBar);
            seekbar.setProgress(myPaintView.getSize());
            /**Setting the seekbar listener to capture when the user changes the progress to change the brush size**/
            seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    newSize = progress*2;
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    myPaintView.setSize(newSize);
                }
            });

            View inflated = stub.inflate();


            stubIsInflated = true;
        }
    }
}
