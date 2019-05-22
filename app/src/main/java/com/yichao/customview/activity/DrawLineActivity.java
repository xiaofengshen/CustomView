package com.yichao.customview.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.yichao.customview.R;

import java.util.Random;

public class DrawLineActivity extends AppCompatActivity {
    private int frame=100;
    private int [] colors={Color.RED,Color.BLACK,Color.GREEN,Color.BLUE,Color.GRAY};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bitmap);
        ImageView imageView= findViewById(R.id.iv_bitmap);
        Bitmap cacheBitmap = Bitmap.createBitmap(800, 1500, Bitmap.Config.ARGB_4444);
        Canvas canvas=new Canvas(cacheBitmap);
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);
        //paint.setColor(Color.RED);
        Random random=new Random();

        for (int i=1;i<=5;i++){

            paint.setColor(colors[random.nextInt(colors.length)]);

            canvas.drawLine(10,frame*i,500,frame*i,paint);

        }


        imageView.setImageBitmap(cacheBitmap);



    }
     public static void startActivity(Context context) {
         Intent starter = new Intent(context, DrawLineActivity.class);
         context.startActivity(starter);
     }
}
