package com.example.idunno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void letsDraw(View view){
        Intent intent = new Intent(this, myCanvas.class);
        startActivity(intent);
    }

    public void letsDrawColor(View view){
        Intent intent = new Intent(this, myColor.class);
        startActivity(intent);
    }

    public void startNow(View view){
        Intent intent = new Intent(this, door2.class);
        startActivity(intent);
    }

    public void door2Go(View view){
        Intent intent = new Intent(this, door2.class);
        startActivity(intent);
    }

    public void door3Now(View view){
        Intent intent = new Intent(this, startAgain.class);
        startActivity(intent);
    }

    public void mysteryNow(View view){

        Random rand = new Random();
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

    }
}
