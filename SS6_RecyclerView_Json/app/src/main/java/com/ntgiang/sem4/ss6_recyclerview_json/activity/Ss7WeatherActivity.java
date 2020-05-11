package com.ntgiang.sem4.ss6_recyclerview_json.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ntgiang.sem4.ss6_recyclerview_json.R;
import com.ntgiang.sem4.ss6_recyclerview_json.adapter.WeatherDayAdapter;
import com.ntgiang.sem4.ss6_recyclerview_json.adapter.WeatherHourAdapter;
import com.ntgiang.sem4.ss6_recyclerview_json.interf.APIManager;
import com.ntgiang.sem4.ss6_recyclerview_json.model.DailyForecast;
import com.ntgiang.sem4.ss6_recyclerview_json.model.WeatherModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Ss7WeatherActivity extends AppCompatActivity {

    private RecyclerView rvHour;
    private TextView tvTemp;
    private TextView tvStatus;
    private RecyclerView rvDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ss7_weather);
        //
        tvTemp = findViewById(R.id.tvTemp);
        tvStatus = findViewById(R.id.tvStatus);
        rvHour = findViewById(R.id.rvHour);
        rvDay = findViewById(R.id.rvDay);
        //data
        getHours();
        //data 5 days daily
        getDays();

    }

    //get Days
    private void getDays() {
        //
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL_WEATHER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIManager service = retrofit.create(APIManager.class);
        //
        service.getDay().enqueue(new Callback<DailyForecast>() {
            @Override
            public void onResponse(Call<DailyForecast> call, Response<DailyForecast> response) {
                //
                if (response.body() == null) return;
                //
                DailyForecast data = response.body();
                WeatherDayAdapter adapter = new WeatherDayAdapter(Ss7WeatherActivity.this, data);
                LinearLayoutManager layoutManager = new LinearLayoutManager(Ss7WeatherActivity.this, RecyclerView.VERTICAL, false);
                //
                rvDay.setLayoutManager(layoutManager);
                rvDay.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<DailyForecast> call, Throwable t) {
                Log.d("Ss7WeatherActivity", "onFailure: "+t);
            }
        });
    }

    //
    private void getHours() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL_WEATHER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);

        service.getHour().enqueue(new Callback<List<WeatherModel>>() {
            @Override
            public void onResponse(Call<List<WeatherModel>> call, Response<List<WeatherModel>> response) {
                //
                if (response.body() == null) return;
                //
                List<WeatherModel> listWeather = response.body();
                WeatherHourAdapter adapter = new WeatherHourAdapter(Ss7WeatherActivity.this, listWeather);
                LinearLayoutManager layoutManager = new LinearLayoutManager(Ss7WeatherActivity.this, LinearLayoutManager.HORIZONTAL, false);
                //
                rvHour.setLayoutManager(layoutManager);
                rvHour.setAdapter(adapter);
                //
                WeatherModel weatherModel = listWeather.get(0);
                tvTemp.setText(weatherModel.getTemperature().getValue().intValue()+ "°C");
                tvStatus.setText(weatherModel.getIconPhrase());
            }

            @Override
            public void onFailure(Call<List<WeatherModel>> call, Throwable t) {
                Log.d("Ss7WeatherActivity", "onFailure: "+t);
            }
        });
    }
}
