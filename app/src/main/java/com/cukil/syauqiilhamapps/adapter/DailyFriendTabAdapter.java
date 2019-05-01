package com.cukil.syauqiilhamapps.adapter;

import android.content.Context;

import com.cukil.syauqiilhamapps.R;
import com.cukil.syauqiilhamapps.model.Tutorial;
import com.cukil.syauqiilhamapps.view.DailyActivityFragment;
import com.cukil.syauqiilhamapps.view.ListFriendFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class DailyFriendTabAdapter extends FragmentPagerAdapter {

    private Context context;
    private List<Tutorial> list = new ArrayList<>();

    public DailyFriendTabAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        return i == 0 ? new DailyActivityFragment() : new ListFriendFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return position == 0 ? context.getString(R.string.title_daily_activity) : context.getString(R.string.title_friend_list);
    }
}
