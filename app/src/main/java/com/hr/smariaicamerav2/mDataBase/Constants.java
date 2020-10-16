package com.hr.smariaicamerav2.mDataBase;

import android.os.Environment;

import java.io.File;


public class Constants {
    //COLUMNS
//    public static final String ROW_ID = "id";
//    public static final String NAME = "name";

    public static final String USER_ID = "user_id";
    public static final String FULLNAME = "fullname";
    public static final String EMAILS = "emails";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String IMEINO = "imeino";
    public static final String PHONE = "phones";
    public static final String CREATEDON = "createdon";

    public static final String B_ID = "b_id";
    public static final String _ID = "_id";
    public static final String BULL_ID = "bull_id";

    public static final String DATE_AI = "date_ai";
    public static final String BULL_NAME = "bull_name";
    public static final String SEMEN_BATCH_NO = "semen_batch_no";
    public static final String AMOUNT_CHARGE = "amount_charge";
    public static final String CASH_DEBIT = "cash_debit";

    public static final String BD_ID = "bd_id";
    public static final String BDR_ID = "bdr_id";

    public static final String R_B_ID = "r_b_id";
    public static final String DATE_ = "date_";
    public static final String SPIECES = "spieces";
    public static final String SUB_SPIECES = "sub_spieces";
    public static final String BREED = "breed";
    public static final String NUMBER_OF_CALVING = "number_of_calving";
    public static final String OWNER_NAME = "owner_name";
    public static final String OWNER_ADD = "owner_add";
    public static final String OWNER_VIL = "owner_vil";
    public static final String OWNER_DIS = "owner_dis";
    public static final String OWNER_STATE = "owner_state";
    public static final String OWNER_MOB = "owner_mob";
    public static final String OWNER_REMARK = "owner_remark";

    public static final String V_ID = "v_id";
    public static final String VD_ID = "vd_id";
    public static final String BS_ID = "bs_id";

    public static final String V_N_I_N = "v_n_i_n";
    public static final String V_D_N_I_N = "v_d_n_i_n";

    public static final String COW_NAME = "cow_name";
    public static final String COW_OWNER_NAME = "cow_owner_name";
    public static final String REMARK = "remark";
    public static final String VIDEO_IMAGE_LINK = "video_image_link";
    public static final String REGISTER_DATE = "register_date";
    public static final String REGISTER_TIME = "register_time";

    // Database SMART_AI_VISION Information
    public static final String DB_NAME = "SMART_AI_VISION.DB";

    //DB
    public static final String BULL_REGISTER = "BULL_REGISTER";
    public static final String BULL_REGISTER_OWNER = "BULL_REGISTER_OWNER";
    public static final String BULL_VIDEO_IAMAGE = "BULL_VIDEO_IAMAGE";
    public static final String BULL_SPIECES = "BULL_SPIECES";
    public static final String USER_SIGNUP = "USER_SIGNUP";
    public static final String BULL_DIAGNOSIS = "BULL_DIAGNOSIS";
    public static final String BULL_DREGISTER_OWNER = "BULL_DREGISTER_OWNER";
    public static final String BULL_D_VIDEO_IAMAGE = "BULL_D_VIDEO_IAMAGE";

    static final int DB_VERSION = 1;

    //CREATE TB
//    static final String CREATE_TB = "CREATE TABLE ii_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
//            + "name TEXT NOT NULL);";

    // Creating CREATE_TABLE_USER_SIGNUP query
    static final String CREATE_TABLE_USER_SIGNUP = "create table " + USER_SIGNUP + "(" + USER_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + FULLNAME + " TEXT NOT NULL, "+ EMAILS + " TEXT NOT NULL, " + USERNAME + " TEXT, " + PASSWORD + " TEXT, " + IMEINO + " TEXT, " + PHONE + " TEXT, " + CREATEDON + " TEXT);";

    // Creating CREATE_TABLE_BULL_REGISTER query
    static final String CREATE_TABLE_BULL_REGISTER = "create table " + BULL_REGISTER + "(" + B_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BULL_ID + " TEXT , " + DATE_AI + " TEXT, " + BULL_NAME + " TEXT, " + SEMEN_BATCH_NO + " TEXT, " + AMOUNT_CHARGE + " TEXT, " + CASH_DEBIT + " TEXT, " + REGISTER_DATE + " TEXT, " + REGISTER_TIME + " TEXT);";

    // Creating CREATE_TABLE_BULL_REGISTER query
    static final String CREATE_TABLE_BULL_REGISTER_OWNER = "create table " + BULL_REGISTER_OWNER + "(" + R_B_ID
            + " INTEGER , " + BULL_ID + " TEXT , " + DATE_ + " TEXT, " + SPIECES + " TEXT, " + SUB_SPIECES + " TEXT, " + BREED + " TEXT, " + NUMBER_OF_CALVING + " TEXT, " + OWNER_NAME + " TEXT, " + OWNER_ADD + " TEXT, " + OWNER_VIL + " TEXT, " + OWNER_DIS + " TEXT, " + OWNER_STATE + " TEXT, " + OWNER_MOB + " TEXT, " + OWNER_REMARK + " TEXT, " + REGISTER_DATE + " TEXT, " + REGISTER_TIME + " TEXT);";

//    // Creating CREATE_TABLE_BULL_REGISTER query
//    static final String CREATE_TABLE_BULL_VIDEO_IAMAGE = "create table " + BULL_VIDEO_IAMAGE + "(" + V_ID
//            + " INTEGER PRIMARY KEY AUTOINCREMENT , " + BULL_ID + " TEXT , " + V_N_I_N + " TEXT, " + REGISTER_DATE + " TEXT, " + REGISTER_TIME + " TEXT);";

    // Creating CREATE_TABLE_BULL_REGISTER query
    static final String CREATE_TABLE_BULL_VIDEO_IAMAGE = "create table " + BULL_VIDEO_IAMAGE + "(" + V_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT , "+B_ID+" INTEGER , " + BULL_ID + " TEXT , " + V_N_I_N + " TEXT, " + REGISTER_DATE + " TEXT, " + REGISTER_TIME + " TEXT);";

    // Creating CREATE_TABLE_BULL_REGISTER query
    static final String CREATE_TABLE_BULL_SPIECES = "create table " + BULL_SPIECES + "(" + BS_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT , " + SPIECES + " TEXT , " + SUB_SPIECES + " TEXT , " + REGISTER_DATE + " TEXT, " + REGISTER_TIME + " TEXT);";

    static final String CREATE_TABLE_BULL_DIAGNOSIS = "create table " + BULL_DIAGNOSIS + "(" + BD_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BULL_ID + " TEXT , " + DATE_AI + " TEXT, " + BULL_NAME + " TEXT, " + SEMEN_BATCH_NO + " TEXT, " + AMOUNT_CHARGE + " TEXT, " + CASH_DEBIT + " TEXT, " + REGISTER_DATE + " TEXT, " + REGISTER_TIME + " TEXT);";

    static final String CREATE_TABLE_BULL_DREGISTER_OWNER = "create table " + BULL_DREGISTER_OWNER + "(" + BDR_ID
            + " INTEGER , " + BULL_ID + " TEXT , " + DATE_ + " TEXT, " + SPIECES + " TEXT, " + SUB_SPIECES + " TEXT, " + BREED + " TEXT, " + NUMBER_OF_CALVING + " TEXT, " + OWNER_NAME + " TEXT, " + OWNER_ADD + " TEXT, " + OWNER_VIL + " TEXT, " + OWNER_DIS + " TEXT, " + OWNER_STATE + " TEXT, " + OWNER_MOB + " TEXT, " + OWNER_REMARK + " TEXT, " + REGISTER_DATE + " TEXT, " + REGISTER_TIME + " TEXT);";
    // Creating CREATE_TABLE_BULL_REGISTER query
    static final String CREATE_TABLE_BULL_D_VIDEO_IAMAGE = "create table " + BULL_D_VIDEO_IAMAGE + "(" + VD_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT , "+BD_ID+" INTEGER , " + BULL_ID + " TEXT , " + V_D_N_I_N + " TEXT, " + REGISTER_DATE + " TEXT, " + REGISTER_TIME + " TEXT);";

    //DROP TB
//    static final String DROP_TB = "DROP TABLE IF EXISTS " + TB_NAME;
    static final String DROP_BULL_REGISTER = "DROP TABLE IF EXISTS " + BULL_REGISTER;
    static final String DROP_BULL_REGISTER_OWNER = "DROP TABLE IF EXISTS " + BULL_REGISTER_OWNER;
    static final String DROP_BULL_VIDEO_IAMAGE = "DROP TABLE IF EXISTS " + BULL_VIDEO_IAMAGE;
    static final String DROP_BULL_USER_SIGNUP = "DROP TABLE IF EXISTS " + USER_SIGNUP;
    static final String DROP_BULL_DIAGNOSIS = "DROP TABLE IF EXISTS " + BULL_DIAGNOSIS;
    static final String DROP_BULL_DREGISTER_OWNER = "DROP TABLE IF EXISTS " + BULL_DREGISTER_OWNER;
    static final String DROP_BULL_D_VIDEO_IAMAGE = "DROP TABLE IF EXISTS " + BULL_D_VIDEO_IAMAGE;


}
