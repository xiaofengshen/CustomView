package com.yichao.customview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yichao.customview.R;
import com.yichao.customview.view.BaseScrollerViewGroup;

public class ScrollerActivity extends AppCompatActivity {
    private String TAG="ScrollerActivity";

    private TextView mTv;
    private LinearLayout mLinearLayout;
    private BaseScrollerViewGroup mBaseScrollerViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller);

        mTv = findViewById(R.id.tv);
        mLinearLayout = findViewById(R.id.ll);
        mBaseScrollerViewGroup = findViewById(R.id.base_view);
    }
    public void scrollerBy(View view){

        mLinearLayout.scrollBy(-5,0);




    }

    public void scrollerTo(View view){
        int scrollX = mLinearLayout.getScrollX();
        int scrollY = mLinearLayout.getScrollY();
        Log.i(TAG,"scrollX:::"+scrollX);


        Log.i(TAG,"scrollY:::"+scrollY);


        mLinearLayout.scrollTo(scrollX-5,scrollY);

    }

    public void scrollerStart(View view){
        mBaseScrollerViewGroup.start();


    }
    public static void startActivity(Context context) {
        Intent starter = new Intent(context, ScrollerActivity.class);
        context.startActivity(starter);
    }



}
