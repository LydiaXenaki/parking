package com.example.skatoules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityParkUnpark extends AppCompatActivity {

    Button btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_park_unpark);

        btnToast = findViewById(R.id.btnToast);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivityParkUnpark.this, "ParkMeter starting now",Toast.LENGTH_LONG).show();
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
}