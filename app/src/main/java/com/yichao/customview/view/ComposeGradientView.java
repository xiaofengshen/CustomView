package com.yichao.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.yichao.customview.R;

/**
 * Author yichao
 * Time  2019/5/18 21:28
 * Dest  ${TODO}
 */
public class ComposeGradientView extends View {
    public ComposeGradientView(Context context) {
        super(context);
    }

    public ComposeGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.draw(canvas);
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);


        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcherss);


        BitmapShader bitmapShader=new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR);




        LinearGradient linearGradient=new LinearGradient(0,0,getMeasuredWidth(),0, Color.RED,Color.BLUE, Shader.TileMode.CLAMP);

        ComposeShader composeShader = new ComposeShader(bitmapShader/*dst*/,linearGradient/*src*/, PorterDuff.Mode.SCREEN);
        paint.setShader(composeShader);
        canvas.drawRect(new RectF(0,0,getMeasuredWidth(),1000),paint);









    }
}
