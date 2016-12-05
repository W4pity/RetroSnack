package com.example.w4pity.retrosnake;

import android.app.VoiceInteractor;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by W4pity on 02/05/2016.
 */


/*
2 --- 540
        x

   240
480
 */
public class SnakeBig {
    private int direction = 1;
    private float speed = 2, saveSpeed = 2;
    ArrayList<Snake> snakes = new ArrayList<>();
    public Rect tete;
    private MediaPlayer md;
    int size;
    int idSong;
    MediaPlayer mdP, mdM;
    public SnakeBig() {
        speed =(float) MainActivity.width*2/540f;
        saveSpeed = speed;
        size = MainActivity.width/30;
        for (int i = 0; i < 40; i++) {
            snakes.add(new Snake(size));
            snakes.get(i).setX(-i * 10 + 200);
            snakes.get(i).setY(200);
            if (i == 0)
                snakes.get(i).setType(1);
        }
        idSong = R.raw.oui;
        int idPomme = R.raw.pomme;
        int idMort = R.raw.mort;
        mdM = MediaPlayer.create(MainActivity.contextMain, idMort);
        md = MediaPlayer.create(MainActivity.contextMain, idSong);
        mdP = MediaPlayer.create(MainActivity.contextMain, idPomme);
        //md.start();
        //tete = new Rect(snakes.get(0).getX(), snakes.get(0).getY(),snakes.get(0).getX()+snakes.get(0).getSize(), snakes.get(0).getY()+ snakes.get(0).getSize());
       // Toast.makeText(MainActivity.contextMain,"speed = "+speed, Toast.LENGTH_LONG).show();
    }


    /*
        660----30
        484

    */


    public void update() {
      //  Log.d("titite", "update " + Map.map.length);
        int x =(int) (snakes.get(0).getX()+snakes.get(0).getSize()/2) * Map.size / MainActivity.width;
        int y =(int)( snakes.get(0).getY()+snakes.get(0).getSize()/2 )* Map.size / (MainActivity.height - MainActivity.marginBottom);
        if (Map.map[y][x] == 1) {
            for (int i = 0; i < CustomView.intervalSnake; i++)
                snakes.add(new Snake(size));
            Map.map[y][x] = 0;
            Map.map[(new Random()).nextInt(Map.size)]
                    [(new Random()).nextInt(Map.size)] = (new Random()).nextInt(3) + 1;
            CustomView.score += 1;
            speed = saveSpeed;
            md.start();
        } else if (Map.map[y][x] == 2) {
            for (int i = 0; i < CustomView.intervalSnake*2; i++)
                snakes.add(new Snake(size));
            Map.map[y][x] = 0;
            Map.map[(new Random()).nextInt(Map.size)]
                    [(new Random()).nextInt(Map.size)] = (new Random()).nextInt(3) + 1;
            CustomView.score += 1;
            speed = saveSpeed;
            md.start();
        } else if (Map.map[y][x] == 3) {
            for (int i = 0; i < CustomView.intervalSnake; i++)
                snakes.add(new Snake(size));
            Map.map[y][x] = 0;
            Map.map[(new Random()).nextInt(Map.size)]
                    [(new Random()).nextInt(Map.size)] = (new Random()).nextInt(3) + 1;
            CustomView.score += 1;
            speed = saveSpeed*2;
            mdP.start();
        }

        if (direction == 1 && snakes.get(0).getX() < MainActivity.width -speed) {
            snakes.get(0).setX(snakes.get(0).getX() + speed);
            //CustomView.map.map[y][x] = 1;
        } else if (direction == 2 && snakes.get(0).getY() < MainActivity.height - MainActivity.marginBottom -speed) {
            snakes.get(0).setY(snakes.get(0).getY() + speed);
            //CustomView.map.map[y][x] = 2;
        } else if (direction == 3 && snakes.get(0).getX() > speed) {
            snakes.get(0).setX(snakes.get(0).getX() - speed);
            //CustomView.map.map[y][x] = 3;
        } else if (direction == 4 && snakes.get(0).getY() > speed) {
            snakes.get(0).setY(snakes.get(0).getY() - speed);
            //CustomView.map.map[y][x] = 4;
        } else {
            CustomView.isDead = true;
            mdM.start();

        }


        for (int i = snakes.size() - 1; i > 0; i--) {
         //   Log.d("taille", "update " + snakes.size() + "position: " + snakes.get(0).getY() / Map.size);
            snakes.get(i).setX(snakes.get(i - 1).getX());
            snakes.get(i).setY(snakes.get(i - 1).getY());
        }
        int padding = 6;
        if (snakes.size() > 25)
            for (int i = 40; i < snakes.size(); i++)
                if (snakes.get(0).getY() * Map.size / MainActivity.height - MainActivity.marginBottom == (snakes.get(i).getY() * (Map.size) / MainActivity.height - MainActivity.marginBottom)
                        && snakes.get(0).getX() * Map.size / MainActivity.width == snakes.get(i).getX() * Map.size / MainActivity.width)
                    CustomView.isDead = true;

    }

    public void draw(Canvas canvas) {

        for (int i = 0; i < snakes.size(); i +=size/4/*CustomView.intervalSnake/speed+1*/)

            snakes.get(i).draw(canvas);
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    public ArrayList<Snake> getSnake()
    {
        return snakes;
    }
}
