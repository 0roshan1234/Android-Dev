package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BacchiResult extends AppCompatActivity {
TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        res=findViewById(R.id.result);
        Intent it1=getIntent();
        String namee=it1.getStringExtra("NAME");
        String locsss=it1.getStringExtra("LOCATION");
        String coursess=it1.getStringExtra("COURSES");
        String dates=it1.getStringExtra("DATE");

        res.setText("Name"+namee+"\n place"+locsss+"\n Courses selected"+coursess+"\n Date"+dates);


        super.onCreate(savedInstanceState);





        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bacchi_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }
}