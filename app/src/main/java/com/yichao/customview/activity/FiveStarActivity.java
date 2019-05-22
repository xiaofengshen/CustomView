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

public class FiveStarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bitmap);
        ImageView imageView= findViewById(R.id.iv_bitmap);
        Bitmap cacheBitmap = Bitmap.createBitmap(800, 1500, Bitmap.Config.ARGB_4444);
        Canvas canvas=new Canvas(cacheBitmap);
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        Path path=new Path();
        path.moveTo(400,50);
       path.rLineTo(-200,500);
       path.rLineTo(400,-200);
       path.rLineTo(-400,0);
       path.rLineTo(400,200);

        path.close();
        canvas.drawPath(path,paint);


        imageView.setImageBitmap(cacheBitmap);
    }
    public static void startActivity(Context context) {
        Intent starter = new Intent(context, FiveStarActivity.class);
        context.startActivity(starter);
    }
}
