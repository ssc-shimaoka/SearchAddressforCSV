# SearchAddressforCSV  
CSVデータをSQLに読み込み、そこから住所検索

## SQLite  
SQLiteは埋込みSQLデータベースエンジンです。  
通常のディスクファイルに直接読み書きを行います。  
小さなライブラリですが、全文検索にも対応した強力なデータベースです。  
Androidでは、標準ライブラリとして利用できます。用途としては、データ保存やキャッシュに利用します。  

## CSVファイル　インポート処理  
更新時の手順を以下にまとめる  
[まとめ](doc/データベース更新手順.xlsx)  

## quecyメソッドの使い方  
### quecyの引数
[関連サイト](https://blog.choilabo.com/20130220/229)

## queryの結果からデータを取得する  
（今回のドはまりポイント）

            Cursor cursor = db.query("Address", null, selection, selectionArgs, groupBy, having, orderBy);

            cursor.moveToFirst();
            Resault = cursor.getString(6);
            
ネット上の情報では、下2行は、ループに挟んでいたが、  
それだとループの内部に処理が入らないので、取得できない状態が続いた。

## DBの取得と値の確認
[関連サイト](https://tamomoru.com/dev_blog/article/39)
