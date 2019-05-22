package com.yichao.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author yichao
 * Time  2019/5/19 10:39
 * Dest  图层运算
 */
public class LayerView extends View {
    public LayerView(Context context) {
        super(context);
    }

    public LayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.draw(canvas);

        Bitmap dst=Bitmap.createBitmap(300,300, Bitmap.Config.ARGB_8888);
        Bitmap src = dst.copy(Bitmap.Config.ARGB_8888, true);
        Bitmap bitmap3 = Bitmap.createBitmap(450, 450, Bitmap.Config.ARGB_8888);

        Canvas canvas1=new Canvas(dst);
        Canvas canvas2=new Canvas(src);
        Canvas canvas3=new Canvas(bitmap3);


        Paint p1=new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setColor(Color.RED);
        canvas1.drawCircle(150,150,150,p1);


        Paint p2=new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.GREEN);
        canvas2.drawRect(0,0,300,300,p2);


        Paint p3=new Paint(Paint.ANTI_ALIAS_FLAG);
        int layer = canvas3.saveLayer(150, 150, 450, 450, null, Canvas.ALL_SAVE_FLAG);
        canvas3.drawBitmap(dst,0,0,null);
        p3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas3.drawBitmap(src,150,150,p3);

        p3.setXfermode(null);
        canvas3.restoreToCount(layer);

        canvas.drawBitmap(bitmap3,0,0,null);





    }
}
