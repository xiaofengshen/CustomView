package com.yichao.customview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yichao.customview.R;
import com.yichao.customview.view.MoveBallView;

import java.util.Timer;
import java.util.TimerTask;

public class BallMoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball_move);
        final MoveBallView moveBallView=findViewById(R.id.moveview);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                moveBallView.postInvalidate();

            }
        },200,50);


    }
    public static void startActivity(Context context) {
        Intent starter = new Intent(context, BallMoveActivity.class);
        context.startActivity(starter);
    }
}
