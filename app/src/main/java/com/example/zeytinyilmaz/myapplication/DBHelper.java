package com.example.zeytinyilmaz.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by ZEYTIN YILMAZ on 14.12.2017.
 */

public class DBHelper extends SQLiteOpenHelper{
    public static  final String VeriTabaniAdi="TRSOZLUK";
    public static final int Version=1;
    public DBHelper(Context context) {
        super(context, VeriTabaniAdi,null, Version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        StringBuilder sorgu=new StringBuilder();
        sorgu.append("CREATE TABLE ");
        sorgu.append(Sozluk_kelime.Tablo_Adi);
        sorgu.append("(");
        sorgu.append(Sozluk_kelime.Sutun_ID);
        sorgu.append(" INTEGER NOT NULL PRIMARY KEY,");//AUTOINCREMENT
        sorgu.append(Sozluk_kelime.Sutun_Kelime);
        sorgu.append(" TEXT NOT NULL");
        sorgu.append(");");

        //sorgu.append(" CREATE TABLE Anlamlar(id NOT NULL PRIMARY KEY ,anlam TEXT TEXT NOT NULL);");
        //sorgu.append(" CREATE TABLE EsAnlamlar(id NOT NULL PRIMARY KEY ,esanlam TEXT TEXT NOT NULL);");

        sqLiteDatabase.execSQL(sorgu.toString());
        sqLiteDatabase.execSQL("CREATE TABLE "+Anlamlar_Tablo_Adi.toString()+"("+Anlamlar_Sutun_ID.toString()+" NOT NULL PRIMARY KEY ,"+Anlamlar_Sutun_anlam.toString()+" TEXT TEXT NOT NULL);");
        sqLiteDatabase.execSQL("CREATE TABLE EsAnlamlar(id NOT NULL PRIMARY KEY ,esanlam TEXT TEXT NOT NULL);");
        //eklemeler
       // sqLiteDatabase.execSQL("insert into "+Sozluk_kelime.Tablo_Adi.toString()+"("+Sozluk_kelime.Sutun_ID.toString()+","+Sozluk_kelime.Sutun_Kelime+") values(1,'deneme')");
       // sqLiteDatabase.execSQL("insert into Anlamlar(id,anlam) values(1,'deneme anlam')");
        veri_tabanina_eklenecek(sqLiteDatabase);
    }
    private  String kelimeSorgu(int id,String kelime){
        return "insert into "+Sozluk_kelime.Tablo_Adi.toString()+"("+Sozluk_kelime.Sutun_ID.toString()+","+Sozluk_kelime.Sutun_Kelime+") values("+id+",'"+kelime.toString()+"')";
    }
    private String anlamSorgu(int id,String anlam){
        return "insert into "+Anlamlar_Tablo_Adi.toString()+"("+Anlamlar_Sutun_ID.toString()+","+Anlamlar_Sutun_anlam.toString()+") values("+id+",'"+anlam.toString()+"')";
    }
    //test
    veritabanina_eklenecekler eklenecekveriler;
    private void  veri_tabanina_eklenecek(SQLiteDatabase sqLiteDatabase){
        eklenecekveriler=new veritabanina_eklenecekler();
        for (int i=0;i<eklenecekveriler.kelime.size();i++){
            sqLiteDatabase.execSQL(kelimeSorgu(i+1,eklenecekveriler.kelime.get(i).toString()));
            sqLiteDatabase.execSQL(anlamSorgu((i+1),eklenecekveriler.anlam.get(i).toString()));
        }
    }




    public static String Anlamlar_Tablo_Adi="Anlamlar";
    public static String Anlamlar_Sutun_ID="id";
    public static  String Anlamlar_Sutun_anlam="anlam";
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public Sozluk_kelime getKelime(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        String[] sutunlar={
                Sozluk_kelime.Sutun_ID,
                Sozluk_kelime.Sutun_Kelime
        };
        Cursor cs=db.query(Sozluk_kelime.Tablo_Adi,sutunlar,"id=?",new String[]{id+""},null,null,null);
        if (cs!=null&&cs.getCount()>0){
            if (cs.moveToFirst()){

                int kelime_id=cs.getInt(cs.getColumnIndex(Sozluk_kelime.Sutun_ID));
                String kelime=cs.getString(cs.getColumnIndex(Sozluk_kelime.Sutun_Kelime));
                Sozluk_kelime kelimesinifi=new Sozluk_kelime(kelime_id,kelime);
                return kelimesinifi;

            }

        }
        return  null;
    }
    public Sozluk_kelime getKelime(String Kelime){
        SQLiteDatabase db=this.getReadableDatabase();
        String[] sutunlar={
                Sozluk_kelime.Sutun_ID,
                Sozluk_kelime.Sutun_Kelime
        };
        Cursor cs=db.query(Sozluk_kelime.Tablo_Adi,sutunlar,Sozluk_kelime.Sutun_Kelime+"=?",new String[]{Kelime.toString()+""},null,null,null);
        if (cs!=null&&cs.getCount()>0){
            if (cs.moveToFirst()){

                int kelime_id=cs.getInt(cs.getColumnIndex(Sozluk_kelime.Sutun_ID));
                String kelime=cs.getString(cs.getColumnIndex(Sozluk_kelime.Sutun_Kelime));
                Sozluk_kelime kelimesinifi=new Sozluk_kelime(kelime_id,kelime);
                return kelimesinifi;

            }

        }
        return  null;
    }



    public Sozluk_kelime getKelimeAnlam(String kelime){//ara kısmında
        SQLiteDatabase db=this.getReadableDatabase();
        Sozluk_kelime kelimesinifi;
        String[] sutunlar={
                Sozluk_kelime.Sutun_ID,
                Sozluk_kelime.Sutun_Kelime
        };
        Cursor cs=db.query(Sozluk_kelime.Tablo_Adi,sutunlar,null,null,null,null,null);
        if (cs!=null&&cs.getCount()>0){
            if (cs.moveToFirst()){

                if (cs.getString(cs.getColumnIndex(Sozluk_kelime.Sutun_Kelime)).toString().equals(kelime)) {


                    int kelime_id = cs.getInt(cs.getColumnIndex(Sozluk_kelime.Sutun_ID));
                    kelime = cs.getString(cs.getColumnIndex(Sozluk_kelime.Sutun_Kelime));
                    String[] sutunlarAnlam2={
                            Anlamlar_Sutun_ID,
                            Anlamlar_Sutun_anlam
                    };
                    //Cursor csanlam=db.query(Anlamlar_Tablo_Adi.toString(),sutunlarAnlam2,Anlamlar_Sutun_ID+"=?",new String[]{kelime.toString()+""},null,null,null);
                    Cursor csanlam=db.query(Anlamlar_Tablo_Adi.toString(),sutunlarAnlam2,"where "+Anlamlar_Sutun_ID.toString()+"="+kelime_id,null,null,null,null);
                    String anlam=csanlam.getString(cs.getColumnIndex(Anlamlar_Sutun_anlam.toString())).toString();
                    kelimesinifi = new Sozluk_kelime(kelime_id, kelime,anlam);
                    return kelimesinifi;
                }
            }

        }
        return  null;

    }
    private int getKelimeId(String Kelime){
        SQLiteDatabase db=this.getReadableDatabase();
        Sozluk_kelime kelimesinifi;
        String[] sutunlar={
                Sozluk_kelime.Sutun_ID,
                Sozluk_kelime.Sutun_Kelime
        };
        int id=-1;
        Cursor cs=db.query(Sozluk_kelime.Tablo_Adi,sutunlar,null,null,null,null,null);
        if (cs!=null&&cs.getCount()>0){
            while (cs.moveToNext()){

                String veritabanindaki_kelime=cs.getString(cs.getColumnIndex(Sozluk_kelime.Sutun_Kelime)).toString();
                if (veritabanindaki_kelime.equals(Kelime)) {


                    int kelime_id = cs.getInt(cs.getColumnIndex(Sozluk_kelime.Sutun_ID));
                    id=kelime_id;
                    break;
                }
            }

        }
        return  id;

    }
    public String getKelimeAnlamString(String kelime){//ara kısmında
        SQLiteDatabase db=this.getReadableDatabase();
        String[] sutunlarAnlam2={
                Anlamlar_Sutun_ID,
                Anlamlar_Sutun_anlam
        };

        Log.i("yazdir", Anlamlar_Sutun_anlam);
        String data="";
        int id=getKelimeId(kelime.toString());
        Cursor csanlam=db.query(Anlamlar_Tablo_Adi.toString(),sutunlarAnlam2,null,null,null,null,null);

       // Cursor csanlam=db.rawQuery("select * from "+Anlamlar_Tablo_Adi.toString()+" where id="+getKelimeId(kelime.toString()),null);

        if (csanlam!=null&&csanlam.getCount()>0){
            while (csanlam.moveToNext()){
                int id_=csanlam.getInt(csanlam.getColumnIndex(Anlamlar_Sutun_ID));
                if (id_==id) {
                    data = csanlam.getString(csanlam.getColumnIndex(Anlamlar_Sutun_anlam));
                    Log.e("data : ",data.toString());
                    break;
                }
            }
        }
        return  data;

    }



    public  Sozluk_kelime getKelimeListesi(){
        SQLiteDatabase db=this.getReadableDatabase();
        Sozluk_kelime kelimesinifi=new Sozluk_kelime(-1,null);
        String[] sutunlar={
                Sozluk_kelime.Sutun_ID,
                Sozluk_kelime.Sutun_Kelime
        };
        Cursor cs=db.query(Sozluk_kelime.Tablo_Adi,sutunlar,null,null,null,null,null);
        if (cs!=null&&cs.getCount()>0){
            if (cs.moveToFirst()){

                int kelime_id=cs.getInt(cs.getColumnIndex(Sozluk_kelime.Sutun_ID));
                String kelime=cs.getString(cs.getColumnIndex(Sozluk_kelime.Sutun_Kelime));
                kelimesinifi=new Sozluk_kelime(kelime_id,kelime);
                //return kelimesinifi;

            }

        }
        return  kelimesinifi;
    }

    public ArrayList<Sozluk_kelime> getKelimeAraArrayList(String Kelime){
        SQLiteDatabase db=this.getReadableDatabase();
        Sozluk_kelime kelimesinifi;
        String[] sutunlar={
                Sozluk_kelime.Sutun_ID,
                Sozluk_kelime.Sutun_Kelime
        };
        ArrayList<Sozluk_kelime> lisss=new ArrayList<>();
        Cursor cs=db.query(Sozluk_kelime.Tablo_Adi,sutunlar,"kelime like '%"+Kelime.toString()+"%'",null,null,null,null);
        //cs=db.rawQuery("select * from "++"")
        if (cs!=null&&cs.getCount()>0){
            while (cs.moveToNext()){

                int kelime_id=cs.getInt(cs.getColumnIndex(Sozluk_kelime.Sutun_ID));
                String kelime=cs.getString(cs.getColumnIndex(Sozluk_kelime.Sutun_Kelime));
                kelimesinifi=new Sozluk_kelime(kelime_id,kelime);
                lisss.add(kelimesinifi);
            }

        }
        return  lisss;
    }
    public ArrayList<Sozluk_kelime> getKelimeListesiArrayList(){
        SQLiteDatabase db=this.getReadableDatabase();
        ArrayList<Sozluk_kelime> kelimeListesi=new ArrayList<>();
        Sozluk_kelime sozluk_sinifi;
        String[] sutunlar={
                Sozluk_kelime.Sutun_ID,
                Sozluk_kelime.Sutun_Kelime
        };
        Cursor cs=db.query(Sozluk_kelime.Tablo_Adi,sutunlar,null,null,null,null,null);
        //cs=db.rawQuery("select * from "+Anlamlar_Tablo_Adi.toString()+" order by "+Anlamlar_Sutun_anlam.toString()+" asc",null);

        if(cs!=null&&cs.getCount()>0){
            while (cs.moveToNext()){
                int kelime_id=cs.getInt(cs.getColumnIndex(Sozluk_kelime.Sutun_ID));
                String kelime=cs.getString(cs.getColumnIndex(Sozluk_kelime.Sutun_Kelime));
                sozluk_sinifi=new Sozluk_kelime(kelime_id,kelime);
                kelimeListesi.add(sozluk_sinifi);
            }
        }
        return kelimeListesi;
    }

    public ArrayList<anlam_base_class> getKelimeAnlamArrayList(String kelime){
        SQLiteDatabase db=this.getReadableDatabase();
        anlam_base_class kelimesinifi;
        String[] sutunlar={
                Sozluk_kelime.Sutun_ID,
                Sozluk_kelime.Sutun_Kelime
        };
        ArrayList<anlam_base_class> list__=new ArrayList<>();
        Cursor cs=db.query(Sozluk_kelime.Tablo_Adi,sutunlar,null,null,null,null,null);
        if (cs!=null&&cs.getCount()>0){
            if (cs.moveToFirst()){
                String kelimecik=cs.getString(cs.getColumnIndex(Sozluk_kelime.Sutun_Kelime)).toString();
                if (kelimecik.equals(kelime.toString())) {


                    int kelime_id = cs.getInt(cs.getColumnIndex(Sozluk_kelime.Sutun_ID));
                    kelime = cs.getString(cs.getColumnIndex(Sozluk_kelime.Sutun_Kelime));
                    String[] sutunlarAnlam2={
                            "id",
                            "anlam"
                    };
                    Cursor csanlam=db.query(Anlamlar_Tablo_Adi.toString(),sutunlarAnlam2,Anlamlar_Sutun_ID+"=?",new String[]{kelime.toString()+""},null,null,null);
       // Cursor cs=db.query(Sozluk_kelime.Tablo_Adi,sutunlar,Sozluk_kelime.Sutun_Kelime+"=?",new String[]{Kelime.toString()+""},null,null,null);

                    String anlam=csanlam.getString(cs.getColumnIndex(Anlamlar_Sutun_anlam.toString())).toString();
                    kelimesinifi = new anlam_base_class(kelime_id, kelime,anlam);
                    list__.add(kelimesinifi);
                    return list__;
                }
            }

        }
        return  null;

    }








}
