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

public class activity_DistanceConvert extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.rl_DistanceRootLayout)
    RelativeLayout rlDistanceRootLayout;

    @BindView(R.id.btn_CalculateDistance)
    Button btnCalculateDistance;

    @BindView(R.id.et_DistanceValue)
    EditText etDistanceValue;

    @BindView(R.id.spinner_DistanceFrom)
    Spinner spinnerDistanceFrom;

    @BindView(R.id.spinner_DistanceTo)
    Spinner spinnerDistanceTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__distance_convert);
        ButterKnife.bind(this);
        rlDistanceRootLayout.setOnTouchListener(new SwipeToMainActivity(this)
        {
            @Override
            public void onSwipe()
            {
                finish();
            }
        });

        btnCalculateDistance.setOnClickListener(this);
        SpinnersInit();
    }

    private void SpinnersInit()
    {
        List<String> list = new ArrayList<String>();
        list.add("Meter");
        list.add("Kilometer");
        list.add("Milimeter");
        list.add("Mile");
        list.add("Yard");
        list.add("Foot");
        list.add("Inch");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        spinnerDistanceFrom.setAdapter(dataAdapter);
        spinnerDistanceTo.setAdapter(dataAdapter);
    }

    @Override
    public void onClick(View view) {
        String ConvertFrom = spinnerDistanceFrom.getSelectedItem().toString();
        String ConvertTo = spinnerDistanceTo.getSelectedItem().toString();
        Double result = Calculate(ConvertFrom,ConvertTo);
        Intent intent = new Intent(this,activity_Results.class);
        intent.putExtra(activity_Results.KEY_VALUE_FROM,etDistanceValue.getText().toString());
        intent.putExtra(activity_Results.MESSAGE_CONVERT_FROM,ConvertFrom);
        intent.putExtra(activity_Results.KEY_VALUE_RESULT,String.valueOf(result));
        intent.putExtra(activity_Results.MESSAGE_CONVERT_TO,ConvertTo);
        startActivity(intent);
    }
    
    private Double Calculate(String From,String To) {
        Double result = null;
        switch (From) {
            case "Meter":
                if (To == "Kilometer") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) / 1000;
                    break;
                } else if (To == "Milimeter") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 1000;
                    break;
                } else if (To == "Mile") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 0.000621371;
                    break;
                } else if (To == "Yard") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 1.09361296;
                    break;
                } else if (To == "Foot") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 3.28084;
                    break;
                }
                else if (To == "Inch")
                {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 39.3701;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etDistanceValue.getText().toString());
                    break;
                }
            case "Kilometer":
                if (To == "Meter") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 1000;
                    break;
                } else if (To == "Milimeter") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 1000000;
                    break;
                } else if (To == "Mile") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 0.621371;
                    break;
                } else if (To == "Yard") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 1093.61;
                    break;
                } else if (To == "Foot") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 3280.84;
                    break;
                }
                else if (To == "Inch")
                {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 39370.1;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etDistanceValue.getText().toString());
                    break;
                }
            case "Milimeter":
                if (To == "Kilometer") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) / 1000000;
                    break;
                } else if (To == "Meter") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 1000;
                    break;
                } else if (To == "Mile") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 6.2137e-7;
                    break;
                } else if (To == "Yard") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 0.00109361;
                    break;
                } else if (To == "Foot") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 0.00328084;
                    break;
                }
                else if (To == "Inch")
                {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 0.0393701;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etDistanceValue.getText().toString());
                    break;
                }
            case "Mile":
                if (To == "Kilometer") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 1.60934;
                    break;
                } else if (To == "Meter") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 1609.34;
                    break;
                } else if (To == "Milimeter") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 1.609e+6;
                    break;
                } else if (To == "Yard") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 1760;
                    break;
                } else if (To == "Foot") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 5280;
                    break;
                }
                else if (To == "Inch")
                {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 63360;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etDistanceValue.getText().toString());
                    break;
                }
            case "Yard":
                if (To == "Kilometer") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 0.0009144;
                    break;
                } else if (To == "Meter") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 0.9144;
                    break;
                } else if (To == "Milimeter") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 914.4;
                    break;
                } else if (To == "Mile") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 0.000568182;
                    break;
                } else if (To == "Foot") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 3;
                    break;
                }
                else if (To == "Inch")
                {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 36;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etDistanceValue.getText().toString());
                    break;
                }
            case "Foot":
                if (To == "Kilometer") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 0.0003048;
                    break;
                } else if (To == "Meter") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 0.3048;
                    break;
                } else if (To == "Milimeter") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 304.8;
                    break;
                } else if (To == "Mile") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 0.000189394;
                    break;
                } else if (To == "Yard") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 0.333333;
                    break;
                }
                else if (To == "Inch")
                {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 12;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etDistanceValue.getText().toString());
                    break;
                }
            case "Inch":
                if (To == "Kilometer") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 2.54e-5;
                    break;
                } else if (To == "Meter") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 0.0254;
                    break;
                } else if (To == "Milimeter") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 25.4;
                    break;
                } else if (To == "Mile") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 1.5783e-5;
                    break;
                } else if (To == "Yard") {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 0.0277778;
                    break;
                }
                else if (To == "Foot")
                {
                    result = Double.parseDouble(etDistanceValue.getText().toString()) * 0.0833333;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etDistanceValue.getText().toString());
                    break;
                }
        }
        return result;
    }
}
