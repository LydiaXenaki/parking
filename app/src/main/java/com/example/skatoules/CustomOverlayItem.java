package com.example.skatoules;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.OverlayItem;

public class CustomOverlayItem extends OverlayItem {
    private int markerResourceId;

    public CustomOverlayItem(String title, String snippet, GeoPoint geoPoint, int markerResourceId) {
        super(title, snippet, geoPoint);
        this.markerResourceId = markerResourceId;
    }

    public int getMarkerResourceId() {
        return markerResourceId;
    }
}
