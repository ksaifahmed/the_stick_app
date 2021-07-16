package com.example.thestick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;


public class Direction extends AppCompatActivity {
    private ImageView image;
    private AnimatedVectorDrawable animation;
    private float degree = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);

        image = findViewById(R.id.arrow);
        Drawable d = image.getDrawable();
        if(d instanceof  AnimatedVectorDrawable)
        {
            animation = (AnimatedVectorDrawable) d;
            animation.start();
        }

        //loop
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                {
                    try {
                        //TODO: if bluetooth connection disrupts call StopDirecting()

                        Thread.sleep(1200);
                        //direction of arrow
                        degree += 90;
                        image.setRotation(degree);
                        Log.d("image: \t\t", String.valueOf(image.getRotation()));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }


    @Override
    public void onBackPressed()
    {
        StopDirecting();
    }



    private void StopDirecting()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}