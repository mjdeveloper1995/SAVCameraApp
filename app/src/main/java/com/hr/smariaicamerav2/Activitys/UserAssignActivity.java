package com.hr.smariaicamerav2.Activitys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hr.smariaicamerav2.Config;
import com.hr.smariaicamerav2.R;
import com.hr.smariaicamerav2.mDataBase.DBAdapter;
import com.hr.smariaicamerav2.mDataBase.RequestHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static android.view.View.GONE;


public class UserAssignActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;
    ProgressBar progressBar;
    Button btnAssign;
    TextView tvIMEI;
    private EditText edFullName, edEmails, edUsername, edPassword, edPhone;
    String IMEI_NO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_assign);

        btnAssign = findViewById(R.id.btnAssign);
        progressBar = findViewById(R.id.progressBar);
        edFullName = findViewById(R.id.edFullName);
        edEmails = findViewById(R.id.edEmails);
        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        edPhone = findViewById(R.id.edPhone);
        tvIMEI = findViewById(R.id.tvIMEI);
        btnAssign.setOnClickListener(this);
        //TODO
        IMEI_NO = getDeviceID();
        tvIMEI.setText(IMEI_NO);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAssign:

                final String SedFullName = edFullName.getText().toString();
                final String SedEmails = edEmails.getText().toString();
                final String SedUsername = edUsername.getText().toString();
                final String SedPassword = edPassword.getText().toString();
                final String SedPhone = edPhone.getText().toString();
                final String SIMEINo = tvIMEI.getText().toString();

                ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                final NetworkInfo netInfo = cm.getActiveNetworkInfo();
                if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                    if (TextUtils.isEmpty(SedFullName)) {
                        edFullName.setError("Enter FullName");
                        edFullName.requestFocus();
                        return;
                    }
                    if (TextUtils.isEmpty(SedEmails)) {
                        edEmails.setError("Enter Email id");
                        edEmails.requestFocus();
                        return;
                    }
                    if (TextUtils.isEmpty(SedUsername)) {
                        edUsername.setError("Enter UserName");
                        edUsername.requestFocus();
                        return;
                    }
                    if (TextUtils.isEmpty(SedPassword)) {
                        edPassword.setError("Enter Password");
                        edPassword.requestFocus();
                        return;
                    }
                    if (TextUtils.isEmpty(SedPhone)) {
                        edPhone.setError("Enter Phone Number");
                        edPhone.requestFocus();
                        return;
                    }

                    User_save(SedFullName, SedEmails, SedUsername, SedPassword, SIMEINo, SedPhone, "");
                    //Create User Online Start
                    HashMap<String, String> params = new HashMap<>();
                    params.put("fullname", SedFullName);
                    params.put("emails", SedEmails);
                    params.put("username", SedUsername);
                    params.put("password", SedPassword);
                    params.put("imeino", SIMEINo);
                    params.put("phones", SedPhone);

                    PerformNetworkRequest request = new PerformNetworkRequest(Config.CREATE_USER_URL, params, CODE_POST_REQUEST);
                    request.execute();

                    edFullName.setText("");
                    edEmails.setText("");
                    edUsername.setText("");
                    edPassword.setText("");
                    edPhone.setText("");
                    //End
                    Intent main = new Intent(UserAssignActivity.this, UserLoginActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    startActivity(main);
                    Toast.makeText(UserAssignActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UserAssignActivity.this, "No network connection", Toast.LENGTH_LONG).show();
                }

                break;
        }
    }

    private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
        String url;
        HashMap<String, String> params;
        int requestCode;

        PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode) {
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(GONE);
            try {
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")) {
                    Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
//                    refreshUniList(object.getJSONArray("universitys"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();


            if (requestCode == CODE_POST_REQUEST)
                return requestHandler.sendPostRequest(url, params);

            if (requestCode == CODE_GET_REQUEST)
                return requestHandler.sendGetRequest(url);

            return null;
        }
    }

    private void User_save(String fullname, String emails, String username, String password, String imeino, String phone, String createdon) {
        DBAdapter db = new DBAdapter(this);
        db.openDB();
        if (db.User_Insert(fullname, emails, username, password, imeino, phone, createdon)) {
//            nameEditText.setText("");
            Toast.makeText(this, "User Save successful!!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Unable To User Save", Toast.LENGTH_SHORT).show();
        }
        db.closeDB();

//        this.getPlanets(null);
    }
}
