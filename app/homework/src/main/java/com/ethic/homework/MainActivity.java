package com.ethic.homework;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mAScoreText, mBScoreText; //显示两队分数
    private TextView AName, BName; // 显示两队队名
    private Button mAAddThreeBtn, mAAddTwoBtn, mAAddOneBtn; //A对加分按钮
    private Button mBAddThreeBtn, mBAddTwoBtn, mBAddOneBtn; //B对加分按钮
    private Button mResetBtn;
    private Button mGameOverBtn;
    private int mAScore, mBScore; //记录两队的分数

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Bundle bundle = this.getIntent().getExtras();
        String a = bundle.getString("A");
        String b = bundle.getString("B");
        AName.setText(a);
        BName.setText(b);
    }

    /**
     * 初始化组件
     */
    private void initView() {
        AName = (TextView) findViewById(R.id.aName);
        BName = (TextView) findViewById(R.id.bName);
        mAScoreText = (TextView) findViewById(R.id.aScoreText);
        mBScoreText = (TextView) findViewById(R.id.bScoreText);
        mAAddThreeBtn = (Button) findViewById(R.id.aAddThreeBtn);
        mAAddTwoBtn = (Button) findViewById(R.id.aAddTwoBtn);
        mAAddOneBtn = (Button) findViewById(R.id.aAddOneBtn);
        mBAddThreeBtn = (Button) findViewById(R.id.bAddThreeBtn);
        mBAddTwoBtn = (Button) findViewById(R.id.bAddTwoBtn);
        mBAddOneBtn = (Button) findViewById(R.id.bAddOneBtn);
        mResetBtn = (Button) findViewById(R.id.resetBtn);
        mGameOverBtn = (Button) findViewById(R.id.gameOverBtn);

        mAAddThreeBtn.setOnClickListener(this);
        mAAddTwoBtn.setOnClickListener(this);
        mAAddOneBtn.setOnClickListener(this);
        mBAddThreeBtn.setOnClickListener(this);
        mBAddTwoBtn.setOnClickListener(this);
        mBAddOneBtn.setOnClickListener(this);
        mResetBtn.setOnClickListener(this);
        mGameOverBtn.setOnClickListener(this);
    }

    /**
     * 实现按钮点击回调
     *
     * @param view
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.aAddThreeBtn:
                aAddScore(3);
                break;
            case R.id.aAddTwoBtn:
                aAddScore(2);
                break;
            case R.id.aAddOneBtn:
                aAddScore(1);
                break;
            case R.id.bAddThreeBtn:
                bAddScore(3);
                break;
            case R.id.bAddTwoBtn:
                bAddScore(2);
                break;
            case R.id.bAddOneBtn:
                bAddScore(1);
                break;
            case R.id.resetBtn:
                showResetDialog();
                break;
            case R.id.gameOverBtn:
                gameOver();
                break;
        }
    }

    /**
     * A队加分
     *
     * @param score 要加的分数
     */
    private void aAddScore(int score) {
        mAScore = mAScore + score;
        displayAScore(mAScore);
    }

    /**
     * B队加分
     *
     * @param score 要加的分数
     */
    private void bAddScore(int score) {
        mBScore = mBScore + score;
        displayBScore(mBScore);
    }

    /**
     * 显示清空得分的弹框
     */
    private void showResetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("确认要清空两队的得分吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        resetScore();  //确定清空
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // ignore
                    }
                });
        builder.show();
    }

    /**
     * 重置两队分数
     */
    private void resetScore() {
        mAScore = 0;
        mBScore = 0;
        displayAScore(mAScore);
        displayBScore(mBScore);
    }

    /**
     * 跳转页面
     */
    private void gameOver(){
        Intent intent = new Intent(MainActivity.this, FinalActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("A", String.valueOf(mAScore));
        bundle.putString("B", String.valueOf(mBScore));
        bundle.putString("AName", String.valueOf(AName));
        bundle.putString("BName", String.valueOf(BName));
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 显示A队得分
     *
     * @param score 分数
     */
    private void displayAScore(int score) {
        mAScoreText.setText(String.valueOf(score));
    }

    /**
     * 显示B队得分
     *
     * @param score 分数
     */
    private void displayBScore(int score) {
        mBScoreText.setText(String.valueOf(score));
    }
}