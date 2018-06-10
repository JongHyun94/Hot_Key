package com.example.android.hotkey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button strbtn;
    Button setbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strbtn = findViewById(R.id.startBtn);
        setbtn = findViewById(R.id.settingBtn);

        strbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //(새로운)NewActivity클래스를 intent로 지목
                Intent intent1 = new Intent (getApplicationContext(),ListMenu.class);

                startActivity(intent1);//Activity 실행
            }
        });
        setbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //(새로운)NewActivity클래스를 intent로 지목
                Intent intent2 = new Intent (getApplicationContext(),SettingMenu.class);

                startActivity(intent2);//Activity 실행

            }
        });

    }
}
