package com.example.beginners_project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {

    //anim vars

    private static int SPLASH_SCREEN=5000;

    Animation topm,botm;
    ImageView Gollaimage;
    TextView appname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        topm= AnimationUtils.loadAnimation(this,R.anim.biganim);
        botm=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        Gollaimage=(ImageView)findViewById(R.id.chobi);
        appname=findViewById(R.id.appname);

        Gollaimage.setAnimation(topm);
        appname.setAnimation(botm);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);


    }
}