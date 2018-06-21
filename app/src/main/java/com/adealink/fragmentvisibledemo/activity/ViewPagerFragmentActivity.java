package com.adealink.fragmentvisibledemo.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.adealink.baselib.framework.BaseMvpActivity;
import com.adealink.fragmentvisibledemo.R;
import com.adealink.fragmentvisibledemo.adapter.pageradapter.CommonFmPagerAdapter;
import com.adealink.fragmentvisibledemo.bean.TagBean;
import com.adealink.fragmentvisibledemo.dagger.component.DaggerViewPagerFragmentComponent;
import com.adealink.fragmentvisibledemo.dagger.module.ViewPagerFragmentModule;
import com.adealink.fragmentvisibledemo.fragment.DemoFmStatePagerAdapter;
import com.adealink.fragmentvisibledemo.fragment.DemoFragment;
import com.adealink.fragmentvisibledemo.presenter.ViewPagerFragmentPresenter;
import com.adealink.fragmentvisibledemo.view.ViewPagerFragmentView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Xuefu_Du on 2018/6/21.
 */
public class ViewPagerFragmentActivity extends BaseMvpActivity<ViewPagerFragmentView, ViewPagerFragmentPresenter>
        implements ViewPagerFragmentView {

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @NonNull
    @Override
    public ViewPagerFragmentPresenter createPresenter() {
        return new ViewPagerFragmentPresenter();
    }

    @Override
    protected void injectDependencies() {
        super.injectDependencies();
        DaggerViewPagerFragmentComponent.builder()
                .viewPagerFragmentModule(new ViewPagerFragmentModule())
                .build()
                .inject(this);
    }

    @Override
    protected void setUpViewAndData() {
        setContentView(R.layout.activity_view_pager_fragment);

        initStatePagerAdapterView();
    }

    private void initView() {
        //ViewPager
        CommonFmPagerAdapter pagerAdapter = new CommonFmPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        //添加Fragment
        pagerAdapter.addFragment(DemoFragment.newInstance("第1页"), "篮球");
        pagerAdapter.addFragment(DemoFragment.newInstance("第2页"), "足球");
        pagerAdapter.addFragment(DemoFragment.newInstance("第3页"), "羽毛球");
        pagerAdapter.addFragment(DemoFragment.newInstance("第4页"), "排球");
        pagerAdapter.addFragment(DemoFragment.newInstance("第5页"), "乒乓球");
        pagerAdapter.addFragment(DemoFragment.newInstance("第6页"), "橄榄球");
        pagerAdapter.addFragment(DemoFragment.newInstance("第7页"), "冰球");
        pagerAdapter.addFragment(DemoFragment.newInstance("第8页"), "曲棍球");

        pagerAdapter.notifyDataSetChanged();
    }

    private void initStatePagerAdapterView() {
        //ViewPager
        DemoFmStatePagerAdapter statePagerAdapter = new DemoFmStatePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(statePagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        List<TagBean> list = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            TagBean tagBean = new TagBean();
            tagBean.setName("球" + i);
            tagBean.setFlag("第" + i + "页");
            list.add(tagBean);
        }
        statePagerAdapter.update(list);

        statePagerAdapter.notifyDataSetChanged();
    }

}
