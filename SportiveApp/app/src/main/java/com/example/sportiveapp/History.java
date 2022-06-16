package com.example.sportiveapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class History extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        Bundle extras = getIntent().getExtras();
        String value = null;
        ListView listView = findViewById(R.id.simpleListHistory);

        if (extras != null) {
            value = extras.getString("UserConnected2");
        }
        String HistoryMatch = new DBManagement().getHistory(value);
        String[] splitMatch = HistoryMatch.split("|");
        for (String s: splitMatch) {
            String[] splitedData = s.split(";");
            new Match(splitedData[1], splitedData[2],splitedData[3]);

        }
    }
}
