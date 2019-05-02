package com.cukil.syauqiilhamapps.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cukil.syauqiilhamapps.R;
import com.cukil.syauqiilhamapps.adapter.DailyActivityAdapter;
import com.cukil.syauqiilhamapps.adapter.ListFriendAdapter;
import com.cukil.syauqiilhamapps.databinding.FragmentDailyFriendBinding;
import com.cukil.syauqiilhamapps.model.Activities;
import com.cukil.syauqiilhamapps.model.Friend;
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

public class DailyFriendFragment extends Fragment {

    private FragmentDailyFriendBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDailyFriendBinding.inflate(inflater);
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbar);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupDailyActivity();
        setupFriendList();
    }

    private void setupDailyActivity() {
        Reader jsonReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.list_activity)));
        List<Activities> list = new Gson().fromJson(jsonReader, new TypeToken<ArrayList<Activities>>() {
        }.getType());
        DailyActivityAdapter dailyActivityAdapter = new DailyActivityAdapter(list);
        binding.rclActivityListAct.setAdapter(dailyActivityAdapter);
        binding.rclActivityListAct.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rclActivityListAct.addItemDecoration(new DividerItemDecoration(getContext(), RecyclerView.VERTICAL));
        binding.rclActivityListAct.setNestedScrollingEnabled(false);
    }

    private void setupFriendList() {
        Reader jsonReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.list_friend)));
        List<Friend> list = new Gson().fromJson(jsonReader, new TypeToken<ArrayList<Friend>>() {
        }.getType());
        ListFriendAdapter listFriendAdapter = new ListFriendAdapter(list);
        binding.rclFriendListFriend.setAdapter(listFriendAdapter);
        binding.rclFriendListFriend.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        binding.rclFriendListFriend.setNestedScrollingEnabled(false);
    }
}
