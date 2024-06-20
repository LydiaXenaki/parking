package com.example.skatoules;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skatoules.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    String[] parkingList = {"doxa", "lalakia", "nisaki"};
    int[] parkingImages = {R.drawable.doxa, R.drawable.lalakia, R.drawable.nisaki};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Variables app = (Variables) getApplicationContext();



        CardView lalakiaRedBox = findViewById(R.id.RedBoxLalakia);
        lalakiaRedBox.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        CardView nisakiRedBox = findViewById(R.id.RedBoxNisaki);
        nisakiRedBox.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        CardView doxaRedBox = findViewById(R.id.RedBoxDoxa);
        doxaRedBox.setBackgroundColor(Color.parseColor("#00FFFFFF"));


        TextView textView = findViewById(R.id.MainPageName);
        ImageButton button2 = findViewById(R.id.imageButtonNisaki);
        ImageButton button1 = findViewById(R.id.imageButtonlalakia);
        ImageButton button3 = findViewById(R.id.imageButtonDoxa);
        FloatingActionButton buttonPin = findViewById(R.id.ParkUnpark_button);
        Log.d("logsex", "einai" + app.getCurrentParking()+ "afto");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (app.getParkingSpotsLal() < app.getParkingSpotsLalmax()){

                    if (Objects.equals(app.getCurrentParking(), "Λαλακιά") || app.getCurrentParking() == ""){
                        handleButtonClick(view.getId());
                    }else{
                        Toast.makeText(MainActivity.this, "Youre allready parked somewhere",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Parking Full!",Toast.LENGTH_LONG).show();
                }


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (app.getParkingSpotsNis() < app.getParkingSpotsNismax()){
                    if (Objects.equals(app.getCurrentParking(), "Νησάκι") || app.getCurrentParking() == ""){
                        handleButtonClick(view.getId());
                    }else{
                        Toast.makeText(MainActivity.this, "Youre allready parked somewhere",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Parking Full!",Toast.LENGTH_LONG).show();
                }

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (app.getParkingSpotsDox() < app.getParkingSpotsDoxmax()){
                    if (Objects.equals(app.getCurrentParking(), "Δόξα") || app.getCurrentParking() == ""){
                        handleButtonClick(view.getId());
                    }else{
                        Toast.makeText(MainActivity.this, "Youre allready parked somewhere",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Parking Full!",Toast.LENGTH_LONG).show();
                }

            }
        });


        buttonPin.setEnabled(app.isParked());


        buttonPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("logsex", "patithika ");
                Intent floatingButtonPress = new Intent(MainActivity.this, MainActivityParkUnpark.class );
                startActivity(floatingButtonPress);

            }
        });


         int lalakiaMax = app.getParkingSpotsLalmax();
         int lalakiaNow = app.getParkingSpotsLal();
         int nisakiMax = app.getParkingSpotsNismax();
         int nisakiNow = app.getParkingSpotsNis();
         int doxaMax = app.getParkingSpotsDoxmax();
         int doxaNow = app.getParkingSpotsDox();

        TextView lalakiaCapacity =findViewById(R.id.LalakiaSpots);
        TextView nisakiCapacity = findViewById(R.id.NisakiSpots);
        TextView doxaCapacity = findViewById(R.id.DoxaSpots);

        lalakiaCapacity.setText(lalakiaNow + "/" + lalakiaMax + "spots");
        nisakiCapacity.setText(nisakiNow + "/" + nisakiMax + "spots");
        doxaCapacity.setText(doxaNow+ "/" + doxaMax + "spots");

        checkredboxes(lalakiaMax, lalakiaNow, nisakiMax, nisakiNow, doxaMax, doxaNow);


    }

    private void checkredboxes(int lalakiaMax, int lalakiaNow, int nisakiMax, int nisakiNow, int doxaMax, int doxaNow) {
       if (lalakiaNow >= lalakiaMax){
           CardView lalakiaRedBox = findViewById(R.id.RedBoxLalakia);
           lalakiaRedBox.setBackgroundColor(Color.parseColor("#92FF0000"));
       }
       if (nisakiNow >= nisakiMax){
           CardView nisakiRedBox = findViewById(R.id.RedBoxNisaki);
           nisakiRedBox.setBackgroundColor(Color.parseColor("#92FF0000"));
       }
       if (doxaNow >= doxaMax){
           CardView doxaRedBox = findViewById(R.id.RedBoxDoxa);
           doxaRedBox.setBackgroundColor(Color.parseColor("#92FF0000"));
       }
    }

    public void openHistoryActivity(View view) {
        startActivity(new Intent(this, HistoryActivity.class));
    }

    public void openMapActivity(View view) {
        startActivity(new Intent(this, MapActivity.class));
    }

    private void handleButtonClick(int viewId) {
        Intent clickParking = new Intent(this, MainActivityParkUnpark.class);
        if (viewId == R.id.imageButtonNisaki) {
            clickParking.putExtra("parkingId", "Νησάκι");

        } else if (viewId == R.id.imageButtonlalakia) {
            clickParking.putExtra("parkingId", "Λαλακιά");
        } else if (viewId == R.id.imageButtonDoxa) {
            clickParking.putExtra("parkingId", "Δόξα");
        } else {
            // Handle unexpected button press (optional)
        }

        startActivity(clickParking);
    }









}





//    public void openMainActivityParkUnpark(View view) {
//        Intent clickParking = new Intent(this,MainActivityParkUnpark.class);
//        Intent.putExtra("parkingId", );
//        startActivity(clickParking);
//    }



    //public void opena14_osmdroidexpanded(View view) {
      //  startActivity(new Intent(this,a14_osmdroidexpanded.class));
   // }
