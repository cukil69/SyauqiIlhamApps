package com.cukil.syauqiilhamapps.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Syauqi Ilham on 5/2/2019.
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
