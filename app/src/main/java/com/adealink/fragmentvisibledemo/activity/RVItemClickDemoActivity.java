package com.adealink.fragmentvisibledemo.activity;

import android.widget.ListView;

import com.adealink.baselib.framework.BaseActivity;
import com.adealink.fragmentvisibledemo.R;
import com.adealink.fragmentvisibledemo.adapter.RVItemClickDemoAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Xuefu_Du on 2018/6/24.
 */
public class RVItemClickDemoActivity extends BaseActivity {

    @BindView(R.id.listview)
    ListView mListView;

    @Override
    protected void setUpViewAndData() {
        setContentView(R.layout.activity_rv_item_click_demo);

        initView();
    }

    private void initView() {
        RVItemClickDemoAdapter adapter = new RVItemClickDemoAdapter(this);
        mListView.setAdapter(adapter);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("item-" + i);
        }
        adapter.updateList(list);
    }
}
