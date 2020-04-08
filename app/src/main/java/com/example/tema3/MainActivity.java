package com.example.tema3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

        Button b1f1a1=(Button)findViewById(R.id.btnF1A1);
        Log.i(TAG,"AiciProblema");
        b1f1a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });


    }
    private void addFragment1(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Fragment1Activity1 fragment1Activity1=new Fragment1Activity1();
        fragmentTransaction.add(R.id.fragment1Activity1Id,fragment1Activity1);

        fragmentTransaction.commit();


    }
    public void openActivity3(){

        Intent intent = new Intent(this,Activity3.class);

        startActivity(intent);
    }

}
