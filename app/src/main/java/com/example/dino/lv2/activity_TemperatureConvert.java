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

import java.lang.reflect.Array;
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
        Double value = Calculate(ConvertFrom,ConvertTo);
        if(value != null)
        {
            Intent dataSender = new Intent(this,activity_Results.class);
            dataSender.putExtra(activity_Results.MESSAGE_CONVERT_FROM,ConvertFrom);
            dataSender.putExtra(activity_Results.KEY_VALUE_FROM,etTemperatureValue.getText().toString());
            dataSender.putExtra(activity_Results.MESSAGE_CONVERT_TO,ConvertTo);
            dataSender.putExtra(activity_Results.KEY_VALUE_RESULT,String.valueOf(value));
            startActivity(dataSender);
        }

    }
    private double Calculate(String From, String To)
    {
        Double result = null;
        switch (From)
        {
            case "Celsius":
                if(To == "Fahrenheit")
                {
                    result = Double.parseDouble(etTemperatureValue.getText().toString()) *1.8 + 32;
                    break;
                }

                else if(To == "Kelvin")
                {
                    result = Double.parseDouble(etTemperatureValue.getText().toString()) + 273.15;
                    break;
                }
                else
                {
                    result = null;
                }
            case "Fahrenheit":
                if(To == "Celsius")
                {
                    result = (Double.parseDouble(etTemperatureValue.getText().toString()) - 32) * 0.5556;
                    break;
                }
                else if(To == "Kelvin")
                {
                    result = (Double.parseDouble(etTemperatureValue.getText().toString()) +459.67) * 0.5556;
                    break;
                }
                else
                {
                    result = null;
                }
            case "Kelvin":
                if(To == "Celsius")
                {
                    result = Double.parseDouble(etTemperatureValue.getText().toString()) - 273.15;
                    break;
                }
                else if(To == "Fahrenheit")
                {
                    result = Double.parseDouble(etTemperatureValue.getText().toString()) * 1.8 -459.67;
                    break;
                }
                else
                {
                    result = null;
                }
        }
        return result;
    }
}
