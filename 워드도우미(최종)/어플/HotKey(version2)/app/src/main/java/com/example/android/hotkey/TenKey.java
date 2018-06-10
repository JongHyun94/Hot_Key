package com.example.android.hotkey;

import android.app.Activity;
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

public class TenKey extends Activity {

    final int PORT = 10000;
    final String MESSAGE_1 = "MESSAGE:1";
    final String MESSAGE_2 = "MESSAGE:2";
    final String MESSAGE_3 = "MESSAGE:3";
    final String MESSAGE_4 = "MESSAGE:4";
    final String MESSAGE_5 = "MESSAGE:5";
    final String MESSAGE_6 = "MESSAGE:6";
    final String MESSAGE_7 = "MESSAGE:7";
    final String MESSAGE_8 = "MESSAGE:8";
    final String MESSAGE_9 = "MESSAGE:9";
    final String MESSAGE_0 = "MESSAGE:0";
    final String MESSAGE_00 = "MESSAGE:00";

    final String MESSAGE_PLUS = "MESSAGE:PLUS";
    final String MESSAGE_MINUS = "MESSAGE:MINUS";
    final String MESSAGE_STAR = "MESSAGE:STAR";
    final String MESSAGE_CUT = "MESSAGE:CUT";
    final String MESSAGE_ZUM = "MESSAGE:ZUM";

    final String MESSAGE_DELETE = "MESSAGE:DELETE";
    final String MESSAGE_HOME = "MESSAGE:HOME";
    final String MESSAGE_END = "MESSAGE:END";
    final String MESSAGE_INSERT = "MESSAGE:INSERT";
    final String MESSAGE_BACK = "MESSAGE:BACK";
    final String MESSAGE_ENTER = "MESSAGE:ENTER ";

    private InetAddress iNet = null;
    private DatagramSocket socket = null;

    Button one, two, three, four, five, six, seven, eight, nine, zero, zerozero;
    Button plus, minus, star, cut, zum;
    Button delete, home, end, insert, back, enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tenkey);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        zerozero = findViewById(R.id.doublezero);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        star = findViewById(R.id.star);
        cut = findViewById(R.id.cut);
        zum = findViewById(R.id.zum);

        delete = findViewById(R.id.delete);
        home = findViewById(R.id.home);
        end = findViewById(R.id.end);
        insert = findViewById(R.id.insert);
        back = findViewById(R.id.back);
        enter = findViewById(R.id.enter);

        String ipStr = getIntent().getStringExtra("ip");
        try {
            iNet = InetAddress.getByName(ipStr);
            socket = new DatagramSocket();
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }catch (SocketException e) {
            e.printStackTrace();
        }

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_1);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_2);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_3);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_4);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_5);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_6);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_7);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_8);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_9);
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_0);
            }
        });

        zerozero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_00);
            }
        });



        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_PLUS);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_MINUS);
            }
        });
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_STAR);
            }
        });
        cut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_CUT);
            }
        });
        zum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_ZUM);
            }
        });



        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_DELETE);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_HOME);
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_END);
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_INSERT);
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_ENTER);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUDP(MESSAGE_BACK);
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

}