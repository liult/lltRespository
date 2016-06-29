package com.dayi.app.moudle.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.dayi.app.R;
import com.dayi.app.moudle.main.MainActivity;

public class SplashActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.start(SplashActivity.this);
                finish();
            }
        }, 1000);
    }
}
