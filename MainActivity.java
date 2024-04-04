package com.example.cakeordering;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
Spinner spins;
Button btn;


String cakeflavour,date,time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spins=findViewById(R.id.spinners);

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.cake));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spins.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            cakeflavour=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public void selectDate(View v){
        Calendar c=Calendar.getInstance();
        int pyear=c.get(Calendar.YEAR);
        int pmonth=c.get(Calendar.MONTH);
        int pdate=c.get(Calendar.DATE);
        DatePickerDialog dialog=new DatePickerDialog(this, android.R.style.Theme_DeviceDefault_DialogWhenLarge, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            date=dayOfMonth+"/"+(month+1)+"/"+year;
            }
        },pyear,pmonth,pdate);
        dialog.show();
    }
    public void selectTime(View v){
        Calendar c1=Calendar.getInstance();
        int phour=c1.get(Calendar.HOUR);
        int pminute=c1.get(Calendar.MINUTE);
        TimePickerDialog dialog1=new TimePickerDialog(this, android.R.style.Theme_DeviceDefault_DialogWhenLarge, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            time=hourOfDay+":"+minute;
            }
        },phour,pminute,false);
        dialog1.show();
    }
    public void PlaceOrder(View v){
        String elec=cakeflavour.toString();
        Intent in =new Intent(getApplicationContext(),ResultActivity.class);
        in.putExtra("ITEM",elec);
        in.putExtra("DATE",date);
        in.putExtra("TIME",time);
        startActivity(in);
    }
}