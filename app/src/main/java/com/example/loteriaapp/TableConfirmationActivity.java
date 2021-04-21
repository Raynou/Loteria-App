package com.example.loteriaapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;

public class TableConfirmationActivity extends AppCompatActivity {

    ImageView myTableView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_confirmation);

        myTableView = (ImageView) findViewById(R.id.myTableView);
        FloatingActionButton fab = findViewById(R.id.fab);

        String namePhoto = getIntent().getStringExtra("NAME_PHOTO");
        byte[] byteArray = getIntent().getByteArrayExtra("BYTE_ARRAY_IMAGE");

        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        myTableView.setImageBitmap(bmp);

        StorageManager storageManager = new StorageManager(myTableView, bmp, getExternalFilesDir(null));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storageManager.saveToGallery(namePhoto);
                Snackbar.make(view, "Tabla guardada", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(TableConfirmationActivity.this, MainActivity.class);
                startActivity(intent);
            }


        });

    }
}