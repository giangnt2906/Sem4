package com.ntgiang.sem4.ss6_recyclerview_json.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ntgiang.sem4.ss6_recyclerview_json.R;
import com.ntgiang.sem4.ss6_recyclerview_json.adapter.ListNewsAdapter;
import com.ntgiang.sem4.ss6_recyclerview_json.interf.APIManager;
import com.ntgiang.sem4.ss6_recyclerview_json.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Ss6JsonBasicActivity extends AppCompatActivity {

    //ss6 1 item json va 1 list nhieu item json
    TextView tvTitle;
    TextView tvContent;
    TextView tvDate;
    ImageView ivCover;
    //
    List<NewsModel> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ss6_recycler_list);

        //
        tvTitle = findViewById(R.id.tvTitle);
        tvDate = findViewById(R.id.tvDate);
        tvContent = findViewById(R.id.tvContent);
        ivCover = findViewById(R.id.ivCover);

        //json tra ve 1 object news
        //getData();

        //json tra ve 1 list nhieu object news
        getListData();
    }

    private void getData() {
        //
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //
        APIManager service = retrofit.create(APIManager.class);
        service.getItemData().enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                //
                NewsModel model = response.body();

                tvTitle.setText(model.getTitle());
                tvDate.setText(model.getDate());
                tvContent.setText(model.getContent());
                Glide.with(Ss6JsonBasicActivity.this).load(model.getImage()).into(ivCover);
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Log.d("Ss6JsonBasicActivity", "onFailure: "+t);
            }
        });
    }

    //json tra ve 1 list nhieu objects
    private void getListData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager serivce = retrofit.create(APIManager.class);
        serivce.getListData().enqueue(new Callback<List<NewsModel>>() {
            @Override
            public void onResponse(Call<List<NewsModel>> call, Response<List<NewsModel>> response) {
                List<NewsModel> listNews = response.body();

                //b2 adapter
                listData = listNews;
                ListNewsAdapter adapter = new ListNewsAdapter(Ss6JsonBasicActivity.this, listData);
                //b3 layout manager LinearLayoutManager (1 trong 3 loai)
                LinearLayoutManager layoutManager = new LinearLayoutManager(Ss6JsonBasicActivity.this, LinearLayoutManager.VERTICAL, false);
                //b4 recycler view
                RecyclerView rvListNews = findViewById(R.id.rvListNews);
                rvListNews.setAdapter(adapter);
                rvListNews.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<List<NewsModel>> call, Throwable t) {
                Log.d("Ss6JsonBasicActivity", "onFailure: "+t);
            }
        });
    }
}
