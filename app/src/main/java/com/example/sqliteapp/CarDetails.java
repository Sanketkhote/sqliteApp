package com.example.sqliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CarDetails extends AppCompatActivity {
    TextView nameTextView,brandTextView,priceTextView;
    private DBHandler dbHandler;
    DBHandler.carDetail carDetailData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        nameTextView=findViewById(R.id.car_name);
        brandTextView=findViewById(R.id.car_brand);
        priceTextView=findViewById(R.id.car_price);

        dbHandler = new DBHandler(CarDetails.this);
        Intent intent = getIntent();
        String carName = intent.getExtras().getString("car_name");
        carDetailData=dbHandler.showCarDetails(carName);

        nameTextView.setText(carDetailData.name);
        brandTextView.setText(carDetailData.brand);
        priceTextView.setText(carDetailData.price);


    }
}