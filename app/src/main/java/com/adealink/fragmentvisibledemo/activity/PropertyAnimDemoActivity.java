package com.adealink.fragmentvisibledemo.activity;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adealink.baselib.framework.BaseActivity;
import com.adealink.fragmentvisibledemo.R;

import butterknife.BindView;

/**
 * 属性动画的用法Demo
 * Created by Xuefu_Du on 2018/6/24.
 */
public class PropertyAnimDemoActivity extends BaseActivity {


    @BindView(R.id.parent_layout)
    LinearLayout mParentLayout;
    @BindView(R.id.flag_tv)
    TextView mFlagTv;

    private void setBgMaskAlpha(int alpha) {
        int color = Color.argb(alpha, 0, 0, 0);
        mParentLayout.setBackgroundColor(color);
    }

    @Override
    protected void setUpViewAndData() {
        setContentView(R.layout.activity_object_anim_demo);

        initView();
    }

    private void initView() {
        ObjectAnimator bgAlphaAnim = ObjectAnimator.ofInt(this, "bgMaskAlpha", 0, (int) (255 * 7f / 10f));
        bgAlphaAnim.setStartDelay(1000);
        bgAlphaAnim.setDuration(2000);
        bgAlphaAnim.start();

        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(mFlagTv, "alpha", 1, 0);
        alphaAnim.setStartDelay(3000);
        alphaAnim.setDuration(2000);
        alphaAnim.start();
    }
}
