package com.example.sportiveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    private TextView played;
    private TextView winned;
    private TextView lost;
    private TextView incoming;
    private TextView ratioWin;

    private Button home;
    private Button deconnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);
        // on a assigne les buttons
        this.home = findViewById(R.id.Home);
        this.deconnexion = findViewById(R.id.deconnexion);

        this.played = findViewById(R.id.Played2);
        this.winned = findViewById(R.id.Winned2);
        this.lost = findViewById(R.id.Lost2);
        this.incoming = findViewById(R.id.Incoming2);
        this.ratioWin = findViewById(R.id.ratioWin2);


        this.home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StatsActivity.this,profilePage.class);
                i.putExtra("UserConnected",UserName[0]);
                startActivity(i);
            }
        });

        this.deconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StatsActivity.this,Connexion.class);
                startActivity(i);
            }
        });
    }
}