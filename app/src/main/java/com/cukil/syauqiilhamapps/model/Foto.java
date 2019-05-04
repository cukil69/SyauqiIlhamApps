package com.cukil.syauqiilhamapps.model;

import com.google.gson.annotations.SerializedName;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class Foto {

    @SerializedName("image")
    private String image;

    @SerializedName("desc")
    private String desc;

    public String getImage() {
        return image;
    }

    public String getDesc() {
        return desc;
    }
}
