package com.example.skatoules;
import android.app.Application;

import java.text.SimpleDateFormat;

public class Variables extends Application {
        private String currentTime;

        private String currentDate;

        private SimpleDateFormat justParkedTimeDate;
        private SimpleDateFormat UnparkedTimeDate;
        private int ParkingSpotsLal;
        private int ParkingSpotsDox;
        private int ParkingSpotsNis;





        public String getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }


        public String getCurrentDate() {
        return currentDate;
    }

        public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

        public SimpleDateFormat getjustParkedTimeDate() {
            return justParkedTimeDate;
        }

        public void setjustParkedTimeDate(SimpleDateFormat justParkedTimeDate) {
            this.justParkedTimeDate = justParkedTimeDate;
        }

        public SimpleDateFormat getUnparkedTimeDate() {
            return UnparkedTimeDate;
        }

        public void setUnparkedTimeDate(SimpleDateFormat UnparkedTimeDate) {
            this.UnparkedTimeDate = UnparkedTimeDate;
        }


    }
