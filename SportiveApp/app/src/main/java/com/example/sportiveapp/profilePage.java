package com.example.sportiveapp;

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

    }
}
