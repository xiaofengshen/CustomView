package com.yichao.customview.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.yichao.customview.R;

public class DrawArcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bitmap);
        ImageView imageView= findViewById(R.id.iv_bitmap);
        Bitmap cacheBitmap = Bitmap.createBitmap(800, 1500, Bitmap.Config.ARGB_4444);
        Canvas canvas=new Canvas(cacheBitmap);
        //画椭圆
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.DKGRAY);
        paint.setStrokeWidth(1);
        RectF rectF=new RectF(100,100,500,500);
        canvas.drawOval(rectF,paint);

        //画圆弧
        paint.setColor(Color.RED);


        canvas.drawArc(rectF,-45,-45,true,paint);



        imageView.setImageBitmap(cacheBitmap);

    }
    public static void startActivity(Context context) {
        Intent starter = new Intent(context, DrawArcActivity.class);
        context.startActivity(starter);
    }
}
