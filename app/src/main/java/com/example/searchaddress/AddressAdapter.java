package com.example.searchaddress;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 */
public class AddressAdapter {

    private SQLiteDatabase db;
    static private DBOpenHelper helper;

    // コンストラクタ
    public AddressAdapter(Context context) {
        helper = new DBOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    //--------------------------------------------------------------------------------------------------------------

    // リストを取得
    public Cursor getAllList() {
        return db.query(DBOpenHelper.TABLE_NAME, null, null, null, null, null, null);
    }
    //--------------------------------------------------------------------------------------------------------------

    // リストを取得
    public String SearchAddress(String Number) {
        StringBuilder ResText = new StringBuilder();
        String str = null;

        try {
            String selectStr = "PostalCode = ?";        // このあたりの条件を有効にすると検索されない・・・
            String[] selectArg = new String[]{Number};

            Cursor cursor = db.query(DBOpenHelper.TABLE_NAME, null, selectStr, selectArg, null, null, null);

            while (cursor.moveToNext()) {
                ResText.append(cursor.getString(7));
            }

            str = new String(ResText);
        } catch (Exception e) {
            e.printStackTrace();
//        }finally{
//            db.close();
        }

        return str;
    }

//    //--------------------------------------------------------------------------------------------------------------
//    // 追加(使っていない)
//    public void insert(String memo) {
//        ContentValues values = new ContentValues();
//        values.put("memo", memo);
//        db.insertOrThrow(DBOpenHelper.TABLE_NAME, null, values);
//
//    }

//--------------------------------------------------------------------------------------------------------------
    // 追加(郵便番号検索リスト)
    public void insertList(Context context, String fineName) {
        AssetManager assetManager = context.getResources().getAssets();

        try {
            // CSVファイルの読み込み
            InputStream inputStream = assetManager.open(fineName);

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferReader.readLine()) != null) {

                String[] RowData = line.split(",");
                ContentValues values = new ContentValues();

                values.put("NationalLocalGovernmentCode", RowData[0]);
                values.put("PostalCode_Old", RowData[1]);
                values.put("PostalCode", RowData[2]);
                values.put("NameOfPrefectures_Kana", RowData[3]);
                values.put("CityName_Kana", RowData[4]);
                values.put("TownName_Kana", RowData[5]);
                values.put("NameOfPrefectures", RowData[6]);
                values.put("CityName", RowData[7]);
                values.put("TownName", RowData[8]);
                values.put("otther1", RowData[9]);
                values.put("otther2", RowData[10]);
                values.put("otther3", RowData[11]);
                values.put("otther4", RowData[12]);
                values.put("ViewUpdates", RowData[13]);
                values.put("ReasonForChange", RowData[14]);

                db.insertOrThrow(DBOpenHelper.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            db.close();
        }
    }
}
