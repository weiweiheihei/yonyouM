package com.e.myapplication;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {




    @Test
    public void addition_isCorrect() {
//        assertEquals(4, 2 + 2);
        String extend = "{\"request\":\"success\",\"age\":18,\"school\":\"清华大学\"}";
        try {
            JSONObject jsonObject = new JSONObject(extend);
//            String value = jsonObject.optString("request");
//            System.out.println(value);
            Iterator<String> it = jsonObject.keys();//使用迭代器
            jsonObject.length();
            while (it.hasNext()) {
                String key = it.next();//获取key
                String value = jsonObject.getString(key);//获取value
//                metadata.addUserMetadata("x-oss-meta-" + key, value);
                System.out.println("key="+key+" value="+value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}