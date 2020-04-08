package com.example.tema3;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Activity3 extends AppCompatActivity {
    private static final String TAG="Activity3";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        addFragment1();
    }
    private void addFragment1(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Fragment1Activity3 fragment1Activity3=new Fragment1Activity3();
        fragmentTransaction.add(R.id.fragment1Activity3Id,fragment1Activity3);

        fragmentTransaction.commit();


    }
}
