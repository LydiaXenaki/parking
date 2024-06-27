
package com.example.skatoules;

import static com.example.skatoules.R.id.end_date;
import static com.example.skatoules.R.id.end_time;
import static com.example.skatoules.R.id.start_date;
import static com.example.skatoules.R.id.start_time;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainTicketViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("logsex", "onCreate: bhka on create ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ticket_view);
        Log.d("logsex", "onCreate: den MPHKA STO IF ");

        Ticket ticket = TicketManager.getInstance().getTicket();

        TextView starting_date = findViewById(start_date);
        TextView ending_date = findViewById(end_date);
        TextView starting_time = findViewById(start_time);
        TextView ending_time = findViewById(end_time);
        TextView parkingName = findViewById(R.id.parking);
        TextView totalFee = findViewById(R.id.totalFee);

        if (ticket != null) {
            Log.d("logsex", "onCreate:MPHKA STO IF ");
            starting_date.setText("Starting Date: " + ticket.getStartDate());
            ending_date.setText("End Date: " + ticket.getEndDate());
            parkingName.setText("Parking: " + ticket.getParkingName());
            starting_time.setText("Starting Time: " +ticket.getStartTime());
            ending_time.setText("End Time: " + ticket.getEndTime());
            totalFee.setText("Total Fee: " + ticket.getTotalFee());
        }
    }

    public void openHistoryActivity(View view) {
        startActivity(new Intent(this, HistoryActivity.class));
    }


    public void openMapActivity(View view) {
        startActivity(new Intent( this , MapActivity.class));
    }


    public void openMainActivity(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

}
