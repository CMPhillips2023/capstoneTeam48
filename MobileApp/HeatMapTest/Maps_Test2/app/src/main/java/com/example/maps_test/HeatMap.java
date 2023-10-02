package com.example.maps_test;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.maps_test.databinding.ActivityHeatMapBinding;

import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.heatmaps.HeatmapTileProvider;
import com.google.maps.android.heatmaps.WeightedLatLng;

import org.json.JSONException;

import java.util.List;

public class HeatMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityHeatMapBinding binding;

   /**
    private void addHeatMap() {
        List<WeightedLatLng> wildfireData = null;
        //create list for data (lat, lng, weight)

        try {
            //Read in the JSON Data
        }
        catch (JSONException e) {
            //display error message
        }

        //create the heatmap provider
        HeatmapTileProvider provider = new HeatmapTileProvider.Builder()
                .weightedData(wildfireData)
                .build();
        //create the overlay using the heatmap provider
        TileOverlay overlay = mMap.addTileOverlay(new TileOverlayOptions().tileProvider(provider));

    }
    **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHeatMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng ETB = new LatLng(30.622706, -96.339220);
        mMap.addMarker(new MarkerOptions().position(ETB).title("Marker at ETB"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ETB));
    }
}