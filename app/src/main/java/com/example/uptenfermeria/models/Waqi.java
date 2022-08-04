package com.example.uptenfermeria.models;

import java.util.ArrayList;

public class Waqi {
    String status;
    ArrayList<data> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Waqi.data> getData() {
        return data;
    }

    public void setData(ArrayList<Waqi.data> data) {
        this.data = data;
    }

    public class data {
        int aqi;
        int idx;
        WaqiAttributions waqiAttributions;
        WaqiCity waqiCity;

       public int getAqi() {
           return aqi;
       }

       public void setAqi(int aqi) {
           this.aqi = aqi;
       }

       public int getIdx() {
           return idx;
       }

       public void setIdx(int idx) {
           this.idx = idx;
       }

       public WaqiAttributions getWaqiAttributions() {
           return waqiAttributions;
       }

       public void setWaqiAttributions(WaqiAttributions waqiAttributions) {
           this.waqiAttributions = waqiAttributions;
       }

        public WaqiCity getWaqiCity() {
            return waqiCity;
        }

        public void setWaqiCity(WaqiCity waqiCity) {
            this.waqiCity = waqiCity;
        }
    }
}
