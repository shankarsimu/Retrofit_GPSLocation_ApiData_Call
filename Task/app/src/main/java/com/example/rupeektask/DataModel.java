package com.example.rupeektask;
/**
 * Author : Shankar
 * github : https://github.com/shankarsimu/
 * Reach out for this project is available on github
 */

public class DataModel {
    private int temp;
    private int time;
    private int rain;
    private int wind;


    public DataModel(int temp, int time, int rain, int wind) {
        this.temp = temp;
        this.time = time;
        this.rain = rain;
        this.wind = wind;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getRain() {
        return rain;
    }

    public void setRain(int rain) {
        this.rain = rain;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }
}
