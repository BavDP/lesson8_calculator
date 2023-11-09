package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private StringBuilder text = new StringBuilder("0");
    private double operand1;
    private double prevValue = 0;
    private String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void numberClick(View view) {
        int id = view.getId();
        String name = getResources().getResourceEntryName(id);
        String val = name.split("btn_")[1];
        text.append(val);
        TextView text = findViewById(R.id.display);
        text.setText(this.text.toString());
    }
}