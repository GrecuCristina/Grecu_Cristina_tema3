package com.example.tema3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static com.example.tema3.Fragment1Activity1.EXTRA_EMAIL;
import static com.example.tema3.Fragment1Activity1.EXTRA_NAME;
import static com.example.tema3.Fragment1Activity1.EXTRA_USERNAME;

public class Activity2 extends AppCompatActivity {
    private static final String TAG="Activity2";
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        addFragment1();
        Intent intent=getIntent();
        String name=intent.getStringExtra(EXTRA_NAME);
        String username=intent.getStringExtra(EXTRA_USERNAME);
        String email=intent.getStringExtra(EXTRA_EMAIL);
        TextView nameView=findViewById(R.id.F2A1_name);
        TextView usernameView=findViewById(R.id.F2A1_username);
        TextView emailView=findViewById(R.id.F2A1_email);

        nameView.setText("Name :"+name);
        usernameView.setText("Username: "+username);
        usernameView.setText("Email "+email);


    }
    private void addFragment1(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Fragment2Activity1 fragment2Activity1=new Fragment2Activity1();
        fragmentTransaction.add(R.id.fragment2Activity1Id,fragment2Activity1);

        fragmentTransaction.commit();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "AicionDestroyMethod2");
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity(); // or finish();
    }
}
