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
import com.ntgiang.sem4.ss6_recyclerview_json.activity.Ss6JsonBasicActivity;
import com.ntgiang.sem4.ss6_recyclerview_json.model.NewsModel;

import java.util.List;

public class ListNewsAdapter extends RecyclerView.Adapter {

    //
    private Activity activity;
    private List<NewsModel> listNews;
    //private IOnClickItem iOnClickItemListener;

    //constructor bo di interface cho IOnClickItem
    public ListNewsAdapter(Activity activity, List<NewsModel> listNews) {
        this.activity = activity;
        this.listNews = listNews;
        //this.iOnClickItemListener = iOnClickItemListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Lay layout 1 (news) item cho vao view v. Tao holder tu v va return holder
        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.activity_ss6_json_basic, parent, false);
        NewsHolder holder = new NewsHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //
        NewsHolder vh = (NewsHolder) holder;
        NewsModel model = listNews.get(position);
        vh.tvTitle.setText(model.getTitle());
        vh.tvDate.setText(model.getDate());
        vh.tvContent.setText(model.getContent());
        Glide.with(activity).load(model.getImage()).into(vh.ivCover);
        //vh.tvTitle.setText(model.getTitle());

        // hanh dong click vao 1 item trong list
        /*vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClickItemListener.onClickItem(position);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    //tao view holder pattern cho recycler view (NewsHolder)
    public static class NewsHolder extends RecyclerView.ViewHolder {

        private ImageView ivCover;
        private TextView tvContent;
        private TextView tvDate;
        private TextView tvTitle;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = itemView.findViewById(R.id.ivCover);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }

    //interface cho hanh dong click on 1 item trong recycler view (chua can su dung den)
    /*public interface IOnClickItem {
        void onClickItem(int position);
    }*/
}
