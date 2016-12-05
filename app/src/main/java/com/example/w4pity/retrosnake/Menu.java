package com.example.w4pity.retrosnake;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    static  boolean isImage = true;
    static int intervalSnake = 3;
    static Context cont;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);
        cont = this;
       // CustomView c = (CustomView) findViewById(R.id.Cv);
        // intervalSnake = c.getSnakes().getSnake().get(0).getSize();
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(cont, MainActivity.class);
                cont.startActivity(menu);
            }
        });
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setting = new Intent(cont, Setting.class);
                cont.startActivity(setting);
            }
        });
        /*Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isImage = true;
                CustomView.intervalSnake = CustomView.size/6;
                MainActivity.corps = MainActivity.feu;
                MainActivity.corps1 = MainActivity.feu1;
                MainActivity.tete = MainActivity.feuTete;
                MainActivity.tete1 = MainActivity.feuTete1;
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
            }
        });*/
    }
}

