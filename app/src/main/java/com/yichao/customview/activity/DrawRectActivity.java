package com.yichao.customview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yichao.customview.R;

public class DrawRectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_rect);
    }
    public static void startActivity(Context context) {
        Intent starter = new Intent(context, DrawRectActivity.class);
        context.startActivity(starter);
    }
}
