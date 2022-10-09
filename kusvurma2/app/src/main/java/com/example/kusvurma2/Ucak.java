package com.example.kusvurma2;

import static com.example.kusvurma2.OyunEkrani.ekranBuyuklukX;
import static com.example.kusvurma2.OyunEkrani.ekranBuyuklukY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Ucak {

    int x , y , genislik, yükseklik, kanatHareketi = 0 ;
    Bitmap ucak1, ucak2;

    Ucak(int ekranY , Resources res) {
        ucak1= BitmapFactory.decodeResource(res,R.drawable.ucak1);
        ucak2= BitmapFactory.decodeResource(res,R.drawable.ucak2);

        genislik = ucak1.getWidth();
        yükseklik = ucak1.getHeight();

        genislik/=4;
        yükseklik/=4;

        genislik *= (int) ekranBuyuklukX;
        yükseklik *= (int) ekranBuyuklukY;

        ucak1 = Bitmap.createScaledBitmap(ucak1,yükseklik,genislik,false);
        ucak2 = Bitmap.createScaledBitmap(ucak2,yükseklik,genislik,false);

        y = ekranY /2;
        x = (int) (64* ekranBuyuklukX);


    }
    //uçağı yukarı aşağı hareket ettirme

    Bitmap getucak(){
        if (kanatHareketi == 0){
            kanatHareketi++;
            return ucak1;
        }
        kanatHareketi--;
        return ucak2;



    }

}
