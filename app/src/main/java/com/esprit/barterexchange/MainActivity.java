package com.esprit.barterexchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    //animation variables
    Animation animTop ,animBottom;

    //layout variables
    ImageView img;
    LinearLayout btnLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //apply animation
        //load animations
        animTop = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        animBottom = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        ImageView img = findViewById(R.id.logo);
        LinearLayout btnLay = findViewById(R.id.btnLay);

        img.setAnimation(animTop);
        btnLay.setAnimation(animBottom);

    }



}