package com.example.skatoules;
import android.app.Application;
public class Variables extends Application {
        private String someGlobalData = "123";

        public String getSomeGlobalData() {
            return someGlobalData;
        }

        public void setSomeGlobalData(String someGlobalData) {
            this.someGlobalData = someGlobalData;
        }
    }
