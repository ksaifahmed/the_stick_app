package com.example.thestick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


public class Direction extends AppCompatActivity {
    private ImageView image;
    public static String dir = "Move Forward";
    private TextView direction;
    private AnimatedVectorDrawable animation;
    public static float degree = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);

        image = findViewById(R.id.arrow);
        direction = findViewById(R.id.direction_text);
        Drawable d = image.getDrawable();
        if(d instanceof  AnimatedVectorDrawable)
        {
            animation = (AnimatedVectorDrawable) d;
            animation.start();
        }

        //loop
        startUIThread();
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

    private void startUIThread() {
        Handler handler = new Handler();
        Runnable runnable = () -> {
            while (true) {
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                handler.post(new Runnable(){
                    public void run() {
                        image.setRotation(degree);
                        direction.setText(dir);
                        //Log.d("image: \t\t", String.valueOf(image.getRotation()));
                    }
                });
            }
        };
        new Thread(runnable).start();
    }

}