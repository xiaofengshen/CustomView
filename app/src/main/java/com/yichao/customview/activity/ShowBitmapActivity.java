package com.yichao.customview.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.yichao.customview.R;

public class ShowBitmapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bitmap);

       ImageView imageView= findViewById(R.id.iv_bitmap);
        Bitmap cacheBitmap = Bitmap.createBitmap(800, 1500, Bitmap.Config.ARGB_4444);
        Canvas canvas=new Canvas(cacheBitmap);

        Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.hello);

        canvas.drawBitmap(srcBitmap,0,0,null);
        //放大3倍
        int width = srcBitmap.getWidth();
        int height = srcBitmap.getHeight();

        Rect srcRect=new Rect(0,0,width,height);


        Rect distRect=new Rect(0,height,width*3,height+height*3);


        canvas.drawBitmap(srcBitmap,srcRect,distRect,null);


        imageView.setImageBitmap(cacheBitmap);

    }


    public static void startActivity(Context context) {
        Intent starter = new Intent(context, ShowBitmapActivity.class);
        context.startActivity(starter);
    }


}
