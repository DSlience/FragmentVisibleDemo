package com.adealink.fragmentvisibledemo.manager.fmmanager;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.adealink.fragmentvisibledemo.R;

/**
 * Created by Xuefu_Du on 2018/6/21.
 */
public class DemoFmMannager extends BaseFmManager {

    public DemoFmMannager(@NonNull FragmentActivity fa) {
        super(fa);
    }

    public void addFragment(@NonNull Fragment fragment, String fgTag) {
        if (fragment.isAdded()) {
            return;
        }
        FragmentTransaction transaction = mFM.beginTransaction();
        transaction.add(R.id.content_layout, fragment, fgTag);
        transaction.commit();
    }

    public void removeFragment(Fragment fragment) {
        FragmentTransaction transaction = mFM.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }

    public void replaceFragment(Fragment fragment, String fgTag) {
        FragmentTransaction transaction = mFM.beginTransaction();
        transaction.replace(R.id.content_layout, fragment, fgTag);
        transaction.commit();
    }

}
