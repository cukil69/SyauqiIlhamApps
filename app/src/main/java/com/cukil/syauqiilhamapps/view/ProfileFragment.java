package com.cukil.syauqiilhamapps.view;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
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
    private Profile item;

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
        item = new Gson().fromJson(jsonReader, Profile.class);
        Glide.with(getContext()).load(item.getImage()).into(binding.imgProfileProfile);
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
        binding.btnProfileAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialog_about);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.findViewById(R.id.btnAboutClose).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        binding.btnProfileEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail(v);
            }
        });
        binding.btnProfilePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPhone(v);
            }
        });
        binding.btnProfileFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFacebook(v);
            }
        });
        binding.btnProfileInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToInstagram(v);
            }
        });
        binding.btnProfileTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTwitter(v);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setMapToolbarEnabled(false);
        LatLng loc = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(loc).title("Lokasi Saya"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
    }

    public void goToInstagram(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.instagram.com/" + item.getInstagram()));
        startActivity(i);
    }

    public void goToTwitter(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.twitter.com/" + item.getTwitter()));
        startActivity(i);
    }

    public void goToFacebook(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(item.getFacebookUrl()));
        startActivity(i);
    }

    public void callPhone(View view) {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:" + item.getPhone()));
        startActivity(i);
    }

    public void sendEmail(View view) {
        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", item.getEmail(), null));
        startActivity(Intent.createChooser(i, "Send email using: "));
    }
}
