package com.example.dino.lv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class activity_TemperatureConvert extends AppCompatActivity implements View.OnClickListener  {

    @BindView(R.id.rl_TemperatureRootLayout)
    RelativeLayout rlTemperatureRootLayout;

    @BindView(R.id.spinner_TemperatureFrom)
    Spinner spinnerTemperatureFrom;

    @BindView(R.id.spinner_TemperatureTo)
    Spinner spinnerTemperatureTo;

    @BindView(R.id.btn_Calculate)
    Button btnCalculate;

    @BindView(R.id.et_temperatureValue)
    EditText etTemperatureValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__temperature_convert);
        ButterKnife.bind(this);
        rlTemperatureRootLayout.setOnTouchListener(new SwipeToMainActivity(this)
        {
            @Override
            public void onSwipe()
            {
                finish();
            }
        });
        SpinnersInit();
        btnCalculate.setOnClickListener(this);
    }

    private void SpinnersInit()
    {
        List<String> list = new ArrayList<String>();
        list.add("Celsius");
        list.add("Fahrenheit");
        list.add("Kelvin");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        spinnerTemperatureFrom.setAdapter(dataAdapter);
        spinnerTemperatureTo.setAdapter(dataAdapter);
    }

    @Override
    public void onClick(View view) {
        String ConvertFrom = String.valueOf(spinnerTemperatureFrom.getSelectedItem());
        String ConvertTo =  String.valueOf(spinnerTemperatureTo.getSelectedItem());
        Float value = Calculate(ConvertFrom,ConvertTo);
        if(value != null)
        {
            Intent dataSender = new Intent(this,activity_Results.class);
            dataSender.putExtra(activity_Results.KEY_VALUE_RESULT,value);
            dataSender.putExtra(activity_Results.MESSAGE_CONVERT_FROM,ConvertFrom);
            dataSender.putExtra(activity_Results.MESSAGE_CONVERT_TO,ConvertTo);
            dataSender.putExtra(activity_Results.KEY_VALUE_FROM,15);
            startActivity(dataSender);
        }

    }
    private float Calculate(String From, String To)
    {
        Float result = null;
        switch (From)
        {
            case "Celsius":
                if(To == "Fahrenheit")
                {
                    result = Float.parseFloat(etTemperatureValue.getText().toString()) *(9/5)+ 32;
                    break;
                }

                else if(To == "Kelvin")
                {
                    result = Float.parseFloat(etTemperatureValue.getText().toString()) + 275.15f;
                    break;
                }
            case "Fahrenheit":
                if(To == "Celsius")
                {
                    result = (Float.parseFloat(etTemperatureValue.getText().toString()) - 32) * (5/9);
                    break;
                }
                else if(To == "Kelvin")
                {
                    result = (Float.parseFloat(etTemperatureValue.getText().toString()) - 32) * (5/9) + 273.15f;
                    break;
                }
            case "Kelvin":
                if(To == "Celsius")
                {
                    result = Float.parseFloat(etTemperatureValue.getText().toString()) - 273.15f;
                    break;
                }
                else if(To == "Fahrenheit")
                {
                    result = (9/5) * (Float.parseFloat(etTemperatureValue.getText().toString()) - 273.15f) + 32;
                    break;
                }
        }
        return result;
    }
}
