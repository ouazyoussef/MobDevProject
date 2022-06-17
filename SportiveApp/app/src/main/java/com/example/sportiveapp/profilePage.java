package com.example.sportiveapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class profilePage extends AppCompatActivity {
    TextView FullName;
    static ImageView imgView = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilepage);
        if (ContextCompat.checkSelfPermission(profilePage.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(profilePage.this, new String[]{
                    Manifest.permission.CAMERA
            }, 100);
        }
        /*imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });*/

        Bundle extras = getIntent().getExtras();
        String value = "";
        if (extras != null) {
            value = extras.getString("UserConnected");

        }
        System.out.println("Getted value " + value);
        Button Stats, History, Creatematchs, ProximityStade, Disconnect;
        Disconnect = findViewById(R.id.deconnexion);
        FullName = findViewById(R.id.user_profile_name);
        Stats = findViewById(R.id.stats);
        History = findViewById(R.id.history);
        Creatematchs = findViewById(R.id.createMatch);
        ProximityStade = findViewById(R.id.proximityStade);
        FullName.setText(value);
        String finalValue = value;
        Stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(" Send value " + finalValue);
                Intent i = new Intent(profilePage.this, StatsActivity.class);
                i.putExtra("UserConnected3", finalValue);
                startActivity(i);
            }
        });

        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(" Send value " + finalValue);
                Intent i = new Intent(profilePage.this, History.class);
                i.putExtra("UserConnected2", finalValue);
                startActivity(i);

            }
        });
        Creatematchs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(" Send value " + finalValue);
                Intent i = new Intent(profilePage.this, CreateMatch.class);
                i.putExtra("UserConnected4", finalValue);
                startActivity(i);

            }
        });
        ProximityStade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(profilePage.this, ProximityStade.class));
            }
        });

        Disconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(profilePage.this, MainActivity.class);

                startActivity(i);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgView.setImageBitmap(bitmap);
        }
    }
}
