package com.cukil.syauqiilhamapps.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.cukil.syauqiilhamapps.adapter.MusicVideoTabAdapter;
import com.cukil.syauqiilhamapps.databinding.FragmentMusicVideoBinding;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class MusicVideoFragment extends Fragment {

    private FragmentMusicVideoBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMusicVideoBinding.inflate(inflater);
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbar);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MusicVideoTabAdapter adapter = new MusicVideoTabAdapter(getContext(), getChildFragmentManager());
        binding.vpgDailyViewPager.setAdapter(adapter);
        binding.tabDailyTab.setupWithViewPager(binding.vpgDailyViewPager);
    }
}
