package com.example.idunno;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class door1 extends AppCompatActivity {

    private boolean hasTransitioned = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door1);

    }

    public void transition(View view){
        //Using a transition drawable
        ImageView image = (ImageView) findViewById(R.id.imageView);
        Drawable drawable = image.getDrawable();
        if (drawable instanceof TransitionDrawable && hasTransitioned == false) {
            ((TransitionDrawable) drawable).startTransition(1000);
            hasTransitioned = true;
        }
        else {
            ((TransitionDrawable) drawable).reverseTransition(1000);
            hasTransitioned = false;
        }
    }
}
