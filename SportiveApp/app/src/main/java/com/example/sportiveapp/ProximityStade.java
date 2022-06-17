package com.example.sportiveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Geocoder;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;


public class ProximityStade extends AppCompatActivity {

    private TextView lattitude;
    private TextView longitude;
    private TextView adressLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_stade);

        this.lattitude = findViewById(R.id.latitudeET);
        this.longitude = findViewById(R.id.longitudeET);
        this.adressLine = findViewById(R.id.address);

        String addressString = "";
        /*
        try {
            // Geocode the address
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            addressString = geocoder.getFromLocation(match.getLatitude(), match.getLongitude(), 1).get(0).getAddressLine(0);
        }catch (Exception e){
            e.printStackTrace();
            addressString = "ERROR on coding the address";
        }*/
    }
}