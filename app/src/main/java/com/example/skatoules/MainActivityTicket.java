package com.example.skatoules;

import static com.example.skatoules.R.id.end_date;
import static com.example.skatoules.R.id.end_time;
import static com.example.skatoules.R.id.start_date;
import static com.example.skatoules.R.id.start_time;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivityTicket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ticket);

        TextView starting_date = findViewById(start_date);
        TextView ending_date = findViewById(end_date);
        TextView starting_time = findViewById(start_time);
        TextView ending_time = findViewById(end_time);

        // Format the current date and time
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ", Locale.getDefault());
        String formattedDate = sdf.format(new Date());

        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss ", Locale.getDefault());
        String formattedTimeStart = time.format(new Date());

        // Display the formatted date and time
        starting_date.setText("Starting Date: " + formattedDate);
        ending_date.setText("End Date: " + formattedDate);

        starting_time.setText("Starting Date: " + formattedTimeStart);
        ending_time.setText("End Date: " + formattedTimeStart);



    }

    public void openHistoryActivity(View view) {
        startActivity(new Intent(this,HistoryActivity.class));
    }

    public void openMainActivity(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}