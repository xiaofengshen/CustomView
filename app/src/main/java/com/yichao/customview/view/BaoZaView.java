package com.yichao.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.yichao.customview.R;

/**
 * Author yichao
 * Time  2019/5/18 13:09
 * Dest  ${TODO}
 */
public class BaoZaView extends View {

    private int mHeight;
    private int mWidth;
    private int mFrame;
    private Bitmap mSrcBitmap;
    private int positon;

    public BaoZaView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.baoza);


        mHeight = mSrcBitmap.getHeight();

        mWidth = mSrcBitmap.getWidth();
        mFrame = mWidth /7;



    }

    public BaoZaView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.draw(canvas);
        RectF rectF=new RectF(0,0,mFrame,mHeight);
        canvas.clipRect(rectF);
        if (positon==7){
            positon=0;
        }
        canvas.drawBitmap(mSrcBitmap,-positon*mFrame,0,null);

        positon+=1;

        invalidate();
        SystemClock.sleep(300);



    }
}
