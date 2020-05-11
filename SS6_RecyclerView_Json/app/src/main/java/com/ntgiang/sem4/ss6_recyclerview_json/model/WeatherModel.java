package com.ntgiang.sem4.ss6_recyclerview_json.model;

public class WeatherModel {
    private String DateTime;
    private int WeatherIcon;
    private String IconPhrase;
    private Temperature Temperature;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public com.ntgiang.sem4.ss6_recyclerview_json.model.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.ntgiang.sem4.ss6_recyclerview_json.model.Temperature temperature) {
        Temperature = temperature;
    }
}
