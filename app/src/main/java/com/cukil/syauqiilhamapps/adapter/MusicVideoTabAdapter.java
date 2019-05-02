package com.cukil.syauqiilhamapps.adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.cukil.syauqiilhamapps.R;
import com.cukil.syauqiilhamapps.view.ListMusicFragment;
import com.cukil.syauqiilhamapps.view.ListVideoFragment;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class MusicVideoTabAdapter extends FragmentPagerAdapter {

    private Context context;

    public MusicVideoTabAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        return i == 0 ? new ListMusicFragment() : new ListVideoFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return position == 0 ? context.getString(R.string.title_music) : context.getString(R.string.title_video);
    }
}
