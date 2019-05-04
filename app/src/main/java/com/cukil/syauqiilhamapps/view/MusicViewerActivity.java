package com.cukil.syauqiilhamapps.view;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.bumptech.glide.Glide;
import com.cukil.syauqiilhamapps.R;
import com.cukil.syauqiilhamapps.databinding.ActivityMusicViewerBinding;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class MusicViewerActivity extends AppCompatActivity {

    private ActivityMusicViewerBinding binding;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_music_viewer);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String image = getIntent().getStringExtra("image");
        String title = getIntent().getStringExtra("title");
        String artist = getIntent().getStringExtra("artist");
        final String url = getIntent().getStringExtra("url");
        Glide.with(this).load(image).into(binding.imgMusicAlbum);
        binding.txtMusicName.setText(title);
        binding.txtMusicArtist.setText(artist);
        binding.btnMusicPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer == null) {
                    try {
                        mediaPlayer = new MediaPlayer();
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mediaPlayer.setDataSource(url);
                        mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                            @Override
                            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                                binding.txtMusicLoading.setText("Buffering: " + i + "%");
                            }
                        });
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                binding.prgMusicLoading.setVisibility(View.GONE);
                                binding.btnMusicPlay.setImageResource(R.drawable.ic_pause);
                                binding.txtMusicLoading.setVisibility(View.INVISIBLE);
                                binding.btnMusicPlay.setEnabled(true);
                                mediaPlayer.start();
                            }
                        });
                        binding.prgMusicLoading.setVisibility(View.VISIBLE);
                        binding.txtMusicLoading.setVisibility(View.VISIBLE);
                        binding.btnMusicPlay.setEnabled(false);
                        mediaPlayer.prepareAsync();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    binding.btnMusicPlay.setImageResource(R.drawable.ic_play);
                } else {
                    mediaPlayer.start();
                    binding.btnMusicPlay.setImageResource(R.drawable.ic_pause);
                }
            }
        });
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
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying())
                mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
