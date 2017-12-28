package com.example.zeytinyilmaz.myapplication;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zeytinyilmaz.myapplication.Sozluk_kelime;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ZEYTIN YILMAZ on 14.12.2017.
 */

public class Sozluk_Kelime_Adapter extends BaseAdapter {
    Context context;
    ArrayList<Sozluk_kelime> veriKaynagi=new ArrayList<>();


    public Sozluk_Kelime_Adapter(Context context, ArrayList<Sozluk_kelime> veriKaynagi) {
        this.context = context;
        this.veriKaynagi = veriKaynagi;
    }

    @Override
    public int getCount() {
        return veriKaynagi.size();
    }

    @Override
    public Object getItem(int i) {
        return veriKaynagi.get(i);
    }

    @Override
    public long getItemId(int i) {
        Sozluk_kelime sozluk=veriKaynagi.get(i);
        if (sozluk==null)
        {
            return 0;
        }
        else {
            return  sozluk.getKelime_id();
        }


    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Sozluk_kelime kelime = veriKaynagi.get(position);
        TextView tv = new TextView(context);
        tv.setText(kelime.getKelime());
        tv.setTextSize(26);
        tv.setTextColor(Color.WHITE);
        //tv.setTextColor(ColorStateList.valueOf(10));
        return tv;
    }
}
