package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Manager.ActivityManager;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().attach(this);
        setContentView(R.layout.activity_register);
        setTitle("RegisterActivity");
    }

    public void click(View view) {
        ActivityManager.getInstance().finish(this);
        ActivityManager.getInstance().finish(LoginActivity.class);
    }
    @Override
    public void onDestroy() {
        ActivityManager.getInstance().detach(this);
        super.onDestroy();
    }
}