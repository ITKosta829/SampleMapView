/*
 * This example aims to give knowledge about how to implements newer Google Maps
 * into our applications.
 * But here we need to include 
 *  1. Google Maps API key.
 * 	2. we need to use Google Play Services project as a library to use project.
 * 	3. Google maps needs some permissions and features which we can see in manifest file.
 */


package org.turntotech.samplemapview;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends FragmentActivity implements OnMapReadyCallback{

    MapFragment mapFrag;
    LatLng TTT, home, parents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TurnToTech", "Project Name - SampleMapView");

        mapFrag = ((MapFragment) getFragmentManager().findFragmentById(R.id.map));
        mapFrag.getMapAsync(this);

        // Create a LatLng object
        TTT = new LatLng(40.7413351,-73.9898172);
        home = new LatLng(40.785039,-73.673232);
        parents = new LatLng(40.770106,-73.782192);

    }

    @Override
    public void onMapReady(GoogleMap map) {

        // Focus map to particular place.
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(TTT, 17));

        // Markers identify locations on the map.
        map.addMarker(new MarkerOptions()
                .title("TurnToTech")
                .snippet("Best place to learn")
                .position(TTT));

        map.addMarker(new MarkerOptions()
                .title("Home")
                .position(home));

        map.addMarker(new MarkerOptions()
                .title("Parents")
                .position(parents));

    }

}
