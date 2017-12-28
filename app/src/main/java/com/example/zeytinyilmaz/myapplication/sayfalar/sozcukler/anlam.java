package com.example.zeytinyilmaz.myapplication.sayfalar.sozcukler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zeytinyilmaz.myapplication.DBHelper;
import com.example.zeytinyilmaz.myapplication.R;
import com.example.zeytinyilmaz.myapplication.Sozluk_Anlam_Custom_Adapter;
import com.example.zeytinyilmaz.myapplication.Sozluk_Kelime_Adapter;
import com.example.zeytinyilmaz.myapplication.Sozluk_kelime;

import java.util.ArrayList;
import com.example.zeytinyilmaz.myapplication.anlam_base_class;
public class anlam extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anlam);
        Initilize();
        Clicks();
        anlamyaz();
    }
    private void Initilize(){
        text=(TextView)findViewById(R.id.anlamyazilacak_alan);
    }
    private void Clicks(){
    }

    DBHelper dbhelper;
    public void anlamyaz(){

        try{
            Intent gelenveri=getIntent();
            Toast.makeText(this, gelenveri.getStringExtra("kelime").toString(), Toast.LENGTH_LONG).show();//test
            String gelendata=gelenveri.getStringExtra("kelime").toString();


            dbhelper=new DBHelper(getApplicationContext());
            String kelimeninAnlami=dbhelper.getKelimeAnlamString(gelendata.toString());
            text.setTextSize(30);
            text.setText(gelendata.toString()+"\n------\n"+kelimeninAnlami.toString());
           // Toast.makeText(this, kelimeninAnlami.toString(), Toast.LENGTH_SHORT).show();
        }
        catch (Exception ee){
            // Toast.makeText(this, ee.getMessage().toString(), Toast.LENGTH_LONG).show();
           // Log.e("Anlam görüntüleme hatası  : ", ee.getMessage().toString());
        }

    }
}
