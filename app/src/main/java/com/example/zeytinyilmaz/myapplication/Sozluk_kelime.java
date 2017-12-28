package com.example.zeytinyilmaz.myapplication;

import java.util.ArrayList;

/**
 * Created by ZEYTIN YILMAZ on 14.12.2017.
 */

public class Sozluk_kelime {
    public static final String Tablo_Adi="Kelimeler";
    public static  final String Sutun_ID="id";
    public static  final String Sutun_Kelime="kelime";
    public int kelime_id;
    public  String kelime;
    public String anlam;

    public Sozluk_kelime(int kelime_id, String kelime) {
        this.kelime_id = kelime_id;
        this.kelime = kelime;
    }

    public Sozluk_kelime(int kelime_id, String kelime,String anlam) {
        this.kelime_id = kelime_id;
        this.kelime = kelime;
        this.anlam=anlam;
    }

    public String getAnlam(){

        return this.anlam;
    }
    public Sozluk_kelime(String kelime) {
        this.kelime = kelime;
    }

    public Sozluk_kelime(int kelime_id) {
        this.kelime_id = kelime_id;
    }

    public int getKelime_id() {
        return kelime_id;
    }

    public void setKelime_id(int kelime_id) {
        this.kelime_id = kelime_id;
    }

    public String getKelime() {
        return kelime;
    }

    public void setKelime(String kelime) {
        this.kelime = kelime;
    }
}
