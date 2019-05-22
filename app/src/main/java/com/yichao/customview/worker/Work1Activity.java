package com.yichao.customview.worker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.yichao.customview.R;

import java.util.Random;

public class Work1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.activity_work1);
        ImageView imageView = findViewById(R.id.iv_bitmap);
        Point point=new Point();
        getWindow().getWindowManager().getDefaultDisplay().getSize(point);
    int with=point.x;
    int height=point.y;
    int circleRadius=10;
    int xSize=with/(circleRadius*2);
    int ySize=height/(circleRadius*2);

        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);
        Random random=new Random();




        Bitmap caCheBitmap = Bitmap.createBitmap(with, height, Bitmap.Config.ARGB_4444);
        Canvas canvas=new Canvas(caCheBitmap);
        //20*20实心圆
        for (int y=0;y<ySize;y++){
            for (int  x=0;x<xSize;x++){
                int a=random.nextInt(255);
                int r=random.nextInt(255);
                int g=random.nextInt(255);
                int b=random.nextInt(255);
                paint.setARGB(a,r,g,b);

                canvas.drawCircle(circleRadius*2*x+circleRadius,circleRadius*2*y+circleRadius,circleRadius,paint);



            }


        }









        imageView.setImageBitmap(caCheBitmap);


    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, Work1Activity.class);
        context.startActivity(starter);
    }

}
