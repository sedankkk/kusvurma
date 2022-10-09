package com.example.kusvurma2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

public class OyunEkrani<paint> extends SurfaceView implements Runnable {
    private Thread thread;
    private boolean isPlaying;
    private int ekranX, ekranY;
    public static float ekranBuyuklukX, ekranBuyuklukY;
    private Arkaplan arkaplan1, arkaplan2;
    private Ucak ucak;
    private Paint paint;



    public OyunEkrani(Context context, int ekranX , int ekranY) {
        super(context);

        this.ekranX = ekranX;
        this.ekranY = ekranY;
        ekranBuyuklukX = 1920f / ekranX;
        ekranBuyuklukY = 1000f/ ekranY;



        arkaplan1 = new Arkaplan( ekranX,ekranY ,getResources());
        arkaplan2 = new Arkaplan( ekranX, ekranY, getResources());


        arkaplan2.x = ekranX;
        paint = new Paint();

    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void run() {
        while (isPlaying){
            update();
            draw();
            sleep();

        }

    }




    @RequiresApi(api = Build.VERSION_CODES.Q)
    private void update(){
        arkaplan1.x -= 10 * ekranBuyuklukX;
        arkaplan2.x -= 10 * ekranBuyuklukX;

        if (arkaplan1.x + arkaplan1.arkaplan.getWidth()<0){
            arkaplan1.x= ekranX;
        }
        if (arkaplan2.x + arkaplan2.arkaplan.getWidth()<0){
            arkaplan2.x= ekranX;
        }

        }
        private void draw() {
        if( getHolder().getSurface().isValid()){
            Canvas canvas= getHolder().lockCanvas();
            canvas.drawBitmap(arkaplan1.arkaplan, arkaplan1.x,arkaplan1.y,paint);
            canvas.drawBitmap(arkaplan2.arkaplan, arkaplan2.x,arkaplan2.y,paint);

            getHolder().unlockCanvasAndPost(canvas);


        }}


    private void sleep(){
        try {
            thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume(){
        isPlaying = true;
        thread = new Thread(this);
        thread.start();

    }
    public void pause(){
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
