package com.cukil.syauqiilhamapps.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cukil.syauqiilhamapps.databinding.FragmentListFriendBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class ListFriendFragment extends Fragment {

    private FragmentListFriendBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListFriendBinding.inflate(inflater);
        return binding.getRoot();
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        Reader jsonReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.list_activity)));
//        List<Activities> list = new Gson().fromJson(jsonReader, new TypeToken<ArrayList<Activities>>() {
//        }.getType());
//        DailyActivityAdapter dailyActivityAdapter = new DailyActivityAdapter(list);
//        binding.rclActivityListAct.setAdapter(dailyActivityAdapter);
//        binding.rclActivityListAct.setLayoutManager(new LinearLayoutManager(getContext()));
//    }
}
