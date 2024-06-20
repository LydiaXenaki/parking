package com.example.skatoules;
import android.app.Application;

public class Variables extends Application {



        private boolean isParked = false;
        private String currentTime;



        private long currentTimeMili;
        private int timeMili;
        private String currentDate;
        private String currentParking = "";



    private String justParked;

        private int parkingSpotsLal;
        private int parkingSpotsDox;
        private int parkingSpotsNis;

        private int parkingSpotsLalmax = 5;
        private int parkingSpotsDoxmax = 5;
        private int parkingSpotsNismax = 5;




        public boolean isParked() {
            return isParked;
        }

        public void setParked(boolean parked) {
            isParked = parked;
        }

        public String getJustParked() {
            return justParked;
        }

        public void setJustParked(String justParked) {
            this.justParked = justParked;
        }

        public String getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }

        public long getCurrentTimeMili() {
            return currentTimeMili;
        }

        public void setCurrentTimeMili(long currentTimeMili) {
            this.currentTimeMili = currentTimeMili;
        }
        public String getCurrentDate() {
        return currentDate;
    }

        public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }


        public int getParkingSpotsLal() {
            return parkingSpotsLal;
        }

        public void setParkingSpotsLal(int parkingSpotsLal) {
            this.parkingSpotsLal = parkingSpotsLal;
        }

        public int getParkingSpotsNis() {
            return parkingSpotsNis;
        }

        public void setParkingSpotsNis(int parkingSpotsNis) {
            this.parkingSpotsNis = parkingSpotsNis;
        }

        public int getParkingSpotsDox() {
            return parkingSpotsDox;
        }

        public void setParkingSpotsDox(int parkingSpotsDox) {
            this.parkingSpotsDox = parkingSpotsDox;

        }

        public int getParkingSpotsNismax() {
            return parkingSpotsNismax;
        }

        public void setParkingSpotsNismax(int parkingSpotsNismax) {
            this.parkingSpotsNismax = parkingSpotsNismax;
        }

        public int getParkingSpotsDoxmax() {
            return parkingSpotsDoxmax;
        }

        public void setParkingSpotsDoxmax(int parkingSpotsDoxmax) {
            this.parkingSpotsDoxmax = parkingSpotsDoxmax;
        }

        public int getParkingSpotsLalmax() {
            return parkingSpotsLalmax;
        }

        public void setParkingSpotsLalmax(int parkingSpotsLalmax) {
            this.parkingSpotsLalmax = parkingSpotsLalmax;
        }

        public String getCurrentParking() {
            return currentParking;
        }

        public void setCurrentParking(String currentParking) {
            this.currentParking = currentParking;
        }




    }
