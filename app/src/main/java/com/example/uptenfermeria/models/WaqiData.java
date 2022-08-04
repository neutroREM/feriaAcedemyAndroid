package com.example.uptenfermeria.models;

public class WaqiData {

    private int aqi;
    private int idx;
    private WaqiAttributions[] attributions;
    private WaqiCity city;

    public WaqiCity getCity() {
        return city;
    }

    public void setCity(WaqiCity city) {
        this.city = city;
    }

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

    public WaqiAttributions[] getAttributions() {
        return attributions;
    }

    public void setAttributions(WaqiAttributions[] attributions) {
        this.attributions = attributions;
    }
}
