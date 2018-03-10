package com.mobtexting.smslibrary;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;

import java.util.HashMap;
import java.util.Map;

import mobtexting.com.mobtextingsms.MobtextingSMS;
import mobtexting.com.mobtextingsms.mobtextinginterface.APIResponseInterface;
import mobtexting.com.mobtextingsms.mobtextinginterface.Method;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //send SMS from mobtexting using POST menthid
        Map<String, String> paramVal = new HashMap<>();
        paramVal.put("api_key", "xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        paramVal.put("message", "this is a test");
        paramVal.put("mobile_no", "72********");
        paramVal.put("message_type", "normal");
        paramVal.put("content_type", "");
        paramVal.put("sender_id", "******");
        MobtextingSMS.MobtextingAPICallBackResponse(new APIResponseInterface() {
            @Override
            public void onSuccessResponse(String s) {
                Log.d("response", s);
            }

            @Override
            public void onFailureResponse(String s) {
                Log.d("response", s);
            }
        }, paramVal, "http://api.mobtexting.com/v1/sms", Method.METHOD_POST, MainActivity.this);



        //get Build URL when pass param as GET Method
        String buildURL = MobtextingSMS.getGetMethodBuildURL();
        Log.d("buildURL", buildURL);


        //send SMS from Mobtexting using GET Method
        Map<String, String> paramVal1 = new HashMap<>();
        paramVal1.put("api_key", "xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        paramVal1.put("message", "this is a test");
        paramVal1.put("mobile_no", "72********");
        paramVal1.put("message_type", "normal");
        paramVal1.put("content_type", "");
        paramVal1.put("sender_id", "******");
        MobtextingSMS.MobtextingAPICallBackResponse(new APIResponseInterface() {
            @Override
            public void onSuccessResponse(String s) {
                Log.d("response", s);
            }

            @Override
            public void onFailureResponse(String s) {
                Log.d("response", s);
            }
        }, paramVal1, "http://api.mobtexting.com/v1/sms", Method.METHOD_GET, MainActivity.this);


    }

}
