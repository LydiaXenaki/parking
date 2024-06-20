package com.example.skatoules;
import android.app.Application;

public class Variables extends Application {
        private String currentTime;
        private String currentDate;
        private String currentParking;

        private int parkingSpotsLal;
        private int parkingSpotsDox;
        private int parkingSpotsNis;

        private int parkingSpotsLalmax = 5;
        private int parkingSpotsDoxmax = 5;
        private int parkingSpotsNismax = 5;





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
