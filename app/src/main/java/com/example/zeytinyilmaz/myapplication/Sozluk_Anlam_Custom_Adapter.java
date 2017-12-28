package com.example.zeytinyilmaz.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zeytinyilmaz.myapplication.R;
import com.example.zeytinyilmaz.myapplication.Sozluk_kelime;

import java.util.ArrayList;

/**
 * Created by ZEYTIN YILMAZ on 22.12.2017.
 */

public class Sozluk_Anlam_Custom_Adapter extends ArrayAdapter<anlam_base_class> {

    private  final Context context;
    private ArrayList<anlam_base_class> sozluk_;
    //private final LayoutInflater inf_;
    private RecyclerView.ViewHolder holder;

    public Sozluk_Anlam_Custom_Adapter(Context context,ArrayList<anlam_base_class> sozluk_) {
        super(context,0,sozluk_);
        this.context = context;
        this.sozluk_ = sozluk_;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater infilator=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout lyt=(LinearLayout)infilator.inflate(R.layout.activity_anlam,null);
        TextView liste=(TextView)lyt.findViewById(R.id.anlamyazilacak_alan);
        return lyt;
    }
}
