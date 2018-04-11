package com.example.dino.lv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class activity_SpeedConvert extends AppCompatActivity {

    @BindView(R.id.rl_SpeedRootLayout)
    RelativeLayout rlSpeedRootLayout;

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
    }
}
