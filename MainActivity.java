package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText aname;
    AutoCompleteTextView place;
    Spinner subjects;
    Button btns;
    RadioGroup rg;
    RadioButton rb;

    ImageView image;

    String course[]={"Python","Cyber Security","Ethical Hacking","Cyber Forencics","bug bounty","Data science"};
    String courses;

    String seldate;
    String locations[]={"Banglore","Darjeeling","vrindavan","madanphille","karnataka"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        aname=findViewById(R.id.namebox);
        place=findViewById(R.id.bus);
        subjects=findViewById(R.id.spinbox);
        rg=findViewById(R.id.gender);
        image=findViewById(R.id.imgbox);
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.select_dialog_item,locations);
        place.setAdapter(adapter);
        place.setThreshold(1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb=findViewById(checkedId);

            }
        });

        ArrayAdapter adapt=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,course);
        subjects.setAdapter(adapt);
        subjects.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                courses=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal=Calendar.getInstance();
                int cyear=cal.get(Calendar.YEAR);
                int cmonth=cal.get(Calendar.MONTH);
                int cdate=cal.get(Calendar.DATE);

                DatePickerDialog dialog=new DatePickerDialog(MainActivity.this, android.R.style.Theme_DeviceDefault_DialogWhenLarge, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        seldate=dayOfMonth+"/"+month+"/"+year;
                    }
                },cyear,cmonth,cdate);
                dialog.show();
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sanju=aname.getText().toString();
                String locs=place.getText().toString();
                Intent it=new Intent(MainActivity.this, BacchiResult.class);

                it.putExtra("NAME",sanju);
                it.putExtra("LOCATION",locs);
                it.putExtra("COURSE",courses);
                it.putExtra("DATE",seldate);
                startActivity(it);

            }
        });
        super.onCreate(savedInstanceState);






        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

    }
}