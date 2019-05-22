package com.yichao.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.yichao.customview.R;

import java.util.Random;

/**
 * Author yichao
 * Time  2019/5/19 18:02
 * Dest  ${TODO}
 */
public class GuaGuaNewView extends View {
    private static final String[] PRIZE = {
            "恭喜，您中了一等奖，奖金 1 亿元",
            "恭喜，您中了二等奖，奖金 5000 万元",
            "恭喜，您中了三等奖，奖金 100 元",
            "很遗憾，您没有中奖，继续加油哦"
    };
    private Random mRandom;
    private Bitmap mBufferBimap;
    private Canvas mBufferCanvas;
    /**
     * 涂抹的粗细
     */
    private static final int FINGER = 50;
    private Paint mClearPaint;
    private int mPreX;
    private int mPreY;

    public GuaGuaNewView(Context context) {
        super(context);
    }

    public GuaGuaNewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mRandom = new Random();


        mClearPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mClearPaint.setStyle(Paint.Style.FILL);
        mClearPaint.setStrokeJoin(Paint.Join.ROUND);
        mClearPaint.setStrokeCap(Paint.Cap.ROUND);
        mClearPaint.setStrokeWidth(FINGER);
        mClearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));

        drawBackground();
    }
    private void drawBackground() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.background);

        Bitmap bgBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas bgCanvas = new Canvas(bgBitmap);

                //计算出文字所占的区域，将文字放在正中间
                Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.WHITE);
                paint.setTextSize(50);
                Rect rect = new Rect();

                String text = getRadomText();
                paint.getTextBounds(text, 0, text.length(), rect);
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();

                int textX = (bgBitmap.getWidth() - rect.width()) / 2;
                int textY = (int) (bitmap.getHeight() / 2 - fontMetrics.descent + ((fontMetrics.bottom - fontMetrics.top) / 2));
            //  int textX = (bgBitmap.getWidth() - rect.width()) / 2;
              //  int textY = (bgBitmap.getHeight() - rect.height()) / 2;
                this.setLayerType(LAYER_TYPE_SOFTWARE, paint);

                paint.setShadowLayer(10, 0, 0, Color.YELLOW);


                bgCanvas.drawText(text, textX, textY, paint);

                paint.setShadowLayer(0, 0, 0, Color.GREEN);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                  this.setBackground(new BitmapDrawable( bgBitmap));
                } else {
                    this.setBackgroundDrawable(new BitmapDrawable(bgBitmap));
                }


    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
if (mBufferBimap==null){

    int measuredHeight = getMeasuredHeight();
    int measuredWidth = getMeasuredWidth();
    mBufferBimap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
    mBufferCanvas = new Canvas(mBufferBimap);
    //为缓冲区添加灰色
    mBufferCanvas.drawColor(Color.parseColor("#FF808080"));

}




    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mPreX = x;
                mPreY = y;

                break;
            case MotionEvent.ACTION_MOVE:
                int currentX = x;
                int currentY = y;
                mBufferCanvas.drawLine(mPreX, mPreY, currentX, currentY, mClearPaint);

                mPreX = currentX;
                mPreY = currentY;

                invalidate();

                break;
            case MotionEvent.ACTION_UP:

                invalidate();
                break;


        }


        return true;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawBitmap(mBufferBimap, 0, 0, null);
    }

    /**
     * 获取随机文本
     *
     * @return
     */

    public String getRadomText() {
        return PRIZE[mRandom.nextInt(PRIZE.length)];

    }
}
