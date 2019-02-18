package com.example.android.testing.espresso.BasicSample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class AlignActivity extends Activity implements View.OnClickListener {

    Button btnLeft, btnCenter, btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_align);

        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnCenter = (Button)findViewById(R.id.btnCenter);
        btnRight = (Button)findViewById(R.id.btnRight);

        btnLeft.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch (v.getId()){
            case R.id.btnLeft:
                intent.putExtra("align", Gravity.LEFT);
                break;
            case R.id.btnCenter:
                intent.putExtra("align",Gravity.CENTER);
                break;
            case R.id.btnRight:
                intent.putExtra("align",Gravity.RIGHT);
                break;
        }
        setResult(RESULT_OK,intent);
        finish();
    }
}
