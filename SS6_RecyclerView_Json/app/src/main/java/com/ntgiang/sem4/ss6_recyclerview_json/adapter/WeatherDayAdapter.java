package com.ntgiang.sem4.ss6_recyclerview_json.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ntgiang.sem4.ss6_recyclerview_json.R;
import com.ntgiang.sem4.ss6_recyclerview_json.model.DailyForecast;
import com.ntgiang.sem4.ss6_recyclerview_json.model.WeatherDay;
import com.ntgiang.sem4.ss6_recyclerview_json.model.WeatherModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherDayAdapter extends RecyclerView.Adapter {
    //
    private Activity activity;
    private DailyForecast dailyForecast;

    public WeatherDayAdapter(Activity activity, DailyForecast dailyForecast) {
        this.activity = activity;
        this.dailyForecast = dailyForecast;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //
        LayoutInflater inflater = activity.getLayoutInflater();
        View itemView = inflater.inflate(R.layout.item_day_ss7, parent, false);
        DayHolder holder = new DayHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //
        List<WeatherDay> listDay = new ArrayList<>();
        listDay = dailyForecast.getDailyForecasts();
        DayHolder dayHolder = (DayHolder) holder;
        WeatherDay model = listDay.get(position);
        dayHolder.tvDay.setText(convertTime(model.getDate()));
        dayHolder.tvMin.setText(model.getTemperature().getMinimum().getValue()+ "°");
        dayHolder.tvMax.setText(model.getTemperature().getMaximum().getValue()+ "°");
        //url
        String url = "";
        if (model.getDay().getIcon() < 10) {
            url = "https://developer.accuweather.com/sites/default/files/0" + model.getDay().getIcon() + "-s.png";
        } else {
            url = "https://developer.accuweather.com/sites/default/files/" + model.getDay().getIcon() + "-s.png";
        }
        Glide.with(activity).load(url).into(dayHolder.ivIcon);
    }

    @Override
    public int getItemCount() {
        return dailyForecast.getDailyForecasts().size();
    }

    //holder
    public static class DayHolder extends RecyclerView.ViewHolder {
        //
        private TextView tvDay;
        private TextView tvMin;
        private TextView tvMax;
        private ImageView ivIcon;

        public DayHolder(@NonNull View itemView) {
            super(itemView);
            tvDay = itemView.findViewById(R.id.tvDay);
            tvMax = itemView.findViewById(R.id.tvMax);
            tvMin = itemView.findViewById(R.id.tvMin);
            ivIcon = itemView.findViewById(R.id.ivIcon);
        }
    }
    //convert time
    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
        String goal = outFormat.format(date);
        return goal;
    }
}
