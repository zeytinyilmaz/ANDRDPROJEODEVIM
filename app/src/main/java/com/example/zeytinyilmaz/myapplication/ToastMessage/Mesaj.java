package com.example.zeytinyilmaz.myapplication.ToastMessage;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ZEYTIN YILMAZ on 7.12.2017.
 */

public class Mesaj {
    public static  enum Sure{
        Uzun,
        Kisa
    }
    public  static  void  ekranaBas(Context sayfa, String Mesaj, Sure sure){
        if (sure.equals(Sure.Kisa)){
            Toast.makeText(sayfa,Mesaj,Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(sayfa,Mesaj,Toast.LENGTH_LONG).show();
        }
    }
}
