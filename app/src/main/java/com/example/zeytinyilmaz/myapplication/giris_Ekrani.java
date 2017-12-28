package com.example.zeytinyilmaz.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;
public class giris_Ekrani extends AppCompatActivity {

    ProgressBar pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris__ekrani);
      //  pro=(ProgressBar)findViewById(R.id.progressbar_karsilama);
       // pro.setMax(100);
       // pro.setProgress(0);
        pro=(ProgressBar)findViewById(R.id.yuklenmecubugu);
        pro.setMax(99);
        pro.setProgress(0);
        Timer timer=new Timer();
        TimerTask gorev=new TimerTask() {
            int size=0;
            @Override
            public void run() {
            size+=1;
                pro.setProgress(size);
                if (size==40){
                   // Intent aramasayfasi=new Intent(giris_Ekrani.this,com.example.zeytinyilmaz.myapplication.sayfalar.sozcukler.arama_sayfasi.class);
                   // startActivity(aramasayfasi);
                   // this.cancel();//test için koydum arkadaki aktivitiyi kapasın diye
                    finishAffinity();//önceki sayfaları kapatıyomuş
                    finish();//test
                    Intent arama_ekrani=new Intent(giris_Ekrani.this,com.example.zeytinyilmaz.myapplication.sayfalar.sozcukler.arama_sayfasi.java.arama_sayfasi.class);
                    startActivity(arama_ekrani);
                    finishAffinity();
                }
            }
        };
        //timer.schedule(gorev,0,100);
        timer.schedule(gorev,0,100);
    }
}
