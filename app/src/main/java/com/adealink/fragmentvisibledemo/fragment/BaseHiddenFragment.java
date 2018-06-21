package com.adealink.fragmentvisibledemo.fragment;

import com.adealink.baselib.framework.BaseFragment;
import com.adealink.baselib.utils.LogUtil;

/**
 * Created by Xuefu_Du on 2018/6/21.
 */
public abstract class BaseHiddenFragment extends BaseFragment {

    private String mFragmentFlag;

    protected boolean mOnPause;//onResume <-> onPause
    protected boolean mPageStart;//pageStart <-> pageEnd
    protected boolean mHidden;

    public void setFlagStr(String flag) {
        mFragmentFlag = flag;
    }

    private String getFlagStr() {
        return mFragmentFlag;
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.w("d_slience", getFlagStr() + "-onResume-onResume");
        mOnPause = false;
        pageStartEndCompute();
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.w("d_slience", getFlagStr() + "-onPause-onPause");
        mOnPause = true;
        pageStartEndCompute();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        LogUtil.w("d_slience", getFlagStr() + "-hidden:" + hidden);
        mHidden = hidden;
        pageStartEndCompute();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        LogUtil.w("d_slience", getFlagStr() + "-isVisibleToUser:" + isVisibleToUser);
    }

    /**
     * 监听页面的Start\End，埋点上报等
     */
    protected void pageStartEndCompute() {
        boolean pageStart = false;
        if (!mOnPause && mHidden) {
            pageStart = true;
        }
        if (pageStart == mPageStart) {
            return;
        }
        mPageStart = pageStart;
        if (mPageStart) {
            onFragmentPageStart();
        } else {
            onFragmentPageEnd();
        }
    }

    //页面起始-用户可见
    protected void onFragmentPageStart() {
//        LogUtil.w("d_slience", getFlagStr() + "-onFragmentPageStart");
    }

    //页面结束-用户不可见
    protected void onFragmentPageEnd() {
//        LogUtil.w("d_slience", getFlagStr() + "-onFragmentPageEnd");
    }

}
