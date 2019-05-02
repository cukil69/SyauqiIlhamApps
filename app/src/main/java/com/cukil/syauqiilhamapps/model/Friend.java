package com.cukil.syauqiilhamapps.model;

import com.google.gson.annotations.SerializedName;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class Friend {

    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String image;

    @SerializedName("phone")
    private String phone;

    @SerializedName("address")
    private String address;

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
