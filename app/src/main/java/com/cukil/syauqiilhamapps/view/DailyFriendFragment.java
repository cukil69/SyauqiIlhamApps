package com.cukil.syauqiilhamapps.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cukil.syauqiilhamapps.adapter.DailyFriendTabAdapter;
import com.cukil.syauqiilhamapps.databinding.FragmentDailyFriendBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class DailyFriendFragment extends Fragment {

    private FragmentDailyFriendBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDailyFriendBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DailyFriendTabAdapter adapter = new DailyFriendTabAdapter(getContext(), getChildFragmentManager());
        binding.vpgDailyViewPager.setAdapter(adapter);
        binding.tabDailyTab.setupWithViewPager(binding.vpgDailyViewPager);
    }
}
