package com.hr.smariaicamerav2.Activitys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hr.smariaicamerav2.Config;
import com.hr.smariaicamerav2.R;
import com.hr.smariaicamerav2.mDataBase.Constants;
import com.hr.smariaicamerav2.mDataBase.DBAdapter;
import com.hr.smariaicamerav2.view.USBCameraActivity;

import java.io.File;

public class LiveRecordingActivity extends AppCompatActivity {
    ListView videolist;
    int count;
    String thumbPath;
    String SedBullID;
    File videoFiles = new File(Environment.getExternalStorageDirectory() + "/SAVCamera");
    String[] thumbColumns = {MediaStore.Video.Thumbnails.DATA, MediaStore.Video.Thumbnails.VIDEO_ID};
    Button btnOpenUsbVideo;

    private Cursor videoCursor;
    private int videoColumnIndex;
    private AdapterView.OnItemClickListener videogridlistener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            System.gc();
            videoColumnIndex = videoCursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            videoCursor.moveToPosition(position);
            String filename = videoCursor.getString(videoColumnIndex);
            System.out.println("---------++-----------------------");
            System.out.println(filename);
            System.out.println("-------------++-------------------");
            Log.i("FileName: ", filename);
            String VideoName = videoCursor.getString(videoCursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME));
//            Toast.makeText(LiveRecordingActivity.this, "Image Name : " + videoCursor.getString(videoCursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME)), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LiveRecordingActivity.this, VideoInseminationActivity.class);
            intent.putExtra("VideoName", VideoName);
            intent.putExtra("SedBullID", SedBullID);
            startActivity(intent);
        }
    };
    @Override
    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_recording);
//        getLast_Bull_Record();
        btnOpenUsbVideo = (Button) findViewById(R.id.btnOpenUsbVideo);
        btnOpenUsbVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startNewActivity(LiveRecordingActivity.this, Pack);
                Intent intent = new Intent(LiveRecordingActivity.this, USBCameraActivity.class);
//                Intent intent = new Intent(LiveRecordingActivity.this, TestCameraActivity.class);
                startActivity(intent);
            }
        });
        SedBullID = getIntent().getStringExtra("SedBullID");
//        Toast.makeText(this, "Animal Id :"+SedBullID, Toast.LENGTH_SHORT).show();
        initialization();
//        getAllDir(videoFiles);
    }

//    public void startNewActivity(Context context, String packageName) {
//        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
//        if (intent == null) {
//            // Bring user to the market or let them choose an app?
//            intent = new Intent(Intent.ACTION_VIEW);
////            intent.setData(Uri.parse("market://details?id=" + packageName));
//            intent.setData(Uri.parse(Config.CAMERA_APK_URL));
////            intent.setData(Uri.parse("Install Web Camera Application")).setType("application/vnd.android.package-archive");
//        }
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
//    }

    private void initialization() {
        System.gc();
        String[] videoProjection = {MediaStore.Video.Media._ID, MediaStore.Video.Media.DATA,
                MediaStore.Video.Media.DISPLAY_NAME, MediaStore.Video.Media.SIZE};
        Log.e("response Media ",""+videoProjection);
//        videoCursor = managedQuery(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, videoProjection, MediaStore.Images.Media.DATA + " like ? ", new String[]{"%UsbWebCamera%"}, null);
//        videoCursor = managedQuery(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, videoProjection, MediaStore.Images.Media.DATA + " like ? ", new String[]{"%"+ Config.downloadDirectory +"%"}, MediaStore.Video.Media.DISPLAY_NAME +" DESC");
        videoCursor = managedQuery(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, videoProjection, MediaStore.Images.Media.DATA + " like ? ", new String[]{"%SAVCamera%"}, MediaStore.Video.Media.DISPLAY_NAME +" DESC");
        count = videoCursor.getCount();
        Log.e("response MediavideoCur",""+videoCursor);
        videolist = (ListView) findViewById(R.id.PhoneVideoList);

        videolist.setAdapter(new VideoListAdapter(this.getApplicationContext()));
        videolist.setOnItemClickListener(videogridlistener);
    }

    public class VideoListAdapter extends BaseAdapter {
        int layoutResourceId;
        private Context vContext;

        public VideoListAdapter(Context c) {
            vContext = c;
        }

        public int getCount() {
            return videoCursor.getCount();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }
//        public int getCount() {
//            // TODO Auto-generated method stub
//            return videoCursor.getCount();
//        }
//
//        public Object getItem(int position) {
//            // TODO Auto-generated method stub
//            return null;
//        }
//
//        public long getItemId(int position) {
//            // TODO Auto-generated method stub
//            return 0;
//        }

        @SuppressLint("ViewHolder")
        public View getView(int position, View convertView, ViewGroup parent) {
            View listItemRow = null;
            listItemRow = LayoutInflater.from(vContext).inflate(R.layout.listitem, parent, false);

            TextView txtTitle = (TextView) listItemRow.findViewById(R.id.txtTitle);
            TextView txtSize = (TextView) listItemRow.findViewById(R.id.txtSize);
            ImageView thumbImage = (ImageView) listItemRow.findViewById(R.id.imgIcon);

            videoColumnIndex = videoCursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME);
            videoCursor.moveToPosition(position);
//            videoCursor.moveToLast();
            txtTitle.setText(videoCursor.getString(videoColumnIndex));

            videoColumnIndex = videoCursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE);
            videoCursor.moveToPosition(position);
//            videoCursor.moveToLast();
            txtSize.setText(" Size(KB):" + videoCursor.getString(videoColumnIndex));

            int videoId = videoCursor.getInt(videoCursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID));
            @SuppressWarnings("deprecation")
            Cursor videoThumbnailCursor = managedQuery(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, thumbColumns,
                    MediaStore.Video.Thumbnails.VIDEO_ID + "=" + videoId, null, null);

            if (videoThumbnailCursor.moveToLast()) {
//
                thumbPath = videoThumbnailCursor
                        .getString(videoThumbnailCursor.getColumnIndex(MediaStore.Video.Thumbnails.DATA));
                Log.i("ThumbPath: ", thumbPath);

            }
//            System.out.println("------------++--------------------");
//            System.out.println(Uri.parse(thumbPath));
//            System.out.println("-------------++-------------------");

//                thumbImage.setImageURI(Uri.parse(thumbPath));

            return listItemRow;

        }

    }

    private void getLast_Bull_Record() {

//        bull_planet.clear();

        DBAdapter db = new DBAdapter(this);
        db.openDB();
//        Bull_Planet B_P = null;
        Cursor c = db.Last_Bull_fetch();
        while (c.moveToNext()) {
            int b_id = c.getInt(c.getColumnIndex(Constants.B_ID));
            String bull_Name = c.getString(c.getColumnIndex(Constants.BULL_NAME));
            String bull_BetchNo = c.getString(c.getColumnIndex(Constants.SEMEN_BATCH_NO));
            String bull_Amount = c.getString(c.getColumnIndex(Constants.AMOUNT_CHARGE));
            String bull_CD = c.getString(c.getColumnIndex(Constants.CASH_DEBIT));
            String bull_Date = c.getString(c.getColumnIndex(Constants.REGISTER_DATE));
            String bull_Time = c.getString(c.getColumnIndex(Constants.REGISTER_TIME));
            String bull_id = c.getString(c.getColumnIndex(Constants.BULL_ID));

//            Toast.makeText(this, "b_id : " + b_id + "\nbull_id : " + bull_id + "\nbull_Name : " + bull_Name + "\nbull_BetchNo : " + bull_BetchNo + "\nbull_Amount : " + bull_Amount + "\nbull_CD : " + bull_CD + "\nbull_Date :  " + bull_Date + "\nbull_Time : " + bull_Time, Toast.LENGTH_SHORT).show();

        }

        db.closeDB();
    }
//    public void getAllDir(File dir) {
//        String pdfPattern = ".mp4";
//
//        File listFile[] = dir.listFiles();
//
//        if (listFile != null) {
//            for (int i = 0; i < listFile.length; i++) {
//
//                if (listFile[i].isDirectory()) {
//                    getAllDir(listFile[i]);
//                    Toast.makeText(LiveRecordingActivity.this, "If List Of File : " + listFile[i], Toast.LENGTH_SHORT).show();
//                } else {
//                    if (listFile[i].getName().endsWith(pdfPattern)) {
//                        Toast.makeText(LiveRecordingActivity.this, "Else List Of File : " + listFile[i].getName(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        }
//    }
}
