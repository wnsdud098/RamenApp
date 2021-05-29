package com.cookandroid.ramenapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentPage2 extends Fragment {
    ArrayAdapter<CharSequence> foodAdapter, ramenAdapter, chickenAdapter, pizzaAdapter; //어댑터 선언
    String choice_food = "";
    String choice_amount = "";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        //////////////////////////////////////////////////////////////스피너
        View view = inflater.inflate(R.layout.fragment_page_2,container,false);
        //xml과 class에 변수들을 연결해준다.
        Spinner spin1 = (Spinner) view.findViewById(R.id.spinner_food);
        Spinner spin2 = (Spinner) view.findViewById(R.id.spinner_amount);


        //음식 어댑터에 값을 넣는다. this는 현재 class를 의미한다.
        foodAdapter = ArrayAdapter.createFromResource(getContext(),R.array.foods_array, android.R.layout.simple_spinner_dropdown_item);
        foodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(foodAdapter); // 어댑터의 값들을 spinner에 넣는다.
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (foodAdapter.getItem(i).equals("라면")) { // 라면을 선택했을 경우
                    choice_food = "라면";
                    ramenAdapter = ArrayAdapter.createFromResource(getContext(), R.array.ramen_array, android.R.layout.simple_spinner_dropdown_item);
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
                    chickenAdapter = ArrayAdapter.createFromResource(getContext(), R.array.chicken_array, android.R.layout.simple_spinner_dropdown_item);
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
                    pizzaAdapter = ArrayAdapter.createFromResource(getContext(), R.array.pizza_array, android.R.layout.simple_spinner_dropdown_item);
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
        });

        return inflater.inflate(R.layout.fragment_page_2, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

