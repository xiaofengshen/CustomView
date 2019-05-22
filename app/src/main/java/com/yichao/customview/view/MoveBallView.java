package com.yichao.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author yichao
 * Time  2019/5/18 10:15
 * Dest  移动的小球
 */
public class MoveBallView extends View {

    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private int radius = 30;
    private Paint mPaint;
    private int cX;
    private boolean toRight;

    public MoveBallView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(1);
        cX = radius;
        toRight = true;


    }

    public MoveBallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MoveBallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mMeasuredWidth = getMeasuredWidth();


    }

    @Override
    public void onDraw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawCircle(cX, radius+100, radius, mPaint);

        if (cX == mMeasuredWidth - radius) {
            toRight = false;
        }
        if (cX == radius) {
            toRight = true;
        }
        cX = toRight ? cX + 5 : cX - 5;


    }
}
