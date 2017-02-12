package com.laithlab.safetycheck;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class SafetyUserInfo {

    public String name;
    public String email;
    public LocationData locationData;


    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public SafetyUserInfo() {
    }

    public SafetyUserInfo(String name, String email, LocationData locationData) {
        this.name = name;
        this.email = email;
        this.locationData = locationData;
    }
}
