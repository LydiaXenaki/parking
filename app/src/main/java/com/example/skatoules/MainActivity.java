package com.example.skatoules;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.skatoules.R;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String[] parkingList = {"doxa", "lalakia", "nisaki"};
    int[] parkingImages = {R.drawable.doxa, R.drawable.lalakia, R.drawable.nisaki};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Variables app = (Variables) getApplicationContext();

        TextView textView = findViewById(R.id.MainPageName);
        ImageButton button2 = findViewById(R.id.imageButtonNisaki);
        ImageButton button1 = findViewById(R.id.imageButtonlalakia);
        ImageButton button3 = findViewById(R.id.imageButtonDoxa);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleButtonClick(view.getId());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleButtonClick(view.getId());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleButtonClick(view.getId());
            }
        });
    }

    public void openHistoryActivity(View view) {
        startActivity(new Intent(this, HistoryActivity.class));
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
