package com.cookandroid.ramenapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //타이틀바 텍스트 (공백)
        ActionBar ab = getSupportActionBar();
        ab.setTitle("");

        //타이틀바 이미지 삽입
        getSupportActionBar().setIcon(R.drawable.logo_title);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}

