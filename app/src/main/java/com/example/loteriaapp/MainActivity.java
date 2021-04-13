package com.example.loteriaapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
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


import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;



public class MainActivity extends AppCompatActivity {


    private final int REQUEST_CODE_ASK_PERMISSION = 111;
    String rutaImagen;


    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    //private Button btnDownload, btnGenerate, btnNewGrid, btnGuardar;
    private ImageView img1;
    public boolean clicked = false;
    private FloatingActionButton newGridFab, generateFab, downloadFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicio();
        iniciarAdd();

    }

    //If you commit any mistake you can comeback to the past commit or simply see the fabFinal branch, the changes made here gonna going to be review and merge first the floatButtonXML and after the floatButtonJava IN THAT ORDER
    public void inicio() {

        img1 = (ImageView) findViewById(R.id.img1);



        /*btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "El anuncio no ha sido cargado aún.");
                }

            }
        });


        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarImagenes();
            }
        });


        btnNewGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Guardar imágen
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //guardarImagen();
                saveToGallery();

            }
        });*/

        //Nuevo grid???
        newGridFab = findViewById(R.id.newGridFab);
        newGridFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's the new grid FAB!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Generar tabla
        generateFab = findViewById(R.id.generateGridFab);
        generateFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's the generate grid FAB!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mostrarImagenes();

            }
        });

        //Botón de descarga
        downloadFab = findViewById(R.id.downloadFab);
        downloadFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Tabla guardada en su teléfono", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "El anuncio no ha sido cargado aún.");
                }
                saveToGallery();
            }
        });

    }

    private void pedirPermisos() {
        int permisosDeLecturaDeAlmacenamiento = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permisosDeEscrituraDeAlmacenamiento = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permisosDeLecturaDeAlmacenamiento != PackageManager.PERMISSION_GRANTED || permisosDeEscrituraDeAlmacenamiento != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_ASK_PERMISSION);
            }
        }

    }


    public void mostrarImagenes() {

        //Objects declarations
        ImageView img1 = findViewById(R.id.img1);
        ImageView img2 = findViewById(R.id.img2);
        ImageView img3 = findViewById(R.id.img3);
        ImageView img4 = findViewById(R.id.img4);
        ImageView img5 = findViewById(R.id.img5);
        ImageView img6 = findViewById(R.id.img6);
        ImageView img7 = findViewById(R.id.img7);
        ImageView img8 = findViewById(R.id.img8);
        ImageView img9 = findViewById(R.id.img9);
        ImageView img10 = findViewById(R.id.img10);
        ImageView img11 = findViewById(R.id.img11);
        ImageView img12 = findViewById(R.id.img12);
        ImageView img13 = findViewById(R.id.img13);
        ImageView img14 = findViewById(R.id.img14);
        ImageView img15 = findViewById(R.id.img15);
        ImageView img16 = findViewById(R.id.img16);

        //Set scale type for imageViews
        img1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img3.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img4.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img5.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img6.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img7.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img8.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img9.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img10.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img11.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img12.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img13.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img14.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img15.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img16.setScaleType(ImageView.ScaleType.CENTER_CROP);



        //Array de valores aleatorios
        int numeros[] = new int[16];

        int imagenes[] =
                {R.drawable.num1, R.drawable.num2, R.drawable.num3, R.drawable.num4, R.drawable.num5,
                        R.drawable.num6, R.drawable.num7, R.drawable.num8, R.drawable.num9, R.drawable.num10,
                        R.drawable.num11, R.drawable.num12, R.drawable.num13, R.drawable.num14, R.drawable.num15, R.drawable.num16, R.drawable.num17};
        ImageView imageViews[] = {img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16};
        introducirValoresEnArray(numeros);


        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i].setImageResource(imagenes[numeros[i]]);
        }


    }

    public static int[] introducirValoresEnArray(int arrayBase[]) {
        Random num = new Random();
        int aux;
        for (int i = 0; i < arrayBase.length; i++) {
            aux = num.nextInt(17);

            while (filtro(aux, i, arrayBase)) {
                aux = num.nextInt(17);
            }
            arrayBase[i] = aux;
        }

        Arrays.sort(arrayBase);
        return arrayBase;
    }

    private static boolean filtro(int aux, int i, int arrayBase[]) {
        for (int x = 0; x < i; x++) {
            if (arrayBase[x] == aux) {
                return true;
            }
        }
        return false;
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

    private void saveToGallery(){
        img1 = (ImageView) findViewById(R.id.img1);
        GridLayout grid = (GridLayout) findViewById(R.id.tabla);
        Bitmap b = Screeenshot.tomarCaptura(grid);
        img1.setImageBitmap(b);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) img1.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();

        FileOutputStream outputStream = null;
        File file = getExternalFilesDir(null);
        File dir = new File(file.getAbsolutePath() + "/MyPics");
        dir.mkdirs();

        String filename = String.format("%d.png",System.currentTimeMillis());
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

    //Versión parcialmente terminada, falta pulir algunos detalles y profundizar en funcionalidades.


    /*private void mostrarBotoner(boolean clicked){
        if (clicked==true){
            downloadBtn.setVisibility(View.VISIBLE);
            generateGridBtn.setVisibility(View.VISIBLE);
            newGridBtn.setVisibility(View.VISIBLE);
        }else{
            downloadBtn.setVisibility(View.INVISIBLE);
            generateGridBtn.setVisibility(View.INVISIBLE);
            newGridBtn.setVisibility(View.INVISIBLE);
        }

    }*/
}





