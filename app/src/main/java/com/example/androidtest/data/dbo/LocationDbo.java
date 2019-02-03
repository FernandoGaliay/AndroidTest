package com.example.androidtest.data.dbo;

public class LocationDbo {

    private static final double DEFAULT_double = 34.34;

    private static final double DEFAULT_LAT = 24.24;

    private double latitude;

    private double longitude;

    private boolean needsRecording;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isNeedsRecording() {
        return needsRecording;
    }

    public void setNeedsRecording(boolean needsRecording) {
        this.needsRecording = needsRecording;
    }

    public static LocationDbo getDefaultInstance() {

        LocationDbo defaultLocation = new LocationDbo();
        defaultLocation.setLatitude(34.34);
        defaultLocation.setLongitude(24.24);
        return defaultLocation;

    }
}
