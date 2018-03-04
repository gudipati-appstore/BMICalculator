package com.gcoders.health.bmi_calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText weight, height;
    private Button calc;
    private TextView result, resulttext;
    private float bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = (EditText) findViewById(R.id.weight);
        height = (EditText) findViewById(R.id.height);
        resulttext = (TextView) findViewById(R.id.result);
        calc = findViewById(R.id.calculate_bmi_btn);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }


    public void calculateBMI() {
        String weightStr = weight.getText().toString();
        String heightStr = height.getText().toString();

        if (!"".equals(heightStr) && !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);
            resulttext.setVisibility(View.VISIBLE);
            resulttext.setText("Calcualted BMI Level : " + bmi);
        }
    }

}




