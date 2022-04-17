package com.example.sqliteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertCars extends AppCompatActivity {
    Button submit;
    EditText nameEditText,brandEditText,priceEditText;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_cars);
        dbHandler = new DBHandler(InsertCars.this);
        submit=findViewById(R.id.submit);
        nameEditText=findViewById(R.id.name);
        brandEditText=findViewById(R.id.brand);
        priceEditText=findViewById(R.id.price);




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name,brand,price;
                name=nameEditText.getText().toString();
                brand=brandEditText.getText().toString();
                price=priceEditText.getText().toString();
                dbHandler.addCarDetails(name,brand,price);
                Toast.makeText(InsertCars.this,"submitted",Toast.LENGTH_LONG).show();

            }
        });

    }
}