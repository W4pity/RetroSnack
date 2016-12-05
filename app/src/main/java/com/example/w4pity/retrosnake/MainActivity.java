package com.example.w4pity.retrosnake;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static int marginBottom = 300;
    static int width, height, density;
    public static Bitmap corps, corps1, tete, tete1, grass1, barriere,serpenVert, pelle, feu, feu1, feuTete, feuTete1, intro, oree, pomme, pomme1, retro, loose, rose, bleu;
    static Context contextMain;
    static MediaPlayer md;
    static boolean sound = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contextMain = this;

        loadTexture();
        feu = corps;
        feu1 = corps1;
        feuTete = tete;
        feuTete1 = tete1;
        setContentView(R.layout.activity_main);
        Display d = getWindowManager().getDefaultDisplay();
        DisplayMetrics dm = getResources().getDisplayMetrics();
        density = dm.densityDpi;
        int wp = dm.widthPixels;
        CustomView c = (CustomView)findViewById(R.id.Cv);
        width = dm.widthPixels;
        height =dm.heightPixels;
        c.setBackgroundColor(Color.BLACK);
       // Toast.makeText(this, "size = "+width+" density "+ density+" wp: "+wp, Toast.LENGTH_LONG).show();
        int idSong = R.raw.tac;
        md = MediaPlayer.create(this, idSong);
        //if(!sound)
            md.setVolume(0,0);


        md.start();
       // Log.d("titite", "onCreate "+width);

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

    public void loadTexture()
    {
        int corpsID = R.drawable.feu;
        int corps1ID = R.drawable.feu1;
        int teteID = R.drawable.tete;
        int tete1ID = R.drawable.tete1;
        int grassID = R.drawable.sol;
        int barriereID = R.drawable.barriere;
        int serpenVertID = R.drawable.serpent_vert;
        int pelleID = R.drawable.pelle;

        int introID = R.drawable.intro;
        int oreeID = R.drawable.oree;
        int pommeID = R.drawable.pomme;
        int pomme1ID = R.drawable.pomme2;
        int retroID = R.drawable.retro;
        int looseID = R.drawable.loose;
        int roseID = R.drawable.serpent_rose;
        int bleuID = R.drawable.serpent_bleu;
        bleu = BitmapFactory.decodeResource(getResources(), bleuID);
        rose = BitmapFactory.decodeResource(getResources(), roseID);
        loose = BitmapFactory.decodeResource(getResources(), looseID);
        retro = BitmapFactory.decodeResource(getResources(), retroID);
        pomme = BitmapFactory.decodeResource(getResources(), pommeID);
        pomme1 = BitmapFactory.decodeResource(getResources(), pomme1ID);
        oree = BitmapFactory.decodeResource(getResources(), oreeID);
        intro = BitmapFactory.decodeResource(getResources(), introID);
        pelle = BitmapFactory.decodeResource(getResources(), pelleID);
        serpenVert = BitmapFactory.decodeResource(getResources(), serpenVertID);
        barriere = BitmapFactory.decodeResource(getResources(), barriereID);
        grass1 = BitmapFactory.decodeResource(getResources(), grassID);
        corps = BitmapFactory.decodeResource(getResources(), corpsID);
        corps1 = BitmapFactory.decodeResource(getResources(), corps1ID);
        tete = BitmapFactory.decodeResource(getResources(), teteID);
        tete1 = BitmapFactory.decodeResource(getResources(), tete1ID);
    }
}
