package com.example.thestick;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private AnimatedVectorDrawable animation;
    private float degree = 0;
    private boolean doubleBackToExitPressedOnce = false;

    //initialize the socket using AsyncTask
    //public static BluetoothSocket btsocket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //button setup
        image = findViewById(R.id.main_button);
        Drawable d = image.getDrawable();
        if(d instanceof  AnimatedVectorDrawable)
        {
            animation = (AnimatedVectorDrawable) d;
            animation.start();
        }
        image.setRotation(degree);


        //when pressed go to another activity
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartDirecting();
            }
        });


        //TODO: add bluetooth code here to initialize the BluetoothSocket

    }

    //go to Direction Activity
    private void StartDirecting()
    {
        //TODO: add if statement to see if bluetooth connection established

        Intent intent = new Intent(this, Direction.class);
        startActivity(intent);
    }


    //double button press to exit
    @Override
    public void onBackPressed()
    {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}