package com.hr.smariaicamerav2.Activitys;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.hr.smariaicamerav2.R;

import java.io.File;


public class VideoInseminationActivity extends AppCompatActivity {

    public static final File AD_INTERNAL_STORAGE_PATH_URL = Environment.getExternalStoragePublicDirectory("Movies/USBCameraTest");
    String VideoNames = "";

    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_insemination);

        VideoNames = getIntent().getStringExtra("VideoName");
        VideoView videoView = (VideoView) findViewById(R.id.VideoInseminationPlayer);
        //specify the location of media file
        // create an object of media controller
        android.widget.MediaController mediaController = new android.widget.MediaController(this);
        // set media controller object for a video view
        videoView.setMediaController(mediaController);
        Uri uri = Uri.parse(AD_INTERNAL_STORAGE_PATH_URL + "/" + VideoNames);
//        Toast.makeText(this, "VideoNames : " + uri, Toast.LENGTH_SHORT).show();
        videoView.setVideoURI(uri);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoView.getLayoutParams();
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 0);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
        videoView.setLayoutParams(layoutParams);
        videoView.start();

    }
}
