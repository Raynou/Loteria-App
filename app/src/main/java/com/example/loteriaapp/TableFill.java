package com.example.loteriaapp;

import android.widget.ImageView;
import java.util.Arrays;
import java.util.Random;

public class TableFill{

    public void mostrarImagenes(ImageView img1, ImageView img2, ImageView img3, ImageView img4, ImageView img5, ImageView img6, ImageView img7, ImageView img8,
                                ImageView img9, ImageView img10, ImageView img11, ImageView img12, ImageView img13, ImageView img14, ImageView img15, ImageView img16) {
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


}
