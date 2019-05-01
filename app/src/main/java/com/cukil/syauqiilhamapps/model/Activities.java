package com.cukil.syauqiilhamapps.model;

import com.google.gson.annotations.SerializedName;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class Activities {

    @SerializedName("time")
    private String time;

    @SerializedName("location")
    private String location;

    @SerializedName("desc")
    private String desc;

    @SerializedName("image")
    private String image;

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getDesc() {
        return desc;
    }

    public String getImage() {
        return image;
    }
}
