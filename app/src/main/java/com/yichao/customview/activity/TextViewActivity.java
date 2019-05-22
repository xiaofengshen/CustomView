package com.yichao.customview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yichao.customview.R;

public class TextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
    }
    public static void startActivity(Context context) {
        Intent starter = new Intent(context, TextViewActivity.class);
        context.startActivity(starter);
    }
}
