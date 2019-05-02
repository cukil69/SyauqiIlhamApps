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
import com.cukil.syauqiilhamapps.adapter.ListMusicAdapter;
import com.cukil.syauqiilhamapps.databinding.FragmentListMusicBinding;
import com.cukil.syauqiilhamapps.model.Music;
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

public class ListMusicFragment extends Fragment {

    private FragmentListMusicBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListMusicBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Reader jsonReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.list_music)));
        List<Music> list = new Gson().fromJson(jsonReader, new TypeToken<ArrayList<Music>>() {
        }.getType());
        ListMusicAdapter listMusicAdapter = new ListMusicAdapter(list);
        binding.rclMusicListMusic.setAdapter(listMusicAdapter);
        binding.rclMusicListMusic.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rclMusicListMusic.addItemDecoration(new DividerItemDecoration(getContext(), RecyclerView.VERTICAL));
    }
}
