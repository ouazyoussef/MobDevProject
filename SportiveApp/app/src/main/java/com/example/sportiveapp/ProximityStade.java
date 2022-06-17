package com.example.sportiveapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class ProximityStade extends AppCompatActivity {

    private TextView lattitude;
    private TextView longitude;
    private TextView adressLine;
    private TextView textView1, textView2, textView3, textView4, textView5;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_stade);

        this.lattitude = findViewById(R.id.latitudeET);
        this.longitude = findViewById(R.id.longitudeET);
        this.adressLine = findViewById(R.id.address);

        this.btn = findViewById(R.id.btnlocation);
        String addressString = "";

        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(ProximityStade.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    System.out.println("Dans la perm");
                    getLocation();
                } else {
                    ActivityCompat.requestPermissions(ProximityStade.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });

    }

    private void getLocation() {

      if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    Geocoder geocoder = new Geocoder(ProximityStade.this, Locale.getDefault());
                    try {
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLatitude(), 1);
                        lattitude.setText(addresses.get(0).getLatitude() + "");
                        longitude.setText("" + addresses.get(0).getLongitude());
                        adressLine.setText("" + addresses.get(0).getAddressLine(0));
                        System.out.println("Lat : " +  addresses.get(0).getLatitude() + " Long : " + addresses.get(0).getLongitude());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });



    }
}