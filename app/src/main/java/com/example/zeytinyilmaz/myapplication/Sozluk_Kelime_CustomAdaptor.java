package com.example.zeytinyilmaz.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZEYTIN YILMAZ on 19.12.2017.
 */

public class Sozluk_Kelime_CustomAdaptor extends ArrayAdapter<Sozluk_kelime>{
    private  final  Context context;
    private  ArrayList<Sozluk_kelime> sozluk_;
    private final  LayoutInflater inf_;
    private RecyclerView.ViewHolder holder;
    public Sozluk_Kelime_CustomAdaptor(Context context, List<Sozluk_kelime> sozluk) {
        super(context, 0, sozluk);
        this.context=context;
        this.sozluk_= (ArrayList<Sozluk_kelime>) sozluk;
        this.inf_=LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater infilator=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout lyt=(LinearLayout)infilator.inflate(R.layout.activity_arama_sayfasi,null);
            ListView liste=(ListView)lyt.findViewById(R.id.liste);

        return lyt;
    }
}
