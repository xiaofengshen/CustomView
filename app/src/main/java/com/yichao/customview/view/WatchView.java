package com.yichao.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author yichao
 * Time  2019/5/18 13:37
 * Dest  ${TODO}
 */
public class WatchView extends View {

    private Paint mPaint;
    private Calendar mCalendar;

    public WatchView(Context context) {
        super(context);
        init();
    }


    public WatchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(2);
        mCalendar = Calendar.getInstance();


    }



    @Override
    public void onDraw(Canvas canvas) {
        super.draw(canvas);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int len = Math.min(measuredHeight, measuredWidth);
       drawPlate(canvas,len);
       drawPoits(canvas,len);






    }

    /**
     * 画指针
     * @param canvas
     * @param len
     */
    private void drawPoits(Canvas canvas, int len) {
        mCalendar.setTimeInMillis(System.currentTimeMillis());

        //获取时分秒
        int hours = mCalendar.get(Calendar.HOUR) % 12;//转换为 12 小时制
        int seconds = mCalendar.get(Calendar.SECOND);
        int minutes = mCalendar.get(Calendar.MINUTE);

        //角度
        int degree=360/12*hours;
        //转化成弧度
        double toRadians = Math.toRadians(degree);
        int r=len/2;
        int startX=r;
        int startY=r;
        int endX= (int) (r+r*Math.cos(toRadians)*0.5);
        int endY= (int) (r+r*Math.sin(toRadians)*0.5);
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(5);

        canvas.save();

        canvas.rotate(-90,r,r);
        canvas.drawLine(startX,startY,endX,endY,mPaint);


        canvas.restore();


        //分针


        int minutesDegree=360/60*minutes;

        double toRadiansMinutes= Math.toRadians(minutesDegree);

        endX= (int) (r+0.6*r*Math.cos(toRadiansMinutes));
        endY= (int) (r+0.6*r*Math.sin(toRadiansMinutes));

        mPaint.setStrokeWidth(3);
        canvas.save();
        canvas.rotate(-90,r,r);
        canvas.drawLine(startX,startY,endX,endY,mPaint);
        canvas.restore();
        //秒
        int sendsDegree=360/60*seconds;

        double toRadiansSends = Math.toRadians(sendsDegree);

        endX= (int) (r+0.9*r*Math.cos(toRadiansSends));
        endY= (int) (r+0.9*r*Math.sin(toRadiansSends));

        mPaint.setStrokeWidth(1);
        canvas.save();
        canvas.rotate(-90,r,r);
        canvas.drawLine(startX,startY,endX,endY,mPaint);
        canvas.restore();







    }

    /**
     * 画表盘
     * @param canvas
     * @param len
     */
    private void drawPlate(Canvas canvas, int len) {
        int r=len/2;
        canvas.drawCircle(r,r,r,mPaint);
        //刻度
        canvas.save();
        for (int i=0;i<60;i++){
            if (i%5==0){
                mPaint.setStrokeWidth(4);
                mPaint.setColor(Color.RED);
               canvas.drawLine(r+9*r/10,r,len,r,mPaint);


            }else {

                mPaint.setStrokeWidth(2);
                mPaint.setColor(Color.GRAY);
                canvas.drawLine(r+14*r/15,r,len,r,mPaint);

            }

            canvas.rotate(6,r,r);


        }
        canvas.restore();




    }

    public void run(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                postInvalidate();
            }
        },0,1000);
    }
}
