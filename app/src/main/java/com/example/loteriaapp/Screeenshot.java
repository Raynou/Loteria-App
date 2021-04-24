package com.example.loteriaapp;

import android.graphics.Bitmap;
import android.view.View;

public class Screeenshot {
    public static Bitmap takeScreenShot(View v){
        v.setDrawingCacheEnabled(true);
        v.buildDrawingCache(true);
        Bitmap b = Bitmap.createBitmap((v.getDrawingCache()));
        v.setDrawingCacheEnabled(false);
        return b;
    }

    public static Bitmap tomarCapturaDeVistaRaíz(View v){
        return takeScreenShot(v.getRootView());
    }
}
