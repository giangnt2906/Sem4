package com.ntgiang.sem4.ss6_recyclerview_json.interf;

import com.ntgiang.sem4.ss6_recyclerview_json.model.DailyForecast;
import com.ntgiang.sem4.ss6_recyclerview_json.model.NewsModel;
import com.ntgiang.sem4.ss6_recyclerview_json.model.WeatherModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIManager {
    String SERVER_URL = "https://api-demo-anhth.herokuapp.com/";
    String SERVER_URL_WEATHER = "http://dataservice.accuweather.com/";

    @GET("data.json")
    Call<NewsModel> getItemData();
    //Call<NewsModel> getItemData(@Query("page") int page, @Query("limit") String limit);

    @GET("datas.json")
    Call<List<NewsModel>> getListData();

    //weather app activity
    @GET("forecasts/v1/hourly/12hour/353412?apikey=QUnERRYQt7dK8G0TGeGP5Q3saTWapm8L&language=vi-vn&metric=true")
    Call<List<WeatherModel>> getHour();

    @GET("forecasts/v1/daily/5day/353412?apikey=QUnERRYQt7dK8G0TGeGP5Q3saTWapm8L&language=vi-vn&metric=true")
    Call<DailyForecast> getDay();
}
