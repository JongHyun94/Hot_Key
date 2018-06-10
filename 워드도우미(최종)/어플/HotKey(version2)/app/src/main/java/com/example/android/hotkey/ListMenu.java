package com.example.android.hotkey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ListMenu extends Activity {
    ImageButton wordBtn;
    ImageButton TouchBtn;
    ImageButton tenBtn;
    String ipStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        wordBtn = findViewById(R.id.btnWord);
        TouchBtn = findViewById(R.id.btnTouchPad);
        tenBtn = findViewById(R.id.btnTenkey);

        ipStr = getIntent().getStringExtra("ip");

        wordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent (getApplicationContext(),WordActivity.class);
                intent1.putExtra("ip",ipStr);

                startActivity(intent1);
            }
        });
        TouchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent (getApplicationContext(),TouchpadActivity.class);
                intent2.putExtra("ip",ipStr);

                startActivity(intent2);
            }
        });
        tenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3 = new Intent (getApplicationContext(),TenKey.class);
                intent3.putExtra("ip",ipStr);

                startActivity(intent3);
            }
        });



    }

}