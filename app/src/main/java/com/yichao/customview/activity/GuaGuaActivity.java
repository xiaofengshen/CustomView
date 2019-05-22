package com.yichao.customview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yichao.customview.R;

public class GuaGuaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gua_gua);
    }
    public static void startActivity(Context context) {
        Intent starter = new Intent(context, GuaGuaActivity.class);
        context.startActivity(starter);
    }
}
