package com.example.android.hotkey;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
    ImageButton strbtn;
    ImageButton setbtn;
    String ipStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strbtn = findViewById(R.id.startBtn);
        setbtn = findViewById(R.id.settingBtn);

        ipStr = getIntent().getStringExtra("ip");

        strbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent (getApplicationContext(),ListMenu.class);
                intent1.putExtra("ip",ipStr);

                startActivity(intent1);
            }
        });
        setbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent (getApplicationContext(),SettingMenu.class);
                intent2.putExtra("ip",ipStr);

                startActivity(intent2);
            }
        });

    }
}
