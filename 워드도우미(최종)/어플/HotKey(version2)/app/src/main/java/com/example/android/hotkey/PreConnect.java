package com.example.android.hotkey;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PreConnect extends Activity {
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    EditText ipAddress;
    ImageButton strBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_real);

        ipAddress =  findViewById(R.id.inputS);
        strBtn =  findViewById(R.id.buttonIP);

        strBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String ipStr = ipAddress.getText().toString();
                Intent intent = new Intent(getApplicationContext(), ListMenu.class);
                intent.putExtra("ip", ipStr);
                sharedPreferences(ipStr);
                startActivity(intent);
            }
        });
        applySharedPreference();
    }

    public void sharedPreferences(String ipStr) {
        sh_Pref = getSharedPreferences("Login IP", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("UserIP", ipStr);
        toEdit.commit();
    }

    public void applySharedPreference(){
        sh_Pref = getSharedPreferences("Login IP", MODE_PRIVATE);
        if (sh_Pref!=null && sh_Pref.contains("UserIP")){
            String name = sh_Pref.getString("UserIP", "192.168.0.1");
            ipAddress.setText(name);
        }
    }
}