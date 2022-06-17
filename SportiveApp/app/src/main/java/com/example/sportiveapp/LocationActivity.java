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

public class LocationActivity extends AppCompatActivity {
    private Button btn;
    private TextView textView1, textView2, textView3, textView4, textView5;
    private FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        btn = findViewById(R.id.btn_locate);
        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Dans le onclick");
                if (ActivityCompat.checkSelfPermission(LocationActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    System.out.println("Dans la perm");
                         getLocation();
                } else {
                    ActivityCompat.requestPermissions(LocationActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
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
                    Geocoder geocoder = new Geocoder(LocationActivity.this, Locale.getDefault());
                    try {
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLatitude(), 1);
                        textView1.setText(Html.fromHtml("<font color = '#6200EE'><b>getLatitude : </b><br></font>" + addresses.get(0).getLatitude()));
                        textView2.setText(Html.fromHtml("<font color = '#6200EE'><b>getLongitude : </b><br></font>" + addresses.get(0).getLongitude()));
                        textView3.setText(Html.fromHtml("<font color = '#6200EE'><b>getCountryName : </b><br></font>" + addresses.get(0).getCountryName()));
                        textView4.setText(Html.fromHtml("<font color = '#6200EE'><b>getLocality : </b><br></font>" + addresses.get(0).getLocality()));
                        textView5.setText(Html.fromHtml("<font color = '#6200EE'><b>getAddressLine : </b><br></font>" + addresses.get(0).getAddressLine(0)));
                        System.out.println("Lat : " +  addresses.get(0).getLatitude() + " Long : " + addresses.get(0).getLongitude());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

    }
}