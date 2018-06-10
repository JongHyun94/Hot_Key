package com.example.android.hotkey;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class WordActivity extends Activity {

    final int PORT = 10000;

    final String MESSAGE_wordCopy = "MESSAGE:wordCopy";
    final String MESSAGE_wordPaste = "MESSAGE:wordPaste";
    final String MESSAGE_wordCreate = "MESSAGE:wordCreate";
    final String MESSAGE_wordSaveAname = "MESSAGE:wordSaveAname";
    final String MESSAGE_wordPrint = "MESSAGE:wordPrint";
    final String MESSAGE_wordPrintlook = "MESSAGE:wordPrintlook";
    final String MESSAGE_wordCut = "MESSAGE:wordCut";
    final String MESSAGE_wordBlockSet = "MESSAGE:wordBlockSet";
    final String MESSAGE_wordFormCopy = "MESSAGE:wordFormCopy";
    final String MESSAGE_wordFormPaste = "MESSAGE:wordFormPaste";
    final String MESSAGE_wordtoTheMemo = "MESSAGE:wordtoTheMemo";
    final String MESSAGE_wordBookIn = "MESSAGE:wordBookIn";
    final String MESSAGE_wordMijoo = "MESSAGE:wordMijoo";
    final String MESSAGE_wordGakjoo = "MESSAGE:wordGakjoo";
    final String MESSAGE_wordDandiverse = "MESSAGE:wordDandiverse";
    final String MESSAGE_wordTimeField = "MESSAGE:wordTimeField";
    final String MESSAGE_wordPageField = "MESSAGE:wordPageField";
    final String MESSAGE_wordMotionChange = "MESSAGE:wordMotionChange";
    final String MESSAGE_wordMotionSizeChange = "MESSAGE:wordMotionSizeChange";
    final String MESSAGE_wordStyleChange = "MESSAGE:wordStyleChange";
    final String MESSAGE_wordleftCenter = "MESSAGE:wordleftCenter";
    final String MESSAGE_wordrightCenter = "MESSAGE:wordrightCenter";
    final String MESSAGE_wordCenter = "MESSAGE:wordCenter";
    final String MESSAGE_wordCapWord = "MESSAGE:wordCapWord";
    final String MESSAGE_wordCheck = "MESSAGE:wordCheck";
    final String MESSAGE_wordWindowDiv = "MESSAGE:wordWindowDiv";
    final String MESSAGE_wordTotalWindow = "MESSAGE:wordTotalWindow";
    final String MESSAGE_wordClose = "MESSAGE:wordClose";
    final String MESSAGE_wordBold = "MESSAGE:wordBold";
    final String MESSAGE_wordTotalSelect = "MESSAGE:wordTotalSelect";

    String msg1, msg2, msg3, msg4;
    String message1, message2, message3, message4;

    private InetAddress iNet = null;
    private DatagramSocket socket = null;


    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    String ipStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_activity);

        Button btnA = findViewById(R.id.iv1);
        Button btnB = findViewById(R.id.iv2);
        Button btnC = findViewById(R.id.iv3);
        Button btnD = findViewById(R.id.iv4);
        ImageButton setBtn = findViewById(R.id.img1);

        ipStr = getIntent().getStringExtra("ip");
        try {
            iNet = InetAddress.getByName(ipStr);
            socket = new DatagramSocket();

        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }catch (SocketException e) {
            e.printStackTrace();
        }
        applySharedPreference();

        btnA.setText(message1);
        btnB.setText(message2);
        btnC.setText(message3);
        btnD.setText(message4);


        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(msg1);
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(msg2);
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(msg3);
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(msg4);
            }
        });

        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent (getApplicationContext(),SettingWord.class);
                intent1.putExtra("ip", ipStr);
                startActivity(intent1);
                finish();
            }
        });



    }

    private void sendMessageUDP(final String message) {

        new Thread(new Runnable() {
            public void run() {
                try {
                    DatagramPacket packet = new DatagramPacket(message.getBytes(),message.getBytes().length, iNet, PORT);
                    socket.send(packet);

                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        socket.close();
    }
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Intent intent = new Intent(getApplicationContext(), WordActivity.class);
        //startActivity(intent);
    }
    */

    public void applySharedPreference(){
        sh_Pref = getSharedPreferences("Login IP", MODE_PRIVATE);
        if (sh_Pref!=null && sh_Pref.contains("Btn1")){
            msg1 = sh_Pref.getString("Btn1", "MESSAGE:wordCopy");
        }
        if (sh_Pref!=null && sh_Pref.contains("Btn2")){
            msg2 = sh_Pref.getString("Btn2", "MESSAGE:wordPaste");
        }
        if (sh_Pref!=null && sh_Pref.contains("Btn3")){
            msg3 = sh_Pref.getString("Btn3", "MESSAGE:wordCut");
        }
        if (sh_Pref!=null && sh_Pref.contains("Btn4")){
            msg4 = sh_Pref.getString("Btn4", "MESSAGE:wordCreate");
        }
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