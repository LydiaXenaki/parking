package com.example.skatoules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        checkButtons(app.isParked());



        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                app.setParked(true);

             SimpleDateFormat nowTime = new SimpleDateFormat("HH:mm:ss ", Locale.getDefault());
                SimpleDateFormat nowDate = new SimpleDateFormat("yyyy-MM-dd ", Locale.getDefault());
                Date date = new Date();
                Date date2 = new Date();
                String formattedTime = nowTime.format(date);
                String formattedDate = nowDate.format(date2);

                app.setCurrentTime(formattedTime);
                String printTime = app.getCurrentTime();

                app.setCurrentDate(formattedDate);
                String printDate = app.getCurrentDate();

                Intent intent = getIntent();
                String currentParking = intent.getStringExtra("parkingId");
                app.setCurrentParking(currentParking);
                long currentTimeMili= System.currentTimeMillis();
                app.setCurrentTimeMili(currentTimeMili);







                Toast.makeText(MainActivityParkUnpark.this, "Park Meter starting now",Toast.LENGTH_LONG).show();
                switch (currentParking){
                    case "Νησάκι":
                        app.setParkingSpotsNis(app.getParkingSpotsNis() + 1);
                        Log.d("logsex", currentParking + app.getParkingSpotsNis());

                        break;

                    case "Λαλακιά":
                        app.setParkingSpotsLal(app.getParkingSpotsLal() + 1);
                        Log.d("logsex", currentParking + app.getParkingSpotsLal());

                        break;

                    case "Δόξα":
                        app.setParkingSpotsDox(app.getParkingSpotsDox() + 1);
                        Log.d("logsex", currentParking + app.getParkingSpotsDox());

                        break;
                }

                checkButtons(app.isParked());
            };

        });


        unpark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String currentParking = app.getCurrentParking();
                if (!app.isParked()){
                    Intent intent = getIntent();
                    currentParking = intent.getStringExtra("parkingId");
                }


                switch (currentParking){
                    case "Νησάκι":
                        app.setParkingSpotsNis(app.getParkingSpotsNis() - 1);
                        Log.d("logsex", currentParking + app.getParkingSpotsNis());

                        break;

                    case "Λαλακιά":
                        app.setParkingSpotsLal(app.getParkingSpotsLal() - 1);
                        Log.d("logsex", currentParking + app.getParkingSpotsLal());

                        break;

                    case "Δόξα":
                        app.setParkingSpotsDox(app.getParkingSpotsDox() - 1);
                        Log.d("logsex", currentParking + app.getParkingSpotsDox());

                        break;
                }
                checkButtons(app.isParked());
                app.setJustParked(app.getCurrentParking());
                app.setCurrentParking("");
                app.setParked(false);
                Intent goTicket = new Intent(MainActivityParkUnpark.this, MainActivityTicket.class);
                startActivity(goTicket);
            }
        });

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

    public void checkButtons(boolean lol){

        if (!lol){
            park.setEnabled(true);
            unpark.setEnabled(false);
        } else{
            park.setEnabled(false);
            unpark.setEnabled(true);
        }

    }

}