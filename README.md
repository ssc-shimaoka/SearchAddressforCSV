# SearchAddressforCSV  
CSVデータをSQLに読み込み、そこから住所検索

更新時の手順を以下にまとめる  
[まとめ](doc/データベース更新手順.xlsx)



## CSVファイル　インポート処理

## quecyメソッドの使い方
### quecy()とrawQuery()

### quecyの引数
[関連サイト](https://blog.choilabo.com/20130220/229)

## queryの結果からデータを取得する  
（今回のドはまりポイント）

            Cursor cursor = db.query("Address", null, selection, selectionArgs, groupBy, having, orderBy);

            cursor.moveToFirst();
            Resault = cursor.getString(6);
            
ネット上の情報では、下2行は、ループに挟んでいたが、  
それだとループの内部に処理が入らないので、取得できない状態が続いた。
