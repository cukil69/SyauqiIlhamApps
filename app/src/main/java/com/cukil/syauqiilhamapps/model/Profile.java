package com.cukil.syauqiilhamapps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Profile {

    @SerializedName("image")
    private String image;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("hobbies")
    private List<Interest> hobbies;

    @SerializedName("portofolio")
    private List<Interest> porto;

    @SerializedName("interest")
    private List<Interest> interest;

    @SerializedName("cita")
    private List<Interest> cita;

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Interest> getHobbies() {
        return hobbies;
    }

    public List<Interest> getPorto() {
        return porto;
    }

    public List<Interest> getInterest() {
        return interest;
    }

    public List<Interest> getCita() {
        return cita;
    }
}
