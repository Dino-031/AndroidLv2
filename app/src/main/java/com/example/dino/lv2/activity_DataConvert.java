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

public class activity_DataConvert extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.rl_DataRootLayout)
    RelativeLayout rlDataRootLayout;

    @BindView(R.id.btn_CalculateData)
    Button btnCalculateData;

    @BindView(R.id.et_DataValue)
    EditText etDataValue;

    @BindView(R.id.spinner_DataFrom)
    Spinner spinnerDataFrom;

    @BindView(R.id.spinner_DataTo)
    Spinner spinnerDataTo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__data_convert);
        ButterKnife.bind(this);
        rlDataRootLayout.setOnTouchListener(new SwipeToMainActivity(this)
        {
            @Override
            public void onSwipe()
            {
                finish();
            }
        });
        SpinnersInit();
        btnCalculateData.setOnClickListener(this);
    }

    private void SpinnersInit()
    {
        List<String> list = new ArrayList<String>();
        list.add("GB");
        list.add("MB");
        list.add("KB");
        list.add("B");
        list.add("b");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        spinnerDataFrom.setAdapter(dataAdapter);
        spinnerDataTo.setAdapter(dataAdapter);
    }

    @Override
    public void onClick(View view) {
        String ConvertFrom = spinnerDataFrom.getSelectedItem().toString();
        String ConvertTo = spinnerDataTo.getSelectedItem().toString();
        Double result = Calculate(ConvertFrom,ConvertTo);
        Intent intent = new Intent(this,activity_Results.class);
        intent.putExtra(activity_Results.KEY_VALUE_FROM,etDataValue.getText().toString());
        intent.putExtra(activity_Results.MESSAGE_CONVERT_FROM,ConvertFrom);
        intent.putExtra(activity_Results.KEY_VALUE_RESULT,String.valueOf(result));
        intent.putExtra(activity_Results.MESSAGE_CONVERT_TO,ConvertTo);
        startActivity(intent);
    }

    private Double Calculate(String From,String To)
    {
        Double result = null;
        switch (From)
        {
            case "GB":
                if(To == "MB")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) * 1024;
                    break;
                }
                else if(To == "KB")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) *1024*1024;
                    break;
                }
                else if(To == "B")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) *1024*1024*1024;
                    break;
                }
                else if(To == "b")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) *1024*1024*1024*8;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etDataValue.getText().toString());
                    break;
                }
            case "MB":
                if(To == "GB")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) /1024;
                    break;
                }
                else if(To == "KB")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) *1024;
                    break;
                }
                else if(To == "B")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) *1024*1024;
                    break;
                }
                else if(To == "b")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) *1024*1024*8;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etDataValue.getText().toString());
                    break;
                }
            case "KB":
                if(To == "GB")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) /1024/1024;
                    break;
                }
                else if(To == "MB")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) /1024;
                    break;
                }
                else if(To == "B")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) *1024;
                    break;
                }
                else if(To == "b")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) *1024*8;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etDataValue.getText().toString());
                    break;
                }
            case "B":
                if(To == "GB")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) /1024/1024/1024;
                    break;
                }
                else if(To == "MB")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) /1024/1024;
                    break;
                }
                else if(To == "KB")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) /1024;
                    break;
                }
                else if(To == "b")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) *8;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etDataValue.getText().toString());
                    break;
                }
            case "b":
                if(To == "GB")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) /8/1024/1024/1024;
                    break;
                }
                else if(To == "MB")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) /8/1024/1024;
                    break;
                }
                else if(To == "KB")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) /8/1024;
                    break;
                }
                else if(To == "B")
                {
                    result = Double.parseDouble(etDataValue.getText().toString()) /8;
                    break;
                }
                else
                {
                    result = Double.parseDouble(etDataValue.getText().toString());
                    break;
                }
        }
        return  result;
    }
}
