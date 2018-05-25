package com.example.android.hotkey;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Battle1 extends Activity {

    final int PORT = 10000;
    final String MESSAGE_A = "MESSAGE:A";
    final String MESSAGE_B = "MESSAGE:B";
    final String MESSAGE_C = "MESSAGE:C";
    final String MESSAGE_D = "MESSAGE:D";



    private InetAddress iNet = null;
    private DatagramSocket socket = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battle1);

        ImageButton btnA = findViewById(R.id.iv1);
        ImageButton btnB = findViewById(R.id.iv2);
        ImageButton btnC = findViewById(R.id.iv3);
        ImageButton btnD = findViewById(R.id.iv4);

        String ipStr = getIntent().getStringExtra("ip");
        try {
            iNet = InetAddress.getByName(ipStr);
            socket = new DatagramSocket();
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }catch (SocketException e) {
            e.printStackTrace();
        }

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_A);
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_B);
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_C);
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_D);
            }
        });
    }

    private void sendMessageUDP(final String message) {

        new Thread(new Runnable() {
            public void run() {
                try {

                    DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, iNet, PORT);

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

}