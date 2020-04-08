package com.example.tema3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.tema3.Fragment1Activity1.EXTRA_EMAIL;
import static com.example.tema3.Fragment1Activity1.EXTRA_NAME;
import static com.example.tema3.Fragment1Activity1.EXTRA_USERNAME;

public class Fragment2Activity1 extends Fragment {
    private String TAG = this.getClass().getSimpleName();
    public Fragment2Activity1() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_activity1, container, false);
       Log.i(TAG,"AiciAmintrat");


       Intent intent=getActivity().getIntent();
       String name=intent.getStringExtra(EXTRA_NAME);
       String username=intent.getStringExtra(EXTRA_USERNAME);
       String email=intent.getStringExtra(EXTRA_EMAIL);
        TextView nameView=view.findViewById(R.id.F2A1_name);
        TextView usernameView=view.findViewById(R.id.F2A1_username);
        TextView emailView=view.findViewById(R.id.F2A1_email);

        nameView.setText("Name :"+name);
        usernameView.setText("Username: "+username);
        usernameView.setText("Email "+email);


       /*
       Bundle bundle=getArguments();
       if(bundle!=null){
           String name=bundle.getString("name");
           String username=bundle.getString("username");
           String email=bundle.getString("email");

           TextView nameView=view.findViewById(R.id.F2A1_name);
           TextView usernameView=view.findViewById(R.id.F2A1_username);
           TextView emailView=view.findViewById(R.id.F2A1_email);

           nameView.setText("Name :"+name);
           usernameView.setText("Username: "+username);
           usernameView.setText("Email "+email);
       }
*/
        return view;
    }
}

