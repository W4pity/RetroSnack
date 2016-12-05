package com.example.w4pity.retrosnake;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by W4pity on 03/05/2016.
 */
public class Options extends AppCompatActivity {

    static  boolean isImage = true;
    static int intervalSnake = 3;
    static Context cont;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_layout);
        cont =this;
        CustomView c = (CustomView) findViewById(R.id.Cv);
       // intervalSnake = c.getSnakes().getSnake().get(0).getSize();
        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isImage = false;
                CustomView.intervalSnake = CustomView.size/8;
                finish();
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isImage = true;
                CustomView.intervalSnake = CustomView.size/6;
                MainActivity.corps = MainActivity.feu;
                MainActivity.corps1 = MainActivity.feu1;
                MainActivity.tete = MainActivity.feuTete;
                MainActivity.tete1 = MainActivity.feuTete1;
                finish();
            }
        });
        Button button3 = (Button) findViewById(R.id.button2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isImage = true;
                CustomView.intervalSnake = CustomView.size/6;
                MainActivity.corps = MainActivity.serpenVert;
                MainActivity.corps1 = MainActivity.serpenVert;
                MainActivity.tete = MainActivity.feuTete;
                MainActivity.tete1 = MainActivity.feuTete1;
                finish();
            }
        });
        Button button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isImage = true;
                CustomView.intervalSnake = CustomView.size/6;
                MainActivity.corps = MainActivity.bleu;
                MainActivity.corps1 = MainActivity.bleu;
                MainActivity.tete = MainActivity.feuTete;
                MainActivity.tete1 = MainActivity.feuTete1;
                finish();
            }
        });
        Button button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isImage = true;
                CustomView.intervalSnake = CustomView.size/6;
                MainActivity.corps = MainActivity.rose;
                MainActivity.corps1 = MainActivity.rose;
                MainActivity.tete = MainActivity.feuTete;
                MainActivity.tete1 = MainActivity.feuTete1;
                finish();
            }
        });
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setting = new Intent(cont, Setting.class);
                cont.startActivity(setting);
            }
        });
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }
}