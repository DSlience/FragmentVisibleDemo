package com.adealink.fragmentvisibledemo.manager.fmmanager;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

/**
 * Created by Xuefu_Du on 2018/6/21.
 */
public class BaseFmManager {

    protected FragmentActivity mActivity;
    protected FragmentManager mFM;

    public BaseFmManager(@NonNull FragmentActivity fa) {
        mActivity = fa;
        mFM = fa.getSupportFragmentManager();
    }

    public void hide(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        FragmentTransaction transaction = mFM.beginTransaction();
        transaction.hide(fragment);
        transaction.commit();
    }

    public void show(Fragment fragment) {
        FragmentTransaction transaction = mFM.beginTransaction();
        transaction.show(fragment);
        transaction.commit();
    }

    public void detach(Fragment fragment) {
        FragmentTransaction transaction = mFM.beginTransaction();
        transaction.detach(fragment);
        transaction.commit();
    }

    public void attach(Fragment fragment) {
        FragmentTransaction transaction = mFM.beginTransaction();
        transaction.attach(fragment);
        transaction.commit();
    }

}
