package com.example.eva2_5_bundles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] datos = {
            "Chihuahua",
            "Meoqui",
            "Parral",
            "Durango",
            "Camargo",
            "Juarez",
            "Jimenez",
            "Casas Grandes",
            "Hermosillo",
            "Delicias",
            "Camargo",
            "Monterrey",
            "Saltillo",
            "Carichi",
            "Guachochi",
            "Ciudad Juarez",
            "Ojinaga",
            "Batopilas",
            "Saucillo",
    };
    Intent intent;
    ListView listVwDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listVwDatos = findViewById(R.id.listVwDatos);
        intent = new Intent(this, DetailActivity.class);
        listVwDatos.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,datos));

        listVwDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("CIUDAD",datos[i]);
                bundle.putInt("POSICION", i);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}