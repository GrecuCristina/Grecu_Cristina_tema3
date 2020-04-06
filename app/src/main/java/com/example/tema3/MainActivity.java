package com.example.tema3;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="Activity1";
    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment1();

    }
    private void addFragment1(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Fragment1Activity1 fragment1Activity1=new Fragment1Activity1();
        fragmentTransaction.add(R.id.fragment1Activity1Id,fragment1Activity1);

        fragmentTransaction.commit();


    }

}
