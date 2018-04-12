package com.example.dino.lv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class activity_Results extends AppCompatActivity {
    public static final String KEY_VALUE_RESULT = "ResultValue";
    public static final String KEY_VALUE_FROM = "InputValue";
    public static final String MESSAGE_CONVERT_FROM = "ConvertFrom";
    public static final String MESSAGE_CONVERT_TO = "ConvertTo";

    public static final String[] ResultsArray = new String[4];

    @BindView(R.id.tv_ValueFrom)
    TextView tvValueFrom;

    @BindView(R.id.tv_UnitFrom)
    TextView tvUnitFrom;

    @BindView(R.id.tv_ValueTo)
    TextView tvValueTo;

    @BindView(R.id.tv_UnitTo)
    TextView tvUnitTo;

    @BindView(R.id.rl_ResultsRootLayout)
    RelativeLayout rlResultsRootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__results);
        ButterKnife.bind(this);
        SetViews();
        rlResultsRootLayout.setOnTouchListener(new SwipeToMainActivity(this)
        {
            @Override
            public void onSwipe()
            {
                finish();
            }
        });
    }


    private void SetViews()
    {
        Intent intent = getIntent();
        if(intent != null)
        {
            tvValueFrom.setText(intent.getStringExtra(KEY_VALUE_FROM));
            tvUnitFrom.setText(intent.getStringExtra(MESSAGE_CONVERT_FROM));
            tvValueTo.setText(intent.getStringExtra(KEY_VALUE_RESULT));
            tvUnitTo.setText(intent.getStringExtra(MESSAGE_CONVERT_TO));
        }
    }
}
