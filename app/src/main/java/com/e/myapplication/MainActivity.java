package com.e.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    //我是本地master
    NotificationManager notificationManager;
    Notification.Builder builder;
    Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        initNotification();
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

//        for (int i = 0; i < 100; i++) {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            builder.setProgress(100, i, false);
//            builder.setContentText("下载进度:" + i + "%");
//            notification = builder.build();
//            notificationManager.notify(1, notification);
//
//            builder.setProgress(100, i+20, false);
//            builder.setContentText("下载进度:" + (i+20) + "%");
//            notification = builder.build();
//            notificationManager.notify(2, notification);
//        }
//        notificationManager.cancel(1);



//        //初始化通知管理器
//        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
////
//        Notification.Builder builder = new Notification.Builder(this);
////
//        Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.jianshu.com/p/890acf8e5080"));
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,mIntent,0);
//
//        builder.setContentIntent(pendingIntent);
////
//        builder.setSmallIcon(R.drawable.ic_launcher_background);
//
//
//        mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.item_notification);
//
//        Notification notification1 = builder.build();
//
//        notification1.bigContentView= remoteViews;
//        for (int i = 0; i < 100; i++) {
//            remoteViews.setProgressBar(R.id.progressbar,100,i,false);
//        }
//        notificationManager.notify(1, notification1);


    }

    private void initNotification() {
        notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new Notification.Builder(this);
        builder.setContentTitle("正在更新...") //设置通知标题
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round)) //设置通知的大图标
                .setDefaults(Notification.DEFAULT_LIGHTS) //设置通知的提醒方式： 呼吸灯
                .setPriority(Notification.PRIORITY_MAX) //设置通知的优先级：最大
                .setAutoCancel(false)//设置通知被点击一次是否自动取消
                .setContentText("下载进度:" + "0%")
                .setProgress(100, 0, false);
        notification = builder.build();//构建通知对象
    }
}
