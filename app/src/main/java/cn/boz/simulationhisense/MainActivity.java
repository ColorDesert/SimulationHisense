package cn.boz.simulationhisense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv1).setOnClickListener(this);
        findViewById(R.id.tv2).setOnClickListener(this);
        findViewById(R.id.tv3).setOnClickListener(this);
        findViewById(R.id.tv4).setOnClickListener(this);
        findViewById(R.id.tv5).setOnClickListener(this);
        findViewById(R.id.tv6).setOnClickListener(this);
        findViewById(R.id.tv7).setOnClickListener(this);
//        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
//                                                      @Override
//                                                      public void onClick(View v) {
//                                                          Intent mIntent = new Intent(MainActivity.this, Test1Activity.class);
//                                                          startActivity(mIntent);
//                                                      }
//                                                  }
//        );
//        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
//                                                      @Override
//                                                      public void onClick(View v) {
//                                                          Intent mIntent = new Intent(MainActivity.this, Test2Activity.class);
//                                                          startActivity(mIntent);
//                                                      }
//                                                  }
//        );
    }

    @Override
    public void onClick(View v) {
        String uriString = "";

        switch (v.getId()) {
            case R.id.tv1:
                uriString = UriUtils.DEPOSIT;
                break;
            case R.id.tv2:
                uriString = UriUtils.LOAN;
                break;
            case R.id.tv3:
                uriString = UriUtils.MY_ACCOUNT;
                break;
            case R.id.tv4:
                uriString = UriUtils.TRANSFER_ACCOUNTS;
                break;
            case R.id.tv5:
                uriString = UriUtils.FINANCIAL;
                break;
            case R.id.tv6:
                uriString = UriUtils.TAX;
                break;
            case R.id.tv7:
                uriString = UriUtils.SOCIAL_SECURITY;
                break;
        }
        CommonUtils.startActivityByUri(MainActivity.this, uriString);

    }
}
