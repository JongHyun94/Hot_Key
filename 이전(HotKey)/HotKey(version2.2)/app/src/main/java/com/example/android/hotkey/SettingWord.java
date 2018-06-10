package com.example.android.hotkey;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.BaseKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SettingWord extends Activity{
    String message1, message2, message3, message4;
    SharedPreferences sh_Pref;

    String ipStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordsetting_btn);

        Button btnA = findViewById(R.id.iv1);
        Button btnB = findViewById(R.id.iv2);
        Button btnC = findViewById(R.id.iv3);
        Button btnD = findViewById(R.id.iv4);



        ImageButton BackBtn = findViewById(R.id.img1);

        applySharedPreference();

        btnA.setText(message1);
        btnB.setText(message2);
        btnC.setText(message3);
        btnD.setText(message4);
        ipStr = getIntent().getStringExtra("ip");

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent5 = new Intent (getApplicationContext(),WordSetting1.class);
                intent5.putExtra("ip",ipStr);
                startActivity(intent5);
                finish();
                }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent (getApplicationContext(),WordSetting2.class);
                intent6.putExtra("ip",ipStr);
                startActivity(intent6);
                finish();
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent (getApplicationContext(),WordSetting3.class);
                intent7.putExtra("ip",ipStr);
                startActivity(intent7);
                finish();
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8 = new Intent (getApplicationContext(),WordSetting4.class);
                intent8.putExtra("ip",ipStr);
                startActivity(intent8);
                finish();
            }
        });

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"변경 완료!", Toast.LENGTH_SHORT).show();
                Intent intent9 = new Intent(getApplicationContext(),WordActivity.class);
                intent9.putExtra("ip",ipStr);
                startActivity(intent9);
                finish();
            }
        });


    }
    @Override
    protected void onResume(){
        super.onResume();

    }
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Intent intent = new Intent(getApplicationContext(), SettingWord.class);
        //startActivity(intent);
    }
    */

    public void applySharedPreference(){
        sh_Pref = getSharedPreferences("Login IP", MODE_PRIVATE);

        if (sh_Pref!=null && sh_Pref.contains("Btn1_w")) {
            message1 = sh_Pref.getString("Btn1_w", "복사");
        }
        if (sh_Pref!=null && sh_Pref.contains("Btn2_w")) {
            message2 = sh_Pref.getString("Btn2_w", "붙여놓기");
        }
        if (sh_Pref!=null && sh_Pref.contains("Btn3_w")) {
            message3 = sh_Pref.getString("Btn3_w", "자르기");
        }
        if (sh_Pref!=null && sh_Pref.contains("Btn4_w")) {
            message4 = sh_Pref.getString("Btn4_w", "새로만들기");
        }
    }

}
