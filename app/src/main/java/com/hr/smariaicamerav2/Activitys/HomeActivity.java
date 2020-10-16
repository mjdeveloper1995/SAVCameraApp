package com.hr.smariaicamerav2.Activitys;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.hr.smariaicamerav2.Config;
import com.hr.smariaicamerav2.R;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;


public class HomeActivity extends AppCompatActivity {

    private static final String[] REQUIRED_PERMISSION_LIST = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.RECORD_AUDIO,
    };
    private static final int REQUEST_CODE = 1;
    private List<String> mMissPermissions = new ArrayList<>();

    Button btnLiveRecording, btnLiveImageFreezing;
    ImageView ivLogout;
    String SedBullID;
    List<String> videoList;
    Hashtable<String, String> videoHash;
    ArrayAdapter<String> videoAdp;
    String User_name, name;
    UserSessionManager session;

    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);

    }

    public void mainLogout() {
        session.logoutUser();

        if (session.checkLogin11()) {
            finish();
        }
        Toast.makeText(HomeActivity.this, "User Logout", Toast.LENGTH_SHORT).show();
    }

    //    public void onBackPressed() {
//        finishAffinity();
//        startActivity(new Intent(HomeActivity.this,HomeActivity.class));
//    }
    private boolean isVersionM() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }
    private void checkAndRequestPermissions() {
        mMissPermissions.clear();
        for (String permission : REQUIRED_PERMISSION_LIST) {
            int result = ContextCompat.checkSelfPermission(this, permission);
            if (result != PackageManager.PERMISSION_GRANTED) {
                mMissPermissions.add(permission);
            }
        }
        // check permissions has granted
        if (mMissPermissions.isEmpty()) {
//            startMainActivity();
        } else {
            ActivityCompat.requestPermissions(this,
                    mMissPermissions.toArray(new String[mMissPermissions.size()]),
                    REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(final int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            for (int i = grantResults.length - 1; i >= 0; i--) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    mMissPermissions.remove(permissions[i]);
                }
            }
        }
        // Get permissions success or not
        if (mMissPermissions.isEmpty()) {
//            startMainActivity();
        } else {
            Toast.makeText(HomeActivity.this, "get permissions failed,exiting...", Toast.LENGTH_SHORT).show();
            HomeActivity.this.finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (isVersionM()) {
            checkAndRequestPermissions();
        }
        File folder = new File(Environment.getExternalStorageDirectory() +
                File.separator + Config.downloadDirectory);
        boolean success = true;
        if (!folder.exists()) {
            success = folder.mkdirs();
        }
        if (success) {
            // Do something on success
        } else {
            // Do something else on failure
        }
        final String game_preferance = "For_User";
        SharedPreferences setting = getSharedPreferences(
                game_preferance, Context.MODE_PRIVATE);
        User_name = setting.getString("username", "");
        session = new UserSessionManager(this.getApplicationContext());

        HashMap<String, String> user = session.getUserDetails();

        // get name
        name = user.get(UserSessionManager.KEY_NAME);

        btnLiveRecording = (Button) findViewById(R.id.btnLiveRecording);
        btnLiveImageFreezing = (Button) findViewById(R.id.btnLiveImageFreezing);
        ivLogout = (ImageView) findViewById(R.id.ivLogout);

        videoHash = new Hashtable<String, String>();
        videoList = new ArrayList<String>();
        getAllDir(Config.AD_INTERNAL_STORAGE_PATH_URL);

        btnLiveRecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startNewActivity(HomeActivity.this,Pack);
//                startActivity(new Intent(HomeActivity.this,LiveRecordingActivity.class));
                Intent intent = new Intent(HomeActivity.this, LiveRecordingActivity.class);
                intent.putExtra("SedBullID", SedBullID);
                startActivity(intent);
            }
        });
        btnLiveImageFreezing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startNewActivity(HomeActivity.this,Pack);
//                startActivity(new Intent(HomeActivity.this,LiveImageFreezingActivity.class));
                Intent intent = new Intent(HomeActivity.this, LiveImageFreezingActivity.class);
                intent.putExtra("SedBullID", SedBullID);
                startActivity(intent);
            }
        });
        ivLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(HomeActivity.this).setTitle("LOGOUT")
                        .setMessage("Are you sure?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mainLogout();
                            }
                        }).setNegativeButton("no", null).show();
            }
        });

    }

    public void startNewActivity(Context context, String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent == null) {
            // Bring user to the market or let them choose an app?
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(Config.CAMERA_APK_URL));
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void getAllDir(File dir) {
        String pdfPattern = ".mp4";

        File listFile[] = dir.listFiles();

        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {

                if (listFile[i].isDirectory()) {
                    getAllDir(listFile[i]);
                } else {
                    if (listFile[i].getName().endsWith(pdfPattern)) {
                        videoHash.put("", listFile[i].getName());
                        videoList.add(listFile[i].getName());
//                        int lastKey = 0;
//                        //you entered Map<Long, String> entry
//                        for (Map.Entry<String, String> entry : videoHash.entrySet()) {
//                            lastKey = Integer.parseInt(entry.getKey());
//                        }
//                        System.out.println(lastKey);
//                        Toast.makeText(this, "videoList : "+lastKey, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}
