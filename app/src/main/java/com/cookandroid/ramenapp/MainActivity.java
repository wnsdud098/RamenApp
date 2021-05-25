package com.cookandroid.ramenapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView textView;

    //스피너에 들어갈 데이터
    String[] items_food = {"치킨", "피자", "라면"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //////////////위쪽 툴바
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);//기본 제목을 없애줍니다.
        actionBar.setDisplayHomeAsUpEnabled(true);


        //////////////스피너
        Spinner spinner =findViewById(R.id.spinner_food);
        textView = findViewById(R.id.textView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                //spinner_list.xml
                this, R.layout.spinner_list, items_food
        );
        //스피너 객체에다가 어댑터를 넣어줌
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //선택되면
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                textView.setText(items_food[position]);
            }
            //아무것도 선택되지 않은 상태일때
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                textView.setText("음식: ");
            }
        });

    }


}

