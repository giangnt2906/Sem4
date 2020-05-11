package com.ntgiang.sem4.ss1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.ntgiang.sem4.ss1.R;
import com.ntgiang.sem4.ss1.adapter.ProductAdapter;
import com.ntgiang.sem4.ss1.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewSs5Activity extends AppCompatActivity implements ProductAdapter.IOnClickItem {

    List<ProductModel> listProduct = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_ss5);

        //b1
        initData();
        //b2
        ProductAdapter adapter = new ProductAdapter(this, listProduct, this);
        //b3 layout manager
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        //b4 recycler view
        RecyclerView rvProduct = findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(adapter);
    }

    private void initData() {
        listProduct.add(new ProductModel("Dress Zara 1", "Very Red", "10000", R.drawable.dress1));
        listProduct.add(new ProductModel("Dress Gucci 2", "Very Cool", "20000", R.drawable.dress2));
        listProduct.add(new ProductModel("Dress Vera 3", "Very Blue", "30000", R.drawable.dress3));
        listProduct.add(new ProductModel("Dress DG 4", "Very Short", "40000", R.drawable.dress4));
        listProduct.add(new ProductModel("Webber", "Constant Characters of 2 personalities", "20000", R.drawable.webber));
        listProduct.add(new ProductModel("Cat", "Very Catto", "90000", R.drawable.skaarf));
    }

    @Override
    public void onClickItem(int position) {
        ProductModel product = listProduct.get(position);
        Toast.makeText(this, product.getTitle() + " is " + product.getPrice(), Toast.LENGTH_SHORT).show();
    }
}
