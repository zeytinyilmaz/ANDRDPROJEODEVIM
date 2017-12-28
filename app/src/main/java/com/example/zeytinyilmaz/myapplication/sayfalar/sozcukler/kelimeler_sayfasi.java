package com.example.zeytinyilmaz.myapplication.sayfalar.sozcukler;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zeytinyilmaz.myapplication.DBHelper;
import com.example.zeytinyilmaz.myapplication.R;
import com.example.zeytinyilmaz.myapplication.Sozluk_Kelime_Adapter;
import com.example.zeytinyilmaz.myapplication.Sozluk_kelime;
import com.example.zeytinyilmaz.myapplication.sayfalar.sozcukler.arama_sayfasi.java.arama_sayfasi;

import java.util.ArrayList;

public class kelimeler_sayfasi extends AppCompatActivity {



    DBHelper helper;
    ListView liste;
    Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_kelimeler_sayfasi);
            Initilize();
            //Clicks();
            listele();
        }
        catch (Exception v){
            Log.e("kelimeler sayfasindan gelen hata: ",v.getMessage().toString());
        }
    }
    private void Initilize(){
        liste=(ListView)findViewById(R.id.liste);
        sp=(Spinner)findViewById(R.id.siralama);
       // sp();
       // spinnerItemInitilize();
        sp.setVisibility(View.GONE);
    }


    private void  spinnerItemInitilize(){
       // ArrayAdapter<String> spAdp=new ArrayAdapter<String>(this,R.array.HarfsiralamaBicimi,R.layout.activity_kelimeler_sayfasi);
       // spAdp=new ArrayAdapter<String>(this,android.R.);
        Resources res=getResources();
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,R.layout.activity_kelimeler_sayfasi,res.getStringArray(R.array.HarfsiralamaBicimi));
        sp.setAdapter(adp);
    }

    private void sp(){
        try {

            String[] harfSiralamasi = {"A-Z", "Z-A", "A", "B", "Ç", "Ç", "D", "E", "F", "Ğ", "Ğ", "H", "I", "İ", "J", "K", "L", "M", "N", "O", "Ö", "P", "R", "Ş", "Ş", "Ü", "Ü", "V", "Y", "Z"};
            ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.activity_kelimeler_sayfasi, harfSiralamasi);
            adp.setDropDownViewResource(R.layout.activity_kelimeler_sayfasi);
            sp.setAdapter(adp);
        }
        catch (Exception E){
            Toast.makeText(this, E.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }
    DBHelper dbhelper;
    private void  listele(){
        try{
            dbhelper = new DBHelper(getApplicationContext());

            ArrayList<Sozluk_kelime> SozcukListesi=dbhelper.getKelimeListesiArrayList();
            Sozluk_Kelime_Adapter adp=new Sozluk_Kelime_Adapter(this,SozcukListesi);
            liste.setAdapter(adp);

        }
        catch (Exception ee){
            // Toast.makeText(this, ee.getMessage().toString(), Toast.LENGTH_LONG).show();
             Log.e("Veri Tabani Hata Mesaji : ", ee.getMessage().toString());
        }

    }
    public  void Clicks(){
        liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView liste__=(TextView)view;
                //Toast.makeText(arama_sayfasi.this,liste__.getText().toString(),Toast.LENGTH_LONG).show();
                anlamGonder(liste__.getText().toString());

            }
        });
        listview_();
    }

    private void anlamGonder(String Kelime){
        Kelime=Kelime.toLowerCase();
        Intent anlam=new Intent(kelimeler_sayfasi.this,com.example.zeytinyilmaz.myapplication.sayfalar.sozcukler.anlam.class);
        anlam.putExtra("kelime",Kelime.toString());
        startActivity(anlam);
    }





    @Override
    public boolean onContextItemSelected(MenuItem item) {
        boolean duns=true;

        switch (item.getItemId()){
            case 0://kelimenin anlami
                duns=true;
                String baslik=baslikSec();
                anlamGonder(baslik.toString());
                break;
        }

        return duns;
    }

    private String baslikSec(){
        SharedPreferences pre= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        return pre.getString("secimtxt","");
    }
    private void baslikKaydet(String kayit){
        SharedPreferences pre=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor ed=pre.edit();
        ed.putString("secimtxt",kayit.toString());
        ed.commit();
    }

    private void listview_(){

        registerForContextMenu(liste);
        liste.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                if (view.getId()==R.id.liste){

                    AdapterView.AdapterContextMenuInfo inf=(AdapterView.AdapterContextMenuInfo)contextMenuInfo;
                    // String txt=Listview.getItemAtPosition(inf.position).toString();
                    TextView vi=(TextView)inf.targetView;
                    String baslik=vi.getText().toString();
                    contextMenu.setHeaderTitle(baslik.toString());
                    baslikKaydet(baslik.toString());
                    contextMenu.add(0,0,0,"Kelimenin Anlamı");
                }
            }

        });

    }










}
