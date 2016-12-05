package com.example.w4pity.retrosnake;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by W4pity on 02/05/2016.
 */
public class CustomView extends View {

    
    public static int score = 0, topscore = 0;
    private boolean isStarted = false;
    public static boolean isDead = false;
    private  int touchX, touchY;
    private SnakeBig snakes;
    public static Map map;
    MediaPlayer md;
    int idSong;
    static int size;
   static int intervalSnake;
    private Paint color = new Paint(Paint.ANTI_ALIAS_FLAG);
    public CustomView(Context c) {
        super(c);
    }
    public CustomView(Context c, AttributeSet as) {
        super(c, as);
        color.setColor(Color.WHITE);
        idSong = R.raw.tac;
        md = MediaPlayer.create(c, idSong);
        md.start();




    }
    public CustomView(Context c, AttributeSet as, int default_style) {
        super(c, as, default_style);
        
    }

    public void init()
    {
        snakes = new SnakeBig();
        map = new Map();
        size = MainActivity.width/30;
       intervalSnake =size/6*2;
       // Log.d("tititeinit", "init "+intervalSnake);

    }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(!isStarted)
        {
            init();
            canvas.drawBitmap(MainActivity.intro, null, new Rect(0, 0, MainActivity.width, MainActivity.height), null);

            invalidate();
           // intervalSnake = snakes.getSnake().get(0).getSize();
        }
        else
        {

            drawEntity(canvas);
            if(!isDead)
                update();
            else
            {
                canvas.drawBitmap(MainActivity.loose,null, new Rect(0, 100,MainActivity.width, MainActivity.height -200), null);

            }
            invalidate();
            if(!md.isPlaying())
                md.start();
        }

    }

    public void drawEntity(Canvas canvas)
    {
        String a =" "+ getResources().getString(R.string.top_score);
        String b = getResources().getString(R.string.your_Score);
        map.draw(canvas);
        color.setTextSize(30);
        canvas.drawText(b+": "+score+a+": "+topscore,10, MainActivity.height-MainActivity.marginBottom+50,  color);
       // canvas.drawText("Top Score: "+topscore,10, MainActivity.height-MainActivity.marginBottom+90,  color);
        snakes.draw(canvas);
        map.draw1(canvas);
    }

    public void update()
    {
        snakes.update();
    }



    public void resetGame()
    {
        if(score >topscore)
            topscore = score;
        isDead = false;
        score = 0;
        md.start();
        init();
    }


    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            if(!isStarted) {
                isStarted = true;
                md.start();
            }
            touchX = (int) event.getX();
            touchY = (int) event.getY();
            if(touchY >200 && isDead) {
                resetGame();
               
            }
            if(touchY <MainActivity.height*200/540 && isDead) {
                Intent I_News = new Intent(MainActivity.contextMain, Options.class);
                MainActivity.contextMain.startActivity(I_News);
            }
                invalidate();
            return true;
        }
        if (event.getActionMasked() == MotionEvent.ACTION_UP) {
            int dir = viewDirection((int) event.getX(), (int) event.getY(), touchX, touchY);
            if (dir == 1 && snakes.getDirection()!=3)
                snakes.setDirection(1);
            if (dir == 2 &&snakes.getDirection()!=4)
                snakes.setDirection(2);
            if (dir == 3 &&  snakes.getDirection()!=1)
                snakes.setDirection(3);
            if (dir == 4 && snakes.getDirection()!=2)
                snakes.setDirection(4);


            invalidate();
            return true;
        }
        return super.onTouchEvent(event);
    }

    public int viewDirection(int x, int y, int oldX, int oldY) {
       // Log.d("resultaaa", "viewDirection " + x + " " + y + " " + oldX + " " + oldY + " ");
        if(x-oldX>0)
            if(oldY-y>0)
                return (oldY - y) >= (x - oldX)?4:1;
            else
                return (x - oldX) >= (y - oldY)?1:2;
        else
        if(oldY-y>0)
            return (oldX - x) >= (oldY - y)?3:4;
        else
            return (oldX - x) >= (y - oldY)?3:2;
    }

    public SnakeBig getSnakes()
    {
        return snakes;
    }


}
