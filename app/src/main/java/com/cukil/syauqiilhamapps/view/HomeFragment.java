package com.cukil.syauqiilhamapps.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.cukil.syauqiilhamapps.R;
import com.cukil.syauqiilhamapps.adapter.ProfileInterestAdapter;
import com.cukil.syauqiilhamapps.databinding.FragmentHomeBinding;
import com.cukil.syauqiilhamapps.model.Profile;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbar);

        Reader jsonReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.profile)));
        Profile item = new Gson().fromJson(jsonReader, Profile.class);
        Glide.with(getContext()).load(item.getImage()).into(binding.imgHomeProfile);
        ProfileInterestAdapter hobiAdapter = new ProfileInterestAdapter(item.getHobbies());
        ProfileInterestAdapter portoAdapter = new ProfileInterestAdapter(item.getPorto());
        ProfileInterestAdapter interestAdapter = new ProfileInterestAdapter(item.getInterest());
        ProfileInterestAdapter citaAdapter = new ProfileInterestAdapter(item.getCita());
        binding.txtHomeJmlPorto.setText(item.getPorto().size() + "");
        binding.txtHomeJmlHobi.setText(item.getHobbies().size() + "");
        binding.txtHomeName.setText(item.getName());
        binding.txtHomeBio.setText(item.getBio());
        binding.txtHomeEmail.setText(item.getEmail());
        binding.rclHomeListHobi.setAdapter(hobiAdapter);
        binding.rclHomeListHobi.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        binding.rclHomeListPorto.setAdapter(portoAdapter);
        binding.rclHomeListPorto.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        binding.rclHomeListInterest.setAdapter(interestAdapter);
        binding.rclHomeListInterest.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        binding.rclHomeListCita.setAdapter(citaAdapter);
        binding.rclHomeListCita.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        binding.btnHomeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).changeBottomNav(R.id.navigation_profile);
            }
        });
    }

}
