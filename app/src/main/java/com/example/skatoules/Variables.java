package com.example.skatoules;
import android.app.Application;

import java.text.SimpleDateFormat;

public class Variables extends Application {
        private String someGlobalData = "123";
        private SimpleDateFormat justParkedTimeDate;
        private SimpleDateFormat UnparkedTimeDate;
        private int ParkingSpotsLal;
        private int ParkingSpotsDox;
        private int ParkingSpotsNis;





//        public String getSomeGlobalData() {
//            return someGlobalData;
//        }
//
//        public void setSomeGlobalData(String someGlobalData) {
//            this.someGlobalData = someGlobalData;
//        }

        public SimpleDateFormat getJustParkedTimeDate() {
            return justParkedTimeDate;
        }

        public void setJustParkedTimeDate(SimpleDateFormat someGlobalData) {
            this.justParkedTimeDate = justParkedTimeDate;
        }

        public SimpleDateFormat getUnparkedTimeDate() {
            return UnparkedTimeDate;
        }

        public void setUnparkedTimeDate(SimpleDateFormat UnparkedTimeDate) {
            this.UnparkedTimeDate = UnparkedTimeDate;
        }


    }
