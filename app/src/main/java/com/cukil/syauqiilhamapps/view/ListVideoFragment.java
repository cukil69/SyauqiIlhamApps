package com.cukil.syauqiilhamapps.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cukil.syauqiilhamapps.R;
import com.cukil.syauqiilhamapps.adapter.ListVideoAdapter;
import com.cukil.syauqiilhamapps.databinding.FragmentListVideoBinding;
import com.cukil.syauqiilhamapps.model.Video;
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

public class ListVideoFragment extends Fragment {

    private FragmentListVideoBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListVideoBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Reader jsonReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.list_video)));
        List<Video> list = new Gson().fromJson(jsonReader, new TypeToken<ArrayList<Video>>() {
        }.getType());
        ListVideoAdapter listVideoAdapter = new ListVideoAdapter(list);
        binding.rclVideoListVideo.setAdapter(listVideoAdapter);
        binding.rclVideoListVideo.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
