package com.example.skatoules;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String[] parkingList = {"doxa", "lalakia", "nisaki"};
    int parkingImages []= {R.drawable.doxa, R.drawable.lalakia, R.drawable.nisaki };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openHistoryActivity(View view) {
        startActivity(new Intent(this,HistoryActivity.class));
    }

    public void openMainActivityParkUnpark(View view) {
        startActivity(new Intent(this,MainActivityParkUnpark.class));
    }


    //public void opena14_osmdroidexpanded(View view) {
      //  startActivity(new Intent(this,a14_osmdroidexpanded.class));
   // }
}