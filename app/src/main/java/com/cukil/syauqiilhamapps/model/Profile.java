package com.cukil.syauqiilhamapps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Profile {

    @SerializedName("image")
    private String image;

    @SerializedName("name")
    private String name;

    @SerializedName("bio")
    private String bio;

    @SerializedName("email")
    private String email;

    @SerializedName("phone")
    private String phone;

    @SerializedName("instagram")
    private String instagram;

    @SerializedName("twitter")
    private String twitter;

    @SerializedName("facebook")
    private String facebook;

    @SerializedName("facebook_url")
    private String facebookUrl;

    @SerializedName("address")
    private String address;

    @SerializedName("lat_lng")
    private String latLng;

    @SerializedName("hobbies")
    private List<Interest> hobbies;

    @SerializedName("portofolio")
    private List<Interest> porto;

    @SerializedName("interest")
    private List<Interest> interest;

    @SerializedName("cita_cita")
    private List<Interest> cita;

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public String getAddress() {
        return address;
    }

    public String getLatLng() {
        return latLng;
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
