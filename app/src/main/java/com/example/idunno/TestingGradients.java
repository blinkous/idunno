package com.example.idunno;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

public class TestingGradients extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_gradients);

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
        int[] colors = {
                Color.rgb(255, 255, 255),   //white
                Color.rgb(176, 66, 244),    //purple
                Color.rgb(0, 157, 255),     //blue
                Color.rgb(0,0,0)            //black
        };
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        RelativeLayout layout = findViewById(R.id.activity_testing_gradients);
        layout.setBackground(gradientDrawable);

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

}
