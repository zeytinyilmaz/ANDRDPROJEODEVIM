package com.example.zeytinyilmaz.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * Created by ZEYTIN YILMAZ on 15.12.2017.
 */

public class ayarlar extends AppCompatActivity {
    Switch sw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

       try
       {


           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_ayarlar);
           Initilize();
           Clicks();
           secimKontrol();


       }
       catch (Exception ee){
           Log.e("Hata : ",ee.getMessage().toString());
       }
       }


    private void Initilize(){
        sw=(Switch)findViewById(R.id.secenek_karsilama_ekreani);
    }
    private  void  Clicks(){
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (sw.isChecked()){
                    SecimKaydet(true);
                }
                else {
                    SecimKaydet(false);
                }
            }
        });

    }
    private  void  SecimKaydet(Boolean durum){
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("otomatikacilma",durum);
        editor.commit();
    }
    private void secimKontrol()
    {
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        sw.setChecked(preferences.getBoolean("otomatikacilma",true));

    }


}
