package com.yichao.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Author yichao
 * Time  2019/5/18 14:53
 * Dest  画矩形
 */
public class DrawRectView extends View {

    private Bitmap mBufferBitmap;
    private Canvas mBufferCanvas;
    private int mPreX;
    private int mPreY;
    private Paint mPaint;
    private Path mPath;

    public DrawRectView(Context context) {
        super(context);
        init();
    }


    public DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath = new Path();


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mBufferBitmap == null) {
            int measuredHeight = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            mBufferBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            mBufferCanvas = new Canvas(mBufferBitmap);
        }


    }

    @Override
    public void onDraw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawBitmap(mBufferBitmap,0,0,null);
        canvas.drawPath(mPath,mPaint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();



        switch (action){
            case MotionEvent.ACTION_DOWN:
                mPreX = (int) event.getX();
                mPreY = (int) event.getY();
                mPath.reset();
                mPath.moveTo(mPreX,mPreY);

                break;
            case MotionEvent.ACTION_MOVE:
                int currentX= (int) event.getX();
                int currentY= (int) event.getY();
                mPath.reset();
                //右下

                if (mPreX<currentX&&mPreY<currentY){

                    mPath.addRect(mPreX,mPreY,currentX,currentY, Path.Direction.CCW);

                }


                //右上
                if (mPreX<currentX&&mPreY>currentY){
                    mPath.addRect(mPreX,currentY,currentX,mPreY, Path.Direction.CCW);
                }

                //左下
                if (mPreX>currentX&& mPreY<currentY){

                    mPath.addRect(currentX,mPreY,mPreX,currentY, Path.Direction.CCW);

                }
                //左上

                if (mPreX>currentX&&mPreY>currentY){
                    mPath.addRect(currentX,currentY,mPreX,mPreY, Path.Direction.CCW);


                }






                invalidate();


                break;
            case MotionEvent.ACTION_UP:
                mBufferCanvas.drawPath(mPath,mPaint);

                invalidate();
                break;

        }


        return true;
    }
}
