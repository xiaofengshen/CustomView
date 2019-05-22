package com.yichao.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author yichao
 * Time  2019/5/18 20:06
 * Dest  线性渐变
 */
public class LinearGradientView extends View {

    private Paint mPaint;
    private int offset=50;

    public LinearGradientView(Context context) {
        super(context);
        init();
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.draw(canvas);
        Rect rect=new Rect(200,100,1000,500);


        //渐变的第一个点和第二个点在矩形定点
        LinearGradient linearGradient=new LinearGradient(rect.left,rect.top,rect.right,rect.bottom, new int[]{Color.RED,Color.BLUE,Color.GREEN},new float[]{0.2f,0.5f,0.8f}, Shader.TileMode.CLAMP);
        mPaint.setShader(linearGradient);
        canvas.drawRect(rect,mPaint);

        //渐变的第一个点和第二个点在矩形外
        canvas.translate(0,rect.bottom+offset);
        Rect rect1=new Rect(rect);
        rect1.inset(-100,-100);
        LinearGradient linearGradient1=new LinearGradient(rect1.left,rect1.top,rect1.right,rect1.bottom, new int[]{Color.RED,Color.BLUE,Color.GREEN},new float[]{0.2f,0.5f,0.8f}, Shader.TileMode.CLAMP);
        mPaint.setShader(linearGradient1);
        canvas.drawRect(rect,mPaint);

        //渐变的第一个点和第二个点在矩形外
        canvas.translate(0,rect.bottom+offset);
        Rect rect2=new Rect(rect);
        rect2.inset(100,100);
        LinearGradient linearGradient2=new LinearGradient(rect2.left,rect2.top,rect2.right,rect2.bottom, new int[]{Color.RED,Color.BLUE,Color.GREEN},new float[]{0.2f,0.5f,0.8f}, Shader.TileMode.CLAMP);
        mPaint.setShader(linearGradient2);
        canvas.drawRect(rect,mPaint);










    }
}
