package com.cukil.syauqiilhamapps.model;

import com.google.gson.annotations.SerializedName;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class Tutorial {

    @SerializedName("image")
    private String image;

    @SerializedName("title_text")
    private String title;

    @SerializedName("desc_text")
    private String desc;

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
