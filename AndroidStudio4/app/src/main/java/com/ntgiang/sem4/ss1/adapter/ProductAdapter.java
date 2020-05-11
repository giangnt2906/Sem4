package com.ntgiang.sem4.ss1.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ntgiang.sem4.ss1.R;
import com.ntgiang.sem4.ss1.model.ProductModel;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter {

    private Activity activity;
    private List<ProductModel> listProduct;
    private IOnClickItem iOnClickItemListener;

    public ProductAdapter(Activity activity, List<ProductModel> listProduct, IOnClickItem iOnClickItemListener) {
        this.activity = activity;
        this.listProduct = listProduct;
        this.iOnClickItemListener = iOnClickItemListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.item_product_ss5, parent, false);
        ProductHolder holder = new ProductHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ProductHolder vh = (ProductHolder) holder;
        ProductModel productModel = listProduct.get(position);
        vh.tvPrice.setText(productModel.getPrice());
        vh.tvTitle.setText(productModel.getTitle());
        vh.tvDesc.setText(productModel.getDesc());
        vh.ivCover.setImageResource(productModel.getImg());

        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClickItemListener.onClickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }


    public static class ProductHolder extends RecyclerView.ViewHolder {

        private ImageView ivCover;
        private TextView tvTitle;
        private TextView tvDesc;
        private TextView tvPrice;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = itemView.findViewById(R.id.ivCover);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }

    public interface IOnClickItem {
        void onClickItem(int position);
    }
}
