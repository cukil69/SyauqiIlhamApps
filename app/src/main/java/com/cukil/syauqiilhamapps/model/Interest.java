package com.cukil.syauqiilhamapps.model;

import com.google.gson.annotations.SerializedName;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class Interest {

    @SerializedName("image")
    private String image;

    @SerializedName("name")
    private String name;

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
