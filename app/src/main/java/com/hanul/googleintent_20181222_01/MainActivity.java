package com.hanul.googleintent_20181222_01;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends BaseActivity {

    EditText phoneNumEdt;
    Button dialBtn;
    Button callBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                폰번 에딧텍스트의 입력값을 받고
                String inputPhoneNum = phoneNumEdt.getText().toString();
//                그 입력값을 전화를 거는데 사용

                Uri uri = Uri.parse(String.format("tel:%s", inputPhoneNum));
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                 startActivity(intent);

            }
});

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                사용자가 입력한 폰번을 받아서 저장
                String inputPhoneNum = phoneNumEdt.getText().toString();

                Uri uri = Uri.parse(String.format("tel:%s", inputPhoneNum));
                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        phoneNumEdt = findViewById(R.id.phoneNumEdt);
        dialBtn = findViewById(R.id.dialBtn);
        callBtn = findViewById(R.id.callBtn);

    }
}
