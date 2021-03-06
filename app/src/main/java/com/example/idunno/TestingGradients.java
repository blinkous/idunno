package com.example.idunno;

import android.animation.Animator;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TestingGradients extends AppCompatActivity {

    private int transition = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_gradients);

        /**
         * Sets a background image view to use a view animator to display a
         * set of 3 gradient images
         */
        ImageView image = (ImageView) findViewById(R.id.backImage);
        image.setBackgroundResource(R.drawable.grad_anim);

        Drawable gradientAnimation = image.getBackground();
        if (gradientAnimation instanceof Animatable) {
            ((Animatable)gradientAnimation).start();
        }

        /**
         * creates an oval gradient using the colors array
         * sets the imageView myRing's drawable to the gradient
         */
/*        int[] colors = {
                Color.rgb(255,255,255),
                Color.rgb(0,0,0)
        };
        GradientDrawable gd = new GradientDrawable();
        ImageView image = (ImageView) findViewById(R.id.myRing);
        gd.setColors(colors);
        gd.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        gd.setShape(GradientDrawable.OVAL);
        gd.setSize(200, 200); //Setting the size ensures that the shape remains a circle and doesn't get stretched
        image.setImageDrawable(gd);*/

        /**
         *does the same thing as the above code using a constructor to pass in colors and orientation
         */
        /*int[] colors = {
                Color.rgb(255, 255, 255),
                Color.rgb(0, 0, 0)
        };
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
        gradientDrawable.setShape(GradientDrawable.OVAL);
        gradientDrawable.setSize(200, 200);
        ImageView image = (ImageView) findViewById(R.id.myRing);
        image.setImageDrawable(gradientDrawable);*/

        /**
         * creates an rectangle gradient using the colors array
         * sets the imageView myRing's drawable to the gradient
         */
        /*int[] colors = {
                Color.rgb(255, 255, 255),   //white
                Color.rgb(176, 66, 244),    //purple
                Color.rgb(0, 157, 255),     //blue
                Color.rgb(0,0,0)            //black
        };
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        RelativeLayout layout = findViewById(R.id.activity_testing_gradients);
        layout.setBackground(gradientDrawable);*/

//        ImageView image = (ImageView) findViewById(R.id.myRing);
//        image.setImageDrawable(gradientDrawable);

        /**
         * fetches the drawable resource rect_blue_black_gradient and
         * sets the imageView myRing's drawable to the drawable
         */
        /*Resources res = getResources();
        Drawable rect = ResourcesCompat.getDrawable(res, R.drawable.rect_blue_black_gradient, getTheme());
        ImageView iv = (ImageView) findViewById(R.id.myRing);
        iv.setBackground(rect);*/


    }

    public void clickedOhNo(View view){
        ImageView image = (ImageView) findViewById(R.id.myRingWhite);
        Animation hyperspaceJump = AnimationUtils.loadAnimation(this, R.anim.animm);
        image.startAnimation(hyperspaceJump);
    }

    /*public void changeGradient(View view){
        *//**
         * Attempting to creating a background of transitioning drawables
         * only iterates once, the loop doesn't restart the transitions
         *//*

        ImageView image1 = (ImageView) findViewById(R.id.gradImage1);
        Drawable drawable1 = image1.getDrawable();

        ImageView image2 = (ImageView) findViewById(R.id.gradImage2);
        Drawable drawable2 = image2.getDrawable();

        ImageView image3 = (ImageView) findViewById(R.id.gradImage3);
        Drawable drawable3 = image3.getDrawable();

        int i = 0;

        while (i < 10) {
            ((TransitionDrawable) drawable1).resetTransition();
            ((TransitionDrawable) drawable2).resetTransition();
            ((TransitionDrawable) drawable3).resetTransition();

            //Using a transition drawable
            image2.setImageAlpha(0);
            image3.setImageAlpha(0);
            image1.setImageAlpha(1);
            ((TransitionDrawable) drawable1).startTransition(500);

            image1.setImageAlpha(0);
            image3.setImageAlpha(0);
            image2.setImageAlpha(1);
            ((TransitionDrawable) drawable2).startTransition(500);

            image2.setImageAlpha(0);
            image1.setImageAlpha(0);
            image3.setImageAlpha(1);
            ((TransitionDrawable) drawable3).startTransition(500);

            i++;
        }
    }*/

}
