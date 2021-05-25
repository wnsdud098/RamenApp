package com.cookandroid.ramenapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mBottomNV;
    Toolbar toolbar;
    TextView textView_food, textView_amount;

    //스피너에 들어갈 데이터
    String[] items_food = {"치킨", "피자", "라면"};
    String[] items_amount = {"1", "2", "3", "4", "5"};

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //탭
        mBottomNV = findViewById(R.id.nav_view);
        mBottomNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { //NavigationItemSelecte
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                BottomNavigate(menuItem.getItemId());


                return true;
            }
        });
        mBottomNV.setSelectedItemId(R.id.tab_second);
    }
    private void BottomNavigate(int id) {  //BottomNavigation 페이지 변경
        String tag = String.valueOf(id);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment currentFragment = fragmentManager.getPrimaryNavigationFragment();
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment);
        }

        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            if (id == R.id.tab_first) {
                fragment = new FragmentPage1();

            } else if (id == R.id.tab_second){

                fragment = new FragmentPage2();
            }else {
                fragment = new FragmentPage3();
            }

            fragmentTransaction.add(R.id.content_layout, fragment, tag);
        } else {
            fragmentTransaction.show(fragment);
        }

        fragmentTransaction.setPrimaryNavigationFragment(fragment);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNow();

        //////////////위쪽 툴바
                toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);//기본 제목을 없애줍니다.
        actionBar.setDisplayHomeAsUpEnabled(true);

/*
        //////////////음식 스피너
        Spinner spinner_food =findViewById(R.id.spinner_food);
        textView_food = findViewById(R.id.foods);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                //spinner_list.xml
                this, R.layout.spinner_list, items_food
        );
        //스피너 객체에다가 어댑터를 넣어줌
        spinner_food.setAdapter(adapter1);
        spinner_food.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //선택되면
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView_food.setText(items_food[position]);
            }
            //아무것도 선택되지 않은 상태일때
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                textView_food.setText("음식: ");
            }
        });


        //////////////양 스피너
        Spinner spinner_amount =findViewById(R.id.spinner_amount);
        textView_amount = findViewById(R.id.amount);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                //spinner_list.xml
                this, R.layout.spinner_list, items_amount
        );
        //스피너 객체에다가 어댑터를 넣어줌
        spinner_amount.setAdapter(adapter2);
        spinner_amount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //선택되면
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView_amount.setText(items_amount[position]);
            }
            //아무것도 선택되지 않은 상태일때
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                textView_amount.setText("몇: ");
            }
        });
*/

    }


}

