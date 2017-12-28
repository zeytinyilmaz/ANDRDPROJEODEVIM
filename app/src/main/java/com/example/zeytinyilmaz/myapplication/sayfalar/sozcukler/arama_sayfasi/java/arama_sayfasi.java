package com.example.zeytinyilmaz.myapplication.sayfalar.sozcukler.arama_sayfasi.java;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.DialogPreference;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.zeytinyilmaz.myapplication.*;
import com.example.zeytinyilmaz.myapplication.ayarlar;
import com.example.zeytinyilmaz.myapplication.sayfalar.sozcukler.*;
import com.example.zeytinyilmaz.myapplication.sayfalar.sozcukler.kelimeler_sayfasi;

import java.util.ArrayList;

//com.example.zeytinyilmaz.myapplication.sayfalar.sozcukler.arama_sayfasi.java.arama_sayfasi
public class arama_sayfasi extends AppCompatActivity {

    ImageView btn_Ara;
    ListView Listview;
    EditText etText_ara;


    @Override
    public void onBackPressed() {
        cikisButon();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_arama_sayfasi);
            Initilize();
            Clicks();
            aramaMetni();

        }
        catch (Exception ee){
            //Log.e("Arama_sayfasi_Oncreate_Log:",ee.getMessage().toString());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf=getMenuInflater();
        inf.inflate(R.menu.menum,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void cikisButon(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Türkçe Sözlük");
        builder.setMessage("Çıkmak istediğinizden eminmisiniz?");
        builder.setCancelable(false);
        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int id){

            }
        });

        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int id){
                System.exit(0);
            }
        });

        builder.show();

    }
    private void Initilize(){
        etText_ara=(EditText)findViewById(R.id.aratxt);
        etText_ara.setText("");
        btn_Ara=(ImageView) findViewById(R.id.btnAra);
        Listview=(ListView)findViewById(R.id.liste);

    }


    private void Clicks(){
        btn_Ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etText_ara.getText().toString().trim().equals("")){
                    Toast.makeText(arama_sayfasi.this, "Aranacak kelimeyi yazınız.", Toast.LENGTH_SHORT).show();
                }
                else {
                    veritabanindaniste(etText_ara.getText().toString());//aranan kelimeleri çekiyo

                }
            }
        });
        etText_ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        Listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView liste__=(TextView)view;
                //Toast.makeText(arama_sayfasi.this,liste__.getText().toString(),Toast.LENGTH_LONG).show();
                anlamGonder(liste__.getText().toString());
            }
        });
        listview_();

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
        SharedPreferences pre=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        return pre.getString("secimtxt","");
    }
    private void baslikKaydet(String kayit){
        SharedPreferences pre=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor ed=pre.edit();
        ed.putString("secimtxt",kayit.toString());
        ed.commit();
    }

    private void listview_(){

        registerForContextMenu(Listview);
        Listview.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
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
    private void anlamGonder(String Kelime){
        Kelime=Kelime.toLowerCase();
        Intent anlam=new Intent(arama_sayfasi.this,com.example.zeytinyilmaz.myapplication.sayfalar.sozcukler.anlam.class);
        anlam.putExtra("kelime",Kelime.toString());
        startActivity(anlam);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        try {
            switch (item.getItemId()) {
                case R.id.ayarlar:

                    Intent intent = new Intent(arama_sayfasi.this, ayarlar.class);
                    startActivity(intent);

                    // break;
                    return true;
                case R.id.Kelimeler:
                  //*  Intent intent_kelimeler = new Intent(arama_sayfasi.this,kelimeler_sayfasi.class);
                    //startActivity(intent_kelimeler);
                    //break;
                    try{
                        dbhelper = new DBHelper(getApplicationContext());

                        ArrayList<Sozluk_kelime> SozcukListesi=dbhelper.getKelimeListesiArrayList();
                        Sozluk_Kelime_Adapter adp=new Sozluk_Kelime_Adapter(this,SozcukListesi);
                        Listview.setAdapter(adp);

                    }
                    catch (Exception ee){
                        // Toast.makeText(this, ee.getMessage().toString(), Toast.LENGTH_LONG).show();
//                        Log.e("Veri Tabani Hata Mesaji : ", ee.getMessage().toString());
                    }

                    return true;
                case R.id.cikis:
                    //finish();

                    cikisButon();

                    //break;
                case R.id.AnlaminiGoster:
//                    Toast.makeText(this, "tiklama aldim", Toast.LENGTH_LONG).show();
                    return true;
            }
        }
        catch (Exception ee){
            Log.e("Hata : ",ee.getMessage().toString());
        }

        //return super.onOptionsItemSelected(item); bunları kaldırında execption dönmedi
        return true;
    }

    DBHelper dbhelper;
    private void veritabanindaniste(String _Kelime){

        try{

            dbhelper = new DBHelper(getApplicationContext());
            ArrayList<Sozluk_kelime> sozlukKelime_=dbhelper.getKelimeAraArrayList(_Kelime.toString());
            Sozluk_Kelime_Adapter adp=new Sozluk_Kelime_Adapter(this,sozlukKelime_);
            Listview.setAdapter(adp);
        }
        catch (Exception ee){
            // Toast.makeText(this, ee.getMessage().toString(), Toast.LENGTH_LONG).show();
             //Log.e("Veri Tabani Hata Mesaji : ", ee.getMessage().toString());
        }

    }
    private void veritabanindancek(){

        try{
dbhelper = new DBHelper(getApplicationContext());

            ArrayList<Sozluk_kelime> SozcukListesi=dbhelper.getKelimeListesiArrayList();
            Sozluk_Kelime_Adapter adp=new Sozluk_Kelime_Adapter(this,SozcukListesi);
            Listview.setAdapter(adp);

        }
        catch (Exception ee){
           // Toast.makeText(this, ee.getMessage().toString(), Toast.LENGTH_LONG).show();
           // Log.e("Veri Tabani Hata Mesaji : ", ee.getMessage().toString());
        }


        }
    private void aramaMetni(){
        SharedPreferences pre = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if(pre.getBoolean("aratxt",true)){
            etText_ara.setText(pre.getString("aramakutusu","").toString());
        }
        else {
            etText_ara.setText("");
        }
    }
    private void aramaMetniniKaydet(String Metin){
        SharedPreferences pre=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor kayıt=pre.edit();
        kayıt.putString("aramakutusu",Metin);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    protected void onPause() {
        aramaMetniniKaydet(etText_ara.getText().toString());
        super.onPause();
    }

    @Override
    protected void onResume() {
        aramaMetni();
        super.onResume();
    }
}
