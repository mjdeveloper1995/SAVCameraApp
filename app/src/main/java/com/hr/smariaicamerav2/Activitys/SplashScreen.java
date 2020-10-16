package com.hr.smariaicamerav2.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.hr.smariaicamerav2.R;


public class SplashScreen extends AppCompatActivity {
//private DBHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//        dbhelper = new DBHelper(SplashScreen.this);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // TODO: Your application init goes here.
                Intent mInHome = new Intent(SplashScreen.this,UserLoginActivity.class);
                SplashScreen.this.startActivity(mInHome);
                SplashScreen.this.finish();
            }
        }, 2000);
    }

}