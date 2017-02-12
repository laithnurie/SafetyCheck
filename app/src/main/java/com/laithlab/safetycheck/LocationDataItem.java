package com.laithlab.safetycheck;

public class LocationDataItem {
    public double latitude;
    public double longtitude;
    public long timestamp;

    public LocationDataItem() {
    }

    public LocationDataItem(double latitude, double longtitude, long timestamp) {
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.timestamp = timestamp;
    }
}
