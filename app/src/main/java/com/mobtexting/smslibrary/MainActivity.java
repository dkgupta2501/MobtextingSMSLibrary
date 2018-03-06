package com.mobtexting.smslibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;

import java.util.HashMap;
import java.util.Map;

import mobtexting.com.mobtextingsms.MobtextingSMS;
import mobtexting.com.mobtextingsms.mobtextinginterface.APIResponseInterface;

public class MainActivity extends AppCompatActivity {
    int method_post=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Map<String,String> paramVal=new HashMap<>();
//        MobtextingSMS.MobtextingAPICallBackResponse(new APIResponseInterface() {
//            @Override
//            public void onSuccessResponse(String s) {
//
//            }
//
//            @Override
//            public void onFailureResponse(String s) {
//
//            }
//        },paramVal,"http://api.mobtexting.com/v1/sms", Request.Method.POST,getBaseContext());

    }
}
