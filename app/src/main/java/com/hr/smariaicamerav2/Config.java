package com.hr.smariaicamerav2;

import android.os.Environment;

import java.io.File;

/**
 * Created by Hardik.
 */
public class Config {

    public static final File AD_INTERNAL_STORAGE_PATH_URL = Environment.getExternalStoragePublicDirectory("/Movies/USBCameraTest");
    public static final File DAD_INTERNAL_STORAGE_PATH_URL = Environment.getExternalStoragePublicDirectory("/DCIM/USBCameraTest");

    //String Values to be Used in App
//    public static final String downloadDirectory = "UsbWebCamera";
    public static final String downloadDirectory = "SAVCamera";
    //    public static final String mainUrl = "http://androhub.com/demo/";
        public static final String CAMERA_APK_URL = "http://www.quarkssystems.com/smartaivision/0.apk";

//    public static final String ROOT_URL = "http://192.168.0.103/SAV2/";
    public static final String ROOT_URL = "http://fablabelectronics.com/SAV2/";
    private static final String ROOT1_URL = ROOT_URL + "v1/Api.php?apicall=";
    public static final String CREATE_USER_URL = ROOT1_URL + "createsignup";

    //JSON Tag from response from server
    public static final String TAG_RESPONSE = "ErrorMessage";
    public static final String TAG_SUCCESS = "success";
}