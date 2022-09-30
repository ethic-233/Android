package com.ethic.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputA;
    private EditText inputB;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        inputA = (EditText) findViewById(R.id.inputA);
        inputB = (EditText) findViewById(R.id.inputB);
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(FirstActivity.this, MainActivity.class);
        Editable textA = inputA.getText();
        Editable textB = inputB.getText();
        Bundle bundle = new Bundle();
        bundle.putString("A", textA.toString());
        bundle.putString("B", textB.toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}