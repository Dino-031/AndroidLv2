package com.example.dino.lv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class activity_UnitsConvert extends AppCompatActivity {

    @BindView(R.id.rl_UnitsRootLayout)
    RelativeLayout rlUnitsRootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__units_convert);
        ButterKnife.bind(this);
        rlUnitsRootLayout.setOnTouchListener(new SwipeToMainActivity(this)
        {
            @Override
            public void onSwipe()
            {
                finish();
            }
        });
    }
}
