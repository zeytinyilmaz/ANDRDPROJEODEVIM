package com.example.zeytinyilmaz.myapplication;

/**
 * Created by ZEYTIN YILMAZ on 22.12.2017.
 */

public class anlam_base_class {
    public int id;
    public String Kelime;
    public String Anlam;

    public anlam_base_class(int id, String kelime, String anlam) {
        this.id = id;
        Kelime = kelime;
        Anlam = anlam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKelime() {
        return Kelime;
    }

    public void setKelime(String kelime) {
        Kelime = kelime;
    }

    public String getAnlam() {
        return Anlam;
    }

    public void setAnlam(String anlam) {
        Anlam = anlam;
    }
}
