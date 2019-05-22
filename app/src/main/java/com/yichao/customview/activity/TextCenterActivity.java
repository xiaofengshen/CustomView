package com.yichao.customview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yichao.customview.R;

public class TextCenterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_center);
    }
    public static void startActivity(Context context) {
        Intent starter = new Intent(context, TextCenterActivity.class);
        context.startActivity(starter);
    }
}
