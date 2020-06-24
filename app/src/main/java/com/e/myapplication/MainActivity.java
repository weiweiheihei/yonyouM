package com.e.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    NotificationManager notificationManager;
    Notification.Builder builder;
    Notification notification;
    Button button;
    private final static String[] permissions = new String[]{"sansec.permission.START_SIGN_ACTIVITY", "sansec.permission.GET_PUBLIC_KEY_ACTIVITY"};
    private final static int PERMISSION_CODE = 1003;
    //获取公钥
    private final int GET_PUBLIC_KEY = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

//                    JSONObject jo = args.optJSONObject(0);
//                    signData = jo.getString("mansigninfo");
//                    password = YYUDALoca.getAppLoca(context, Constant.SECRET);
//                    userId = YYUDALoca.getAppLoca(context, Constant.LOGIN_NAME);

                    Intent publicKeyIntent = new Intent("android.intent.action.GET_PUBLIC_KEY_ACTIVITY");
                    publicKeyIntent.setClassName("sansec.cusmobileshield", "sansec.cusmobileshield.activity.GetPublicKeyActivity");
                    if (getPackageManager().resolveActivity(publicKeyIntent, 0) != null) {
                        //第一次登陆提示
//                    if (isFirstDownload) {
//                        String html = "<font color='#074791' size='18px'>" + "需安装并绑定E-Port手机盾APP，进行加签验证" + "</font>";
//                        Toast.makeText(context, Html.fromHtml(html), Toast.LENGTH_LONG).show();
//                        return true;
//                    }

                        if (!checkPermission(getApplicationContext(), permissions)) {
                            requestPermission(MainActivity.this);
                        }

//                        if (!TextUtils.isEmpty(userId)) {
//                            publicKeyIntent.putExtra("userId", userId);
                            startActivityForResult( publicKeyIntent, GET_PUBLIC_KEY);
//                        } else {
//                            Toast.makeText(MainActivity.this, "请打开手机盾应用并申请密钥", Toast.LENGTH_SHORT).show();
//                        }
                    } else {

                        //下载手机盾

//                        if (confirmDialog == null)
//                            initConfirmDialog(this);
//                        confirmDialog.show();
                    }
                } catch (Exception e) {
                    Log.e("e:",e.getMessage());
                }
            }
        });



    }
    public static boolean checkPermission(Context context, String[] permissions) {
        PackageManager pm = context.getPackageManager();
        boolean result;
        for (String permission : permissions) {
            result = PackageManager.PERMISSION_GRANTED == pm.checkPermission(permission, context.getPackageName());
            if (!result) {
                return false;
            }
        }
        return true;

    }

    public static void requestPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23)
            activity.requestPermissions(permissions, PERMISSION_CODE);

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
