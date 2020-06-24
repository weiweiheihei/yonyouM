package com.e.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import q.rorbin.badgeview.QBadgeView;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //动态添加
        Button button = findViewById(R.id.btn);

        new QBadgeView(this).bindTarget(button).setBadgeGravity(Gravity.CENTER | Gravity.END).setBadgeNumber(5);

    }
}
