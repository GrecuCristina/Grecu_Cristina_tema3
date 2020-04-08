package com.example.tema3;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

/*
public class Fragment1Activity3 extends Fragment implements TimePickerDialog.OnTimeSetListener {


    public Fragment1Activity3()
    {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment1_activity3, container, false);

        Button btn1=(Button)view.findViewById(R.id.btn1F1A3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Activity3","AiciBeforePicker");
                DialogFragment timePicker=new PickerFragment();
                Log.i("Activity3","AiciAfterPicker");
                timePicker.show(getFragmentManager(),"time picker");
                Log.i("Activity3","AiciAfterPicker2");
            }
        });


        return view;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView txt1=(TextView)view.findViewById(R.id.textView1);
        Log.i("Activity3","AiciMy");
        txt1.setText("The hour is "+hourOfDay+" and minute: "+minute);

    }
}

 */
public class Fragment1Activity3 extends Fragment {

    Calendar c;
    public Fragment1Activity3()
    {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment1_activity3, container, false);

        final TextView txt1=(TextView)view.findViewById(R.id.txt1);
        final TextView txt2=(TextView)view.findViewById(R.id.txt2);

        Button btn2=(Button)view.findViewById(R.id.btn2F1A3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Activity3","AiciBeforePicker");

                int hour,minute;
                String format;
                 c=Calendar.getInstance();
                 Calendar c=Calendar.getInstance();
                 hour=c.get(Calendar.HOUR_OF_DAY);
                 minute=c.get(Calendar.MINUTE);
                Log.i("Activity3","AiciMy1");
                 TimePickerDialog timePickerDialog=new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String hourSelected=""+hourOfDay;
                        int minuteSelected=minute;
                        Log.i("Activity3","AiciMy");
                        txt2.setText("The hour is "+hourSelected+" and  "+minuteSelected+" minutes");
                        Log.i("Activity3","Aici "+hourSelected);
                        //Toast.makeText(getContext(),hourSelected,Toast.LENGTH_SHORT).show();

                    }
                },hour,minute,true);
                timePickerDialog.show();

            }
        });
        Button btn1=(Button)view.findViewById(R.id.btn1F1A3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=Calendar.getInstance();
                Calendar c=Calendar.getInstance();
                int day=c.get(Calendar.DAY_OF_MONTH);
                int month=c.get(Calendar.MONTH);
                int year=c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String yearSelected=year+"";
                        String monthSelected=month+"";
                        String daySelected=dayOfMonth+"";


                        txt1.setText("dd: "+daySelected+" mm: "+monthSelected+" yyyy: "+yearSelected);
                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });

        return view;
    }


}