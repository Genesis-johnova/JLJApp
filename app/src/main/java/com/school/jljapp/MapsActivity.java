package com.school.jljapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button locate;//for exercise 2
    private EditText lat, lng; //for exercise 2
    int newMarkerIndex=0;//added for exercise 2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);//for exercise 2
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //below for exercise 2
        locate = findViewById(R.id.escape);
       // lat = findViewById(R.id.editText);
      //  lng = findViewById(R.id.editText2);
        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                /*double dblLat = Double.parseDouble(lat.getText().toString());
                double dblLng = Double.parseDouble(lng.getText().toString());
                LatLng place = new LatLng(dblLat,dblLng);
                mMap.addMarker(new MarkerOptions().position(place).title("New Marker "+(++newMarkerIndex)));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(place));*/
            }
        });
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

        LatLng singapore = new LatLng(1.3098, 103.7775);//search internet, more accurate
        mMap.addMarker(new MarkerOptions().position(singapore).title("500 Dover Rd, Singapore 139651"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(singapore, 15));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);
        // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(singapore,15));//with zoom
    }
}