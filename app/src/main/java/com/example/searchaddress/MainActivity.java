package com.example.searchaddress;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AddressAdapter Address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("activity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Address = new AddressAdapter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void onClickSearchAddress(View view)
    {
        // 検索入力文字
        TextView textview = (TextView)findViewById(R.id.inputAddressNumber);
        String text = textview.getText().toString();

        // 検索処理
        String[] Result = Address.SearchAddress(text);

        // 県表示
        TextView lblList1 = (TextView)this.findViewById(R.id.outputAddress1);
        lblList1.setText(Result[0]);

        // 市町村表示
        TextView lblList2 = (TextView)this.findViewById(R.id.outputAddress2);
        lblList2.setText(Result[1]);

        // 番地表示
        TextView lblList3 = (TextView)this.findViewById(R.id.outputAddress3);
        lblList3.setText(Result[2]);
    }

    public void onClickUpdateData(View view)
    {
        //リスト更新
        Address.insertList(this, "Address.csv");
    }
}
