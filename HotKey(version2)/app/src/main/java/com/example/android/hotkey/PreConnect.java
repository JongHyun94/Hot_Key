package com.example.android.hotkey;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PreConnect extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview);

        final EditText ipAddress =  findViewById(R.id.input);
        Button connectionBtn =  findViewById(R.id.ipButton);


        connectionBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                String ipStr = ipAddress.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ip", ipStr);
                startActivity(intent);

            }
        });

    }

}