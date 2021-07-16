package com.example.thestick;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private AnimatedVectorDrawable animation;
    private float degree = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.arrow);
//        image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        Log.d("\t\tclicked", "image\t\tview");
        Drawable d = image.getDrawable();
        if(d instanceof  AnimatedVectorDrawable)
        {
            animation = (AnimatedVectorDrawable) d;
            animation.start();
        }
        degree += 90;

        image.setRotation(degree);
    }
}