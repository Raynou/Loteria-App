    package com.example.loteriaapp;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.snackbar.Snackbar;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;



public class MainActivity extends AppCompatActivity {


    private final int REQUEST_CODE_ASK_PERMISSION = 111;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    String namePhoto="";
    Bitmap myTable;
    private ImageView img1;
    private FloatingActionButton generateFab, downloadFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Objects declarations


        init();
        iniciarAdd();

    }

    public void init() {

        ImageView img1 = (ImageView) findViewById(R.id.img1);
        ImageView img2 = (ImageView) findViewById(R.id.img2);
        ImageView img3 = (ImageView) findViewById(R.id.img3);
        ImageView img4 = (ImageView) findViewById(R.id.img4);
        ImageView img5 = (ImageView) findViewById(R.id.img5);
        ImageView img6 = (ImageView) findViewById(R.id.img6);
        ImageView img7 = (ImageView) findViewById(R.id.img7);
        ImageView img8 = (ImageView) findViewById(R.id.img8);
        ImageView img9 = (ImageView) findViewById(R.id.img9);
        ImageView img10 = (ImageView) findViewById(R.id.img10);
        ImageView img11 = (ImageView) findViewById(R.id.img11);
        ImageView img12 = (ImageView) findViewById(R.id.img12);
        ImageView img13 = (ImageView) findViewById(R.id.img13);
        ImageView img14 = (ImageView) findViewById(R.id.img14);
        ImageView img15 = (ImageView) findViewById(R.id.img15);
        ImageView img16 = (ImageView) findViewById(R.id.img16);
        GridLayout gridLayout = (GridLayout) findViewById(R.id.tabla);
        File file = getExternalFilesDir(null);

        //Generar tabla
        generateFab = findViewById(R.id.generateGridFab);
        generateFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TableFill tableFill = new TableFill();
                try {
                    tableFill.mostrarImagenes(img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16);
                    Snackbar.make(view, "New table created!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }catch (Exception e){
                    Snackbar.make(view, e.toString(), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    Log.v("Exception", e.toString());
                }


            }
        });

        //Botón de descarga
        downloadFab = findViewById(R.id.downloadFab);
        downloadFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "El anuncio no ha sido cargado aún.");
                }

                StorageManager storageManager =  new StorageManager(img1, gridLayout, file);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Nombre de la tabla: ");

                //Ticket #1. Partially solved.
                /*Apparently, when the user is typing the name of his table, the keyboard generate a problem when the class take the screen of the GridLayout,
                 a possible solution is show the screen in other activity*/
                final EditText input = new EditText(MainActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                builder.setView(input);


                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Ticket #2.
                        /*A problem appears when the program is trying to validating the content of the variable or of the editText, nothing happens and let the user put a void name, for example*/

                        //Ticket #3
                        //storageManager.saveToGallery(/*Here's go the parameter of the name of the photo who choose the user*/);
                       try {
                            /*Ticket #4. Put here a method for hide the keyboard*/
                           Intent intent = new Intent(MainActivity.this, TableConfirmationActivity.class);
                           Screeenshot screeenshot = new Screeenshot();
                           myTable = screeenshot.tomarCaptura(gridLayout);

                           ByteArrayOutputStream stream = new ByteArrayOutputStream();
                           myTable.compress(Bitmap.CompressFormat.PNG, 100, stream);
                           byte[] byteArray = stream.toByteArray();
                           intent.putExtra("BYTE_ARRAY_IMAGE", byteArray);
                           startActivity(intent);
                       }catch (Exception e){
                           Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                           Log.v("EXCEPTION",e.toString());
                       }

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Do anything
                    }
                });
                AlertDialog myAlert = builder.create();
                myAlert.show();

            }
        });

    }

    //Change the semantics
    private void askPermissions() {
        int permisosDeLecturaDeAlmacenamiento = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permisosDeEscrituraDeAlmacenamiento = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permisosDeLecturaDeAlmacenamiento != PackageManager.PERMISSION_GRANTED || permisosDeEscrituraDeAlmacenamiento != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_ASK_PERMISSION);
            }
        }

    }

    public void iniciarAdd() {
        //Empieza AddMob
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        //Banner
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //Fin del banner

        //Intersitital
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        //Fin del intersitital


        //Termina AddMob
    }



    //Versión parcialmente terminada, falta pulir algunos detalles y profundizar en funcionalidades.

}





