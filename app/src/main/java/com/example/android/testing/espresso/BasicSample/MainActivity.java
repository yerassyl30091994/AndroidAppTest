
package com.example.android.testing.espresso.BasicSample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnColor, btnAlign;
    ImageButton Facebook, Vk, Instagram, Telegram;
    TextView textView;
    final int REQUEST_CODE_COLOR = 1;
    final int REQUEST_CODE_ALIGN = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        textView.setGravity(Gravity.CENTER);

        btnColor = (Button) findViewById(R.id.btnColor);
        btnAlign = (Button)findViewById(R.id.btnAlign);

        Facebook = (ImageButton)findViewById(R.id.Facebook);
        Vk = (ImageButton)findViewById(R.id.Vk);
        Instagram = (ImageButton)findViewById(R.id.Instagram);
        Telegram = (ImageButton)findViewById(R.id.Telegram);

        btnColor.setOnClickListener(this);
        btnAlign.setOnClickListener(this);

        Facebook.setOnClickListener(this);
        Vk.setOnClickListener(this);
        Instagram.setOnClickListener(this);
        Telegram.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnColor:
             intent = new Intent(this,ColorActivity.class);
             startActivityForResult(intent,REQUEST_CODE_COLOR);
                break;
            case R.id.btnAlign:
                intent = new Intent(this,AlignActivity.class);
                startActivityForResult(intent,REQUEST_CODE_ALIGN);
                break;
            case R.id.Facebook:
                intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com"));
                startActivity(intent);
                break;
            case R.id.Vk:
                intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://vk.com"));
                startActivity(intent);
                break;
            case R.id.Instagram:
                intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com"));
                startActivity(intent);
                break;
            case R.id.Telegram:
                intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://web.telegram.org/#/login"));
                startActivity(intent);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK){
            switch (requestCode){
                case REQUEST_CODE_COLOR:
                    int color = data.getIntExtra("color",Color.BLACK);
                    textView.setTextColor(color);
                    break;
                case REQUEST_CODE_ALIGN:
                    int align = data.getIntExtra("align",Gravity.CENTER);
                    textView.setGravity(align);
                    break;
            }
        }else{
            Toast.makeText(this,"Wrong result",Toast.LENGTH_SHORT).show();
        }
    }
}
