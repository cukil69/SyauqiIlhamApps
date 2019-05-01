package com.cukil.syauqiilhamapps.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cukil.syauqiilhamapps.R;
import com.cukil.syauqiilhamapps.adapter.TutorialPagerAdapter;
import com.cukil.syauqiilhamapps.databinding.ActivityTutorialBinding;
import com.cukil.syauqiilhamapps.model.Tutorial;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class TutorialActivity extends AppCompatActivity {

    private ActivityTutorialBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tutorial);
        Reader jsonReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.list_tutorial)));
        List<Tutorial> list = new Gson().fromJson(jsonReader, new TypeToken<ArrayList<Tutorial>>() {
        }.getType());
        TutorialPagerAdapter tutorialPagerAdapter = new TutorialPagerAdapter(getSupportFragmentManager(), list);
        binding.vpgTutorialViewPager.setAdapter(tutorialPagerAdapter);
        binding.btnTutorialGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TutorialActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
