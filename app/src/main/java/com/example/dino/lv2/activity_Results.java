package com.example.dino.lv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class activity_Results extends AppCompatActivity {

    public static final String KEY_VALUE_FROM = "";
    public static final String KEY_VALUE_RESULT = "";
    public static final String MESSAGE_CONVERT_FROM = "";
    public static final String MESSAGE_CONVERT_TO = "";

    @BindView(R.id.tv_ResultFrom)
    TextView tvResultFrom;

    @BindView(R.id.tv_ResultTo)
    TextView tvResultTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__results);
        ButterKnife.bind(this);
        Intent startingIntent = getIntent();
        SetViews(startingIntent);
    }

    private void SetViews(Intent intent)
    {
        if(intent != null)
        {
            if(intent.hasExtra(KEY_VALUE_FROM) && intent.hasExtra(KEY_VALUE_RESULT) && intent.hasExtra(MESSAGE_CONVERT_FROM) && intent.hasExtra(MESSAGE_CONVERT_TO))
            {
                tvResultFrom.setText(intent.getStringExtra(MESSAGE_CONVERT_FROM) + " " + intent.getStringExtra(KEY_VALUE_FROM));
                tvResultTo.setText(intent.getStringExtra(MESSAGE_CONVERT_TO) + " " + intent.getStringExtra(KEY_VALUE_RESULT));
            }
        }
    }
}
