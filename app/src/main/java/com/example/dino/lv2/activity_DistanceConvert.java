package com.example.dino.lv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class activity_DistanceConvert extends AppCompatActivity {

    @BindView(R.id.rl_DistanceRootLayout)
    RelativeLayout rlDistanceRootLayout;

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
    }
}
