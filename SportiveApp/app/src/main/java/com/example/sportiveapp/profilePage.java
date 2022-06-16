package com.example.sportiveapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class profilePage extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilepage);
        Button Stats, History, CreateMatch, ProximityStade;
        Stats = findViewById(R.id.stats);
        History = findViewById(R.id.history);
        CreateMatch = findViewById(R.id.createMatch);
        ProximityStade = findViewById(R.id.proximityStade);
        Stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(profilePage.this, StatsActivity.class));
            }
        });
        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(profilePage.this, History.class));
            }
        });
        CreateMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(profilePage.this, CreateMatch.class));
            }
        });
        ProximityStade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(profilePage.this, ProximityStade.class));
            }
        });

    }
}
