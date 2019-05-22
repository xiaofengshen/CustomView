package com.yichao.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.yichao.customview.R;

/**
 * Author yichao
 * Time  2019/5/19 12:15
 * Dest  ${TODO}
 */
public class CirclePhotoView extends View {

    private Canvas mMaskCanvas;
    private Bitmap mMaskBitmap;
    private Bitmap mDst;
    private Paint mPaint;
    private int mR;
    private int mHeight;
    private int mWidth;

    public CirclePhotoView(Context context) {
        super(context);
    }

    public CirclePhotoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mDst = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
        mHeight = mDst.getHeight();
        mWidth = mDst.getWidth();
        int len = Math.min(mHeight, mWidth);
        mR = len/2;

        mMaskBitmap = Bitmap.createBitmap(len, len, Bitmap.Config.ARGB_8888);
        mMaskCanvas = new Canvas(mMaskBitmap);

        mMaskCanvas.drawCircle(mR, mR, mR,mPaint);


    }

    @Override
    public void onDraw(Canvas canvas) {

        int layer = canvas.saveLayer(mWidth / 2 - mR, mHeight / 2 - mR, mWidth / 2 + mR, mHeight / 2 + mR, null, Canvas.ALL_SAVE_FLAG);
         canvas.drawBitmap(mDst,0,0,null);

        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

        canvas.drawBitmap(mMaskBitmap,mWidth/2-mR,0,mPaint);
        mPaint.setXfermode(null);

        canvas.restoreToCount(layer);

        
    }
}
