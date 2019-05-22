package com.yichao.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.yichao.customview.R;

/**
 * Author yichao
 * Time  2019/5/21 11:16
 * Dest  ${TODO}
 */
public class CircleImageView extends ImageView {

    private int mColor;
    private float mBorde;
    private Path mPath;
    private Paint mPaint;

    public CircleImageView(Context context) {
        super(context);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);

        mPath = new Path();



        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView);
        mColor = typedArray.getColor(R.styleable.CircleImageView_border_color, Color.parseColor("#ccddff"));
        mBorde = typedArray.getDimension(R.styleable.CircleImageView_circle_border, 0);

        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        BitmapDrawable drawable = (BitmapDrawable) getDrawable();

        if (drawable==null){
            super.onDraw(canvas);
        }

        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();

        RectF ovalRectF=new RectF(0,0,measuredWidth,measuredHeight);
        int layer = canvas.saveLayer(getPaddingLeft(), getPaddingTop(), measuredWidth, measuredHeight, null);


        Bitmap bitmap = drawable.getBitmap();
        canvas.drawBitmap(bitmap,new Rect(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight()),ovalRectF,null);
        mPath.reset();
        mPath.addOval(ovalRectF, Path.Direction.CW);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawPath(mPath,mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(layer);


        if (mBorde!=0){

            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(mColor);
            mPaint.setStrokeWidth(mBorde);
            ovalRectF.inset(mBorde/2,mBorde/2);
            canvas.drawOval(ovalRectF,mPaint);


        }






    }
}
