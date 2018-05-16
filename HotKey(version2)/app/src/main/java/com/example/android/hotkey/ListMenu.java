package com.example.android.hotkey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class ListMenu extends AppCompatActivity {
    ImageButton wordBtn;
    ImageButton excelBtn;
    ImageButton battleBtn;
    String ipStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        wordBtn = findViewById(R.id.btnWord);
        excelBtn = findViewById(R.id.btnExcel);
        battleBtn = findViewById(R.id.btnBattle);

        ipStr = getIntent().getStringExtra("ip");

        wordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent (getApplicationContext(),Word1.class);
                intent1.putExtra("ip",ipStr);

                startActivity(intent1);
            }
        });
        excelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent (getApplicationContext(),Excel1.class);
                intent2.putExtra("ip",ipStr);

                startActivity(intent2);
            }
        });
        battleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3 = new Intent (getApplicationContext(),Battle1.class);
                intent3.putExtra("ip",ipStr);

                startActivity(intent3);
            }
        });

    }

}