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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class activity_SpeedConvert extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.rl_SpeedRootLayout)
    RelativeLayout rlSpeedRootLayout;

    @BindView(R.id.btn_CalculateSpeed)
    Button btnCalculateSpeed;

    @BindView(R.id.et_SpeedValue)
    EditText etSpeedValue;

    @BindView(R.id.spinner_SpeedFrom)
    Spinner spinnerSpeedFrom;

    @BindView(R.id.spinner_SpeedTo)
    Spinner spinnerSpeedTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__speed_convert);
        ButterKnife.bind(this);
        rlSpeedRootLayout.setOnTouchListener(new SwipeToMainActivity(this)
        {
            @Override
            public void onSwipe()
            {
                finish();
            }
        });
        SpinnersInit();
        btnCalculateSpeed.setOnClickListener(this);
    }
    private void SpinnersInit()
    {
        List<String> list = new ArrayList<String>();
        list.add("Km/h");
        list.add("M/s");
        list.add("Mph");
        list.add("Ft/s");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        spinnerSpeedFrom.setAdapter(dataAdapter);
        spinnerSpeedTo.setAdapter(dataAdapter);
    }

    @Override
    public void onClick(View view) {
        String ConvertFrom = String.valueOf(spinnerSpeedFrom.getSelectedItem());
        String ConvertTo =  String.valueOf(spinnerSpeedTo.getSelectedItem());
        Double result = Calculate(ConvertFrom,ConvertTo);
        Intent intent = new Intent(this,activity_Results.class);
        intent.putExtra(activity_Results.KEY_VALUE_FROM,etSpeedValue.getText().toString());
        intent.putExtra(activity_Results.MESSAGE_CONVERT_FROM,ConvertFrom);
        intent.putExtra(activity_Results.KEY_VALUE_RESULT,String.valueOf(result));
        intent.putExtra(activity_Results.MESSAGE_CONVERT_TO,ConvertTo);
        startActivity(intent);

    }

    private double Calculate(String From, String To)
    {
        Double result = null;
        switch (From)
        {
            case "Km/h":
                if(To == "M/s")
                {
                    result = Double.parseDouble(etSpeedValue.getText().toString()) * 0.277778;
                    break;
                }
                else if(To == "Mph")
                {
                    result = Double.parseDouble(etSpeedValue.getText().toString()) * 0.621371;
                    break;
                }
                else if(To == "Ft/s")
                {
                    result =  Double.parseDouble(etSpeedValue.getText().toString()) * 0.911344;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etSpeedValue.getText().toString());
                    break;
                }
            case "M/s":
                if(To == "Km/h")
                {
                    result = Double.parseDouble(etSpeedValue.getText().toString()) * 3.6;
                    break;
                }
                else if(To == "Mph")
                {
                    result = Double.parseDouble(etSpeedValue.getText().toString()) * 2.236936;
                    break;
                }
                else if(To == "Ft/s")
                {
                    result = Double.parseDouble(etSpeedValue.getText().toString()) *3.280840;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etSpeedValue.getText().toString());;
                    break;
                }
            case "Ft/s":
            {
                if(To == "Km/h")
                {
                    result = Double.parseDouble(etSpeedValue.getText().toString()) * 1.09728;
                    break;
                }
                else if (To == "M/s")
                {
                    result =Double.parseDouble(etSpeedValue.getText().toString()) *0.3048;
                    break;
                }
                else if(To == "Mph")
                {
                    result = Double.parseDouble(etSpeedValue.getText().toString()) * 0.681818;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etSpeedValue.getText().toString());
                    break;
                }
            }
            case "Mph":
            {
                if(To == "Km/h")
                {
                    result = Double.parseDouble(etSpeedValue.getText().toString()) * 1.609344;
                    break;
                }
                else if(To == "M/s")
                {
                    result = Double.parseDouble(etSpeedValue.getText().toString()) * 0.44704;
                    break;
                }
                else if(To == "Ft/s")
                {
                    result = Double.parseDouble(etSpeedValue.getText().toString()) * 1.466667;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etSpeedValue.getText().toString());
                    break;
                }
            }
        }
        return result;
    }
}
