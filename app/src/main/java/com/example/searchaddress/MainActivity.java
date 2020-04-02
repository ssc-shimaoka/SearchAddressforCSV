package com.example.searchaddress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private AddressAdapter Address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("activity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Address = new AddressAdapter(this);
        //Displist();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //リスト更新
        //Address.insertList(this, "x-ken-all.csv");
    }

    public void onClickSearchAddress(View view)
    {
        
    }
}
