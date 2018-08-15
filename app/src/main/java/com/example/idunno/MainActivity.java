package com.example.idunno;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private boolean darkModeOn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Animates the background colors of the main screen using anim_2 in res/animator**/
        ConstraintLayout myCon = findViewById(R.id.mainLayout);
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,
                R.animator.anim_2);
        set.setTarget(myCon);
        set.start();
    }

    public void switchTheme(View view){
        if (darkModeOn) {

            ConstraintLayout myCon = findViewById(R.id.mainLayout);
            myCon.postInvalidate();
            setTheme(R.style.LightTheme);
            AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,
                    R.animator.anim_2);
            set.setTarget(myCon);
            set.start();
            darkModeOn = false;
        }
        else {

            ConstraintLayout myCon = findViewById(R.id.mainLayout);
            myCon.postInvalidate();
            setTheme(R.style.DarkTheme);
            AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,
                    R.animator.anim_2dark);
            set.setTarget(myCon);
            set.start();
            darkModeOn = true;
        }
    }

    public void testing(View view){
        Intent intent = new Intent(this, TestingGradients.class);
        startActivity(intent);
    }

    public void letsDraw(View view){
        Intent intent = new Intent(this, myCanvas.class);
        startActivity(intent);
    }

    public void door1(View view){
        Intent intent = new Intent(this, door1.class);
        startActivity(intent);
    }

    public void door2(View view){
        Intent intent = new Intent(this, door2.class);
        startActivity(intent);
    }

    public void door3(View view){
        Intent intent = new Intent(this, door3.class);
        startActivity(intent);
    }

    public void mysteryNow(View view){
        /**Experimenting with animators and toasts**/

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));
/*        int col = Color.WHITE;
        layout.setBackgroundColor(col);*/

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("i wonder what that did...");

        Toast toast = new Toast(getApplicationContext());
//        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

        /*
        //This code changes the button text from purple to white infinitely when the property name is set to textColor
        Button mystButton = findViewById(R.id.mysteryButton);
        mystButton.getBackground();
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,
                R.animator.anim_2);
        set.setTarget(mystButton);
        set.start();*/

        /*
        ImageView image = (ImageView) findViewById(R.id.mysteryImageAndy);
        Animation hyperspaceJump = AnimationUtils.loadAnimation(this, R.anim.animm);
        hyperspaceJump.setDuration(500);
        hyperspaceJump.setRepeatCount(-1);
        hyperspaceJump.setRepeatMode(2);
        image.startAnimation(hyperspaceJump);*/


        /*       int color = Color.rgb(100,000,100);
        ObjectAnimator animator = ObjectAnimator.ofArgb(findViewById(R.id.mysteryButton), "android:background", color);
        animator.start();*/

        /*AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.animtest);
        set.setTarget(findViewById(R.id.mysteryButton));
        set.start();*/


/*        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This is a custom toast");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();*/

        /*Random rand = new Random();
        int  n = rand.nextInt(3) + 1;

        switch(n){
            case 1:
                Intent intent = new Intent(this, guess1.class);
                startActivity(intent);
                break;
            case 2:
                Intent intent2 = new Intent(this, guess2.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(this, guess3.class);
                startActivity(intent3);
                break;
        }
*/
    }
}
