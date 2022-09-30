package com.ethic.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Bundle bundle = this.getIntent().getExtras();
        TextView mAScoreText = null, mBScoreText = null; //显示两队分数
//        TextView AName = null, BName = null; // 显示两队队名
        String a = bundle.getString("A");
        String b = bundle.getString("B");
        String aName = bundle.getString("AName");
        String bName = bundle.getString("BName");
        mAScoreText = (TextView) findViewById(R.id.aScoreText);
        mBScoreText = (TextView) findViewById(R.id.bScoreText);
//        AName = (TextView) findViewById(R.id.aName);
//        BName = (TextView) findViewById(R.id.bName);
        mAScoreText.setText(a);
        mBScoreText.setText(b);
//        AName.setText(aName);
//        BName.setText(bName);
    }
}