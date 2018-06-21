package com.adealink.fragmentvisibledemo.activity;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.adealink.baselib.framework.BaseActivity;
import com.adealink.fragmentvisibledemo.R;
import com.adealink.fragmentvisibledemo.fragment.DemoFragment;
import com.adealink.fragmentvisibledemo.manager.fmmanager.DemoFmMannager;

import butterknife.BindViews;

/**
 * Created by Xuefu_Du on 2018/6/21.
 */
public class ManagerFragmentActivity extends BaseActivity {

    private final int TAB_NUM = 4;//底部tab数量

    private final int TAB_NEWS = 0;
    private final int TAB_COMMUNITY = 1;
    private final int TAB_ME = 2;
    private final int TAB_CAR = 3;

    private final String FLAG_NEWS = "第1页";
    private final String FLAG_COMMUNITY = "第2页";
    private final String FLAG_CAR = "第3页";
    private final String FLAG_ME = "第4页";

    private Fragment[] mFragments = new Fragment[TAB_NUM];
    private DemoFmMannager mFmMannager;
    private int mCurrTabIndex = -1;//当前tab索引

    @BindViews({R.id.news_tab_btn, R.id.community_tab_btn, R.id.me_tab_btn, R.id.car_tab_btn})
    TextView[] mTabs;//底部tab数组 news_img

    @Override
    protected void setUpViewAndData() {
        setContentView(R.layout.activity_manager_fragment);

        mFmMannager = new DemoFmMannager(this);

        goFragment(TAB_NEWS);
    }

    //底部Tab点击选中
    public void onTabSelect(View view) {
        switch (view.getId()) {
            case R.id.news_tab:
                goFragment(TAB_NEWS);
                break;
            case R.id.community_tab:
                goFragment(TAB_COMMUNITY);
                break;
            case R.id.car_tab:
                goFragment(TAB_CAR);
                break;
            case R.id.me_tab:
                goFragment(TAB_ME);
                break;
        }
    }

    /**
     * @param tabIndex 去到的Tab索引
     */
    private void goFragment(int tabIndex) {
        if (mCurrTabIndex == tabIndex) {
            return;
        }
        //隐藏旧的
        if (mCurrTabIndex >= 0 && mCurrTabIndex < mTabs.length) {
            Fragment currFragment = mFragments[mCurrTabIndex];
            mFmMannager.hide(currFragment);
        }
        //显示新的
        Fragment goFragment = mFragments[tabIndex];
        if (goFragment == null) {
            goFragment = initFragment(tabIndex);
            mFragments[tabIndex] = goFragment;
            mFmMannager.addFragment(goFragment, getFmFlag(tabIndex));
        }
        mFmMannager.show(goFragment);

        //变换Tab状态
        switchTab(tabIndex);

        //记录Tab Index值
        mCurrTabIndex = tabIndex;
    }

    /**
     * @param tabIndex 初始化的Tab索引
     */
    private Fragment initFragment(int tabIndex) {
        DemoFragment fragment = null;
        switch (tabIndex) {
            case TAB_NEWS:
                fragment = DemoFragment.newInstance(FLAG_NEWS);
                break;
            case TAB_COMMUNITY:
                fragment = DemoFragment.newInstance(FLAG_COMMUNITY);
                break;
            case TAB_CAR:
                fragment = DemoFragment.newInstance(FLAG_CAR);
                break;
            case TAB_ME:
                fragment = DemoFragment.newInstance(FLAG_ME);
                break;
        }
        return fragment;
    }

    /**
     * @param tabIndex
     * @return tabIndex对应的Fm的Flag
     */
    private String getFmFlag(int tabIndex) {
        String fmFlag = null;
        switch (tabIndex) {
            case TAB_NEWS:
                fmFlag = FLAG_NEWS;
                break;
            case TAB_COMMUNITY:
                fmFlag = FLAG_COMMUNITY;
                break;
            case TAB_CAR:
                fmFlag = FLAG_CAR;
                break;
            case TAB_ME:
                fmFlag = FLAG_ME;
                break;
        }
        return fmFlag;
    }

    /**
     * @param tabIndex 切换到的Tab
     */
    private void switchTab(int tabIndex) {
        if (mCurrTabIndex >= 0 && mCurrTabIndex < mTabs.length) {
            mTabs[mCurrTabIndex].setSelected(false);
        }
        mTabs[tabIndex].setSelected(true);
    }

}
