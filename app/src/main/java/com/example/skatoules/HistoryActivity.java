package com.example.skatoules;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);



        Ticket ticket = TicketManager.getInstance().getTicket();
        CardView firstCardView = findViewById(R.id.firstTicket);
        TextView dateInfo = firstCardView.findViewById(R.id.DateInfo);
        TextView parkingInfo = firstCardView.findViewById(R.id.ParkingInfo);

        TextView startTime = firstCardView.findViewById(R.id.StartTimeInfo);
        TextView endTime = firstCardView.findViewById(R.id.EndTimeInfo);

        if (ticket != null) {
            dateInfo.setText(ticket.getStartDate());
            parkingInfo.setText(ticket.getParkingName());
            startTime.setText(ticket.getStartTime());
            endTime.setText(ticket.getEndTime());
        }


    firstCardView.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Log.d("logsex", "onClick: patithika gia intent");
            Intent goTicketView = new Intent(HistoryActivity.this, MainTicketViewActivity.class);
            startActivity(goTicketView);
        }
    }) ;

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