package com.cukil.syauqiilhamapps.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.cukil.syauqiilhamapps.model.Tutorial;
import com.cukil.syauqiilhamapps.view.TutorialFragment;

import java.util.ArrayList;
import java.util.List;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class TutorialPagerAdapter extends FragmentPagerAdapter {

    private List<Tutorial> list = new ArrayList<>();

    public TutorialPagerAdapter(FragmentManager fm, List<Tutorial> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return TutorialFragment.newInstance(list.get(i));
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
