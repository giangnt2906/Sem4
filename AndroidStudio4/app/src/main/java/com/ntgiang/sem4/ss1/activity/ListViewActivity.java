package com.ntgiang.sem4.ss1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ntgiang.sem4.ss1.R;

public class ListViewActivity extends AppCompatActivity {

    //list view ss4
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = (ListView)findViewById(R.id.lvContact);
        //b1: data
        final String[] datas = {"Samsung", "Apple", "Nokia", "Xiaomi", "Oppo", "HTC", "Samsung", "Apple", "Nokia", "Xiaomi", "Oppo", "HTC"};
        //b2: tao adapter
        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , datas);
        //b3: hien thi
        listView.setAdapter(arrayAdapter);
        //de khi click vao thi no hien thi thong bao cho minh
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, datas[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
