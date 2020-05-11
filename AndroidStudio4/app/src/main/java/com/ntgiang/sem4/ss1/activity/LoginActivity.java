package com.ntgiang.sem4.ss1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ntgiang.sem4.ss1.R;

public class LoginActivity extends AppCompatActivity {

    Button btLogin;
    EditText edUser;
    EditText edPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_ss4);

        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);

        btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textUser = edUser.getText().toString();
                String textPass = edPass.getText().toString();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                intent.putExtra("UserName", textUser);
                intent.putExtra("Pass", textPass);
                startActivity(intent);
            }
        });
    }
}
