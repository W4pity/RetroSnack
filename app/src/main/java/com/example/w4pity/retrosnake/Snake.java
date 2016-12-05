package com.example.w4pity.retrosnake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by W4pity on 02/05/2016.
 */
public class Snake {

    private boolean anim=true;
    private int speed = 1;
    private float x = 0, y = 0;
    private int size = 20;
    private int type=0;
    private int longeur = 1;
     private long oldTimeView;

    private int direction = 0;
    private Paint color = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint color2 = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Snake(int size)
    {
        //this.type = type;
        this.size = size;
        color.setColor(Color.RED);
        color2.setColor(Color.BLACK);
        ;
        direction=1;
        oldTimeView = (new Random()).nextInt(10)*1000000000/2;
    }

    public void update()
    {/*
        if (direction == 1 && x<MainActivity.width) {
            x += speed;
            CustomView.map.map[y][x] = 1;
        }
        if(direction == 2 && y<MainActivity.height-CustomView.marginBottom) {
            y += speed;
            CustomView.map.map[y][x] = 2;
        }
        if(direction == 3 && x>0) {
            x -= speed;
            CustomView.map.map[y][x] = 3;
        }
        if(direction == 4 && y>0) {
            y -= speed;
            CustomView.map.map[y][x] = 4;
        }
        */
    }

    public void draw(Canvas canvas)
    {
        int more = 5;
        if(Options.isImage) {
            Rect r = new Rect((int)(x - size / 2),(int) (y - size / 2), (int)(x - (size / 2) + size), (int)(y - (size / 2) + size));
            Rect r1 = new Rect((int)(x - (size + more) / 2),(int)( y - (more + size) / 2), (int)(x - ((size + more) / 2) + (size + more)), (int)(y - ((size + more) / 2) + (size + more)));
            if (anim)
                if (type == 1)
                    canvas.drawBitmap(MainActivity.tete, null, r1, null);
                else
                    canvas.drawBitmap(MainActivity.corps, null, r, null);
            else {
                if (type == 1)
                    canvas.drawBitmap(MainActivity.tete1, null, r, null);
                else
                    canvas.drawBitmap(MainActivity.corps1, null, r, null);
            }

        }
        else
        {
            if (anim)
            if (type == 1) {
                canvas.drawCircle(x, y, 8 + more, color);
                canvas.drawCircle(x, y, 5 + more, color2);
            }
            else {
                canvas.drawCircle(x, y, 8, color);
                canvas.drawCircle(x, y, 5, color2);
            }
            else {
                if (type == 1) {
                    canvas.drawCircle(x, y, 8, color);
                    canvas.drawCircle(x, y, 5 , color2);
                }
                else {
                    canvas.drawCircle(x, y, 8, color);
                    canvas.drawCircle(x, y, 5, color2);
                }
            }
        }
        if(1000000000/5<System.nanoTime()-oldTimeView) {
            anim = !anim;
            oldTimeView = System.nanoTime();
        }


    }

    public int getSize() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    public void setType(int type)
    {
        this.type=type;
    }
}
