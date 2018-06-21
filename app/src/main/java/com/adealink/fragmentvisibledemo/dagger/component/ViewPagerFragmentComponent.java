package com.adealink.fragmentvisibledemo.dagger.component;

import com.adealink.fragmentvisibledemo.activity.ViewPagerFragmentActivity;
import com.adealink.fragmentvisibledemo.dagger.module.ViewPagerFragmentModule;

import dagger.Component;

/**
 * Created by Xuefu_Du on 2018/5/23.
 */
@Component(modules = ViewPagerFragmentModule.class)
public interface ViewPagerFragmentComponent {

    void inject(ViewPagerFragmentActivity activity);
}
