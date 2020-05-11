package com.ntgiang.sem4.ss6_recyclerview_json.model;

import java.util.List;

public class DailyForecast {
    List<WeatherDay> DailyForecasts;

    public List<WeatherDay> getDailyForecasts() {
        return DailyForecasts;
    }

    public void setDailyForecasts(List<WeatherDay> dailyForecasts) {
        DailyForecasts = dailyForecasts;
    }
}
