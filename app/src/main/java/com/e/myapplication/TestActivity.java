package com.e.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import q.rorbin.badgeview.QBadgeView;
import retrofit2.Response;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class TestActivity extends AppCompatActivity {

    private Subscription everModify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //动态添加
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TestActivity.this);
                builder.setMessage("第一次使用时，请修改密码");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(TestActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("取消", null);

                builder.show();
            }
        });

//        new QBadgeView(this).bindTarget(button).setBadgeGravity(Gravity.CENTER | Gravity.END).setBadgeNumber(5);

    }
}
