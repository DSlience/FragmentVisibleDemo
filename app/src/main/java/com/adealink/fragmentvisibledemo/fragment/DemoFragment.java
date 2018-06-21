package com.adealink.fragmentvisibledemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.adealink.baselib.utils.LogUtil;
import com.adealink.fragmentvisibledemo.R;

import butterknife.BindView;

/**
 * Created by Xuefu_Du on 2018/6/21.
 */
public class DemoFragment extends BaseHiddenFragment {

    private static final String FRAGMENT_TYPE_MARK = "fragment_type_mark";

    @BindView(R.id.name_tv)
    TextView mNameTv;

    public static DemoFragment newInstance(String flag) {
        DemoFragment fragment = new DemoFragment();
        fragment.setFlagStr(flag);//尽早的赋值数据，便于log观察
        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENT_TYPE_MARK, flag);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_demo;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        LogUtil.w("d_slience", getFlagStr() + "DemoFragment-onActivityCreated");

        Bundle bundle = getArguments();
        if (bundle != null) {
            String flag = bundle.getString(FRAGMENT_TYPE_MARK);
            mNameTv.setText(flag);
        }
    }

}
