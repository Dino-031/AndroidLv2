package com.example.dino.lv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.iv_Temperature)
    ImageView ivTemperature;

    @BindView(R.id.iv_Distance)
    ImageView ivDistance;

    @BindView(R.id.iv_Speed)
    ImageView ivSpeed;

    @BindView(R.id.iv_Units)
    ImageView ivUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ivTemperature.setOnClickListener(this);
        ivDistance.setOnClickListener(this);
        ivSpeed.setOnClickListener(this);
        ivUnits.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,MainActivity.class) ;
        switch (view.getId()) {
            case R.id.iv_Temperature:
                intent.setClass(this, activity_TemperatureConvert.class);
                break;
            case R.id.iv_Distance:
                intent.setClass(this, activity_DistanceConvert.class);
                break;
            case R.id.iv_Speed:
                intent.setClass(this, activity_SpeedConvert.class);
                break;
            case R.id.iv_Units:
                intent.setClass(this, activity_UnitsConvert.class);
                break;
        }
        startActivity(intent);
    }
}
