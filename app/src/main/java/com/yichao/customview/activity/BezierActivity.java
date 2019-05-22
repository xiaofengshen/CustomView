package com.yichao.customview.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.yichao.customview.R;

public class BezierActivity extends AppCompatActivity {

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
        paint.setStrokeWidth(5);
        paint.setColor(Color.GRAY);


        Path path=new Path();
        path.moveTo(200,200);
        path.quadTo(300,100,800,1000);
        canvas.drawPath(path,paint);

paint.setColor(Color.RED);


canvas.drawPoints(new float[]{200,200,300,100,800,1000},paint);










        imageView.setImageBitmap(cacheBitmap);
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, BezierActivity.class);
        context.startActivity(starter);
    }
}
