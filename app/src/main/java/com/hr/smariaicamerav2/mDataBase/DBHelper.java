package com.hr.smariaicamerav2.mDataBase;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
//           db.execSQL(Constants.CREATE_TB);
            db.execSQL(Constants.CREATE_TABLE_USER_SIGNUP);
            db.execSQL(Constants.CREATE_TABLE_BULL_REGISTER);
            db.execSQL(Constants.CREATE_TABLE_BULL_REGISTER_OWNER);
            db.execSQL(Constants.CREATE_TABLE_BULL_VIDEO_IAMAGE);
            db.execSQL(Constants.CREATE_TABLE_BULL_SPIECES);
            db.execSQL(Constants.CREATE_TABLE_BULL_DIAGNOSIS);
            db.execSQL(Constants.CREATE_TABLE_BULL_DREGISTER_OWNER);
            db.execSQL(Constants.CREATE_TABLE_BULL_D_VIDEO_IAMAGE);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // If you need to add a column
//        if (newVersion > oldVersion) {
//            db.execSQL("ALTER TABLE "+Constants.BULL_VIDEO_IAMAGE+" ADD COLUMN "+Constants.B_ID+" INTEGER DEFAULT 0");
//        }
//       db.execSQL(Constants.DROP_TB);
        db.execSQL(Constants.DROP_BULL_REGISTER);
        db.execSQL(Constants.DROP_BULL_REGISTER_OWNER);
        db.execSQL(Constants.DROP_BULL_VIDEO_IAMAGE);
        db.execSQL(Constants.DROP_BULL_USER_SIGNUP);
        db.execSQL(Constants.DROP_BULL_DIAGNOSIS);
        db.execSQL(Constants.DROP_BULL_DREGISTER_OWNER);
        db.execSQL(Constants.DROP_BULL_D_VIDEO_IAMAGE);
        onCreate(db);
    }
}
