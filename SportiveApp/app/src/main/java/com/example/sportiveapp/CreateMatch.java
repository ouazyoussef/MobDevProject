package com.example.sportiveapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class CreateMatch extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newmatch);
        final String[] eventname = new String[1];
        final String[] place = new String[1];
        final String[] date = new String[1];
        final String[] temps = new String[1];
        EditText EventName, Place, Date, Temps;
        Button Validate;
        EventName = findViewById(R.id.eventName);
        Place = findViewById(R.id.eventPlace);
        Date = findViewById(R.id.eventDate);
        Temps = findViewById(R.id.eventTime);
        Validate = findViewById(R.id.btnSave);
        Validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventname[0] = EventName.getText().toString();
                place[0] = Place.getText().toString();
                date[0] = Date.getText().toString();
                temps[0] = Temps.getText().toString();
                //send to DB
                System.out.println("Event : " + eventname[0] + " Created");
                finish();
            }
        });


    }
}
