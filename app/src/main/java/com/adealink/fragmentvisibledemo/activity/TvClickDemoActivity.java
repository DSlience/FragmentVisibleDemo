package com.adealink.fragmentvisibledemo.activity;

import android.view.View;

import com.adealink.baselib.framework.BaseActivity;
import com.adealink.baselib.utils.LogUtil;
import com.adealink.fragmentvisibledemo.R;

import butterknife.OnClick;

/**
 * Created by Xuefu_Du on 2018/6/24.
 */
public class TvClickDemoActivity extends BaseActivity {

    @Override
    protected void setUpViewAndData() {
        setContentView(R.layout.activity_tv_click_demo);

        initView();
    }

    private void initView() {

    }

    @OnClick(R.id.parent_layout)
    public void onParentClicked(View view) {
        LogUtil.d("d_slience", "onParentClicked-onParentClicked");
    }

//    @OnClick(R.id.down_tv)
//    public void onDownClicked(View view) {
//        LogUtil.d("d_slience", "onDownClicked-onDownClicked");
//    }
}
