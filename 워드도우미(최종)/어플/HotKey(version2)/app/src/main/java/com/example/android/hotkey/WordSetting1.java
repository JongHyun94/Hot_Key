package com.example.android.hotkey;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class WordSetting1 extends Activity {
    RadioGroup radioGroup1;
    RadioButton wordCopy;
    RadioButton wordPaste;
    RadioButton wordCreate;
    RadioButton wordSaveAname;
    RadioButton wordPrint;
    RadioButton wordPrintlook;
    RadioButton wordCut;
    RadioButton wordFormCopy;
    RadioButton wordFormPaste;
    RadioButton wordtoTheMemo;
    RadioButton wordBookIn;
    RadioButton wordMijoo;
    RadioButton wordGakjoo;
    RadioButton wordDandiverse;
    RadioButton wordTimeField;
    RadioButton wordPageField;
    RadioButton wordMotionChange;
    RadioButton wordMotionSizeChange;
    RadioButton wordStyleChange;
    RadioButton wordleftCenter;
    RadioButton wordrightCenter;
    RadioButton wordCenter;
    RadioButton wordCapWord;
    RadioButton wordCheck;
    RadioButton wordWindowDiv;
    RadioButton wordTotalWindow;
    RadioButton wordClose;
    RadioButton wordBold;
    RadioButton wordTotalSelect;
    RadioButton wordOpen;
    RadioButton wordFound;
    RadioButton wordCancle;
    RadioButton wordRePlay;
    RadioButton wordSave;
    RadioButton wordPlusOne;
    RadioButton wordDownOne;
    RadioButton wordlineOne;
    RadioButton wordlineTwo;
    RadioButton wordlineOneTwo;
    RadioButton wordAdopt;
    RadioButton wordHelp;
    RadioButton wordFinalRe;
    RadioButton wordSynonym;
    RadioButton wordUnderline;
    RadioButton wordMotionLean;
    RadioButton wordInitial;
    RadioButton wordFullScreen;

    Button btn1;

    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    String ipStr;

    String value1 = "";
    String value2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordsetting1);

        btn1 = findViewById(R.id.set1);

        radioGroup1 = findViewById(R.id.rgroup1);

        wordCopy = findViewById(R.id.wordCopy);
        wordPaste = findViewById(R.id.wordPaste);
        wordCreate = findViewById(R.id.wordCreate);
        wordSaveAname = findViewById(R.id.wordSaveAname);
        wordPrint = findViewById(R.id.wordPrint);
        wordPrintlook = findViewById(R.id.wordPrintlook);
        wordCut = findViewById(R.id.wordCut);
        wordFormCopy = findViewById(R.id.wordFormCopy);
        wordFormPaste = findViewById(R.id.wordFormPaste);
        wordtoTheMemo = findViewById(R.id.wordtoTheMemo);
        wordBookIn = findViewById(R.id.wordBookIn);
        wordMijoo = findViewById(R.id.wordMijoo);
        wordGakjoo = findViewById(R.id.wordGakjoo);
        wordDandiverse = findViewById(R.id.wordDandiverse);
        wordTimeField = findViewById(R.id.wordTimeField);
        wordPageField = findViewById(R.id.wordPageField);
        wordMotionChange = findViewById(R.id.wordMotionChange);
        wordMotionSizeChange = findViewById(R.id.wordMotionSizeChange);
        wordStyleChange = findViewById(R.id.wordStyleChange);
        wordleftCenter = findViewById(R.id.wordleftCenter);
        wordrightCenter = findViewById(R.id.wordrightCenter);
        wordCenter = findViewById(R.id.wordCenter);
        wordCapWord = findViewById(R.id.wordCapWord);
        wordCheck = findViewById(R.id.wordCheck);
        wordWindowDiv = findViewById(R.id.wordWindowDiv);
        wordTotalWindow = findViewById(R.id.wordTotalWindow);
        wordClose = findViewById(R.id.wordClose);
        wordBold = findViewById(R.id.wordBold);
        wordTotalSelect = findViewById(R.id.wordTotalSelect);

        wordOpen = findViewById(R.id.wordOpen);
        wordFound = findViewById(R.id.wordFound);
        wordCancle = findViewById(R.id.wordCancle);
        wordRePlay = findViewById(R.id.wordRePlay);
        wordSave = findViewById(R.id.wordSave);
        wordPlusOne = findViewById(R.id.wordPlusOne);
        wordDownOne = findViewById(R.id.wordDownOne);
        wordlineOne = findViewById(R.id.wordlineOne);
        wordlineTwo = findViewById(R.id.wordlineTwo);
        wordlineOneTwo = findViewById(R.id.wordlineOneTwo);
        wordAdopt = findViewById(R.id.wordAdopt);
        wordHelp = findViewById(R.id.wordHelp);
        wordFinalRe = findViewById(R.id.wordFinalRe);
        wordSynonym = findViewById(R.id.wordSynonym);
        wordUnderline = findViewById(R.id.wordUnderline);
        wordMotionLean = findViewById(R.id.wordMotionLean);
        wordInitial = findViewById(R.id.wordInitial);
        wordFullScreen = findViewById(R.id.wordFullScreen);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioSet = radioGroup1.getCheckedRadioButtonId();

                if (wordCopy.getId() == radioSet){
                    value1 = "MESSAGE:wordCopy";
                    value2 = wordCopy.getText().toString();
                }
                if (wordPaste.getId() == radioSet){
                    value1 = "MESSAGE:wordPaste";
                    value2 = wordPaste.getText().toString();
                }
                if (wordCreate.getId() == radioSet){
                    value1 = "MESSAGE:wordCreate";
                    value2 = wordCreate.getText().toString();
                }
                if (wordSaveAname.getId() == radioSet){
                    value1 = "MESSAGE:wordSaveAname";
                    value2 = wordSaveAname.getText().toString();
                }
                if (wordPrint.getId() == radioSet){
                    value1 = "MESSAGE:wordPrint";
                    value2 = wordPrint.getText().toString();
                }
                if (wordPrintlook.getId() == radioSet){
                    value1 = "MESSAGE:wordPrintlook";
                    value2 = wordPrintlook.getText().toString();
                }
                if (wordCut.getId() == radioSet){
                    value1 = "MESSAGE:wordCut";
                    value2 = wordCut.getText().toString();
                }
                if (wordFormCopy.getId() == radioSet){
                    value1 = "MESSAGE:wordFormCopy";
                    value2 = wordFormCopy.getText().toString();
                }
                if (wordFormPaste.getId() == radioSet){
                    value1 = "MESSAGE:wordFormPaste";
                    value2 = wordFormPaste.getText().toString();
                }
                if (wordtoTheMemo.getId() == radioSet){
                    value1 = "MESSAGE:wordtoTheMemo";
                    value2 = wordtoTheMemo.getText().toString();
                }
                if (wordBookIn.getId() == radioSet){
                    value1 = "MESSAGE:wordBookIn";
                    value2 = wordBookIn.getText().toString();
                }
                if (wordMijoo.getId() == radioSet){
                    value1 = "MESSAGE:wordMijoo";
                    value2 = wordMijoo.getText().toString();
                }
                if (wordGakjoo.getId() == radioSet){
                    value1 = "MESSAGE:wordGakjoo";
                    value2 = wordGakjoo.getText().toString();
                }
                if (wordDandiverse.getId() == radioSet){
                    value1 = "MESSAGE:wordDandiverse";
                    value2 = wordDandiverse.getText().toString();
                }
                if (wordTimeField.getId() == radioSet){
                    value1 = "MESSAGE:wordTimeField";
                    value2 = wordTimeField.getText().toString();
                }
                if (wordPageField.getId() == radioSet){
                    value1 = "MESSAGE:wordPageField";
                    value2 = wordPageField.getText().toString();
                }
                if (wordMotionChange.getId() == radioSet){
                    value1 = "MESSAGE:wordMotionChange";
                    value2 = wordMotionChange.getText().toString();
                }
                if (wordMotionSizeChange.getId() == radioSet){
                    value1 = "MESSAGE:wordMotionSizeChange";
                    value2 = wordMotionSizeChange.getText().toString();
                }
                if (wordStyleChange.getId() == radioSet){
                    value1 = "MESSAGE:wordStyleChange";
                    value2 = wordStyleChange.getText().toString();
                }
                if (wordleftCenter.getId() == radioSet){
                    value1 = "MESSAGE:wordleftCenter";
                    value2 = wordleftCenter.getText().toString();
                }
                if (wordrightCenter.getId() == radioSet){
                    value1 = "MESSAGE:wordrightCenter";
                    value2 = wordrightCenter.getText().toString();
                }
                if (wordCenter.getId() == radioSet){
                    value1 = "MESSAGE:wordCenter";
                    value2 = wordCenter.getText().toString();
                }
                if (wordCapWord.getId() == radioSet){
                    value1 = "MESSAGE:wordCapWord";
                    value2 = wordCapWord.getText().toString();
                }
                if (wordCheck.getId() == radioSet){
                    value1 = "MESSAGE:wordCheck";
                    value2 = wordCheck.getText().toString();
                }
                if (wordWindowDiv.getId() == radioSet){
                    value1 = "MESSAGE:wordWindowDiv";
                    value2 = wordWindowDiv.getText().toString();
                }
                if (wordTotalWindow.getId() == radioSet){
                    value1 = "MESSAGE:wordTotalWindow";
                    value2 = wordTotalWindow.getText().toString();
                }
                if (wordClose.getId() == radioSet){
                    value1 = "MESSAGE:wordClose";
                    value2 = wordClose.getText().toString();
                }
                if (wordBold.getId() == radioSet){
                    value1 = "MESSAGE:wordBold";
                    value2 = wordBold.getText().toString();
                }
                if (wordTotalSelect.getId() == radioSet){
                    value1 = "MESSAGE:wordTotalSelect";
                    value2 = wordTotalSelect.getText().toString();
                }
                if (wordOpen.getId() == radioSet){
                    value1 = "MESSAGE:wordOpen";
                    value2 = wordOpen.getText().toString();
                }
                if (wordFound.getId() == radioSet){
                    value1 = "MESSAGE:wordFound";
                    value2 = wordFound.getText().toString();
                }
                if (wordCancle.getId() == radioSet){
                    value1 = "MESSAGE:wordCancle";
                    value2 = wordCancle.getText().toString();
                }
                if (wordFound.getId() == radioSet){
                    value1 = "MESSAGE:wordFound";
                    value2 = wordFound.getText().toString();
                }
                if (wordSave.getId() == radioSet){
                    value1 = "MESSAGE:wordSave";
                    value2 = wordSave.getText().toString();
                }
                if (wordRePlay.getId() == radioSet){
                    value1 = "MESSAGE:wordRePlay";
                    value2 = wordRePlay.getText().toString();
                }
                if (wordPlusOne.getId() == radioSet){
                    value1 = "MESSAGE:wordPlusOne";
                    value2 = wordPlusOne.getText().toString();
                }
                if (wordDownOne.getId() == radioSet){
                    value1 = "MESSAGE:wordDownOne";
                    value2 = wordDownOne.getText().toString();
                }
                if (wordlineOne.getId() == radioSet){
                    value1 = "MESSAGE:wordlineOne";
                    value2 = wordlineOne.getText().toString();
                }
                if (wordlineTwo.getId() == radioSet){
                    value1 = "MESSAGE:wordlineTwo";
                    value2 = wordlineTwo.getText().toString();
                }
                if (wordlineOneTwo.getId() == radioSet){
                    value1 = "MESSAGE:wordlineOneTwo";
                    value2 = wordlineOneTwo.getText().toString();
                }
                if (wordAdopt.getId() == radioSet){
                    value1 = "MESSAGE:wordAdopt";
                    value2 = wordAdopt.getText().toString();
                }
                if (wordHelp.getId() == radioSet){
                    value1 = "MESSAGE:wordHelp";
                    value2 = wordHelp.getText().toString();
                }
                if (wordFinalRe.getId() == radioSet){
                    value1 = "MESSAGE:wordFinalRe";
                    value2 = wordFinalRe.getText().toString();
                }
                if (wordSynonym.getId() == radioSet){
                    value1 = "MESSAGE:wordSynonym";
                    value2 = wordSynonym.getText().toString();
                }
                if (wordUnderline.getId() == radioSet){
                    value1 = "MESSAGE:wordUnderline";
                    value2 = wordUnderline.getText().toString();
                }
                if (wordMotionLean.getId() == radioSet){
                    value1 = "MESSAGE:wordMotionLean";
                    value2 = wordMotionLean.getText().toString();
                }
                if (wordInitial.getId() == radioSet){
                    value1 = "MESSAGE:wordInitial";
                    value2 = wordInitial.getText().toString();
                }
                if (wordFullScreen.getId() == radioSet){
                    value1 = "MESSAGE:wordFullScreen";
                    value2 = wordFullScreen.getText().toString();
                }

                sharedPreferences(value1, value2);
                Toast.makeText(getApplicationContext(), value2+" 저장되었당 ", Toast.LENGTH_SHORT).show();
                ipStr = getIntent().getStringExtra("ip");
                Intent intent = new Intent(getApplicationContext(),SettingWord.class);
                intent.putExtra("ip",ipStr);
                startActivity(intent);
                finish();
            }
        });
    }

    public void sharedPreferences(String value1, String value2) {
        sh_Pref = getSharedPreferences("Login IP", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("Btn1", value1);
        toEdit.putString("Btn1_w",value2);
        toEdit.commit();
    }

}