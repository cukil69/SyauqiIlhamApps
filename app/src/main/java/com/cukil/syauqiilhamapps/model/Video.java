package com.cukil.syauqiilhamapps.model;

import com.google.gson.annotations.SerializedName;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class Video {

    @SerializedName("image")
    private String image;

    @SerializedName("title")
    private String title;

    @SerializedName("artist")
    private String artist;

    @SerializedName("duration")
    private String duration;

    @SerializedName("url")
    private String url;

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getDuration() {
        return duration;
    }

    public String getUrl() {
        return url;
    }
}
