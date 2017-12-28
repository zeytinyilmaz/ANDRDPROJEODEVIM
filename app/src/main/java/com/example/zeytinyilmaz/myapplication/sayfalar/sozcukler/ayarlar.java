package com.example.zeytinyilmaz.myapplication.sayfalar.sozcukler;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.zeytinyilmaz.myapplication.R;

/**
 * Created by ZEYTIN YILMAZ on 15.12.2017.
 */

public class ayarlar extends AppCompatActivity {
    Switch sw,aramametni;
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
        aramametni=(Switch)findViewById(R.id.secenek_ara_metni_sakla);
    }
    private  void  Clicks(){
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (sw.isChecked()){
                    SecimKaydet("otomatikacilma",true);
                }
                else {
                    SecimKaydet("otomatikacilma",false);
                }
            }
        });
        aramametni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //aratxt
                if (aramametni.isChecked()){
                    SecimKaydet("aratxt",true);
                }
                else {
                    SecimKaydet("aratxt",false);
                }
            }
        });

    }
    private  void  SecimKaydet(String etiket, Boolean durum){
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean(etiket.toString(),durum);
        editor.commit();
    }
    private void secimKontrol()
    {
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        sw.setChecked(preferences.getBoolean("otomatikacilma",true));
        aramametni.setChecked(preferences.getBoolean("aratxt",false));

    }



}
