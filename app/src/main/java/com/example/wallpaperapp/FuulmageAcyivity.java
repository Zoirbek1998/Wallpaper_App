package com.example.wallpaperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

import java.io.IOException;

public class FuulmageAcyivity extends AppCompatActivity {

    ImageView fullImage;
    MaterialButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuulmage_acyivity);

        fullImage=findViewById(R.id.fullImage);
        button=findViewById(R.id.apply);

        Glide.with(this).load(getIntent().getStringExtra("images")).into(fullImage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap bitmap=((BitmapDrawable)fullImage.getDrawable()).getBitmap();

                WallpaperManager manager=WallpaperManager.getInstance(getApplicationContext());

                try {
                    manager.setBitmap(bitmap);
                } catch (IOException e) {
                    Toast.makeText(FuulmageAcyivity.this, "Error :"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }
}