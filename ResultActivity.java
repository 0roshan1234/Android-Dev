package com.example.cakeordering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        res=findViewById(R.id.Result);
        Intent it=getIntent();
        String cakeflav=it.getStringExtra("ITEM");
        String dated=it.getStringExtra("DATE");
        String timer=it.getStringExtra("TIME");
        res.setText("Your Order placed Successfully "+"\n your"+cakeflav+"cake will delivered on "+dated+"nat"+timer);
    }
}