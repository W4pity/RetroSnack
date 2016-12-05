package com.example.w4pity.retrosnake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.util.Log;

/**
 * Created by W4pity on 02/05/2016.
 */
public class Map {
    private int width;
    private int height;
    static int[][] map;
    static int size;
    float ratio = 0;
    private Paint color = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint red, blue, yellow, black;

    public Map() {
        size =30;

        red = new Paint(Paint.ANTI_ALIAS_FLAG);
        blue = new Paint(Paint.ANTI_ALIAS_FLAG);
        black =  new Paint(Paint.ANTI_ALIAS_FLAG);
        yellow =  new Paint(Paint.ANTI_ALIAS_FLAG);
        red.setColor(Color.RED);
        yellow.setColor(Color.YELLOW);
        black.setColor(Color.BLACK);
        blue.setColor(Color.BLUE);
        ratio = (MainActivity.height-MainActivity.marginBottom)/MainActivity.width;
        width = MainActivity.width/(size);


        height = (MainActivity.height-MainActivity.marginBottom)/(size);
        //Log.d("tititesize", "Map "+size+10+" " +size);


        map = new int[(int)(size+10)][size];


        color.setColor(Color.GREEN);
        for(int i = 0; i<size; i++)
            for(int j=0; j<size; j++)
                map[i][j] = 0;
        map[2][3] = 1;
        }

    public void update()
    {

    }

    public void draw(Canvas canvas)
    {
        //if (map[i][j] == 0)
           // canvas.drawBitmap(MainActivity.grass, null,  new Rect(0,0, MainActivity.width,MainActivity.height), null);
        int caseMore = 3;
        for(int i = 0; i<size; i++)
            for(int j=0; j<size; j++) {

                Rect r = new Rect(j*width*caseMore,i* height*caseMore, j*width*caseMore+width*caseMore, i*height*caseMore  + height*caseMore);
                Rect r1 = new Rect(j*width,i* height, j*width+width, i*height  + height);
                Rect r2 = new Rect(j*width-30,i* height-30, j*width+width+30, i*height  + height+30);
                if(i*caseMore<size && j*caseMore<size)
                    canvas.drawBitmap(MainActivity.grass1, null, r, null);

                if (map[i][j] == 1) {

                    canvas.drawBitmap(MainActivity.oree, null, r2, null);
                    canvas.drawBitmap(MainActivity.corps, null, r1, null);

                }
                else  if (map[i][j] == 2) {

                    canvas.drawBitmap(MainActivity.oree, null, r2, null);
                    canvas.drawBitmap(MainActivity.pomme, null, r1, null);

                }
                else  if (map[i][j] == 3) {

                    canvas.drawBitmap(MainActivity.oree, null, r2, null);
                    canvas.drawBitmap(MainActivity.pomme1, null, r1, null);

                }


            }
        canvas.drawBitmap(MainActivity.retro, null,new Rect(0,0,MainActivity.width, MainActivity.height-MainActivity.marginBottom+30), null);
        //canvas.drawRect(0, height*size, width*size,( height*size+MainActivity.marginBottom), color );

    }

    public void  draw1(Canvas canvas)
    {
        canvas.drawBitmap(MainActivity.barriere,null, new Rect(0, height*size-100,width*size,height*size+20 ), null);
        //canvas.drawBitmap(MainActivity.table,null, new Rect(width*size-400, 0,width*size, 100 ), null);
        canvas.drawBitmap(MainActivity.pelle,null, new Rect(-100, height*size-300,300-100, height*size +30), null);

    }
}
