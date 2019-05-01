package com.cukil.syauqiilhamapps.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.cukil.syauqiilhamapps.R;
import com.cukil.syauqiilhamapps.util.PreferenceHelper;

import androidx.appcompat.app.AppCompatActivity;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, TutorialActivity.class);
                startActivity(i);
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        }, PreferenceHelper.getBoolean(this, PreferenceHelper.KEY_FIRST_TIME, true) ? 1500 : 800);
    }
}
