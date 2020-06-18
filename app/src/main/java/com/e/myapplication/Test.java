package com.e.myapplication;

import android.util.Log;


import org.json.JSONObject;

import java.util.Iterator;

public class Test {

    public static void main(String[] args) {

        String extend = "{\"request\":\"success\",\"age\":18,\"school\":\"清华大学\"}";
        try {
            JSONObject jsonObject = new JSONObject(extend);
            String value = jsonObject.optString("request");
            System.out.println(value);
//            Iterator<String> it = jsonObject.keys();//使用迭代器
//            jsonObject.length();
//            while (it.hasNext()) {
//                String key = it.next();//获取key
//                String value = jsonObject.getString(key);//获取value
////                metadata.addUserMetadata("x-oss-meta-" + key, value);
//            System.out.println("key-value","key="+key+" value="+value);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
