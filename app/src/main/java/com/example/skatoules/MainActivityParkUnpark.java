package com.example.skatoules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MainActivityParkUnpark extends AppCompatActivity {


    Button park;
    Button unpark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_park_unpark);
        Variables app = (Variables) getApplicationContext();

        park = findViewById(R.id.btnPark);
        unpark = findViewById(R.id.btnUnpark);


        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             SimpleDateFormat nowTime = new SimpleDateFormat("HH:mm:ss ", Locale.getDefault());

            //    Toast.makeText(MainActivityParkUnpark.this, "Park Meter starting now",Toast.LENGTH_LONG).show();
               // app.setJustParkedTimeDate(nowTime);

            }
        });
//        sygnwmh gia opoion to diavasei afto

    }

    public void openHistoryActivity(View view) {
        startActivity(new Intent(this,HistoryActivity.class));
    }

    public void openMainActivity(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }

    public void openMainActivityTicket(View view) {
        startActivity(new Intent(this,MainActivityTicket.class));
    }

    public void openMapActivity(View view) {
        startActivity(new Intent(this,MapActivity.class));
    }
}