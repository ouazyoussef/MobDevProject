package com.example.sportiveapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class History extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        this.listView = findViewById(R.id.simpleListHistory);

        Bundle extras = getIntent().getExtras();
        String value = null;
        if (extras != null) {
            value = extras.getString("UserConnected2");
        }

        String HistoryMatch = new DBManagement().getHistory(value);
        ArrayList<String> matchesDescription = new ArrayList<>();

        String[] splitMatch = HistoryMatch.split("\\|");
        if(splitMatch[0].contains("-")) {
            for (int i = 0; i < splitMatch.length; i++) {
                System.out.println("splitmatch : " + splitMatch[i]);
                String[] splitedData = splitMatch[i].split("-");
                String a = new Match(getResources(),    splitedData[1], splitedData[2], splitedData[3]).toString();
                matchesDescription.add(a);
            }

            ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, matchesDescription);
            this.listView.setAdapter(adapter);
        }
    }
}
