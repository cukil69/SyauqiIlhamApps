package com.cukil.syauqiilhamapps.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Syauqi Ilham on 5/2/2019.
 */
public class Music {

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
