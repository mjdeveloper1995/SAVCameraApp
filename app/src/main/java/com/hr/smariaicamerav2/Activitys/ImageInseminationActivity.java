package com.hr.smariaicamerav2.Activitys;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;

import com.hr.smariaicamerav2.Config;
import com.hr.smariaicamerav2.R;

import java.io.File;


public class ImageInseminationActivity extends AppCompatActivity {

    public static final File AD_INTERNAL_STORAGE_PATH_URL = Environment.getExternalStoragePublicDirectory("Movies/USBCameraTest");
    String VideoNames = "";

    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_insemination);
        VideoNames = getIntent().getStringExtra("VideoName");

        ImageView videoView = (ImageView) findViewById(R.id.VideoInseminationPlayer);
        Bitmap bmp = BitmapFactory.decodeFile(Config.DAD_INTERNAL_STORAGE_PATH_URL + "/" + VideoNames);
        ImageView img;
        videoView.setImageBitmap(bmp);

    }

}
