package com.cukil.syauqiilhamapps.view;

import android.os.Bundle;
import android.view.MenuItem;

import com.cukil.syauqiilhamapps.R;
import com.cukil.syauqiilhamapps.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            getSupportActionBar().setTitle(item.getTitle());
//            binding.navMainNavigation.setSelectedItemId(item.getItemId());
            changeFragment(item.getItemId());
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        setSupportActionBar(binding.tlbMainToolbar);
        changeFragment(R.id.navigation_home);
        binding.navMainNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void changeFragment(int itemId) {
        Fragment fragment;
        switch (itemId) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_daily_activity:
                fragment = new DailyFriendFragment();
                break;
            case R.id.navigation_gallery:
                fragment = new GalleryFragment();
                break;
            case R.id.navigation_music_video:
                fragment = new MusicVideoFragment();
                break;
            case R.id.navigation_profile:
                fragment = new ProfileFragment();
                break;
            default:
                fragment = new HomeFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frmMainFrame, fragment).commit();
    }

    public void changeBottomNav(int itemId) {
        binding.navMainNavigation.setSelectedItemId(itemId);
    }

}
