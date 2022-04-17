package com.example.sqliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowCars extends AppCompatActivity {
    private DBHandler dbHandler;
    private ArrayList<String> carList;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        dbHandler = new DBHandler(ShowCars.this);
        carList=dbHandler.carList();
        lv =  findViewById(R.id.car_list);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                carList );

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String o = lv.getItemAtPosition(position).toString();
                Toast.makeText(getBaseContext(),o,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ShowCars.this, CarDetails.class);
                intent.putExtra("car_name", o);
                startActivity(intent);
            }
        });

    }
}