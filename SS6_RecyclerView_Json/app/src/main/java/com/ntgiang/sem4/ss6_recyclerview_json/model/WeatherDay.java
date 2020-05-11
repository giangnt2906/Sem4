package com.ntgiang.sem4.ss6_recyclerview_json.model;

public class WeatherDay {
    private String Date;
    private TempDay Temperature;
    private Day Day;
    private Day Night;

    public com.ntgiang.sem4.ss6_recyclerview_json.model.Day getDay() {
        return Day;
    }

    public void setDay(com.ntgiang.sem4.ss6_recyclerview_json.model.Day day) {
        Day = day;
    }

    public com.ntgiang.sem4.ss6_recyclerview_json.model.Day getNight() {
        return Night;
    }

    public void setNight(com.ntgiang.sem4.ss6_recyclerview_json.model.Day night) {
        Night = night;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public TempDay getTemperature() {
        return Temperature;
    }

    public void setTemperature(TempDay temperature) {
        Temperature = temperature;
    }
}
