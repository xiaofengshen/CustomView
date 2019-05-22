package com.yichao.customview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author yichao
 * Time  2019/5/21 16:22
 * Dest  流式布局
 */
public class MarginFlowlayoutView extends ViewGroup {
    public MarginFlowlayoutView(Context context) {
        super(context);
    }

    public MarginFlowlayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();

        int childLineWidth=((MarginLayoutParams)getChildAt(0).getLayoutParams()).leftMargin;
        int maxLineheight=((MarginLayoutParams)getChildAt(0).getLayoutParams()).topMargin;
        int width=getMeasuredWidth();
        int height=((MarginLayoutParams)getChildAt(0).getLayoutParams()).topMargin;

        for (int i=0;i<childCount;i++){
            View childView = getChildAt(i);
            MarginLayoutParams marginLayoutParams= (MarginLayoutParams) childView.getLayoutParams();
            int leftMargin = marginLayoutParams.leftMargin;
            int rightMargin = marginLayoutParams.rightMargin;
            int topMargin = marginLayoutParams.topMargin;
            int bottomMargin = marginLayoutParams.bottomMargin;

            //换行
            if (childLineWidth+childView.getMeasuredWidth()+leftMargin+rightMargin>width-getPaddingRight()-getPaddingLeft()){
                height+=maxLineheight;
                maxLineheight=0+topMargin;
                childLineWidth=0+leftMargin;

            }
            layout(childView,childLineWidth,height,childLineWidth+childView.getMeasuredWidth(),height+childView.getMeasuredHeight());

            maxLineheight=Math.max(maxLineheight,childView.getMeasuredHeight()+topMargin+bottomMargin);

            childLineWidth+=childView.getMeasuredWidth()+leftMargin+rightMargin;

        }


    }

    private void layout(View childView, int l, int t, int r, int b) {


        childView.layout(getPaddingLeft()+l,getPaddingTop()+t,r+getPaddingLeft(),b+getPaddingTop());

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);


        int width = getMesureWith(widthMeasureSpec);
        int height = getMesureHeight(heightMeasureSpec);


        setMeasuredDimension(width, height);


    }

    private int getMesureHeight(int heightMeasureSpec) {


        int mode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);
        int with=getMeasuredWidth();
        int height=0;
        int childLineWidth=0;
        int maxLineheight=0;
        switch (mode){
            case MeasureSpec.EXACTLY:
                height=size;
            break;
            case MeasureSpec.AT_MOST:

                int childCount = getChildCount();
                for (int i=0;i<childCount;i++){

                    View childView = getChildAt(i);
                    MarginLayoutParams marginLayoutParams= (MarginLayoutParams) childView.getLayoutParams();
                    int leftMargin = marginLayoutParams.leftMargin;
                    int rightMargin = marginLayoutParams.rightMargin;
                    int topMargin = marginLayoutParams.topMargin;
                    int bottomMargin = marginLayoutParams.bottomMargin;




                    childLineWidth+=childView.getMeasuredWidth()+leftMargin+rightMargin;
                    maxLineheight=Math.max(maxLineheight,childView.getMeasuredHeight()+topMargin+bottomMargin);
                    //假设需要换行
                    if (i<childCount-1&& childLineWidth+getChildAt(i+1).getMeasuredWidth()+((MarginLayoutParams)getChildAt(i+1).getLayoutParams()).leftMargin+((MarginLayoutParams)getChildAt(i+1).getLayoutParams()).rightMargin>with-getPaddingLeft()-getPaddingRight()){

                        height+=maxLineheight;
                        maxLineheight=0;
                        childLineWidth=0;

                    }else if (i==childCount-1){
                        //结束
                        height+=maxLineheight;
                    }

                }

                break;
        }





        return height+getPaddingTop()+getPaddingBottom();
    }

    private int getMesureWith(int widthMeasureSpec) {
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int width = 0;
        int childrenWidth=0;
        switch (mode) {

            case MeasureSpec.EXACTLY:
                width = size;

                break;
            case MeasureSpec.AT_MOST:
                int childCount = getChildCount();
                for (int i=0;i<childCount;i++){
                    View childView = getChildAt(i);
                    int childWidth = childView.getMeasuredWidth();
                     MarginLayoutParams marginLayoutParams= (MarginLayoutParams) childView.getLayoutParams();
                    int leftMargin = marginLayoutParams.leftMargin;
                    int rightMargin = marginLayoutParams.rightMargin;
                    int topMargin = marginLayoutParams.topMargin;
                    int bottomMargin = marginLayoutParams.bottomMargin;


                    if (childWidth>size){
                        throw new IllegalStateException("Sub view is too large");
                    }

                    childrenWidth+= childView.getMeasuredWidth()+leftMargin+rightMargin;
                }


                if (childrenWidth>size){
                    width=size;

                }else {
                    width=childrenWidth;
                }

                break;
        }

        return width+getPaddingLeft()+getPaddingRight();
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);

    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);

    }
}
