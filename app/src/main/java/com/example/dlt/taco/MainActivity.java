package com.example.dlt.taco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
public class MainActivity extends AppCompatActivity {

    Button btn;
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    Button send;
    CheckBox cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s="";
                radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
                int SelectedID1= radioGroup1.getCheckedRadioButtonId();
                if(SelectedID1>=0) {
                    RadioButton rd1 = (RadioButton) findViewById(SelectedID1);
                    s += "Size: "+rd1.getText();
                }
                radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
                int SelectedID2= radioGroup1.getCheckedRadioButtonId();
                if(SelectedID2>=0) {
                    RadioButton rd2 = (RadioButton) findViewById(SelectedID2);
                    s += "\nTortilla: "+rd2.getText();
                }
                cb2 = (CheckBox) findViewById(R.id.checkBox2);
                cb3 = (CheckBox) findViewById(R.id.checkBox3);
                cb4 = (CheckBox) findViewById(R.id.checkBox4);
                cb5 = (CheckBox) findViewById(R.id.checkBox5);
                cb6 = (CheckBox) findViewById(R.id.checkBox6);
                cb7 = (CheckBox) findViewById(R.id.checkBox7);
                cb8 = (CheckBox) findViewById(R.id.checkBox8);
                cb9 = (CheckBox) findViewById(R.id.checkBox9);
                cb10 = (CheckBox) findViewById(R.id.checkBox10);
                cb11 = (CheckBox) findViewById(R.id.checkBox11);
                if(cb2.isChecked() || cb3.isChecked() || cb4.isChecked() || cb5.isChecked() || cb6.isChecked() || cb7.isChecked() || cb8.isChecked() || cb9.isChecked()
                        || cb10.isChecked() || cb11.isChecked()) {
                    s+="\nFillings: ";
                    if(cb2.isChecked()){
                        s+=cb2.getText()+",";
                    }
                    if(cb3.isChecked()){
                        s+=cb3.getText()+",";
                    }
                    if(cb4.isChecked()){
                        s+=cb4.getText()+",";
                    }
                    if(cb5.isChecked()){
                        s+=cb5.getText()+",";
                    }
                    if(cb6.isChecked()){
                        s+=cb6.getText()+",";
                    }
                    if(cb7.isChecked()){
                        s+=cb7.getText()+",";
                    }
                    if(cb8.isChecked()){
                        s+=cb8.getText()+",";
                    }
                    if(cb9.isChecked()){
                        s+=cb9.getText()+",";
                    }
                    if(cb10.isChecked()){
                        s+=cb10.getText()+",";
                    }
                    if(cb11.isChecked()){
                        s+=cb11.getText();
                    }
                }
                cb12 = (CheckBox) findViewById(R.id.checkBox2);
                cb13 = (CheckBox) findViewById(R.id.checkBox3);
                cb14 = (CheckBox) findViewById(R.id.checkBox4);
                cb15 = (CheckBox) findViewById(R.id.checkBox5);
                if(cb12.isChecked() || cb13.isChecked() || cb14.isChecked() || cb15.isChecked()) {
                    s += "\nBeverage: ";
                    if (cb12.isChecked()) {
                        s += cb12.getText() + ",";
                    }
                    if (cb13.isChecked()) {
                        s += cb13.getText() + ",";
                    }
                    if (cb14.isChecked()) {
                        s += cb14.getText() + ",";
                    }
                    if (cb15.isChecked()) {
                        s += cb15.getText();
                    }
                }
                SendSMS(s);
            }
        });

    }
    private void SendSMS(String mess)
    {
        /*SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("", null,"I WANT A "+mess+" TACO - sms message",null, null);*/
        String phoneNumber = "01646720755";

        Intent intent = new Intent(Intent.ACTION_SENDTO,
                Uri.parse("sms:" + phoneNumber));
        intent.putExtra("sms_body", mess);
        startActivity(intent);
    }
}
