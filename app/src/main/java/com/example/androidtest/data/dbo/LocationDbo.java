package com.example.androidtest.data.dbo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "location_table")
public class LocationDbo {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "latitude")
    private Long latitude;

    @ColumnInfo(name = "longitude")
    private Long longitude;

    @ColumnInfo(name = "needs_recording")
    private boolean needsRecording;

    public LocationDbo(Long latitude, Long longitude, boolean needsRecording) {

        this.latitude = latitude;
        this.longitude = longitude;
        this.needsRecording = needsRecording;

    }

    public Long getLatitude() {
        return latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public boolean isNeedsRecording() {
        return needsRecording;
    }

}
