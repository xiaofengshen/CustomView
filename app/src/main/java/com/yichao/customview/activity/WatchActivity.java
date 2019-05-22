package com.yichao.customview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yichao.customview.R;
import com.yichao.customview.view.WatchView;

public class WatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        WatchView watchView = findViewById(R.id.watchview);
        watchView.run();
    }
    public static void startActivity(Context context) {
        Intent starter = new Intent(context, WatchActivity.class);
        context.startActivity(starter);
    }
}
