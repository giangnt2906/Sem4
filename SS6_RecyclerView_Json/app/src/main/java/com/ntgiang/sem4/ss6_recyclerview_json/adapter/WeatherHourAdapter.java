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
import com.ntgiang.sem4.ss6_recyclerview_json.model.WeatherModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WeatherHourAdapter extends RecyclerView.Adapter {
    //
    private Activity activity;
    private List<WeatherModel> listWeather;

    public WeatherHourAdapter(Activity activity, List<WeatherModel> listWeather) {
        this.activity = activity;
        this.listWeather = listWeather;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //
        LayoutInflater inflater = activity.getLayoutInflater();
        View itemView = inflater.inflate(R.layout.item_hour_ss7, parent, false);
        HourHolder holder = new HourHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HourHolder vh = (HourHolder) holder;
        WeatherModel weatherModel = listWeather.get(position);
        vh.tvTime.setText(convertTime(weatherModel.getDateTime()));
        vh.tvTemp.setText(weatherModel.getTemperature().getValue()+"°");
        String url = "";
        if (weatherModel.getWeatherIcon() < 10) {
            url = "https://developer.accuweather.com/sites/default/files/0" +weatherModel.getWeatherIcon()+ "-s.png";
        } else {
            url = "https://developer.accuweather.com/sites/default/files/" +weatherModel.getWeatherIcon()+ "-s.png";
        }
        Glide.with(activity).load(url).into(vh.ivIcon);
    }

    @Override
    public int getItemCount() {
        return listWeather.size();
    }

    //holder
    public static class HourHolder extends RecyclerView.ViewHolder {
        //
        private TextView tvTemp;
        private ImageView ivIcon;
        private TextView tvTime;
        public HourHolder(@NonNull View itemView) {
            super(itemView);
            tvTemp = itemView.findViewById(R.id.tvTemp);
            ivIcon = itemView.findViewById(R.id.ivIcon);
            tvTime = itemView.findViewById(R.id.tvTime);
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
        SimpleDateFormat outFormat = new SimpleDateFormat("h a");
        String goal = outFormat.format(date);
        return goal;
    }
}
