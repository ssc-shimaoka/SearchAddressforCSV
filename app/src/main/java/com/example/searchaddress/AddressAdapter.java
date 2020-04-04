package com.example.searchaddress;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
/*
    // リストを取得
    public String SearchAddress(String Number) {
        StringBuilder ResText = new StringBuilder();
        String str = null;

        try {
            //String selectStr = AddressList.PostalCode + " = ?";        // このあたりの条件を有効にすると検索されない・・・
            String selectStr = PostalCode + " = ?";        // このあたりの条件を有効にすると検索されない・・・
            String[] selectArg = new String[]{Number};

            //Cursor cursor = db.query(DBOpenHelper.TABLE_NAME, null, selectStr, selectArg, null, null, null);
            Cursor cursor = db.query(DBOpenHelper.TABLE_NAME, null, null, null, null, null, null);
            //Cursor cursor = db.rawQuery( "SELECT NameOfPrefectures FROM Address WHERE PostalCode LIKE ? ORDER BY NameOfPrefectures",new String[]{Number});

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

 */
//--------------------------------------------------------------------------------------------------------------

    public String SearchAddress2(String text) {
        String text2 = new String();
        String text3 = null;
        //queryメソッドでデータを取得
        //String[] cols = {"No", "Name", "Tel", "Age"};
        String selection = "PostalCode = ?";
        String[] selectionArgs = {text};
        String groupBy = null;
        String having = null;
        String orderBy = null;

        try {
            Cursor cursor = db.query("Address", null, null, null, groupBy, having, orderBy);
            //TextViewに表示

            //while (cursor.moveToNext()) {
            cursor.moveToNext();
                text2 = cursor.getString(6);
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            db.close();
        }
        return text3;
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
            String lineUTF;
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
                Log.d("InsertAddressList","inport="+RowData[2]+RowData[7]);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            db.close();
        }
    }
}
