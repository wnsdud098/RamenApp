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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mBottomNV; //바텀 네비게이션 선언
    Toolbar toolbar; //툴바 선언
    ArrayAdapter<CharSequence> foodAdapter, ramenAdapter, chickenAdapter, pizzaAdapter; //어댑터 선언
    String choice_food="";
    String choice_amount="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //탭
        mBottomNV = findViewById(R.id.nav_view);
        mBottomNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { //NavigationItemSelected
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                BottomNavigate(menuItem.getItemId());

                return true;
            }
        });
        mBottomNV.setSelectedItemId(R.id.tab_second);


        //////////////////////////////////////////////////////////////스피너
        /*
        setContentView(R.layout.fragment_page_2);
        //xml과 class에 변수들을 연결해준다.
        Spinner spin1 = (Spinner) findViewById(R.id.spinner_food);
        Spinner spin2 = (Spinner) findViewById(R.id.spinner_amount);


        //음식 어댑터에 값을 넣는다. this는 현재 class를 의미한다.
        foodAdapter = ArrayAdapter.createFromResource(this,R.array.foods_array, android.R.layout.simple_spinner_dropdown_item);
        foodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(foodAdapter); // 어댑터의 값들을 spinner에 넣는다.
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (foodAdapter.getItem(i).equals("라면")) { // 라면을 선택했을 경우
                    choice_food = "라면";
                    ramenAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.ramen_array, android.R.layout.simple_spinner_dropdown_item);
                    ramenAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(ramenAdapter); // 두 번째 어댑터 값을 두 번째 spinner에 넣는다.
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_amount = ramenAdapter.getItem(i).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (foodAdapter.getItem(i).equals("치킨")) { // 치킨을 선택했을 경우
                    choice_food = "치킨";
                    chickenAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.chicken_array, android.R.layout.simple_spinner_dropdown_item);
                    chickenAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(chickenAdapter); // 두 번째 어댑터 값을 두 번째 spinner에 넣는다.
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_amount = chickenAdapter.getItem(i).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (foodAdapter.getItem(i).equals("피자")) { // 피자를 선택했을 경우
                    choice_food = "피자";
                    pizzaAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.pizza_array, android.R.layout.simple_spinner_dropdown_item);
                    pizzaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(pizzaAdapter); // 두 번째 어댑터 값을 두 번째 spinner에 넣는다.
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_amount = pizzaAdapter.getItem(i).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });*/
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
            } else {
                fragment = new FragmentPage3();
            }

            fragmentTransaction.add(R.id.content_layout, fragment, tag);
        } else {
            fragmentTransaction.show(fragment);
        }

        fragmentTransaction.setPrimaryNavigationFragment(fragment);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNow();


        /////////////////////////////////////////////////////////////위쪽 툴바
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);//기본 제목을 없애줍니다.
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

}

