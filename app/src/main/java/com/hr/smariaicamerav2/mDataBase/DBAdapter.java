//package hr.qs.smart_ai_vision.mDataBase;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//
///**
// * Created by Oclemmy on 5/2/2016 for ProgrammingWizards Channel and http://www.Camposha.com.
// */
//public class DBAdapter {
//
//    Context c;
//    SQLiteDatabase db;
//    DBHelper helper;
//
//    public DBAdapter(Context c) {
//        this.c = c;
//        helper = new DBHelper(c);
//    }
//
//    //OPEN DB
//    public void openDB() {
//        try {
//            db = helper.getWritableDatabase();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //CLOSE
//    public void closeDB() {
//        try {
//            helper.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //INSERT DATA
////    public boolean add(String name)
////    {
////        try
////        {
////            ContentValues cv=new ContentValues();
////            cv.put(Constants.NAME, name);
////
////            db.insert(Constants.TB_NAME, Constants.ROW_ID, cv);
////
////            return true;
////
////        }catch (SQLException e)
////        {
////            e.printStackTrace();
////        }
////        return false;
////    }
////
////    //RETRIEVE DATA AND FILTER
////    public Cursor retrieve(String searchTerm)
////    {
////        String[] columns={Constants.ROW_ID,Constants.NAME};
////        Cursor c=null;
////
////        if(searchTerm != null && searchTerm.length()>0)
////        {
////            String sql="SELECT * FROM "+Constants.TB_NAME+" WHERE "+Constants.NAME+" LIKE '%"+searchTerm+"%'";
////            c=db.rawQuery(sql,null);
////            return c;
////
////        }
////
////        c=db.query(Constants.TB_NAME,columns,null,null,null,null,null);
////        return c;
////    }
//
//    // User Data
//
//    // User Data
//    public boolean User_Insert(String fullname, String username, String password, String imeino, String phone, String createdon) {
//        try {
//            ContentValues contentValue = new ContentValues();
//            contentValue.put(Constants.FULLNAME, fullname);
//            contentValue.put(Constants.USERNAME, username);
//            contentValue.put(Constants.PASSWORD, password);
//            contentValue.put(Constants.IMEINO, imeino);
//            contentValue.put(Constants.PHONE, phone);
//            contentValue.put(Constants.CREATEDON, createdon);
//            db.insert(Constants.USER_SIGNUP, null, contentValue);
//            return true;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public Cursor User_fetch(String Search_Bull_id) {
//
//        String[] columns = new String[]{Constants.USER_ID, Constants.FULLNAME, Constants.USERNAME, Constants.PASSWORD, Constants.IMEINO, Constants.PHONE, Constants.CREATEDON};
//        Cursor c = null;
//
//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.USER_SIGNUP + " WHERE " + Constants.FULLNAME + " LIKE '%" + Search_Bull_id + "%'";
//            c = db.rawQuery(sql, null);
//            return c;
//        }
//        c = db.query(Constants.USER_SIGNUP, columns, null, null, null, null, null);
//        return c;
//    }
//
//    public int User_update(long User_ID, String fullname, String username, String password, String imeino, String phone, String createdon) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(Constants.FULLNAME, fullname);
//        contentValues.put(Constants.USERNAME, username);
//        contentValues.put(Constants.PASSWORD, password);
//        contentValues.put(Constants.IMEINO, imeino);
//        contentValues.put(Constants.PHONE, phone);
//        int i = db.update(Constants.USER_SIGNUP, contentValues, Constants.USER_ID + " = " + User_ID, null);
//        return i;
//    }
//
//    //BUll Data
//    public boolean Bull_Insert(String bull_id, String date_ai, String bull_name, String semen_batch_no, String amount_charge, String cash_debit, String register_date, String register_time) {
//        try {
//            ContentValues contentValue = new ContentValues();
//            contentValue.put(Constants.BULL_ID, bull_id);
//            contentValue.put(Constants.DATE_AI, date_ai);
//            contentValue.put(Constants.BULL_NAME, bull_name);
//            contentValue.put(Constants.SEMEN_BATCH_NO, semen_batch_no);
//            contentValue.put(Constants.AMOUNT_CHARGE, amount_charge);
//            contentValue.put(Constants.CASH_DEBIT, cash_debit);
//            contentValue.put(Constants.REGISTER_DATE, register_date);
//            contentValue.put(Constants.REGISTER_TIME, register_time);
//            db.insert(Constants.BULL_REGISTER, Constants.B_ID, contentValue);
//
//            return true;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public Cursor Bull_fetch(String Search_Bull_id) {
//
//        String[] columns = {Constants.B_ID, Constants.BULL_ID, Constants.DATE_AI, Constants.BULL_NAME, Constants.SEMEN_BATCH_NO, Constants.AMOUNT_CHARGE, Constants.CASH_DEBIT, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
//        Cursor c = null;
//
//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER + " WHERE " + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%'";
//            c = db.rawQuery(sql, null);
//            return c;
//        }
//        c = db.query(Constants.BULL_REGISTER, columns, null, null, null, null, null);
//        return c;
//    }
//
//    public Cursor Bull_Date_fetch(String Search_Bull_id) {
//
//        String[] columns = {Constants.B_ID, Constants.BULL_ID, Constants.DATE_AI, Constants.BULL_NAME, Constants.SEMEN_BATCH_NO, Constants.AMOUNT_CHARGE, Constants.CASH_DEBIT, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
//        Cursor c = null;
//
//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER + " WHERE " + Constants.REGISTER_DATE + " LIKE '%" + Search_Bull_id + "%'";
//            c = db.rawQuery(sql, null);
//            return c;
//        }
//        c = db.query(Constants.BULL_REGISTER, columns, null, null, null, null, null);
//        return c;
//    }
//
////    public int Bull_update(long b_id, String bull_id, String date_ai, String bull_name, String semen_batch_no, String amount_charge, String cash_debit, String register_date, String register_time) {
////        ContentValues contentValues = new ContentValues();
////        contentValues.put(DatabaseHelper.B_ID, b_id);
////        contentValues.put(DatabaseHelper.BULL_ID, bull_id);
////        contentValues.put(DatabaseHelper.DATE_AI, date_ai);
////        contentValues.put(DatabaseHelper.BULL_NAME, bull_name);
////        contentValues.put(DatabaseHelper.SEMEN_BATCH_NO, semen_batch_no);
////        contentValues.put(DatabaseHelper.AMOUNT_CHARGE, amount_charge);
////        contentValues.put(DatabaseHelper.CASH_DEBIT, cash_debit);
////        contentValues.put(DatabaseHelper.REGISTER_DATE, register_date);
////        contentValues.put(DatabaseHelper.REGISTER_TIME, register_time);
////        int i = database.update(DatabaseHelper.BULL_REGISTER, contentValues, DatabaseHelper.B_ID + " = " + b_id, null);
////        return i;
////    }
////
////    public void Bull_delete(long b_id) {
////        database.delete(DatabaseHelper.BULL_REGISTER, DatabaseHelper.B_ID + "=" + b_id, null);
////    }
//
//    //Bull Owner Insert
//    public boolean Bull_Owner_Insert(long r_b_id, String bull_id, String date_, String spieces, String sub_spieces, String breed, String number_of_calving, String owner_name, String owner_add, String owner_vil, String owner_dis, String owner_state, String owner_mob, String owner_remark, String register_date, String register_time) {
//        try {
//            ContentValues contentValue = new ContentValues();
//            contentValue.put(Constants.R_B_ID, r_b_id);
//            contentValue.put(Constants.BULL_ID, bull_id);
//            contentValue.put(Constants.DATE_, date_);
//            contentValue.put(Constants.SPIECES, spieces);
//            contentValue.put(Constants.SUB_SPIECES, sub_spieces);
//            contentValue.put(Constants.BREED, breed);
//            contentValue.put(Constants.NUMBER_OF_CALVING, number_of_calving);
//            contentValue.put(Constants.OWNER_NAME, owner_name);
//            contentValue.put(Constants.OWNER_ADD, owner_add);
//            contentValue.put(Constants.OWNER_VIL, owner_vil);
//            contentValue.put(Constants.OWNER_DIS, owner_dis);
//            contentValue.put(Constants.OWNER_STATE, owner_state);
//            contentValue.put(Constants.OWNER_MOB, owner_mob);
//            contentValue.put(Constants.OWNER_REMARK, owner_remark);
//            contentValue.put(Constants.REGISTER_DATE, register_date);
//            contentValue.put(Constants.REGISTER_TIME, register_time);
//            db.insert(Constants.BULL_REGISTER_OWNER, Constants.R_B_ID, contentValue);
//
//            return true;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public Cursor Bull_Owner_Id_fetch1(String Search_Bull_id) {
//
//        String[] columns = new String[]{Constants.R_B_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
//        Cursor c = null;
//
//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.BULL_ID + "=" + Search_Bull_id+" GROUP BY "+Constants.R_B_ID;
//            //+ " LIKE '%" + Search_Bull_id + "%'";
//            c = db.rawQuery(sql, null);
//            return c;
//        }
//        c = db.query(Constants.BULL_REGISTER_OWNER, columns, null, null, null, null, null);
//        return c;
//    }
//    public Cursor Bull_Owner_Id_fetch(String Search_Bull_id) {
//
//        String[] columns = new String[]{Constants.R_B_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
//        Cursor c = null;
//
//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%'";
//            c = db.rawQuery(sql, null);
//            return c;
//        }
//        c = db.query(Constants.BULL_REGISTER_OWNER, columns, null, null, null, null, null);
//        return c;
//    }
//
//    public Cursor Bull_Owner_Date_fetch(String Search_Bull_id) {
//        String[] columns = new String[]{Constants.R_B_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
//        Cursor c = null;
//
//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.REGISTER_DATE + " LIKE '%" + Search_Bull_id + "%'";
//            c = db.rawQuery(sql, null);
//            return c;
//        }
//        c = db.query(Constants.BULL_REGISTER_OWNER, columns, null, null, null, null, null);
//        return c;
//    }
//
//    public Cursor Bull_Owner_Vill_fetch(String Search_Bull_id) {
//        String[] columns = new String[]{Constants.R_B_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
//        Cursor c = null;
//
//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.OWNER_VIL + " LIKE '%" + Search_Bull_id + "%'";
//            c = db.rawQuery(sql, null);
//            return c;
//        }
//        c = db.query(Constants.BULL_REGISTER_OWNER, columns, null, null, null, null, null);
//        return c;
//    }
//
////    public int Bull_Owner_update(long r_b_id, String bull_id, String date_, String spieces, String sub_spieces, String breed,
////                                 String number_of_calving, String owner_name, String owner_add, String owner_vil, String owner_dis,
////                                 String owner_state, String owner_mob, String owner_remark, String register_date, String register_time) {
////        ContentValues contentValues = new ContentValues();
////        contentValues.put(DatabaseHelper.R_B_ID, r_b_id);
////        contentValues.put(DatabaseHelper.BULL_ID, bull_id);
////        contentValues.put(DatabaseHelper.DATE_, date_);
////        contentValues.put(DatabaseHelper.SPIECES, spieces);
////        contentValues.put(DatabaseHelper.SUB_SPIECES, sub_spieces);
////        contentValues.put(DatabaseHelper.BREED, breed);
////        contentValues.put(DatabaseHelper.NUMBER_OF_CALVING, number_of_calving);
////        contentValues.put(DatabaseHelper.OWNER_NAME, owner_name);
////        contentValues.put(DatabaseHelper.OWNER_ADD, owner_add);
////        contentValues.put(DatabaseHelper.OWNER_VIL, owner_vil);
////        contentValues.put(DatabaseHelper.OWNER_DIS, owner_dis);
////        contentValues.put(DatabaseHelper.OWNER_STATE, owner_state);
////        contentValues.put(DatabaseHelper.OWNER_MOB, owner_mob);
////        contentValues.put(DatabaseHelper.OWNER_REMARK, owner_remark);
////        contentValues.put(DatabaseHelper.REGISTER_DATE, register_date);
////        contentValues.put(DatabaseHelper.REGISTER_TIME, register_time);
////        int i = database.update(DatabaseHelper.BULL_REGISTER_OWNER, contentValues, DatabaseHelper.R_B_ID + " = " + r_b_id, null);
////        return i;
////    }
////
////    public void Bull_Owner_delete(long r_b_id) {
////        database.delete(DatabaseHelper.BULL_REGISTER_OWNER, DatabaseHelper.R_B_ID + "=" + r_b_id, null);
////    }
//
//    //Bull Image And Video Insert
//    public boolean Bull_V_I_Insert(String bull_id, String v_n_i_n, String register_date, String register_time) {
//        try {
//            ContentValues contentValue = new ContentValues();
//            contentValue.put(Constants.BULL_ID, bull_id);
//            contentValue.put(Constants.V_N_I_N, v_n_i_n);
//            contentValue.put(Constants.REGISTER_DATE, register_date);
//            contentValue.put(Constants.REGISTER_TIME, register_time);
//            db.insert(Constants.BULL_VIDEO_IAMAGE, Constants.V_ID, contentValue);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public Cursor Bull_V_I_Owner_fetch(String Search_Bull_id) {
//        String[] columns = new String[]{Constants.BULL_ID, Constants.V_N_I_N, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
//        Cursor c = null;
//
//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_VIDEO_IAMAGE + " WHERE " + Constants.BULL_ID + " LIKE '" + Search_Bull_id + "'";
//            c = db.rawQuery(sql, null);
//            return c;
//        }
//        c = db.query(Constants.BULL_VIDEO_IAMAGE, columns, null, null, null, null, null);
//        return c;
//    }
//
////    public int Bull_V_I_Owner_update(long v_id, String bull_id, String v_n_i_n, String register_date, String register_time) {
////        ContentValues contentValues = new ContentValues();
////        contentValues.put(DatabaseHelper.BULL_ID, bull_id);
////        contentValues.put(DatabaseHelper.V_N_I_N, v_n_i_n);
////        contentValues.put(DatabaseHelper.REGISTER_DATE, register_date);
////        contentValues.put(DatabaseHelper.REGISTER_TIME, register_time);
////        int i = database.update(DatabaseHelper.BULL_VIDEO_IAMAGE, contentValues, DatabaseHelper.V_ID + " = " + v_id, null);
////        return i;
////    }
////
////    public void Bull_V_I_Owner_delete(long v_id) {
////        database.delete(DatabaseHelper.BULL_VIDEO_IAMAGE, DatabaseHelper.V_ID + "=" + v_id, null);
////    }
//
//    //Bull SPIECES Insert
////    public void Bull_SPIECES_Insert(String spieces, String sub_spieces, String register_date, String register_time) {
////        ContentValues contentValue = new ContentValues();
////        contentValue.put(DatabaseHelper.SPIECES, spieces);
////        contentValue.put(DatabaseHelper.SUB_SPIECES, sub_spieces);
////        contentValue.put(DatabaseHelper.REGISTER_DATE, register_date);
////        contentValue.put(DatabaseHelper.REGISTER_TIME, register_time);
////        database.insert(DatabaseHelper.BULL_SPIECES, null, contentValue);
////    }
//
//    public Cursor Bull_SPIECES_Owner_fetch(String s_bs_id) {
//        String[] columns = new String[]{Constants.SPIECES, Constants.SUB_SPIECES, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
//        Cursor c = null;
//
//        if (s_bs_id != null && s_bs_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_SPIECES + " WHERE " + Constants.BS_ID + " LIKE '%" + s_bs_id + "%'";
//            c = db.rawQuery(sql, null);
//            return c;
//        }
//        c = db.query(Constants.BULL_SPIECES, columns, null, null, null, null, null);
//        return c;
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
package com.hr.smariaicamerav2.mDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;


public class DBAdapter {

    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    public DBAdapter(Context c) {
        this.c = c;
        helper = new DBHelper(c);
    }

    //OPEN DB
    public void openDB() {
        try {
            db = helper.getWritableDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //CLOSE
    public void closeDB() {
        try {
            helper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //INSERT DATA
//    public boolean add(String name)
//    {
//        try
//        {
//            ContentValues cv=new ContentValues();
//            cv.put(Constants.NAME, name);
//
//            db.insert(Constants.TB_NAME, Constants.ROW_ID, cv);
//
//            return true;
//
//        }catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    //RETRIEVE DATA AND FILTER
//    public Cursor retrieve(String searchTerm)
//    {
//        String[] columns={Constants.ROW_ID,Constants.NAME};
//        Cursor c=null;
//
//        if(searchTerm != null && searchTerm.length()>0)
//        {
//            String sql="SELECT * FROM "+Constants.TB_NAME+" WHERE "+Constants.NAME+" LIKE '%"+searchTerm+"%'";
//            c=db.rawQuery(sql,null);
//            return c;
//
//        }
//
//        c=db.query(Constants.TB_NAME,columns,null,null,null,null,null);
//        return c;
//    }

    // User Data

    // User Data
    public boolean User_Insert(String fullname, String emails,String username, String password, String imeino, String phone, String createdon) {
        try {
            ContentValues contentValue = new ContentValues();
            contentValue.put(Constants.FULLNAME, fullname);
            contentValue.put(Constants.EMAILS, emails);
            contentValue.put(Constants.USERNAME, username);
            contentValue.put(Constants.PASSWORD, password);
            contentValue.put(Constants.IMEINO, imeino);
            contentValue.put(Constants.PHONE, phone);
            contentValue.put(Constants.CREATEDON, createdon);
            db.insert(Constants.USER_SIGNUP, null, contentValue);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Cursor User_fetch(String Search_Bull_id) {

        String[] columns = new String[]{Constants.USER_ID, Constants.FULLNAME, Constants.USERNAME, Constants.PASSWORD, Constants.IMEINO, Constants.PHONE, Constants.CREATEDON};
        Cursor c = null;

        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
            String sql = "SELECT * FROM " + Constants.USER_SIGNUP + " WHERE " + Constants.FULLNAME + " LIKE '%" + Search_Bull_id + "%'";
            c = db.rawQuery(sql, null);
            return c;
        }
        c = db.query(Constants.USER_SIGNUP, columns, null, null, null, null, null);
        return c;
    }

    public int User_update(long User_ID, String fullname, String username, String password, String imeino, String phone, String createdon) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.FULLNAME, fullname);
        contentValues.put(Constants.USERNAME, username);
        contentValues.put(Constants.PASSWORD, password);
        contentValues.put(Constants.IMEINO, imeino);
        contentValues.put(Constants.PHONE, phone);
        int i = db.update(Constants.USER_SIGNUP, contentValues, Constants.USER_ID + " = " + User_ID, null);
        return i;
    }

    //BUll Data
    public boolean Bull_Insert(String bull_id, String date_ai, String bull_name, String semen_batch_no, String amount_charge, String cash_debit, String register_date, String register_time) {
        try {
            ContentValues contentValue = new ContentValues();
            contentValue.put(Constants.BULL_ID, bull_id);
            contentValue.put(Constants.DATE_AI, date_ai);
            contentValue.put(Constants.BULL_NAME, bull_name);
            contentValue.put(Constants.SEMEN_BATCH_NO, semen_batch_no);
            contentValue.put(Constants.AMOUNT_CHARGE, amount_charge);
            contentValue.put(Constants.CASH_DEBIT, cash_debit);
            contentValue.put(Constants.REGISTER_DATE, register_date);
            contentValue.put(Constants.REGISTER_TIME, register_time);
            db.insert(Constants.BULL_REGISTER, Constants.B_ID, contentValue);

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Cursor Bull_fetch(String Search_Bull_id) {

        String[] columns = {Constants.B_ID, Constants.BULL_ID, Constants.DATE_AI, Constants.BULL_NAME, Constants.SEMEN_BATCH_NO, Constants.AMOUNT_CHARGE, Constants.CASH_DEBIT, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
        Cursor c = null;

        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
            String sql = "SELECT * FROM " + Constants.BULL_REGISTER + " WHERE " + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%'";
            c = db.rawQuery(sql, null);
            return c;
        }
        c = db.query(Constants.BULL_REGISTER, columns, null, null, null, null, null);
        return c;
    }

    public Cursor Last_Bull_fetch() {

//        String[] columns = {Constants.B_ID, Constants.BULL_ID, Constants.DATE_AI, Constants.BULL_NAME, Constants.SEMEN_BATCH_NO, Constants.AMOUNT_CHARGE, Constants.CASH_DEBIT, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
        Cursor c = null;
        String sql = "SELECT * FROM " + Constants.BULL_REGISTER + " ORDER BY " + Constants.B_ID + " DESC LIMIT 1";
        c = db.rawQuery(sql, null);
        return c;

//        c = db.query(Constants.BULL_REGISTER, columns, null, null, null, null, null);
//        return c;
    }

    public Cursor Last_D_Bull_fetch() {

//        String[] columns = {Constants.B_ID, Constants.BULL_ID, Constants.DATE_AI, Constants.BULL_NAME, Constants.SEMEN_BATCH_NO, Constants.AMOUNT_CHARGE, Constants.CASH_DEBIT, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
        Cursor c = null;
        String sql = "SELECT * FROM " + Constants.BULL_DIAGNOSIS + " ORDER BY " + Constants.BD_ID + " DESC LIMIT 1";
        c = db.rawQuery(sql, null);
        return c;

//        c = db.query(Constants.BULL_REGISTER, columns, null, null, null, null, null);
//        return c;
    }

    public Cursor Bull_Date_fetch(String Search_Bull_id) {

        String[] columns = {Constants.B_ID, Constants.BULL_ID, Constants.DATE_AI, Constants.BULL_NAME, Constants.SEMEN_BATCH_NO, Constants.AMOUNT_CHARGE, Constants.CASH_DEBIT, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
        Cursor c = null;

        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
            String sql = "SELECT * FROM " + Constants.BULL_REGISTER + " WHERE " + Constants.REGISTER_DATE + " LIKE '%" + Search_Bull_id + "%'";
            c = db.rawQuery(sql, null);
            return c;
        }
        c = db.query(Constants.BULL_REGISTER, columns, null, null, null, null, null);
        return c;
    }

//    public int Bull_update(long b_id, String bull_id, String date_ai, String bull_name, String semen_batch_no, String amount_charge, String cash_debit, String register_date, String register_time) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DatabaseHelper.B_ID, b_id);
//        contentValues.put(DatabaseHelper.BULL_ID, bull_id);
//        contentValues.put(DatabaseHelper.DATE_AI, date_ai);
//        contentValues.put(DatabaseHelper.BULL_NAME, bull_name);
//        contentValues.put(DatabaseHelper.SEMEN_BATCH_NO, semen_batch_no);
//        contentValues.put(DatabaseHelper.AMOUNT_CHARGE, amount_charge);
//        contentValues.put(DatabaseHelper.CASH_DEBIT, cash_debit);
//        contentValues.put(DatabaseHelper.REGISTER_DATE, register_date);
//        contentValues.put(DatabaseHelper.REGISTER_TIME, register_time);
//        int i = database.update(DatabaseHelper.BULL_REGISTER, contentValues, DatabaseHelper.B_ID + " = " + b_id, null);
//        return i;
//    }
//
//    public void Bull_delete(long b_id) {
//        database.delete(DatabaseHelper.BULL_REGISTER, DatabaseHelper.B_ID + "=" + b_id, null);
//    }

    //Bull Diagnosis Insert
    public boolean Bull_Diagnosis_Insert(String bull_id, String date_ai, String bull_name, String semen_batch_no, String amount_charge, String cash_debit, String register_date, String register_time) {
        try {
            ContentValues contentValue = new ContentValues();
            contentValue.put(Constants.BULL_ID, bull_id);
            contentValue.put(Constants.DATE_AI, date_ai);
            contentValue.put(Constants.BULL_NAME, bull_name);
            contentValue.put(Constants.SEMEN_BATCH_NO, semen_batch_no);
            contentValue.put(Constants.AMOUNT_CHARGE, amount_charge);
            contentValue.put(Constants.CASH_DEBIT, cash_debit);
            contentValue.put(Constants.REGISTER_DATE, register_date);
            contentValue.put(Constants.REGISTER_TIME, register_time);
            db.insert(Constants.BULL_DIAGNOSIS, Constants.BD_ID, contentValue);

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Bull Owner Insert
    public boolean Bull_Owner_Insert(long r_b_id, String bull_id, String date_, String spieces, String sub_spieces, String breed, String number_of_calving, String owner_name, String owner_add, String owner_vil, String owner_dis, String owner_state, String owner_mob, String owner_remark, String register_date, String register_time) {
        try {
            ContentValues contentValue = new ContentValues();
            contentValue.put(Constants.R_B_ID, r_b_id);
            contentValue.put(Constants.BULL_ID, bull_id);
            contentValue.put(Constants.DATE_, date_);
            contentValue.put(Constants.SPIECES, spieces);
            contentValue.put(Constants.SUB_SPIECES, sub_spieces);
            contentValue.put(Constants.BREED, breed);
            contentValue.put(Constants.NUMBER_OF_CALVING, number_of_calving);
            contentValue.put(Constants.OWNER_NAME, owner_name);
            contentValue.put(Constants.OWNER_ADD, owner_add);
            contentValue.put(Constants.OWNER_VIL, owner_vil);
            contentValue.put(Constants.OWNER_DIS, owner_dis);
            contentValue.put(Constants.OWNER_STATE, owner_state);
            contentValue.put(Constants.OWNER_MOB, owner_mob);
            contentValue.put(Constants.OWNER_REMARK, owner_remark);
            contentValue.put(Constants.REGISTER_DATE, register_date);
            contentValue.put(Constants.REGISTER_TIME, register_time);
            db.insert(Constants.BULL_REGISTER_OWNER, Constants.R_B_ID, contentValue);

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean Bull_DOwner_Insert(long bdr_id, String bull_id, String date_, String spieces, String sub_spieces, String breed, String number_of_calving, String owner_name, String owner_add, String owner_vil, String owner_dis, String owner_state, String owner_mob, String owner_remark, String register_date, String register_time) {
        try {
            ContentValues contentValue = new ContentValues();
            contentValue.put(Constants.BDR_ID, bdr_id);
            contentValue.put(Constants.BULL_ID, bull_id);
            contentValue.put(Constants.DATE_, date_);
            contentValue.put(Constants.SPIECES, spieces);
            contentValue.put(Constants.SUB_SPIECES, sub_spieces);
            contentValue.put(Constants.BREED, breed);
            contentValue.put(Constants.NUMBER_OF_CALVING, number_of_calving);
            contentValue.put(Constants.OWNER_NAME, owner_name);
            contentValue.put(Constants.OWNER_ADD, owner_add);
            contentValue.put(Constants.OWNER_VIL, owner_vil);
            contentValue.put(Constants.OWNER_DIS, owner_dis);
            contentValue.put(Constants.OWNER_STATE, owner_state);
            contentValue.put(Constants.OWNER_MOB, owner_mob);
            contentValue.put(Constants.OWNER_REMARK, owner_remark);
            contentValue.put(Constants.REGISTER_DATE, register_date);
            contentValue.put(Constants.REGISTER_TIME, register_time);
            db.insert(Constants.BULL_DREGISTER_OWNER, Constants.BDR_ID, contentValue);

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public Cursor Bull_Owner_Id_fetch1(String Search_Bull_id) {

//        String[] columns = new String[]{Constants.R_B_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
        Cursor c = null;

        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%' GROUP BY " + Constants.R_B_ID;
            //+ " LIKE '%" + Search_Bull_id + "%'";
            c = db.rawQuery(sql, null);
//            return c;
        }
//        c = db.query(Constants.BULL_REGISTER_OWNER, columns, null, null, null, null, null);
        return c;
    }
    public Cursor Bull_Owner_Id_fetch2Get(String Search_Bull_id) {

//        String[] columns = new String[]{Constants.R_B_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
        Cursor c = null;

        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.BULL_ID + " = " + Search_Bull_id + " GROUP BY " + Constants.R_B_ID;
            //+ " LIKE '%" + Search_Bull_id + "%'";
            c = db.rawQuery(sql, null);
//            return c;
        }
//        c = db.query(Constants.BULL_REGISTER_OWNER, columns, null, null, null, null, null);
        return c;
    }

    public Cursor Bull_Owner_Id_fetch(String Search_Bull_id) {

//        String[] columns = new String[]{"ro." + Constants.R_B_ID, "ro." + Constants.BULL_ID, "ro." + Constants.DATE_, "ro." + Constants.SPIECES,
//                "ro." + Constants.SUB_SPIECES, "ro." + Constants.BREED, "ro." + Constants.NUMBER_OF_CALVING, "ro." + Constants.OWNER_NAME, "ro." + Constants.OWNER_ADD, "ro." + Constants.OWNER_VIL,
//                "ro." + Constants.OWNER_DIS, "ro." + Constants.OWNER_STATE, "ro." + Constants.OWNER_MOB, "ro." + Constants.OWNER_REMARK, "ro." + Constants.REGISTER_DATE, "ro." + Constants.REGISTER_TIME, "vi." + Constants.B_ID, "vi." + Constants.REGISTER_TIME, "vi." + Constants.V_N_I_N};
        Cursor c = null;

        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%'";
            String sql = "SELECT " + Constants.BULL_REGISTER + ".*," + Constants.BULL_REGISTER_OWNER + ".*," + Constants.BULL_VIDEO_IAMAGE + ".* FROM " + Constants.BULL_REGISTER + " INNER JOIN " + Constants.BULL_REGISTER_OWNER + " ON " + Constants.BULL_REGISTER_OWNER + "." + Constants.BULL_ID + " = " + Constants.BULL_REGISTER + "." + Constants.BULL_ID + " INNER JOIN " + Constants.BULL_VIDEO_IAMAGE + " ON " + Constants.BULL_VIDEO_IAMAGE + "." + Constants.BULL_ID + " = " + Constants.BULL_REGISTER_OWNER + "." + Constants.BULL_ID + " WHERE " +Constants.BULL_VIDEO_IAMAGE+"."+Constants.B_ID+" = " +Constants.BULL_REGISTER+"."+Constants.B_ID+" and "+ Constants.BULL_VIDEO_IAMAGE + "." + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%' group by " + Constants.BULL_VIDEO_IAMAGE + "." + Constants.REGISTER_TIME;
            c = db.rawQuery(sql, null);
//            return c;
        }else{
            String sql = "SELECT " + Constants.BULL_REGISTER + ".*," + Constants.BULL_REGISTER_OWNER + ".*," + Constants.BULL_VIDEO_IAMAGE + ".* FROM " + Constants.BULL_REGISTER + " INNER JOIN " + Constants.BULL_REGISTER_OWNER + " ON " + Constants.BULL_REGISTER_OWNER + "." + Constants.BULL_ID + " = " + Constants.BULL_REGISTER + "." + Constants.BULL_ID + " INNER JOIN " + Constants.BULL_VIDEO_IAMAGE + " ON " + Constants.BULL_VIDEO_IAMAGE + "." + Constants.BULL_ID + " = " + Constants.BULL_REGISTER_OWNER + "." + Constants.BULL_ID + " WHERE " +Constants.BULL_VIDEO_IAMAGE+"."+Constants.B_ID+" = " +Constants.BULL_REGISTER+"."+Constants.B_ID+" and "+ Constants.BULL_VIDEO_IAMAGE + "." + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%' group by " + Constants.BULL_VIDEO_IAMAGE + "." + Constants.REGISTER_TIME;
            c = db.rawQuery(sql, null);
        }
//        c = db.query(Constants.BULL_REGISTER_OWNER + " as ro," + Constants.BULL_VIDEO_IAMAGE + " as vi,"+ Constants.BULL_REGISTER + " as br", columns, null, null, "vi." + Constants.REGISTER_TIME, null, null);
        return c;
    }

    public Cursor Bull_Owner_Date_fetch(String Search_Bull_id) {
//        String[] columns = new String[]{Constants.R_B_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME, Constants.V_N_I_N};
//        String[] columns = new String[]{"ro." + Constants.R_B_ID, "ro." + Constants.BULL_ID, "ro." + Constants.DATE_, "ro." + Constants.SPIECES,
//                "ro." + Constants.SUB_SPIECES, "ro." + Constants.BREED, "ro." + Constants.NUMBER_OF_CALVING, "ro." + Constants.OWNER_NAME, "ro." + Constants.OWNER_ADD, "ro." + Constants.OWNER_VIL,
//                "ro." + Constants.OWNER_DIS, "ro." + Constants.OWNER_STATE, "ro." + Constants.OWNER_MOB, "ro." + Constants.OWNER_REMARK, "ro." + Constants.REGISTER_DATE, "ro." + Constants.REGISTER_TIME, "vi." + Constants.B_ID, "vi." + Constants.REGISTER_TIME, "vi." + Constants.V_N_I_N};

        Cursor c = null;

//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.REGISTER_DATE + " LIKE '%" + Search_Bull_id + "%'";
            String sql = "SELECT " + Constants.BULL_REGISTER + ".*," + Constants.BULL_REGISTER_OWNER + ".*," + Constants.BULL_VIDEO_IAMAGE + ".* FROM " + Constants.BULL_REGISTER + " INNER JOIN " + Constants.BULL_REGISTER_OWNER + " ON " + Constants.BULL_REGISTER_OWNER + "." + Constants.BULL_ID + " = " + Constants.BULL_REGISTER + "." + Constants.BULL_ID + " INNER JOIN " + Constants.BULL_VIDEO_IAMAGE + " ON " + Constants.BULL_VIDEO_IAMAGE + "." + Constants.BULL_ID + " = " + Constants.BULL_REGISTER_OWNER + "." + Constants.BULL_ID + " WHERE " +Constants.BULL_VIDEO_IAMAGE+"."+Constants.B_ID+" = " +Constants.BULL_REGISTER+"."+Constants.B_ID+" and "+ Constants.BULL_VIDEO_IAMAGE + "." + Constants.REGISTER_DATE + " LIKE '%" + Search_Bull_id + "%' group by " + Constants.BULL_VIDEO_IAMAGE + "." + Constants.REGISTER_TIME;
            c = db.rawQuery(sql, null);
            return c;
//        }
////        c = db.query(Constants.BULL_REGISTER_OWNER, columns, null, null, null, null, null);
//        c = db.query(Constants.BULL_REGISTER_OWNER + " as ro," + Constants.BULL_VIDEO_IAMAGE + " as vi,"+ Constants.BULL_REGISTER + " as br", columns, null, null, "vi." + Constants.REGISTER_TIME, null, null);
//        return c;
    }

    public Cursor Bull_Owner_Vill_fetch(String Search_Bull_id) {
//        String[] columns = new String[]{Constants.R_B_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME, Constants.V_N_I_N};
//        String[] columns = new String[]{"ro." + Constants.R_B_ID, "ro." + Constants.BULL_ID, "ro." + Constants.DATE_, "ro." + Constants.SPIECES,
//                "ro." + Constants.SUB_SPIECES, "ro." + Constants.BREED, "ro." + Constants.NUMBER_OF_CALVING, "ro." + Constants.OWNER_NAME, "ro." + Constants.OWNER_ADD, "ro." + Constants.OWNER_VIL,
//                "ro." + Constants.OWNER_DIS, "ro." + Constants.OWNER_STATE, "ro." + Constants.OWNER_MOB, "ro." + Constants.OWNER_REMARK, "ro." + Constants.REGISTER_DATE, "ro." + Constants.REGISTER_TIME, "vi." + Constants.B_ID, "vi." + Constants.REGISTER_TIME, "vi." + Constants.V_N_I_N};

        Cursor c = null;

//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.OWNER_VIL + " LIKE '%" + Search_Bull_id + "%'";
            String sql = "SELECT " + Constants.BULL_REGISTER + ".*," + Constants.BULL_REGISTER_OWNER + ".*," + Constants.BULL_VIDEO_IAMAGE + ".* FROM " + Constants.BULL_REGISTER + " INNER JOIN " + Constants.BULL_REGISTER_OWNER + " ON " + Constants.BULL_REGISTER_OWNER + "." + Constants.BULL_ID + " = " + Constants.BULL_REGISTER + "." + Constants.BULL_ID + " INNER JOIN " + Constants.BULL_VIDEO_IAMAGE + " ON " + Constants.BULL_VIDEO_IAMAGE + "." + Constants.BULL_ID + " = " + Constants.BULL_REGISTER_OWNER + "." + Constants.BULL_ID + " WHERE " +Constants.BULL_VIDEO_IAMAGE+"."+Constants.B_ID+" = " +Constants.BULL_REGISTER+"."+Constants.B_ID+" and "+ Constants.BULL_REGISTER_OWNER + "." + Constants.OWNER_VIL + " LIKE '%" + Search_Bull_id + "%' group by " + Constants.BULL_VIDEO_IAMAGE + "." + Constants.REGISTER_TIME;
            c = db.rawQuery(sql, null);
            return c;
//        }
////        c = db.query(Constants.BULL_REGISTER_OWNER, columns, null, null, null, null, null);
//        c = db.query(Constants.BULL_REGISTER_OWNER + " as ro," + Constants.BULL_VIDEO_IAMAGE + " as vi,"+ Constants.BULL_REGISTER + " as br", columns, null, null, "vi." + Constants.REGISTER_TIME, null, null);
//        return c;
    }

    public Cursor Bull_Owner_Dist_fetch(String Search_Bull_id) {
//        String[] columns = new String[]{Constants.R_B_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME, Constants.V_N_I_N};
//        String[] columns = new String[]{"ro." + Constants.R_B_ID, "ro." + Constants.BULL_ID, "ro." + Constants.DATE_, "ro." + Constants.SPIECES,
//                "ro." + Constants.SUB_SPIECES, "ro." + Constants.BREED, "ro." + Constants.NUMBER_OF_CALVING, "ro." + Constants.OWNER_NAME, "ro." + Constants.OWNER_ADD, "ro." + Constants.OWNER_VIL,
//                "ro." + Constants.OWNER_DIS, "ro." + Constants.OWNER_STATE, "ro." + Constants.OWNER_MOB, "ro." + Constants.OWNER_REMARK, "ro." + Constants.REGISTER_DATE, "ro." + Constants.REGISTER_TIME, "vi." + Constants.B_ID, "vi." + Constants.REGISTER_TIME, "vi." + Constants.V_N_I_N};

        Cursor c = null;

//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.OWNER_VIL + " LIKE '%" + Search_Bull_id + "%'";
        String sql = "SELECT " + Constants.BULL_REGISTER + ".*," + Constants.BULL_REGISTER_OWNER + ".*," + Constants.BULL_VIDEO_IAMAGE + ".* FROM " + Constants.BULL_REGISTER + " INNER JOIN " + Constants.BULL_REGISTER_OWNER + " ON " + Constants.BULL_REGISTER_OWNER + "." + Constants.BULL_ID + " = " + Constants.BULL_REGISTER + "." + Constants.BULL_ID + " INNER JOIN " + Constants.BULL_VIDEO_IAMAGE + " ON " + Constants.BULL_VIDEO_IAMAGE + "." + Constants.BULL_ID + " = " + Constants.BULL_REGISTER_OWNER + "." + Constants.BULL_ID + " WHERE " +Constants.BULL_VIDEO_IAMAGE+"."+Constants.B_ID+" = " +Constants.BULL_REGISTER+"."+Constants.B_ID+" and "+ Constants.BULL_REGISTER_OWNER + "." + Constants.OWNER_DIS + " LIKE '%" + Search_Bull_id + "%' group by " + Constants.BULL_VIDEO_IAMAGE + "." + Constants.REGISTER_TIME;
        c = db.rawQuery(sql, null);
        return c;
//        }
////        c = db.query(Constants.BULL_REGISTER_OWNER, columns, null, null, null, null, null);
//        c = db.query(Constants.BULL_REGISTER_OWNER + " as ro," + Constants.BULL_VIDEO_IAMAGE + " as vi,"+ Constants.BULL_REGISTER + " as br", columns, null, null, "vi." + Constants.REGISTER_TIME, null, null);
//        return c;
    }
    public Cursor Bull_Owner_State_fetch(String Search_Bull_id) {
//        String[] columns = new String[]{Constants.R_B_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME, Constants.V_N_I_N};
//        String[] columns = new String[]{"ro." + Constants.R_B_ID, "ro." + Constants.BULL_ID, "ro." + Constants.DATE_, "ro." + Constants.SPIECES,
//                "ro." + Constants.SUB_SPIECES, "ro." + Constants.BREED, "ro." + Constants.NUMBER_OF_CALVING, "ro." + Constants.OWNER_NAME, "ro." + Constants.OWNER_ADD, "ro." + Constants.OWNER_VIL,
//                "ro." + Constants.OWNER_DIS, "ro." + Constants.OWNER_STATE, "ro." + Constants.OWNER_MOB, "ro." + Constants.OWNER_REMARK, "ro." + Constants.REGISTER_DATE, "ro." + Constants.REGISTER_TIME, "vi." + Constants.B_ID, "vi." + Constants.REGISTER_TIME, "vi." + Constants.V_N_I_N};

        Cursor c = null;

//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.OWNER_VIL + " LIKE '%" + Search_Bull_id + "%'";
        String sql = "SELECT " + Constants.BULL_REGISTER + ".*," + Constants.BULL_REGISTER_OWNER + ".*," + Constants.BULL_VIDEO_IAMAGE + ".* FROM " + Constants.BULL_REGISTER + " INNER JOIN " + Constants.BULL_REGISTER_OWNER + " ON " + Constants.BULL_REGISTER_OWNER + "." + Constants.BULL_ID + " = " + Constants.BULL_REGISTER + "." + Constants.BULL_ID + " INNER JOIN " + Constants.BULL_VIDEO_IAMAGE + " ON " + Constants.BULL_VIDEO_IAMAGE + "." + Constants.BULL_ID + " = " + Constants.BULL_REGISTER_OWNER + "." + Constants.BULL_ID + " WHERE " +Constants.BULL_VIDEO_IAMAGE+"."+Constants.B_ID+" = " +Constants.BULL_REGISTER+"."+Constants.B_ID+" and "+ Constants.BULL_REGISTER_OWNER + "." + Constants.OWNER_STATE + " LIKE '%" + Search_Bull_id + "%' group by " + Constants.BULL_VIDEO_IAMAGE + "." + Constants.REGISTER_TIME;
        c = db.rawQuery(sql, null);
        return c;
//        }
////        c = db.query(Constants.BULL_REGISTER_OWNER, columns, null, null, null, null, null);
//        c = db.query(Constants.BULL_REGISTER_OWNER + " as ro," + Constants.BULL_VIDEO_IAMAGE + " as vi,"+ Constants.BULL_REGISTER + " as br", columns, null, null, "vi." + Constants.REGISTER_TIME, null, null);
//        return c;
    }
//    public Cursor Bull_D_Owner_Id_fetch(String Search_Bull_id) {
//
//        String[] columns = new String[]{Constants.BDR_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
//        Cursor c = null;
//
//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_DREGISTER_OWNER + " WHERE " + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%'";
//            c = db.rawQuery(sql, null);
//            return c;
//        }
//        c = db.query(Constants.BULL_DREGISTER_OWNER, columns, null, null, null, null, null);
//        return c;
//    }
//
//    public Cursor Bull_D_Owner_Date_fetch(String Search_Bull_id) {
//        String[] columns = new String[]{Constants.BDR_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
//        Cursor c = null;
//
//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_DREGISTER_OWNER + " WHERE " + Constants.REGISTER_DATE + " LIKE '%" + Search_Bull_id + "%'";
//            c = db.rawQuery(sql, null);
//            return c;
//        }
//        c = db.query(Constants.BULL_DREGISTER_OWNER, columns, null, null, null, null, null);
//        return c;
//    }
//
//    public Cursor Bull_D_Owner_Vill_fetch(String Search_Bull_id) {
//        String[] columns = new String[]{Constants.BDR_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
//        Cursor c = null;
//
//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_DREGISTER_OWNER + " WHERE " + Constants.OWNER_VIL + " LIKE '%" + Search_Bull_id + "%'";
//            c = db.rawQuery(sql, null);
//            return c;
//        }
//        c = db.query(Constants.BULL_DREGISTER_OWNER, columns, null, null, null, null, null);
//        return c;
//    }

    //    public int Bull_Owner_update(long r_b_id, String bull_id, String date_, String spieces, String sub_spieces, String breed,
//                                 String number_of_calving, String owner_name, String owner_add, String owner_vil, String owner_dis,
//                                 String owner_state, String owner_mob, String owner_remark, String register_date, String register_time) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DatabaseHelper.R_B_ID, r_b_id);
//        contentValues.put(DatabaseHelper.BULL_ID, bull_id);
//        contentValues.put(DatabaseHelper.DATE_, date_);
//        contentValues.put(DatabaseHelper.SPIECES, spieces);
//        contentValues.put(DatabaseHelper.SUB_SPIECES, sub_spieces);
//        contentValues.put(DatabaseHelper.BREED, breed);
//        contentValues.put(DatabaseHelper.NUMBER_OF_CALVING, number_of_calving);
//        contentValues.put(DatabaseHelper.OWNER_NAME, owner_name);
//        contentValues.put(DatabaseHelper.OWNER_ADD, owner_add);
//        contentValues.put(DatabaseHelper.OWNER_VIL, owner_vil);
//        contentValues.put(DatabaseHelper.OWNER_DIS, owner_dis);
//        contentValues.put(DatabaseHelper.OWNER_STATE, owner_state);
//        contentValues.put(DatabaseHelper.OWNER_MOB, owner_mob);
//        contentValues.put(DatabaseHelper.OWNER_REMARK, owner_remark);
//        contentValues.put(DatabaseHelper.REGISTER_DATE, register_date);
//        contentValues.put(DatabaseHelper.REGISTER_TIME, register_time);
//        int i = database.update(DatabaseHelper.BULL_REGISTER_OWNER, contentValues, DatabaseHelper.R_B_ID + " = " + r_b_id, null);
//        return i;
//    }
//
//    public void Bull_Owner_delete(long r_b_id) {
//        database.delete(DatabaseHelper.BULL_REGISTER_OWNER, DatabaseHelper.R_B_ID + "=" + r_b_id, null);
//    }
    public Cursor Bull_D_Owner_Id_fetch1(String Search_Bull_id) {

//        String[] columns = new String[]{Constants.BDR_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
        Cursor c = null;

        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
            String sql = "SELECT * FROM " + Constants.BULL_DREGISTER_OWNER + " WHERE " + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%' GROUP BY " + Constants.BDR_ID;
            c = db.rawQuery(sql, null);
//            Log.e("d sql ",""+sql);
//            Log.e("d sql ",""+c);
//            if(sql!=null) {//+ " LIKE '%" + Search_Bull_id + "%'";
//                Log.e("d sql if",""+sql);
//                String sql1 = "SELECT * FROM " + Constants.BULL_DREGISTER_OWNER + " WHERE " + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%' GROUP BY " + Constants.BDR_ID;
//                c = db.rawQuery(sql1, null);
//            }else {
//                Log.e("d sql else",""+sql);
//                String sql2 = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%' GROUP BY " + Constants.R_B_ID;
//                //+ " LIKE '%" + Search_Bull_id + "%'";
//                c = db.rawQuery(sql2, null);
//            }
//            return c;
        }
//        c = db.query(Constants.BULL_DREGISTER_OWNER, columns, null, null, null, null, null);
        return c;
    }
    public Cursor Bull_D_Owner_Id_fetch2Get(String Search_Bull_id) {

//        String[] columns = new String[]{Constants.BDR_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
        Cursor c = null;

        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
            String sql = "SELECT * FROM " + Constants.BULL_DREGISTER_OWNER + " WHERE " + Constants.BULL_ID + " = " + Search_Bull_id + " GROUP BY " + Constants.BDR_ID;
            //+ " LIKE '%" + Search_Bull_id + "%'";
            c = db.rawQuery(sql, null);
//            return c;
        }
//        c = db.query(Constants.BULL_DREGISTER_OWNER, columns, null, null, null, null, null);
        return c;
    }

    public Cursor Bull_D_Owner_Id_fetch(String Search_Bull_id) {

//        String[] columns = new String[]{"ro." + Constants.BDR_ID, "ro." + Constants.BULL_ID, "ro." + Constants.DATE_, "ro." + Constants.SPIECES,
//                "ro." + Constants.SUB_SPIECES, "ro." + Constants.BREED, "ro." + Constants.NUMBER_OF_CALVING, "ro." + Constants.OWNER_NAME, "ro." + Constants.OWNER_ADD, "ro." + Constants.OWNER_VIL,
//                "ro." + Constants.OWNER_DIS, "ro." + Constants.OWNER_STATE, "ro." + Constants.OWNER_MOB, "ro." + Constants.OWNER_REMARK, "ro." + Constants.REGISTER_DATE, "ro." + Constants.REGISTER_TIME, "vi." + Constants.BD_ID,"vi." + Constants.REGISTER_TIME, "vi." + Constants.V_D_N_I_N};
        Cursor c = null;

        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%'";
//            String sql = "SELECT * FROM " + Constants.BULL_DIAGNOSIS + " INNER JOIN " + Constants.BULL_DREGISTER_OWNER + " ON " + Constants.BULL_DREGISTER_OWNER + "." + Constants.BULL_ID + " = " + Constants.BULL_DIAGNOSIS + "." + Constants.BULL_ID + " INNER JOIN " + Constants.BULL_D_VIDEO_IAMAGE + " ON " + Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.BULL_ID + " = " + Constants.BULL_DREGISTER_OWNER + "." + Constants.BULL_ID + " WHERE " +Constants.BULL_D_VIDEO_IAMAGE+"."+Constants.BD_ID+" = " +Constants.BULL_DIAGNOSIS+"."+Constants.BD_ID+" and "+ Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%' group by " + Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.REGISTER_TIME;
            String sql = "SELECT " + Constants.BULL_DIAGNOSIS + ".*," + Constants.BULL_DREGISTER_OWNER + ".*," + Constants.BULL_D_VIDEO_IAMAGE + ".* FROM " + Constants.BULL_DIAGNOSIS + " INNER JOIN " + Constants.BULL_DREGISTER_OWNER + " ON " + Constants.BULL_DREGISTER_OWNER + "." + Constants.BULL_ID + " = " + Constants.BULL_DIAGNOSIS + "." + Constants.BULL_ID + " INNER JOIN " + Constants.BULL_D_VIDEO_IAMAGE + " ON " + Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.BULL_ID + " = " + Constants.BULL_DREGISTER_OWNER + "." + Constants.BULL_ID + " WHERE " +Constants.BULL_D_VIDEO_IAMAGE+"."+Constants.BD_ID+" = " +Constants.BULL_DIAGNOSIS+"."+Constants.BD_ID+" and "+ Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%' group by " + Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.REGISTER_TIME;
            c = db.rawQuery(sql, null);
//            return c;
        }else{
            String sql = "SELECT " + Constants.BULL_DIAGNOSIS + ".*," + Constants.BULL_DREGISTER_OWNER + ".*," + Constants.BULL_D_VIDEO_IAMAGE + ".* FROM " + Constants.BULL_DIAGNOSIS + " INNER JOIN " + Constants.BULL_DREGISTER_OWNER + " ON " + Constants.BULL_DREGISTER_OWNER + "." + Constants.BULL_ID + " = " + Constants.BULL_DIAGNOSIS + "." + Constants.BULL_ID + " INNER JOIN " + Constants.BULL_D_VIDEO_IAMAGE + " ON " + Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.BULL_ID + " = " + Constants.BULL_DREGISTER_OWNER + "." + Constants.BULL_ID + " WHERE " +Constants.BULL_D_VIDEO_IAMAGE+"."+Constants.BD_ID+" = " +Constants.BULL_DIAGNOSIS+"."+Constants.BD_ID+" and "+ Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%' group by " + Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.REGISTER_TIME;
            c = db.rawQuery(sql, null);
        }
//        c = db.query(Constants.BULL_DREGISTER_OWNER + " as ro," + Constants.BULL_D_VIDEO_IAMAGE + " as vi,"+ Constants.BULL_DIAGNOSIS + " as bdr", columns, null, null, "vi." + Constants.REGISTER_TIME, null, null);
        return c;
    }

    public Cursor Bull_D_Owner_Date_fetch(String Search_Bull_id) {
//        String[] columns = new String[]{Constants.R_B_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME, Constants.V_N_I_N};
//        String[] columns = new String[]{"ro." + Constants.BDR_ID, "ro." + Constants.BULL_ID, "ro." + Constants.DATE_, "ro." + Constants.SPIECES,
//                "ro." + Constants.SUB_SPIECES, "ro." + Constants.BREED, "ro." + Constants.NUMBER_OF_CALVING, "ro." + Constants.OWNER_NAME, "ro." + Constants.OWNER_ADD, "ro." + Constants.OWNER_VIL,
//                "ro." + Constants.OWNER_DIS, "ro." + Constants.OWNER_STATE, "ro." + Constants.OWNER_MOB, "ro." + Constants.OWNER_REMARK, "ro." + Constants.REGISTER_DATE, "ro." + Constants.REGISTER_TIME, "vi." + Constants.BD_ID, "vi." + Constants.REGISTER_TIME, "vi." + Constants.V_D_N_I_N};

        Cursor c = null;

//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%'";
            String sql = "SELECT " + Constants.BULL_DIAGNOSIS + ".*," + Constants.BULL_DREGISTER_OWNER + ".*," + Constants.BULL_D_VIDEO_IAMAGE + ".* FROM " + Constants.BULL_DIAGNOSIS + " INNER JOIN " + Constants.BULL_DREGISTER_OWNER + " ON " + Constants.BULL_DREGISTER_OWNER + "." + Constants.BULL_ID + " = " + Constants.BULL_DIAGNOSIS + "." + Constants.BULL_ID + " INNER JOIN " + Constants.BULL_D_VIDEO_IAMAGE + " ON " + Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.BULL_ID + " = " + Constants.BULL_DREGISTER_OWNER + "." + Constants.BULL_ID + " WHERE " +Constants.BULL_D_VIDEO_IAMAGE+"."+Constants.BD_ID+" = " +Constants.BULL_DIAGNOSIS+"."+Constants.BD_ID+" and "+ Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.REGISTER_DATE + " LIKE '%" + Search_Bull_id + "%' group by " + Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.REGISTER_TIME;
            c = db.rawQuery(sql, null);
            return c;
//        }
//        c = db.query(Constants.BULL_DREGISTER_OWNER + " as ro," + Constants.BULL_D_VIDEO_IAMAGE + " as vi,"+ Constants.BULL_DIAGNOSIS + " as bdr", columns, null, null, "vi." + Constants.REGISTER_TIME, null, null);
//        return c;
    }

    public Cursor Bull_D_Owner_Vill_fetch(String Search_Bull_id) {
//        String[] columns = new String[]{Constants.R_B_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME, Constants.V_N_I_N};
//        String[] columns = new String[]{"ro." + Constants.BDR_ID, "ro." + Constants.BULL_ID, "ro." + Constants.DATE_, "ro." + Constants.SPIECES,
//                "ro." + Constants.SUB_SPIECES, "ro." + Constants.BREED, "ro." + Constants.NUMBER_OF_CALVING, "ro." + Constants.OWNER_NAME, "ro." + Constants.OWNER_ADD, "ro." + Constants.OWNER_VIL,
//                "ro." + Constants.OWNER_DIS, "ro." + Constants.OWNER_STATE, "ro." + Constants.OWNER_MOB, "ro." + Constants.OWNER_REMARK, "ro." + Constants.REGISTER_DATE, "ro." + Constants.REGISTER_TIME, "vi." + Constants.BD_ID, "vi." + Constants.REGISTER_TIME, "vi." + Constants.V_D_N_I_N};

        Cursor c = null;

//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%'";
            String sql = "SELECT " + Constants.BULL_DIAGNOSIS + ".*," + Constants.BULL_DREGISTER_OWNER + ".*," + Constants.BULL_D_VIDEO_IAMAGE + ".* FROM " + Constants.BULL_DIAGNOSIS + " INNER JOIN " + Constants.BULL_DREGISTER_OWNER + " ON " + Constants.BULL_DREGISTER_OWNER + "." + Constants.BULL_ID + " = " + Constants.BULL_DIAGNOSIS + "." + Constants.BULL_ID + " INNER JOIN " + Constants.BULL_D_VIDEO_IAMAGE + " ON " + Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.BULL_ID + " = " + Constants.BULL_DREGISTER_OWNER + "." + Constants.BULL_ID + " WHERE " +Constants.BULL_D_VIDEO_IAMAGE+"."+Constants.BD_ID+" = " +Constants.BULL_DIAGNOSIS+"."+Constants.BD_ID+" and "+ Constants.BULL_DREGISTER_OWNER + "." + Constants.OWNER_VIL + " LIKE '%" + Search_Bull_id + "%' group by " + Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.REGISTER_TIME;
            c = db.rawQuery(sql, null);
            return c;
//        }
//        c = db.query(Constants.BULL_DREGISTER_OWNER + " as ro," + Constants.BULL_D_VIDEO_IAMAGE + " as vi,"+ Constants.BULL_DIAGNOSIS + " as bdr", columns, null, null, "vi." + Constants.REGISTER_TIME, null, null);
//        return c;
    }
    public Cursor Bull_D_Owner_Dist_fetch(String Search_Bull_id) {
//        String[] columns = new String[]{Constants.R_B_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME, Constants.V_N_I_N};
//        String[] columns = new String[]{"ro." + Constants.BDR_ID, "ro." + Constants.BULL_ID, "ro." + Constants.DATE_, "ro." + Constants.SPIECES,
//                "ro." + Constants.SUB_SPIECES, "ro." + Constants.BREED, "ro." + Constants.NUMBER_OF_CALVING, "ro." + Constants.OWNER_NAME, "ro." + Constants.OWNER_ADD, "ro." + Constants.OWNER_VIL,
//                "ro." + Constants.OWNER_DIS, "ro." + Constants.OWNER_STATE, "ro." + Constants.OWNER_MOB, "ro." + Constants.OWNER_REMARK, "ro." + Constants.REGISTER_DATE, "ro." + Constants.REGISTER_TIME, "vi." + Constants.BD_ID, "vi." + Constants.REGISTER_TIME, "vi." + Constants.V_D_N_I_N};

        Cursor c = null;

//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%'";
        String sql = "SELECT " + Constants.BULL_DIAGNOSIS + ".*," + Constants.BULL_DREGISTER_OWNER + ".*," + Constants.BULL_D_VIDEO_IAMAGE + ".* FROM " + Constants.BULL_DIAGNOSIS + " INNER JOIN " + Constants.BULL_DREGISTER_OWNER + " ON " + Constants.BULL_DREGISTER_OWNER + "." + Constants.BULL_ID + " = " + Constants.BULL_DIAGNOSIS + "." + Constants.BULL_ID + " INNER JOIN " + Constants.BULL_D_VIDEO_IAMAGE + " ON " + Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.BULL_ID + " = " + Constants.BULL_DREGISTER_OWNER + "." + Constants.BULL_ID + " WHERE " +Constants.BULL_D_VIDEO_IAMAGE+"."+Constants.BD_ID+" = " +Constants.BULL_DIAGNOSIS+"."+Constants.BD_ID+" and "+ Constants.BULL_DREGISTER_OWNER + "." + Constants.OWNER_DIS + " LIKE '%" + Search_Bull_id + "%' group by " + Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.REGISTER_TIME;
        c = db.rawQuery(sql, null);
        return c;
//        }
//        c = db.query(Constants.BULL_DREGISTER_OWNER + " as ro," + Constants.BULL_D_VIDEO_IAMAGE + " as vi,"+ Constants.BULL_DIAGNOSIS + " as bdr", columns, null, null, "vi." + Constants.REGISTER_TIME, null, null);
//        return c;
    }
    public Cursor Bull_D_Owner_State_fetch(String Search_Bull_id) {
//        String[] columns = new String[]{Constants.R_B_ID, Constants.BULL_ID, Constants.DATE_, Constants.SPIECES,
//                Constants.SUB_SPIECES, Constants.BREED, Constants.NUMBER_OF_CALVING, Constants.OWNER_NAME, Constants.OWNER_ADD, Constants.OWNER_VIL,
//                Constants.OWNER_DIS, Constants.OWNER_STATE, Constants.OWNER_MOB, Constants.OWNER_REMARK, Constants.REGISTER_DATE, Constants.REGISTER_TIME, Constants.V_N_I_N};
//        String[] columns = new String[]{"ro." + Constants.BDR_ID, "ro." + Constants.BULL_ID, "ro." + Constants.DATE_, "ro." + Constants.SPIECES,
//                "ro." + Constants.SUB_SPIECES, "ro." + Constants.BREED, "ro." + Constants.NUMBER_OF_CALVING, "ro." + Constants.OWNER_NAME, "ro." + Constants.OWNER_ADD, "ro." + Constants.OWNER_VIL,
//                "ro." + Constants.OWNER_DIS, "ro." + Constants.OWNER_STATE, "ro." + Constants.OWNER_MOB, "ro." + Constants.OWNER_REMARK, "ro." + Constants.REGISTER_DATE, "ro." + Constants.REGISTER_TIME, "vi." + Constants.BD_ID, "vi." + Constants.REGISTER_TIME, "vi." + Constants.V_D_N_I_N};

        Cursor c = null;

//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
//            String sql = "SELECT * FROM " + Constants.BULL_REGISTER_OWNER + " WHERE " + Constants.BULL_ID + " LIKE '%" + Search_Bull_id + "%'";
        String sql = "SELECT " + Constants.BULL_DIAGNOSIS + ".*," + Constants.BULL_DREGISTER_OWNER + ".*," + Constants.BULL_D_VIDEO_IAMAGE + ".* FROM " + Constants.BULL_DIAGNOSIS + " INNER JOIN " + Constants.BULL_DREGISTER_OWNER + " ON " + Constants.BULL_DREGISTER_OWNER + "." + Constants.BULL_ID + " = " + Constants.BULL_DIAGNOSIS + "." + Constants.BULL_ID + " INNER JOIN " + Constants.BULL_D_VIDEO_IAMAGE + " ON " + Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.BULL_ID + " = " + Constants.BULL_DREGISTER_OWNER + "." + Constants.BULL_ID + " WHERE " +Constants.BULL_D_VIDEO_IAMAGE+"."+Constants.BD_ID+" = " +Constants.BULL_DIAGNOSIS+"."+Constants.BD_ID+" and "+ Constants.BULL_DREGISTER_OWNER + "." + Constants.OWNER_STATE + " LIKE '%" + Search_Bull_id + "%' group by " + Constants.BULL_D_VIDEO_IAMAGE + "." + Constants.REGISTER_TIME;
        c = db.rawQuery(sql, null);
        return c;
//        }
//        c = db.query(Constants.BULL_DREGISTER_OWNER + " as ro," + Constants.BULL_D_VIDEO_IAMAGE + " as vi,"+ Constants.BULL_DIAGNOSIS + " as bdr", columns, null, null, "vi." + Constants.REGISTER_TIME, null, null);
//        return c;
    }
    //Bull Image And Video Insert
    public boolean Bull_V_I_Insert(int b_id, String bull_id, String v_n_i_n, String register_date, String register_time) {
        try {
            ContentValues contentValue = new ContentValues();
            contentValue.put(Constants.B_ID, b_id);
            contentValue.put(Constants.BULL_ID, bull_id);
            contentValue.put(Constants.V_N_I_N, v_n_i_n);
            contentValue.put(Constants.REGISTER_DATE, register_date);
            contentValue.put(Constants.REGISTER_TIME, register_time);
            db.insert(Constants.BULL_VIDEO_IAMAGE, Constants.V_ID, contentValue);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Bull Diagnosis Image And Video Insert
    public boolean Bull_D_V_I_Insert(int bd_id,String bull_id, String v_d_n_i_n, String register_date, String register_time) {
        try {
            ContentValues contentValue = new ContentValues();
            contentValue.put(Constants.BD_ID, bd_id);
            contentValue.put(Constants.BULL_ID, bull_id);
            contentValue.put(Constants.V_D_N_I_N, v_d_n_i_n);
            contentValue.put(Constants.REGISTER_DATE, register_date);
            contentValue.put(Constants.REGISTER_TIME, register_time);
            db.insert(Constants.BULL_D_VIDEO_IAMAGE, Constants.VD_ID, contentValue);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Cursor Bull_V_I_Owner_fetch(String Search_Bull_id) {
//        String[] columns = new String[]{Constants.B_ID,Constants.BULL_ID, Constants.V_N_I_N, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
        Cursor c = null;

//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
            String sql = "SELECT * FROM " + Constants.BULL_VIDEO_IAMAGE + " WHERE " + Constants.V_N_I_N + " LIKE '" + Search_Bull_id + "'";
            c = db.rawQuery(sql, null);
            return c;
//        }
//        c = db.query(Constants.BULL_VIDEO_IAMAGE, columns, null, null, null, null, null);
//        return c;
    }

    public Cursor Bull_D_V_I_Owner_fetch(String Search_Bull_id) {
//        String[] columns = new String[]{Constants.BD_ID,Constants.BULL_ID, Constants.V_D_N_I_N, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
        Cursor c = null;

//        if (Search_Bull_id != null && Search_Bull_id.length() > 0) {
            String sql = "SELECT * FROM " + Constants.BULL_D_VIDEO_IAMAGE + " WHERE " + Constants.V_D_N_I_N + " LIKE '" + Search_Bull_id + "'";
            c = db.rawQuery(sql, null);
//            return c;
//        }
//        c = db.query(Constants.BULL_D_VIDEO_IAMAGE, columns, null, null, null, null, null);
        return c;
    }

//    public int Bull_V_I_Owner_update(long v_id, String bull_id, String v_n_i_n, String register_date, String register_time) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DatabaseHelper.BULL_ID, bull_id);
//        contentValues.put(DatabaseHelper.V_N_I_N, v_n_i_n);
//        contentValues.put(DatabaseHelper.REGISTER_DATE, register_date);
//        contentValues.put(DatabaseHelper.REGISTER_TIME, register_time);
//        int i = database.update(DatabaseHelper.BULL_VIDEO_IAMAGE, contentValues, DatabaseHelper.V_ID + " = " + v_id, null);
//        return i;
//    }
//
//    public void Bull_V_I_Owner_delete(long v_id) {
//        database.delete(DatabaseHelper.BULL_VIDEO_IAMAGE, DatabaseHelper.V_ID + "=" + v_id, null);
//    }

    //Bull SPIECES Insert
//    public void Bull_SPIECES_Insert(String spieces, String sub_spieces, String register_date, String register_time) {
//        ContentValues contentValue = new ContentValues();
//        contentValue.put(DatabaseHelper.SPIECES, spieces);
//        contentValue.put(DatabaseHelper.SUB_SPIECES, sub_spieces);
//        contentValue.put(DatabaseHelper.REGISTER_DATE, register_date);
//        contentValue.put(DatabaseHelper.REGISTER_TIME, register_time);
//        database.insert(DatabaseHelper.BULL_SPIECES, null, contentValue);
//    }

    public Cursor Bull_SPIECES_Owner_fetch(String s_bs_id) {
        String[] columns = new String[]{Constants.SPIECES, Constants.SUB_SPIECES, Constants.REGISTER_DATE, Constants.REGISTER_TIME};
        Cursor c = null;

        if (s_bs_id != null && s_bs_id.length() > 0) {
            String sql = "SELECT * FROM " + Constants.BULL_SPIECES + " WHERE " + Constants.BS_ID + " LIKE '%" + s_bs_id + "%'";
            c = db.rawQuery(sql, null);
            return c;
        }
        c = db.query(Constants.BULL_SPIECES, columns, null, null, null, null, null);
        return c;
    }
}