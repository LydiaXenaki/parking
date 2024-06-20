package com.example.skatoules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }

    public void openMapActivity(View view) {
        startActivity(new Intent(this, MapActivity.class));
    }

    public void openMainActivityParkUnpark(View view) {
        startActivity(new Intent(this,MainActivityParkUnpark.class));
    }
    public void openMainActivity(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}