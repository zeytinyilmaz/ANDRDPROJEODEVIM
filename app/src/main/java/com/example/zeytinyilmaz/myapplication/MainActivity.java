package com.example.zeytinyilmaz.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

//import com.example.zeytinyilmaz.myapplication.sayfalar.sozcukler.kelimeler_sayfasi;

public class MainActivity extends AppCompatActivity {
    EditText aratext;
    ListView liste;
    Button arabuton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.arama_);

        //Initilize();
        //Clicks();
        /*
        Intent gecis=new Intent(MainActivity.this,sozcukler.class);
        startActivity(gecis);

        Mesaj.ekranaBas(this," deneme", Mesaj.Sure.Uzun);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();*/
/*
        DBHelper helper=new DBHelper(this);
        ArrayList<Sozluk_kelime> kelimeListesi_=helper.getKelimeListesi();
        Sozluk_Kelime_Adapter adp=new Sozluk_Kelime_Adapter(this,kelimeListesi_);
        liste.setAdapter(adp);
*/





        /*
        *
        *
                SharedPreferences preferans= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor=preferans.edit();
                editor.putBoolean("otomatikacilma",b);
                editor.commit();
        *
        * */
        try{



            SharedPreferences pre= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            if (pre.getBoolean("otomatikacilma",true)){

                //eğer otomatik açılma true ise giriş ekranını başlatıcak
                Intent gecis=new Intent(MainActivity.this,giris_Ekrani.class/*testten sonra kaldır*//*com.example.zeytinyilmaz.myapplication.testing.MainActivity.class*/);
                startActivity(gecis);

            }
            else {
                //eğer otomatik açılma false ise giriş ekranını açmadan arama ekranını açıcak



                Intent gecis=new Intent(MainActivity.this,/*testten sonra kaldır*/com.example.zeytinyilmaz.myapplication.sayfalar.sozcukler.arama_sayfasi.java.arama_sayfasi.class);
                startActivity(gecis);

            }

        }
        catch (Exception e){

        }
    }

    private void Initilize(){

        aratext=(EditText)findViewById(R.id.aratxt);
        liste=(ListView)findViewById(R.id.liste);
       // arabuton=(Button) findViewById(R.id.arabuton);


    }
    private  void  Clicks(){
        arabuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecis=new Intent(MainActivity.this,kelimeler_sayfasi.class);
                startActivity(gecis);
            }
        });
    }



}
