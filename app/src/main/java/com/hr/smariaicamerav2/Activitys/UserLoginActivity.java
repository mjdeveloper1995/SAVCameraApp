package com.hr.smariaicamerav2.Activitys;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.hr.smariaicamerav2.R;
import com.hr.smariaicamerav2.mDataBase.DBAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UserLoginActivity extends AppCompatActivity {
    ImageView ivAdminLogin;
    Button btnLogin, btnSignUp;
    EditText edUsername, edPassword;
    String IMEI_NO;
    String SImeiNo, SedUsername, SedPassword;
    UserSessionManager session;
    Intent iSession = new Intent();
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;

    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);
    }

    private void checkAndRequestPermissions() {
        int permissionStorage = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int locationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        List<String> listPermissionsNeeded = new ArrayList<>();
        if (locationPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (permissionStorage != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = new UserSessionManager(UserLoginActivity.this);
        checkAndRequestPermissions();
        DBAdapter db = new DBAdapter(this);
        db.openDB();
        UsbManager manager = (UsbManager) getSystemService(Context.USB_SERVICE);
        HashMap<String, UsbDevice> deviceList = manager.getDeviceList();
        for (UsbDevice device : deviceList.values()) {
            //your code
            Log.e("usbDevices : ", "" + device);
        }

        if (!session.checkLogin()) {
            HashMap<String, String> user = session.getUserDetails();
            String name = user.get(UserSessionManager.KEY_NAME);
            session.createUserLoginSession(name);
            iSession.setClass(UserLoginActivity.this, HomeActivity.class);
            iSession.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            iSession.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(iSession);
            finish();
        }
        ivAdminLogin = findViewById(R.id.ivAdminLogin);
        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        getUser_Planets(null);
        //TODO
        IMEI_NO = getDeviceID();

        ivAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(UserLoginActivity.this, AdminLoginActivity.class));
            }
        });
        btnLogin.setOnClickListener(v -> {
            if (edUsername.getText().toString().isEmpty() || edUsername.getText().toString().length() == 0) {
                Toast.makeText(UserLoginActivity.this, "Enter Username", Toast.LENGTH_SHORT).show();
                return;
            }
            if (edPassword.getText().toString().isEmpty() || edPassword.getText().toString().length() == 0) {
                Toast.makeText(UserLoginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                return;
            }
            if (edUsername.getText().toString().equals(SedUsername) && edPassword.getText().toString().equals(SedPassword) && IMEI_NO.equals(SImeiNo)) {
                final String game_preferance = "For_User";
                SharedPreferences setting = getSharedPreferences(game_preferance, MODE_PRIVATE);
                final SharedPreferences.Editor preditor = setting.edit();
                preditor.putString("username", SedUsername);
                preditor.apply();
                session.createUserLoginSession(SedUsername);
                iSession.setClass(UserLoginActivity.this, HomeActivity.class);
                iSession.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                iSession.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(iSession);
                finish();
            } else {
                Toast.makeText(UserLoginActivity.this, "Wrog Id Password!! Plz Try Again", Toast.LENGTH_SHORT).show();
            }
        });
        btnSignUp.setOnClickListener(v -> startActivity(new Intent(UserLoginActivity.this, UserAssignActivity.class)));
    }

    String getDeviceID() {
        @SuppressLint({"MissingPermission", "HardwareIds"})
        String id = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
        if (id == null) {
            id = "not available";
        }
        return id;
    }

    private void getUser_Planets(String searchTerm) {
        DBAdapter db = new DBAdapter(this);
        db.openDB();
        Cursor c = db.User_fetch(searchTerm);
        if (c.moveToLast()) {
            SImeiNo = c.getString(c.getColumnIndex("imeino"));
            SedUsername = c.getString(c.getColumnIndex("username"));
            SedPassword = c.getString(c.getColumnIndex("password"));
            edUsername.setText(c.getString(c.getColumnIndex("username")));
        }
        db.closeDB();
    }
}
