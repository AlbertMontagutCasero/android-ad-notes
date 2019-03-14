package com.montagut.casero.albert.test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    // Declarar variable contenedora de un contenedor de anuncios
    private AdView adViewTop;
    private AdView adViewBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Inicializar modulo de ads
        MobileAds.initialize(this, "ca-app-pub-1661379239296772~8355807797");

        // Crear un banner de anuncios
        adViewTop = new AdView(this);
        adViewTop.setAdSize(AdSize.BANNER);
        adViewTop.setAdUnitId("ca-app-pub-3940256099942544~3347511713");

        adViewBottom = findViewById(R.id.bottom_banner);
        AdRequest adrequest = new AdRequest.Builder().build();
        adViewBottom.loadAd(adrequest);

        // anadimos funciones de callback
        adViewTop.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Log.d("ad", "onAdLoaded: add loaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d("ad", "something goes bad error code : "+ errorCode);
            }

            @Override
            public void onAdOpened() {
                Log.d("ad", "onAdLoaded: the add is open ");
            }

            @Override
            public void onAdLeftApplication() {
                Log.d("ad", "onAdLoaded: add removed");

            }

            @Override
            public void onAdClosed() {
                Log.d("ad", "onAdLoaded: add closed by user");
            }
        });
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
