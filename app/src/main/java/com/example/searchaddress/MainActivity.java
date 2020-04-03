package com.example.searchaddress;

import android.database.Cursor;
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
        //リスト更新
        //Address.insertList(this, "x-ken-all.csv");　　//これを有効化すると5分以上起動にかかるようになります。
    }

    public void onClickSearchAddress(View view)
    {
        TextView textview = (TextView)findViewById(R.id.inputAddressNumber);
        String text = textview.getText().toString();
        String Res = Address.SearchAddress(text);

        TextView lblList = (TextView)this.findViewById(R.id.textView3Id);
        lblList.setText(Res);
    }
}
