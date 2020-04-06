package com.example.searchaddress;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DB_FILE_NAME = "Data.db";
    private static final String DB_NAME = "AddressList.db";
    private static final int DB_VERSION = 1;
    //public static final String TABLE_NAME = "Address";

    private Context context;
    private File dbPath;
    private boolean createDatabase = false;

    // コンストラクタ
    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        this.dbPath = context.getDatabasePath(DB_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        super.onOpen(db);
        // getWritableDatabase()したときに呼ばれてくるので、
        // 初期化する必要があることを保存する
        this.createDatabase = true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    // CopyUtilsからのコピペ
    private static int copy(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[1024 * 4];
        int count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    // データベース読み込み（読み込み専用）
    @Override
    public synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase database = super.getReadableDatabase();
        if (createDatabase) {
            try {
                database = copyDatabase(database);
            } catch (IOException e) {
            }
        }
        return database;
    }

    // データベース読み込み（書き込み可能）
    @Override
    public synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase database = super.getWritableDatabase();
        if (createDatabase) {
            try {
                database = copyDatabase(database);
            } catch (IOException e) {
            }
        }
        return database;
    }

    // データベースコピー処理
    private SQLiteDatabase copyDatabase(SQLiteDatabase database) throws IOException {
        // dbがひらきっぱなしなので、書き換えできるように閉じる
        database.close();

        // コピー！
        InputStream input = context.getAssets().open(DB_FILE_NAME);
        OutputStream output = new FileOutputStream(this.dbPath);
        copy(input, output);

        createDatabase = false;
        // dbを閉じたので、また開く
        return super.getWritableDatabase();
    }
}


