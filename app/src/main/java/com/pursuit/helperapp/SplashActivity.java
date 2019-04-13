package com.pursuit.helperapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

        ImageView splashImage;
        private final int SPLASH_DISPLAY_LENGTH = 1000;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);
        }

        @Override
        protected void onStart() {
            super.onStart();
            splashImage.setImageResource(R.drawable.construction);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
