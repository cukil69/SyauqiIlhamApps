package com.cukil.syauqiilhamapps.view;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.cukil.syauqiilhamapps.R;
import com.cukil.syauqiilhamapps.databinding.ActivityGalleryViewerBinding;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class GalleryViewerActivity extends AppCompatActivity {

    private ActivityGalleryViewerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_gallery_viewer);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String image = getIntent().getStringExtra("image");
        String desc = getIntent().getStringExtra("desc");
        Glide.with(this).load(image).into(binding.imgGalleryFoto);
        getSupportActionBar().setTitle(desc);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
