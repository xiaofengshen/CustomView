package com.yichao.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yichao.customview.activity.BallMoveActivity;
import com.yichao.customview.activity.BezierActivity;
import com.yichao.customview.activity.CanvasTranslateActivity;
import com.yichao.customview.activity.CirclePhotoActivity;
import com.yichao.customview.activity.CircleViewActivity;
import com.yichao.customview.activity.ClipViewActivity;
import com.yichao.customview.activity.DrawArcActivity;
import com.yichao.customview.activity.DrawCurveActivity;
import com.yichao.customview.activity.DrawLineActivity;
import com.yichao.customview.activity.DrawRectActivity;
import com.yichao.customview.activity.FiveStarActivity;
import com.yichao.customview.activity.FlowlayotActivity;
import com.yichao.customview.activity.GuaGuaActivity;
import com.yichao.customview.activity.LayerViewActivity;
import com.yichao.customview.activity.LinearGradientActivity;
import com.yichao.customview.activity.OperationPathActivity;
import com.yichao.customview.activity.ScrollerActivity;
import com.yichao.customview.activity.ShawViewActivity;
import com.yichao.customview.activity.ShowBitmapActivity;
import com.yichao.customview.activity.TextCenterActivity;
import com.yichao.customview.activity.TextViewActivity;
import com.yichao.customview.activity.WatchActivity;
import com.yichao.customview.worker.Work1Activity;
import com.yichao.customview.worker.Work2Activity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mStringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycle);

        mStringList = new ArrayList<>();
        mStringList.add("放大位图");
        mStringList.add("画扇形");
        mStringList.add("画直线");
        mStringList.add("五角星");
        mStringList.add("贝塞尔曲线");
        mStringList.add("path运算");
        mStringList.add("圆满屏");
        mStringList.add("干扰线");
        mStringList.add("圆球移动");
        mStringList.add("Canvas转换");
        mStringList.add("ClipView");
        mStringList.add("手表");
        mStringList.add("画曲线");
        mStringList.add("画矩形");
        mStringList.add("阴影");
        mStringList.add("线性渐变");
        mStringList.add("文字居中");
        mStringList.add("位图运算");
        mStringList.add("圆角图片");
        mStringList.add("刮刮奖");
        mStringList.add("自定义TextView");
        mStringList.add("自定义ImageView");
        mStringList.add("流式布局");
        mStringList.add("Scroller");


        CommonAdapter commonAdapter = new CommonAdapter<String>(this, R.layout.item_name, mStringList) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.item, s);
            }
        };


        commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

                onClick(position);


            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mRecyclerView.setAdapter(commonAdapter);

    }

    private void onClick(int position) {

        switch (position) {
            case 0:
                ShowBitmapActivity.startActivity(this);
                break;
            case 1:
                DrawArcActivity.startActivity(this);
                break;
            case 2:
                DrawLineActivity.startActivity(this);
                break;
            case 3:
                FiveStarActivity.startActivity(this);
                break;
            case 4:
                BezierActivity.startActivity(this);
                break;
            case 5:
                OperationPathActivity.startActivity(this);
                break;
            case 6:
                Work1Activity.startActivity(this);
                break;
            case 7:
                Work2Activity.startActivity(this);
                break;
            case 8:
                BallMoveActivity.startActivity(this);
                break;
            case 9:
                CanvasTranslateActivity.startActivity(this);
                break;
            case 10:
                ClipViewActivity.startActivity(this);
                break;
            case 11:
                WatchActivity.startActivity(this);
                break;
            case 12:
                DrawCurveActivity.startActivity(this);
                break;
            case 13:
                DrawRectActivity.startActivity(this);
                break;
            case 14:
                ShawViewActivity.startActivity(this);
                break;
            case 15:
                LinearGradientActivity.startActivity(this);
                break;
            case 16:
                TextCenterActivity.startActivity(this);
                break;
            case 17:
                LayerViewActivity.startActivity(this);
                break;
            case 18:
                CirclePhotoActivity.startActivity(this);
                break;
            case 19:
                GuaGuaActivity.startActivity(this);
                break;
            case 20:
                TextViewActivity.startActivity(this);
                break;
            case 21:
                CircleViewActivity.startActivity(this);
                break;
            case 22:
                FlowlayotActivity.startActivity(this);
                break;
  case 23:
                ScrollerActivity.startActivity(this);
                break;


        }


    }
}
