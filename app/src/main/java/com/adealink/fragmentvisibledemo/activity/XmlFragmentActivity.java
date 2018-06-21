package com.adealink.fragmentvisibledemo.activity;

import com.adealink.baselib.framework.BaseActivity;
import com.adealink.fragmentvisibledemo.R;
import com.adealink.fragmentvisibledemo.fragment.DemoFragment;

/**
 * Created by Xuefu_Du on 2018/6/21.
 */
public class XmlFragmentActivity extends BaseActivity {

    @Override
    protected void setUpViewAndData() {
        setContentView(R.layout.activity_xml_fragment);


        DemoFragment fragment = (DemoFragment) getSupportFragmentManager().findFragmentById(R.id.demo_fm);
    }
}
