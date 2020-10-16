package com.hr.smariaicamerav2.Activitys;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hr.smariaicamerav2.R;


public class AdminLoginActivity extends AppCompatActivity {

    Button btnGo;
    EditText edUsername, edPassword;

    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }
    @Override
    public void onBackPressed() {
        finishAffinity();
        startActivity(new Intent(AdminLoginActivity.this,UserLoginActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        verifyStoragePermissions(this);
        btnGo = (Button) findViewById(R.id.btnGo);
        edUsername = (EditText) findViewById(R.id.edUsername);
        edPassword = (EditText) findViewById(R.id.edPassword);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edUsername.getText().toString().isEmpty() || edUsername.getText().toString().length() == 0) {
                    Toast.makeText(AdminLoginActivity.this, "Enter Username", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edPassword.getText().toString().isEmpty() || edPassword.getText().toString().length() == 0) {
                    Toast.makeText(AdminLoginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edUsername.getText().toString().equals("Admin") && edPassword.getText().toString().equals("123")) {
                    startActivity(new Intent(AdminLoginActivity.this, UserAssignActivity.class));
                } else {
                    Toast.makeText(AdminLoginActivity.this, "Wrog Id Password!! Plz Try Again", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
