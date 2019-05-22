package com.yichao.customview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Scroller;

/**
 * Author yichao
 * Time  2019/5/21 22:12
 * Dest  ${TODO}
 */
public class BaseScrollerViewGroup extends ViewGroup {
    private String TAG="BaseScrollerViewGroup";
    private Scroller mScroller;
    private Button mButton;

    public BaseScrollerViewGroup(Context context) {
        this(context,null);
    }

    public BaseScrollerViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);

        mScroller = new Scroller(context);
        LayoutParams layoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        mButton = new Button(context);

        mButton.setText("Android自定义组件");

        addView(mButton,layoutParams);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (MeasureSpec.getMode(widthMeasureSpec)==MeasureSpec.AT_MOST ||MeasureSpec.getMode(heightMeasureSpec)==MeasureSpec.AT_MOST){
            throw new IllegalStateException("Must be MeasureSpec.EXACTLY.");
        }

         measureChildren(widthMeasureSpec,heightMeasureSpec);


        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),MeasureSpec.getSize(heightMeasureSpec));



    }




    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mButton.layout(100,100,mButton.getMeasuredWidth()+100,mButton.getMeasuredHeight()+100);

    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()){
            this.scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            postInvalidate();

            Log.i(TAG,"getScrollX::"+getScrollX());

            Log.i(TAG,"getScrollY::"+getScrollY());

            Log.i(TAG,"mScroller.getCurrX()::"+mScroller.getCurrX());

            Log.i(TAG,"mScroller.getCurrY()::"+mScroller.getCurrY());

        }
        
    }



    public void start(){
        Log.i(TAG,"getScrollX::"+getScrollX());

        Log.i(TAG,"getScrollY::"+getScrollY());

        mScroller.startScroll(this.getScrollX(),this.getScrollY(),-900,0,1000);
        postInvalidate();


    }

}
