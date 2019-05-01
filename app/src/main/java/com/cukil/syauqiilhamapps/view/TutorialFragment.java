package com.cukil.syauqiilhamapps.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cukil.syauqiilhamapps.databinding.FragmentTutorialBinding;
import com.cukil.syauqiilhamapps.model.Tutorial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */


public class TutorialFragment extends Fragment {

    private FragmentTutorialBinding binding;
    private Tutorial item;

    public static TutorialFragment newInstance(Tutorial item) {
        TutorialFragment fragment = new TutorialFragment();
        fragment.setItem(item);
        return fragment;
    }

    public void setItem(Tutorial item) {
        this.item = item;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTutorialBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (item != null) {
            int imgResId = getContext().getResources().getIdentifier(item.getImage(), "drawable", getContext().getPackageName());
            binding.imgTutorialImage.setImageResource(imgResId);
            binding.txtTutorialTitle.setText(item.getTitle());
            binding.txtTutorialDesc.setText(item.getDesc());
        }
    }
}
