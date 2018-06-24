package com.adealink.baselib.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * 支持点击空白地方的监听的RecyclerView；
 * Created by Xuefu_Du on 2018/6/19.
 */
public class BlankClickRV extends RecyclerView {

    private GestureDetectorCompat mGestureCompat;
    private View.OnClickListener mBlankAreaClickListener;//空白区域的点击监听
    private OnItemClickListener mOnItemClickListener;//列表项点击监听

    public BlankClickRV(Context context) {
        super(context);
    }

    public BlankClickRV(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BlankClickRV(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if (mGestureCompat != null && mGestureCompat.onTouchEvent(e)) {
            View childView = findChildViewUnder(e.getX(), e.getY());
            /**
             * 空白区域的点击
             */
            if (childView == null) {
                if (mBlankAreaClickListener != null) {
                    mBlankAreaClickListener.onClick(null);
                }
                return true;
            }
            /**
             * 列表项的点击
             */
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(childView, getChildAdapterPosition(childView));
                return true;
            }
        }
        return super.onTouchEvent(e);
    }

    private void initGestureCompat() {
        if (this.mGestureCompat == null) {
            this.mGestureCompat = new GestureDetectorCompat(getContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
        }
    }

    /**
     * 设置空白区域处的点击
     */
    public void setBlankAreaClickListener(View.OnClickListener listener) {
        this.mBlankAreaClickListener = listener;
        initGestureCompat();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
        initGestureCompat();
    }

    public interface OnItemClickListener {

        void onItemClick(View view, int position);
    }

}
