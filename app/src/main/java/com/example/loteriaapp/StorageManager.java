package com.example.loteriaapp;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;

public class StorageManager {
    public ImageView myImg;
    public File myDir;
    public Bitmap bitmap;

    public StorageManager(){
        this.myImg = null;
        this.bitmap = null;
        this.myDir = null;
    }

    public StorageManager(ImageView myImg, Bitmap bitmap, File myDir){
        this.myImg = myImg;
        this.bitmap = bitmap;
        this.myDir = myDir;
    }
   public void saveToGallery(String namePhoto){
        myImg.setImageBitmap(bitmap);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) myImg.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        FileOutputStream outputStream = null;
        File dir = new File(myDir.getAbsolutePath() + "/MyPics");
        dir.mkdirs();

        String filename = String.format(namePhoto +".png",System.currentTimeMillis());
        File outFile = new File(dir,filename);
        try{
            outputStream = new FileOutputStream(outFile);
        }catch (Exception e){
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
        try{
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            outputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
