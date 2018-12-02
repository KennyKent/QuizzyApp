package com.suonk.quizzy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private LinearLayout loginLinearLayout;
    private LinearLayout signinLinearLayout;
    private Button buttonConnectLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        loginLinearLayout = findViewById(R.id.login_frame_id);
        signinLinearLayout = findViewById(R.id.sign_in_linear_layout);
        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        buttonConnectLogin = findViewById(R.id.buttonConnectLogin);

        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.login_frame:
                        loginLinearLayout.setVisibility(View.VISIBLE);
                        signinLinearLayout.setVisibility(View.GONE);
                        return true;
                    case R.id.sign_in_frame:
                        loginLinearLayout.setVisibility(View.GONE);
                        signinLinearLayout.setVisibility(View.VISIBLE);
                        return true;
                }
                return false;
            }
        };

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        buttonConnectLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            }
        });
    }

}
