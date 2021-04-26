package com.example.loteriaapp;

import android.widget.ImageView;
import java.util.Arrays;
import java.util.Random;

public class TableFill{

    public void showImages(ImageView img1, ImageView img2, ImageView img3, ImageView img4, ImageView img5, ImageView img6, ImageView img7, ImageView img8,
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



        //Arr for the random numbers
        int numbers[] = new int[16];

        int images[] =
                {R.drawable.num20, R.drawable.num21,R.drawable.num22,R.drawable.num25,R.drawable.num26,R.drawable.num30,R.drawable.num32,R.drawable.num33,
                R.drawable.num34, R.drawable.num37, R.drawable.num38,R.drawable.num39,R.drawable.num41,R.drawable.num48,R.drawable.num50,R.drawable.num51,R.drawable.num52,
                R.drawable.num6, R.drawable.num9, R.drawable.num10, R.drawable.num11, R.drawable.num13, R.drawable.num14, R.drawable.num15, R.drawable.num17,R.drawable.num18,
                R.drawable.num19, R.drawable.num53, R.drawable.num54, R.drawable.num1, R.drawable.num5, R.drawable.num7, R.drawable.num8, R.drawable.num12, R.drawable.num24,
                R.drawable.num27, R.drawable.num29, R.drawable.num31, R.drawable.num35, R.drawable.num40, R.drawable.num44, R.drawable.num45, R.drawable.num47, R.drawable.num49,
                R.drawable.num2, R.drawable.num3, R.drawable.num4,R.drawable.num16,R.drawable.num23,R.drawable.num28,R.drawable.num36,R.drawable.num42,R.drawable.num43,R.drawable.num46};
        /*int imagenes[] =
                {R.drawable.num1, R.drawable.num2, R.drawable.num3, R.drawable.num4, R.drawable.num5,
                        R.drawable.num6, R.drawable.num7, R.drawable.num8, R.drawable.num9, R.drawable.num10,
                        R.drawable.num11, R.drawable.num12, R.drawable.num13, R.drawable.num14, R.drawable.num15, R.drawable.num16, R.drawable.num17};*/
        ImageView imageViews[] = {img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16};
        setValuesToTheArray(numbers);


        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i].setImageResource(images[numbers[i]]);
        }


    }

    //Generates random numbers and put him on the array
    public static int[] setValuesToTheArray(int baseArray[]) {
        Random num = new Random();
        int aux;
        for (int i = 0; i < baseArray.length; i++) {
            aux = num.nextInt(54);

            while (filter(aux, i, baseArray)) {
                aux = num.nextInt(54);
            }
            baseArray[i] = aux;
        }

        Arrays.sort(baseArray);
        return baseArray;
    }

    //This method filters the repeated numbers
    private static boolean filter(int aux, int i, int baseArray[]) {
        for (int x = 0; x < i; x++) {
            if (baseArray[x] == aux) {
                return true;
            }
        }
        return false;
    }


}
