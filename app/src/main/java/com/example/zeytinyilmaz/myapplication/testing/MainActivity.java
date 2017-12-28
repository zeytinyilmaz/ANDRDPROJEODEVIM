package com.example.zeytinyilmaz.myapplication.testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.zeytinyilmaz.myapplication.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arama_);

    }








    private void openAyarla(){}
    private void openKelimeler(){}
    private void openExit(){

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator=getMenuInflater();
        inflator.inflate(R.menu.menum,menu);
        return super.onCreateOptionsMenu(menu);
    }




}
