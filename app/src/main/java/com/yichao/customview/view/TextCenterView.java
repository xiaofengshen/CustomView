package com.yichao.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.yichao.customview.R;

/**
 * Author yichao
 * Time  2019/5/19 9:51
 * Dest  ${TODO}
 */
public class TextCenterView extends View {

    private int mMeasuredHeight;
    private int mMeasuredWidth;

    public TextCenterView(Context context) {
        super(context);
    }

    public TextCenterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.background);
        Bitmap bitmap1 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        this.setBackground(new BitmapDrawable(bitmap1));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mMeasuredHeight = getMeasuredHeight();
        mMeasuredWidth = getMeasuredWidth();


    }

    @Override
    public void onDraw(Canvas canvas) {
        super.draw(canvas);

        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(100);
        Rect rect=new Rect();
        String text="这是文字居中呈现";
        paint.getTextBounds(text,0,text.length(),rect);
        int width = rect.width();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();

        int textX=mMeasuredWidth/2-width/2;
        int textY= (int) (mMeasuredHeight/2+((fontMetrics.descent-fontMetrics.ascent)/2)-fontMetrics.descent);
        canvas.drawText(text,textX,textY,paint);







    }
}
