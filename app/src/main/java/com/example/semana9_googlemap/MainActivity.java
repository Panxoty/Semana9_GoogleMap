package com.example.semana9_googlemap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap Mymap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Mymap = googleMap;

        LatLng sydney = new LatLng(-30.6045845, -71.2073349);
        Mymap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney"));
        Mymap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        Mymap.moveCamera(CameraUpdateFactory.zoomTo(15));

        Mymap.getUiSettings().setZoomControlsEnabled(true);
        Mymap.getUiSettings().setCompassEnabled(true);

        Mymap.getUiSettings().setZoomGesturesEnabled(false);
        Mymap.getUiSettings().setScrollGesturesEnabled(false);
    }
}