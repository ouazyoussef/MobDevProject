package com.example.sportiveapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class CreateMatch extends Activity {
    private EditText EventName, Place, Date, Temps;
    private Button Validate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newmatch);

        final String[] eventname = new String[1];
        final String[] place = new String[1];
        final String[] date = new String[1];
        final String[] temps = new String[1];

        this.EventName = findViewById(R.id.eventName);
        this.Place = findViewById(R.id.eventPlace);
        this.Date = findViewById(R.id.eventDate);
        this.Temps = findViewById(R.id.eventTime);
        this.Validate = findViewById(R.id.btnSave);

        Bundle extras = getIntent().getExtras();
        String value = "";
        if (extras != null) {
            value = extras.getString("UserConnected4");
        }

        String finalValue = value;

        Validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventname[0] = EventName.getText().toString();
                place[0] = Place.getText().toString();
                date[0] = Date.getText().toString();
                temps[0] = Temps.getText().toString();
                //send to DB
                System.out.println("Event : " + eventname[0] + " Created");
                new DBManagement().CreateMatch(finalValue, "date");
                finish();
            }
        });
    }
}
