package com.example.searchaddress;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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
// 検索処理
    public String[] SearchAddress(String text) {
        String[] Resault = new String[3];

        //queryメソッドでデータを取得
        //String[] cols = {"No", "Name", "Tel", "Age"};
        String selection = "PostalCode = ?";
        String[] selectionArgs = {text};
        String groupBy = null;
        String having = null;
        String orderBy = null;

        try {
            Cursor cursor = db.query("Address", null, selection, selectionArgs, groupBy, having, orderBy);
            //TextViewに表示

            cursor.moveToFirst();
            Resault[0] = cursor.getString(6);
            Resault[1] = cursor.getString(7);
            Resault[2] = cursor.getString(8);

        } catch (Exception e) {
            e.printStackTrace();
 //       }finally {
 //           db.close();
        }
        return Resault;
    }

//---------------------------------------------------------------------------------------------
// 追加(郵便番号検索CSVインポート)
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
