package com.example.edward.examenborja;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class Mensaje extends AppCompatActivity implements GoogleMap.InfoWindowAdapter {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);





    }

    LayoutInflater inflater=null;

    Mensaje(LayoutInflater inflater){
        this.inflater=inflater;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }


    @Override
    public View getInfoContents(Marker marker) {
        View infoWindows =inflater.inflate(R.layout.activity_mensaje,null);
        TextView title=(TextView)infoWindows.findViewById(R.id.title);
        TextView descripcion=(TextView)infoWindows.findViewById(R.id.snippet);

        title.setText(marker.getTitle());
        descripcion.setText(marker.getSnippet());

        return infoWindows;
    }
}
