package com.cukil.syauqiilhamapps.model;

import com.google.gson.annotations.SerializedName;

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
