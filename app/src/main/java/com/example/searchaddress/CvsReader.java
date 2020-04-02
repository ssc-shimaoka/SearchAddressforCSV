package com.example.searchaddress;


import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CvsReader {
    List<AddressItem> objects = new ArrayList<AddressItem>();

    public void reader(Context context) {
        AssetManager assetManager = context.getResources().getAssets();
        try {
            // CSVファイルの読み込み
            InputStream inputStream = assetManager.open("x-ken-all.csv");

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferReader.readLine()) != null) {

                //カンマ区切りで１つづつ配列に入れる
                AddressItem data = new AddressItem();
                String[] RowData = line.split(",");

                //CSVの左([0]番目)から順番にセット
                data.setNationalLocalGovernmentCode(RowData[0]);
                data.setPostalCode_Old(RowData[1]);
                data.setPostalCode(RowData[2]);
                data.setNameOfPrefectures_Kana(RowData[3]);
                data.setCityName_Kana(RowData[4]);
                data.setTownName_Kana(RowData[5]);
                data.setNameOfPrefectures(RowData[6]);
                data.setCityName(RowData[7]);
                data.setTownName(RowData[8]);
                data.setotther1(RowData[9]);
                data.setotther2(RowData[10]);
                data.setotther3(RowData[11]);
                data.setotther4(RowData[12]);
                data.setViewUpdates(RowData[13]);
                data.setReasonForChange(RowData[14]);

                objects.add(data);
            }
            bufferReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
