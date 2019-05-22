package com.yichao.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author yichao
 * Time  2019/5/21 9:54
 * Dest  ${TODO}
 */
public class CustomTextView extends View {

    String text = "今天星期三，哈哈哦";
    private Paint.FontMetrics mFontMetrics;
    private Rect mRect;
    private Paint mPaint;

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(50);
        mPaint.setColor(Color.RED);
        mRect = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), mRect);
        mFontMetrics = mPaint.getFontMetrics();


    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(text,(getMeasuredWidth()-mRect.width())/2,getMeasuredHeight()/2+((mFontMetrics.descent-mFontMetrics.ascent)/2)-mFontMetrics.descent ,mPaint);



    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {


        int with = getWith(widthMeasureSpec);
        int height = getHeight(heightMeasureSpec);

        setMeasuredDimension(with, height);


    }

    private int getHeight(int heightMeasureSpec) {
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);
        int height=0;
        switch (mode) {

            case MeasureSpec.EXACTLY:

                height = size;

                break;
            case MeasureSpec.AT_MOST:
                height=    mRect.height();
                break;
        }

        return height;


    }

    private int getWith(int widthMeasureSpec) {
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int with=0;
        switch (mode) {

            case MeasureSpec.EXACTLY:

                with = size;

                break;
            case MeasureSpec.AT_MOST:
                with=    mRect.width();
                break;
        }

        return with;
    }
}
