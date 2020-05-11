package com.ntgiang.sem4.ss1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ntgiang.sem4.ss1.R;

public class MainActivity extends AppCompatActivity {
    TextView tvTitle;

    /*Button btLogin;
    TextView tvTitle;
    ImageView ivCover;
    EditText edUser;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the current intent
        Intent intent = getIntent();
        //get the attached extras from the intent
        //we should use the same key as we used to attach the data.
        String user_name = intent.getStringExtra("UserName");
        String password = intent.getStringExtra("Pass");
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText(user_name);

        /*//EditText
        edUser = findViewById(R.id.edUser);
        //ImageView
        ivCover = findViewById(R.id.ivCover);
        //TextView
        tvTitle = findViewById(R.id.tvTitle);
        //Button
        btLogin = findViewById(R.id.btLogin);
        //dang ki su kien click button
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //goi vao day
                //tvTitle.setText("FPT");
                ivCover.setImageResource(R.drawable.skaarf);
                String textUser = edUser.getText().toString();
                tvTitle.setText(textUser);
            }
        });*/

    }
}
