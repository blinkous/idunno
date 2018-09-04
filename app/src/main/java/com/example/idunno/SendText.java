package com.example.idunno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SendText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_text);
    }

//    // Create the text message with a string
//    Intent sendIntent = new Intent();
//sendIntent.setAction(Intent.ACTION_SEND);
//sendIntent.setType("text/plain");
//sendIntent.putExtra(Intent.EXTRA_TEXT, "Hello");
//    // Start the activity
//    startActivity(sendIntent);
}
