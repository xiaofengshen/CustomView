package com.yichao.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author yichao
 * Time  2019/5/18 10:57
 * Dest  花布扩大缩小
 */
public class CanvasTranslateView extends View {


    public CanvasTranslateView(Context context) {
        super(context);
    }

    public CanvasTranslateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasTranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.draw(canvas);
        //平移
        Paint paint =new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(1);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);

        RectF rectF=new RectF(10,10,200,200);

        canvas.save();
        for (int i=0;i<10;i++){
            canvas.drawRect(rectF,paint);
            canvas.translate(10,10);


        }
        canvas.restore();


        //缩放
        canvas.translate(0,350);
        canvas.save();
        RectF rectF1=new RectF(0,0,500,500);

        for (int i=0;i<7;i++){
            canvas.drawRect(rectF1,paint);
            canvas.scale(0.9f,0.9f,250,250);



        }
        canvas.restore();


        //画表盘
        canvas.translate(0,600);

     canvas.drawCircle(300,300,200,paint);



        canvas.save();
        for (int i=0;i<12;i++){
            canvas.drawLine(450,300,500,300,paint);
             canvas.rotate(30,300,300);

        }
        canvas.restore();














    }
}
