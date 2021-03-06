package com.cukil.syauqiilhamapps.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.cukil.syauqiilhamapps.R;
import com.cukil.syauqiilhamapps.adapter.GalleryAdapter;
import com.cukil.syauqiilhamapps.databinding.FragmentGalleryBinding;
import com.cukil.syauqiilhamapps.model.Foto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater);
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbar);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Reader jsonReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.list_foto)));
        List<Foto> list = new Gson().fromJson(jsonReader, new TypeToken<ArrayList<Foto>>() {
        }.getType());
        GalleryAdapter galleryAdapter = new GalleryAdapter(list);
        binding.rclGalleryListFoto.setAdapter(galleryAdapter);
        binding.rclGalleryListFoto.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }
}
