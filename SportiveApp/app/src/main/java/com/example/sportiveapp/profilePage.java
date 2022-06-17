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

import java.util.Random;

public class profilePage extends AppCompatActivity {

    private TextView FullName;
    private ImageView imgView;
    private Button Stats, History, Creatematchs, ProximityStade, Disconnect;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilepage);

        if (ContextCompat.checkSelfPermission(profilePage.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(profilePage.this, new String[]{
                    Manifest.permission.CAMERA
            }, 100);
        }

        Bundle extras = getIntent().getExtras();
        String value = "";
        if (extras != null) {
            value = extras.getString("UserConnected");
        }

        this.Disconnect = findViewById(R.id.deconnexion);
        this.FullName = findViewById(R.id.user_profile_name);
        this.Stats = findViewById(R.id.stats);
        this.History = findViewById(R.id.history);
        this.Creatematchs = findViewById(R.id.createMatch);
        this.ProximityStade = findViewById(R.id.proximityStade);
        this.FullName.setText(value);
        this.imgView = findViewById(R.id.header_cover_image);

        String finalValue = value;

        this.imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int random = (new Random()).nextInt(100);
                if (random%5 == 0)
                    imgView.setImageResource(R.mipmap.sui_foreground);
                if (random%3 == 0)
                    imgView.setImageResource(R.mipmap.messi_foreground);
                if (random%2 == 0)
                    imgView.setImageResource(R.mipmap.ney_foreground);
            }
        });

        this.Stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(" Send value " + finalValue);
                Intent i = new Intent(profilePage.this, StatsActivity.class);
                i.putExtra("UserConnected3", finalValue);
                startActivity(i);
            }
        });

        this.History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(" Send value " + finalValue);
                Intent i = new Intent(profilePage.this, History.class);
                i.putExtra("UserConnected2", finalValue);
                startActivity(i);

            }
        });

        this.Creatematchs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(" Send value " + finalValue);
                Intent i = new Intent(profilePage.this, CreateMatch.class);
                i.putExtra("UserConnected4", finalValue);
                startActivity(i);

            }
        });

        this.ProximityStade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(profilePage.this, ProximityStade.class));
            }
        });

        this.Disconnect.setOnClickListener(new View.OnClickListener() {
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
