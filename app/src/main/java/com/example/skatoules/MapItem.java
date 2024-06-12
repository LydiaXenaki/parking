package com.example.skatoules;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import org.osmdroid.util.GeoPoint;

public class MapItem {

    private String group;
    private String title;
    private String description;
    private GeoPoint geoPoint;
    private int pinResourceID;
    private int imageResourceID;

    public MapItem(String group, String title, String description, GeoPoint geopoint, int pinResourceID, int imageResourceID){
        this.group = group;
        this.title = title;
        this.description = description;
        this.geoPoint = geopoint;
        this.pinResourceID = pinResourceID;
        this.imageResourceID = imageResourceID;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }

    public int getPinResourceID() {
        return pinResourceID;
    }

    public void setPinResourceID(int pinResourceID) {
        this.pinResourceID = pinResourceID;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }


    public Drawable getMarker(Context context) {
        return ContextCompat.getDrawable(context, pinResourceID);
    }

}
