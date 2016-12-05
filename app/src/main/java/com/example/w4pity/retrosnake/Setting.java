package com.example.w4pity.retrosnake;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class Setting extends AppCompatActivity {
    static Context cont;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_setting);

        cont = this;
        // CustomView c = (CustomView) findViewById(R.id.Cv);
        // intervalSnake = c.getSnakes().getSnake().get(0).getSize();
        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent about = new Intent(cont, About.class);
                cont.startActivity(about);
            }
        });
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        /*final Switch s = (Switch) findViewById(R.id.switch1);
        s.setChecked(MainActivity.sound);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!s.isChecked()) {
                    MainActivity.sound = false;
                    MainActivity.md.setVolume(0, 0);
                } else {
                    MainActivity.md.setVolume(100, 100);
                    MainActivity.sound=true;
                }
            }
        });*/
      /*
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

