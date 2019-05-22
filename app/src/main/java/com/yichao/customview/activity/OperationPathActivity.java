package com.yichao.customview.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.yichao.customview.R;

public class OperationPathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bitmap);
        ImageView imageView= findViewById(R.id.iv_bitmap);
        Bitmap cacheBitmap = Bitmap.createBitmap(800, 1500, Bitmap.Config.ARGB_4444);
        Canvas canvas=new Canvas(cacheBitmap);
        Path path1=new Path();
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(3);

        path1.addRect(10,10,110,110, Path.Direction.CCW);

       // canvas.drawPath(path1,paint);
        paint.setColor(Color.RED);
        Path path2=new Path();
        path2.addCircle(100,100,50, Path.Direction.CCW);




    //    canvas.drawPath(path2,paint);

        //做运算

        path1.op(path2, Path.Op.INTERSECT);


        canvas.drawPath(path1,paint);








        imageView.setImageBitmap(cacheBitmap);
    }


    public static void startActivity(Context context) {
        Intent starter = new Intent(context, OperationPathActivity.class);
        context.startActivity(starter);
    }
}
