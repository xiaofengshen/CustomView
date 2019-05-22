package com.yichao.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author yichao
 * Time  2019/5/18 22:23
 * Dest  ${TODO}
 */
public class SweepView extends View {

    private SweepGradient mSweepGradient;
    private Paint mPaint;
    private float mX;
    private float mY;
    private float rotate;

    public SweepView(Context context) {
        super(context);
    }

    public SweepView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        setFocusableInTouchMode(true);
        mX = 100;
        mY = 160;
        mSweepGradient = new SweepGradient(mX, mY,new int[]{Color.RED,Color.GREEN,Color.BLUE,Color.RED},null);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setShader(mSweepGradient);



    }

    @Override
    public void onDraw(Canvas canvas) {
        super.draw(canvas);


        canvas.translate(300,300);
        canvas.drawColor(Color.WHITE);

        Matrix matrix=new Matrix();
        matrix.setRotate(rotate,mX,mY);
        mSweepGradient.setLocalMatrix(matrix);

        rotate+=3;

        if (rotate>=360){
            rotate=0;
        }



        invalidate();

        canvas.drawCircle(mX,mY,200,mPaint);















    }
}
