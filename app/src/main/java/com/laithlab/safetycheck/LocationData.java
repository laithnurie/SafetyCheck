package com.laithlab.safetycheck;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.List;

@IgnoreExtraProperties

public class LocationData {

    List<LocationDataItem> locationDataItems;

    public LocationData() {
        locationDataItems = new ArrayList<>();
    }

    public void recordLocation(LocationDataItem locationDataItem) {
        locationDataItems.add(locationDataItem);
    }
}
