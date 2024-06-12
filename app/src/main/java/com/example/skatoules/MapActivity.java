package com.example.skatoules;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.CustomZoomButtonsController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.FolderOverlay;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.MinimapOverlay;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity - thomas";
    private final int REQUEST_PERMISSIONS_REQUEST_CODE = 1;
    private MapView map = null;

    private MyLocationNewOverlay mLocationOverlay;

    private GpsMyLocationProvider mLocationProvider;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //handle permissions first, before map is created. not depicted here

        //load/initialize the osmdroid configuration, this can be done
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        //setting this before the layout is inflated is a good idea
        //it 'should' ensure that the map has a writable location for the map cache, even without permissions
        //if no tiles are displayed, you can try overriding the cache path using Configuration.getInstance().setCachePath
        //see also StorageUtils
        //note, the load method also sets the HTTP User Agent to your application's package name, abusing osm's
        //tile servers will get you banned based on this string

        //inflate and create the map
        setContentView(R.layout.activity_map);

        map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);

        requestPermissionsIfNecessary(
                new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}
        );

        // UP TO HERE WE HAVE THE BASIC GITHUB TUTORIAL REFINED FOR ANDROID STUDIO GIRAFFE 2022.3.1.

        // map.setBuiltInZoomControls(true);
        // use below instead of deprecated commented line above
        // see more here: https://www.javadoc.io/doc/org.osmdroid/osmdroid-android/6.1.4/org/osmdroid/views/MapView.html

        // SET THIS TO NEVER for emulator
        // this allows multi touch controls on physical device
        map.getZoomController().setVisibility(CustomZoomButtonsController.Visibility.ALWAYS);
        map.setMultiTouchControls(true);

        // The latitude of Syros, Siros Ermoupoli, Greece is 37.463493, and the longitude is 24.916088
        // set center point on Syros on zool level 12.5 (setZoom accepts a double).
        IMapController mapController = map.getController();
        mapController.setZoom(12.5);
        GeoPoint startPoint = new GeoPoint(37.463493, 24.916088);
        mapController.setCenter(startPoint);

        // try to show user location from here on:

        // Create and configure the location provider
        try {
            Log.i(TAG, "onCreate: creating location provider");
            mLocationProvider = new GpsMyLocationProvider(this);
            mLocationProvider.setLocationUpdateMinTime(1000); // Update location every 1 second
            mLocationProvider.setLocationUpdateMinDistance(10); // Update location every 10 meters
        } catch (Exception e) {
            Log.e(TAG, "Error creating location provider", e);
            Toast.makeText(this, "Failed to create location provider", Toast.LENGTH_SHORT).show();
        }


        // Create and add the MyLocationNewOverlay
        try {
            Log.i(TAG, "onCreate: creating location overlay");
            mLocationOverlay = new MyLocationNewOverlay(mLocationProvider, map);
            mLocationOverlay.enableFollowLocation();
            mLocationOverlay.enableMyLocation();




            // Convert the vector drawable to a bitmap
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.custom_location_icon);
            Bitmap bitmap = getBitmapFromVectorDrawable(drawable);

            //Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 48, 48, false);

            // Set the custom bitmap icon for the location overlay
            mLocationOverlay.setDirectionArrow(bitmap, bitmap);



            //Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.custom_location_icon);
            //mLocationOverlay.setPersonIcon(bitmap2);

            map.getOverlays().add(mLocationOverlay);
        } catch (Exception e) {
            Log.e(TAG, "Error creating location overlay", e);
            Toast.makeText(this, "Failed to create location overlay", Toast.LENGTH_SHORT).show();
        }

        // Add the location button
        FloatingActionButton locationButton = findViewById(R.id.location_button);
        Log.i(TAG, "onCreate: created floating button");
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mLocationOverlay.getMyLocation() != null) {
                        map.getController().animateTo(mLocationOverlay.getMyLocation());
                        String myLoca = mLocationOverlay.getMyLocation().getLatitude() + ", " + mLocationOverlay.getMyLocation().getLongitude();
                        Toast.makeText(MapActivity.this, "You seem to be at " + myLoca, Toast.LENGTH_SHORT).show();
                        map.getController().setZoom(19.0);
                    } else {
                        Toast.makeText(MapActivity.this, "Location not available", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Error handling location button click", e);
                    Toast.makeText(MapActivity.this, "Failed to get location", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // add Compass overlay
        CompassOverlay mCompassOverlay;
        mCompassOverlay = new CompassOverlay(ctx, new InternalCompassOrientationProvider(ctx), map);
        mCompassOverlay.enableCompass();
        map.getOverlays().add(mCompassOverlay);

        // add MinimapOverlay
        MinimapOverlay mMinimapOverlay;
        mMinimapOverlay = new MinimapOverlay(ctx, map.getTileRequestCompleteHandler());
        mMinimapOverlay.setWidth(200);
        mMinimapOverlay.setHeight(400);
//optionally, you can set the minimap to a different tile source
//mMinimapOverlay.setTileSource(....);
        map.getOverlays().add(mMinimapOverlay);

        addItemsOnMap();

    }

    @Override
    public void onResume() {
        super.onResume();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        map.onResume(); //needed for compass, my location overlays, v6.0.0 and up

        if (mLocationOverlay != null) {
            mLocationOverlay.enableMyLocation();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        map.onPause();  //needed for compass, my location overlays, v6.0.0 and up

        if (mLocationOverlay != null) {
            mLocationOverlay.disableMyLocation();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        ArrayList<String> permissionsToRequest = new ArrayList<>();
        for (int i = 0; i < grantResults.length; i++) {
            permissionsToRequest.add(permissions[i]);
        }
        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(
                    this,
                    permissionsToRequest.toArray(new String[0]),
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }

    private void requestPermissionsIfNecessary(String[] permissions) {
        ArrayList<String> permissionsToRequest = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                permissionsToRequest.add(permission);
            }
        }
        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(
                    this,
                    permissionsToRequest.toArray(new String[0]),
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }

    private Bitmap getBitmapFromVectorDrawable(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }


    public void addItemsOnMap() {
        FolderOverlay poiMarkers = new FolderOverlay(this);
        map.getOverlays().add(poiMarkers);



        ArrayList<MapItem> mapItems = createMapItems();

        for (int i = 0; i < mapItems.size(); i++) {


            MapItem mapItem = mapItems.get(i);
            Marker itemMarker = new Marker(map);
            itemMarker.setTitle(mapItem.getGroup() + "\n"+mapItem.getDescription());
            itemMarker.setSnippet(mapItem.getTitle());

            itemMarker.setPosition(mapItem.getGeoPoint());

            Drawable marker = ContextCompat.getDrawable(this, mapItem.getPinResourceID());
            itemMarker.setIcon(marker);
            /*
            if (mapItem.getTitle().equals("A' Gymnasio")) {
                Drawable paneMarker = ContextCompat.getDrawable(this, R.drawable.ic_pane_24);
                itemMarker.setIcon(paneMarker);
            }
            else {
                itemMarker.setIcon(getResources().getDrawable(mapItem.getPinResourceID()));

            }*/

            itemMarker.setImage(ContextCompat.getDrawable(this, mapItem.getImageResourceID()));
            //itemMarker.setImage(getResources().getDrawable(mapItem.getImageResourceID()));
            poiMarkers.add(itemMarker);
        }

        ArrayList<OverlayItem> overlayItems = new ArrayList<>();

        for (int i = 0; i < mapItems.size(); i++) {
            MapItem mapItem = mapItems.get(i);
            OverlayItem overlayItem = new OverlayItem(
                    mapItem.getTitle(),
                    mapItem.getDescription(),
                    mapItem.getGeoPoint()
            );
            overlayItem.setMarker(mapItem.getMarker(map.getContext()));
            overlayItems.add(overlayItem);
        }

        ItemizedIconOverlay<OverlayItem> itemizedIconOverlay = new ItemizedIconOverlay<>(
                overlayItems,
                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(int index, OverlayItem item) {
                        Log.v("Item click", "Item click");
                        return false;
                    }

                    @Override
                    public boolean onItemLongPress(int index, OverlayItem item) {
                        Log.v("Item long click", "Item long click");
                        return false;
                    }
                },
                map.getContext()
        );

        map.getOverlays().add(itemizedIconOverlay);

        /*
        //"cast" map items to overlay items
        ArrayList<OverlayItem> overlayItems = new ArrayList<OverlayItem>();
        for (int i = 0; i < mapItems.size(); i++) {
            overlayItems.add(new OverlayItem(mapItems.get(i).getTitle(), mapItems.get(i).getDescription(), mapItems.get(i).getGeoPoint()));
        }

        ItemizedIconOverlay itemizedIconOverlay = new ItemizedIconOverlay(overlayItems, getResources().getDrawable(R.drawable.ic_baseline_push_pin_24), new ItemizedIconOverlay.OnItemGestureListener() {
            @Override
            public boolean onItemSingleTapUp(int index, Object item) {
                Log.v("Item click", "Item click");
                return false;
            }

            @Override
            public boolean onItemLongPress(int index, Object item) {
                Log.v("Item long click", "Item long click");
                return false;
            }
        }, map.getContext());

        map.getOverlays().add(itemizedIconOverlay);
*/
        // refresh the map
        map.invalidate();
    }

    private ArrayList<MapItem> createMapItems() {
        MapItem item;
        ArrayList<MapItem> mapItems = new ArrayList<>();

        //create item 0 for buildings
        item = new MapItem("Parking Lalakia", "1,2km away", "AMEA accessible: NO",
                new GeoPoint(37.44249224685732, 24.93704824423158),
                R.drawable.ic_baseline_push_pin_24,
                R.drawable.lalakia);
        //add item to list
        mapItems.add(item);
        // 1
        item = new MapItem("Parking Nisaki", "350m away, AMEA accessible: YES", "AMEA accessible: YES",
                new GeoPoint(37.442527776667156, 24.945209394037725),
                R.drawable.ic_baseline_push_pin_24,
                R.drawable.nisaki);
        //add item to list
        mapItems.add(item);
        // 2
        item = new MapItem("Parking Doxa", "1,1km away", "AMEA accessible: YES",
                new GeoPoint(37.45070563713925, 24.94789696705189),
                R.drawable.ic_baseline_push_pin_24,
                R.drawable.doxa);
        //add item to list
        mapItems.add(item);

        //den tha baloume alla shmeia sto xarth
        //create item 0 for squares
        // item = new MapItem("Squares", "Plateia Miaouli", "This is plateia Miaouli...",
        //     new GeoPoint(37.444474, 24.942527),
        //   R.drawable.ic_baseline_push_pin_24,
        //  R.drawable.miaouli);
        //add item to list
        // mapItems.add(item);
        // 1
        //item = new MapItem("Squares", "Plateia Iroon", "This is plateia irroon ...",
        //   new GeoPoint(37.437909, 24.935860),
        //   R.drawable.ic_baseline_push_pin_24,
        //    R.drawable.iroon);
        //add item to list
        // mapItems.add(item);

        return mapItems;

    }
}