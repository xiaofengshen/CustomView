package com.yichao.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.yichao.customview.R;

/**
 * Author yichao
 * Time  2019/5/18 12:50
 * Dest  ${TODO}
 */
public class ClipView extends View {

    public ClipView(Context context) {
        super(context);
    }

    public ClipView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ClipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.draw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
        canvas.drawBitmap(bitmap,0,0,null);
        canvas.translate(0,200+bitmap.getHeight());

//第一个clip
        canvas.clipRect(new Rect(50,50,200,200));

        //第二个clip
        Path path=new Path();
        path.addCircle(200,200,100, Path.Direction.CCW);

//        canvas.clipPath(path, Region.Op.UNION);//并集
//      canvas.clipPath(path, Region.Op.DIFFERENCE);//保留第一，并去除交集
//
//        canvas.clipPath(path, Region.Op.REVERSE_DIFFERENCE);//保留第二，并去除交集
  //      canvas.clipPath(path, Region.Op.REPLACE);//保留第二个
//      canvas.clipPath(path, Region.Op.INTERSECT);//交集集
        canvas.clipPath(path, Region.Op.XOR);//补集







        canvas.drawBitmap(bitmap,0,0,null);







    }
}
