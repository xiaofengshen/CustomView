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
 * Time  2019/5/18 16:49
 * Dest  ${TODO}
 */
public class ShawView extends View {

    private Paint mPaint;

    public ShawView(Context context) {
        super(context);
        init();
    }



    public ShawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);

        mPaint.setTextSize(100);
        mPaint.setColor(Color.DKGRAY);
        this.setLayerType(View.LAYER_TYPE_SOFTWARE,mPaint);
        mPaint.setShadowLayer(10,20,2,Color.YELLOW);

    }

    @Override
    public void onDraw(Canvas canvas) {
        super.draw(canvas);


        canvas.drawText("hahhhanidsdhs你好好的",100,100,mPaint);
    }
}
