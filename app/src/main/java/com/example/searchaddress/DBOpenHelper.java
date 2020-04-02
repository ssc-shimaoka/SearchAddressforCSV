package com.example.searchaddress;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "AddressList.db";
    static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "Address";
    protected SQLiteDatabase db;

    // コンストラクタ
    public DBOpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);

    }

    // 作成
    @Override
    public void onCreate(SQLiteDatabase db){
        // create
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + " ("+
                        "   NationalLocalGovernmentCode TEXT ,"+
                        "   PostalCode_Old TEXT ,"+
                        "   PostalCode TEXT ,"+
                        " NameOfPrefectures_Kana TEXT ,"+
                        " CityName_Kana TEXT ,"+
                        " TownName_Kana TEXT ,"+
                        " NameOfPrefectures TEXT ,"+
                        " CityName TEXT ,"+
                        " TownName TEXT ,"+
                        " otther1 TEXT ,"+
                        " otther2 TEXT ,"+
                        " otther3 TEXT ,"+
                        " otther4 TEXT ,"+
                        " ViewUpdates TEXT ,"+
                        " ReasonForChange TEXT "+
                        " ); "
        );
    }

    // 更新
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        onCreate(db);
    }

}
