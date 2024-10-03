package com.parrarivera.tema04.ejerciciopaises;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview);
        Country[] countries = null;

        countries = ContryParser.parsearXml(this);

        for (Country country: countries) {
            Log.i("Caso1", country.toString());
        }
        CountryAdapter adapter = new CountryAdapter(this, countries);
        listView.setAdapter(adapter);

    }
}