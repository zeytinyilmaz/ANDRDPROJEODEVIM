package com.example.zeytinyilmaz.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

/**
 * Created by ZEYTIN YILMAZ on 15.12.2017.
 */

public class kelimeler_sayfasi extends AppCompatActivity {



    DBHelper helper;
    ListView liste;
    Spinner sp;
    private String[] harfSiralamasi={"A-Z","Z-A","A","B","C","D","E"};
    private ArrayAdapter<String> adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelimeler_sayfasi);
        Initilize();
        listele();
    }
    public void Initilize(){
        liste=(ListView)findViewById(R.id.liste);
        sp=(Spinner)findViewById(R.id.siralama);
        adp=new ArrayAdapter<String>(this,R.layout.kelimeler_,harfSiralamasi);
        adp.setDropDownViewResource(R.layout.kelimeler_);
        sp.setAdapter(adp);
    }
    private void  listele(){





    }
    public  void Clicks(){
        liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }





}
