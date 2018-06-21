package com.adealink.fragmentvisibledemo.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;

import com.adealink.baselib.utils.CommonUtil;
import com.adealink.fragmentvisibledemo.bean.TagBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xuefu_Du on 2018/6/21.
 */
public class DemoFmStatePagerAdapter extends FragmentStatePagerAdapter {

    private Fragment mCurFragment;//记录当前的Fragment
    private List<TagBean> mTagBeanList = new ArrayList<>();//资讯标签列表

    public DemoFmStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * 更新翻页Adapter
     *
     * @param list 资讯标签列表
     */
    public void update(List<TagBean> list) {
        mTagBeanList.clear();
        if (!CommonUtil.isListBlank(list)) {
            mTagBeanList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        TagBean tagBean = getItemBeanWithPosition(position);
        String flag = null;
        if (tagBean != null) {
            flag = tagBean.getFlag();
        }
        return DemoFragment.newInstance(flag);
    }

    @Override
    public int getCount() {
        return mTagBeanList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    /**
     * 每次viewpager滑动后都会被调用, object参数就是显示的Fragment;
     */
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        try {
            mCurFragment = (Fragment) object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.setPrimaryItem(container, position, object);
    }

    public Fragment getCurFragment() {
        return mCurFragment;
    }

    /**
     * @param position
     * @return 对应位置页面的Tag
     */
    @Override
    public CharSequence getPageTitle(int position) {
        TagBean tagBean = getItemBeanWithPosition(position);
        if (tagBean != null) {
            return tagBean.getName();
        }
        return "";
    }

    /**
     * @param position
     * @return 对应位置的数据单元
     */
    public TagBean getItemBeanWithPosition(int position) {
        if (position >= 0 && position < mTagBeanList.size()) {
            return mTagBeanList.get(position);
        }
        return null;
    }

}
