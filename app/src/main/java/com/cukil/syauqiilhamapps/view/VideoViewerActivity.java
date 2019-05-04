package com.cukil.syauqiilhamapps.view;

import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;

import com.cukil.syauqiilhamapps.R;
import com.cukil.syauqiilhamapps.databinding.ActivityVideoViewerBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class VideoViewerActivity extends AppCompatActivity {

    private ActivityVideoViewerBinding binding;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_viewer);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String image = getIntent().getStringExtra("image");
        String title = getIntent().getStringExtra("title");
        String artist = getIntent().getStringExtra("artist");
        final String url = getIntent().getStringExtra("url");
//        Glide.with(this).load(image).into(binding.imgVideoAlbum);
        binding.txtVideoName.setText(title);
        binding.txtVideoArtist.setText(artist);
        playVideo(url);
    }

    public void playVideo(String videopath) {
        try {
            binding.prgVideoLoading.setVisibility(View.VISIBLE);
            getWindow().setFormat(PixelFormat.TRANSLUCENT);

            mediaController = new MediaController(this);

            Uri video = Uri.parse(videopath);
            binding.vdwVideoMain.setMediaController(mediaController);
            binding.vdwVideoMain.setVideoURI(video);

            binding.vdwVideoMain.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                public void onPrepared(MediaPlayer mp) {
                    binding.prgVideoLoading.setVisibility(View.GONE);
                    binding.vdwVideoMain.start();
                }
            });

        } catch (Exception e) {
            binding.prgVideoLoading.setVisibility(View.GONE);
            System.out.println("Video Play Error :" + e.getMessage());
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (binding.vdwVideoMain.isPlaying()) {
            binding.vdwVideoMain.stopPlayback();
        }
    }
}
