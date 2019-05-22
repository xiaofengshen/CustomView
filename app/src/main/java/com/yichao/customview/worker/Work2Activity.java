package com.yichao.customview.worker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.yichao.customview.R;

import java.util.Random;

//在 ImageView 绘制一个空心矩形，随机产生 100 条干扰线，并随机生成 4 个数
//字显示在矩形框内
public class Work2Activity extends AppCompatActivity {
    private String TAG=this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work1);
        ImageView imageView = findViewById(R.id.iv_bitmap);
        Bitmap caCheBitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(caCheBitmap);
        RectF rectF = new RectF(0, 0, 500, 400);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setStrokeWidth(1);
        paint.setTextSize(100);
        canvas.drawRect(rectF, paint);
        Random random=new Random();

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        int i1 = random.nextInt(9);
        int i2 = random.nextInt(9);
        int i3 = random.nextInt(9);
        int i4 = random.nextInt(9);
        StringBuilder builder=new StringBuilder();
        String text = builder.append(i1).append(i2).append(i3).append(i4).toString();


        Rect rect2=new Rect();
        paint.getTextBounds(text,0,text.length(),rect2);
        int width = rect2.width();

        int textX= (int) ((rectF.width()-width)/2);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();

        Log.i(TAG,"ascent::"+fontMetrics.ascent);
        Log.i(TAG,"descent::"+fontMetrics.descent);
        Log.i(TAG,"top::"+fontMetrics.top);
        Log.i(TAG,"bottom::"+fontMetrics.bottom);
        Log.i(TAG,"leading::"+fontMetrics.leading);




        int baseLineY= (int) (rectF.centerY()-fontMetrics.descent+((fontMetrics.bottom-fontMetrics.top)/2));


        canvas.drawText(text,0,text.length(),textX,baseLineY,paint);





        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.STROKE);


        for (int i=0;i<100;i++){

            canvas.drawLine(random.nextInt(500),random.nextInt(400),random.nextInt(500),random.nextInt(400),paint);



        }



        imageView.setImageBitmap(caCheBitmap);


    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, Work2Activity.class);
        context.startActivity(starter);
    }

}
