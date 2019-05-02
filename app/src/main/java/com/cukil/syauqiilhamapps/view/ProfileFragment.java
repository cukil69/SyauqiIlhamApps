package com.cukil.syauqiilhamapps.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cukil.syauqiilhamapps.R;
import com.cukil.syauqiilhamapps.databinding.FragmentProfileBinding;
import com.cukil.syauqiilhamapps.model.Profile;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class ProfileFragment extends Fragment implements OnMapReadyCallback {

    private FragmentProfileBinding binding;
    private GoogleMap mMap;
    private double lat, lng;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Reader jsonReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.profile)));
        Profile item = new Gson().fromJson(jsonReader, Profile.class);
        binding.txtProfileName.setText(item.getName());
        binding.txtProfileBio.setText(item.getBio());
        binding.txtProfileEmail.setText(item.getEmail());
        binding.txtProfilePhone.setText(item.getPhone());
        binding.txtProfileInstagram.setText(item.getInstagram());
        binding.txtProfileFacebook.setText(item.getFacebook());
        binding.txtProfileTwitter.setText(item.getTwitter());
        binding.txtProfileAddress.setText(item.getAddress());
        lat = Double.parseDouble(item.getLatLng().split(",")[0]);
        lng = Double.parseDouble(item.getLatLng().split(",")[1]);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.mapProfileMap);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setMapToolbarEnabled(false);
        LatLng loc = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(loc).title("Lokasi Saya"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
    }
}
