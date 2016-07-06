package com.example.edward.examenborja;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;


import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;

public class Rutas extends AppCompatActivity  {

    private ListView lista;
    private ArrayAdapter<String> adaptador;
    //int[] imagenes={R.drawable.r615,R.drawable.tonala,R.drawable.r615};
    String[] datos= {"Ruta_615 CUTonala", "Ruta_368 CUTonala","Ruta_644 B CUTonala"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InicializacionControles();
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
                String value = (String) adapter.getItemAtPosition(position);

                if (value.equals("Ruta_615 CUTonala")) {
                    ImageView imagen=(ImageView)findViewById(R.id.foto1);
                    imagen.setImageResource(R.drawable.camion1);

                }

                if (value.equals("Ruta_368 CUTonala")) {
                    ImageView imagen=(ImageView)findViewById(R.id.foto1);
                    imagen.setImageResource(R.drawable.camion2);

                }

                if (value.equals("Ruta_644 B CUTonala")) {
                    ImageView imagen=(ImageView)findViewById(R.id.foto1);
                    imagen.setImageResource(R.drawable.camion3);

                }



            }
        });
    }




    private void InicializacionControles() {
        // TODO Auto-generated method stub
        lista = (ListView) findViewById(R.id.ListView01);
        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
