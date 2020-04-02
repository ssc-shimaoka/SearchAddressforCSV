package com.example.searchaddress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 */
public class AddressListAdapter extends ArrayAdapter<AddressItem> {
    private LayoutInflater layoutinflater;

    // コンストラクタ
    public AddressListAdapter(Context context, int textViewResourceId, List<AddressItem> objects){
        super(context, textViewResourceId, objects);
        //layoutinflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /*
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 指定行のデータを取得
        AddressItem detail = (AddressItem)getItem(position);

        // nullの場合のみ再作成
        if(null == convertView){
            convertView = layoutinflater.inflate(R.layout.row, null);
        }


        // 行のデータを項目へ設定
        TextView text1 = (TextView)convertView.findViewById(R.id.textView);
        text1.setText(String.valueOf(detail.get_id()));

        TextView text2 = (TextView)convertView.findViewById(R.id.textView2);
        text2.setText(detail.getMemo());

        // 返却
        return convertView;
    }
     */

}
