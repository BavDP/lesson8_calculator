package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private StringBuilder displayText = new StringBuilder("0");
    private double operand1;
    private double operand2;
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
        if (!oper.isEmpty() || operand1 == 0 && operand2 == 0) {
            clearTextView();
        }
        if (displayText.toString().equals("0")){
            displayText.delete(0, 1000);
        }
        displayText.append(val);
        getTextView().setText(displayText.toString());
    }

    public void operationClick(View view) {
        int id = view.getId();
        calc();
        oper = getResources().getResourceEntryName(id);
        operand1 = Double.parseDouble(this.displayText.toString());
    }

    public void clearClick(View view) {
        clearTextView();
        init();
    }

    public void calcClick(View view) {
        calc();
        init();
    }

    private String getTextViewValue() {
        return getTextView().getText().toString();
    }

    private TextView getTextView() {
        return findViewById(R.id.display);
    }

    private void clearTextView() {
        displayText.delete(0, 1000).append("0");
        getTextView().setText("0");
    }

    private void calc() {
        if (!oper.isEmpty()) {
            double res = 0;
            operand2 = Double.parseDouble(getTextViewValue());
            switch (oper) {
                case "plus":
                    res = operand1 + operand2;
                    break;
                case "sub":
                    res = operand1 - operand2;
                    break;
                case "mul":
                    res = operand1 * operand2;
                    break;
                case "div":
                    res = operand1 / operand2;
                    break;
            }
            oper = "";
            getTextView().setText("" + res);
            displayText = new StringBuilder("" + res);
            init();
        }
    }

    private void init() {
        operand1 = 0;
        operand2 = 0;
        oper = "";
    }
}