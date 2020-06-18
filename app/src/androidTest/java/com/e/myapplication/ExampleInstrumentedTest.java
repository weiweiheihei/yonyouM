package com.e.myapplication;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.e.myapplication", appContext.getPackageName());
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
