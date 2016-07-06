package com.example.edward.examenborja;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Marker;

import java.io.IOException;


public class MapsActivity extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener {

    private GoogleMap Mapa; // Might be null if Google Play services APK is not available.



    public Marker Marcador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();




    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #Mapa} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (Mapa == null) {
            // Try to obtain the map from the SupportMapFragment.
            Mapa = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (Mapa != null) {
                try {
                    setUpMap();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setUpMap() throws IOException {

        //se crean los elementos  para el zoom y activar los controles
        UiSettings mapSettings;
        mapSettings = Mapa.getUiSettings();
        mapSettings.setZoomControlsEnabled(true);

        //se crea una variable que contiene la localizacion gps
        LatLng CutonalaUbicacion = new LatLng(20.5659959,-103.2263966);

        //al marcador le agregamoss elementos para que muestre el titulo y la informacion
        Marker Marcador = Mapa.addMarker(new MarkerOptions()
                        .position(CutonalaUbicacion)
                        .title("Centro universitario de tonala")
                        .snippet("Av. Nuevo Periférico No. 555" + "\n" + "Ejido San José Tateposco" + "\n" + "cp.48525 Tonalá, Jal." + "\n" + "Telefono:01 33 3540 3020" + "\n" + "" + "\n" + "Click para ver rutas de camion")

                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        );

        //Aqui mandamos llamar al adaptador de la clase Mensaje que contiene las caracteristicas
        Mapa.setInfoWindowAdapter(new Mensaje(getLayoutInflater()));

        //aqui se le indica que la camara tiene que posicionarse sobre la ubicacion designada
        Mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(CutonalaUbicacion, 7));

        //aqui se activa el listener para el infowindow
        Mapa.setOnInfoWindowClickListener(this);



    }

//aqui son las acciones al ser presionado el infowindow
    @Override
    public void onInfoWindowClick(Marker marker) {

        Intent intent = new Intent(MapsActivity.this, Rutas.class);
        startActivity(intent);
      //  Toast.makeText(getApplicationContext(), "this is my Toast message!!! =)",
                 //   Toast.LENGTH_LONG).show();

    }
}
