package com.adealink.fragmentvisibledemo.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.adealink.baselib.customview.BlankClickRV;
import com.adealink.baselib.framework.BaseLVAdapter;
import com.adealink.baselib.itemdecoration.GridSpaceItemDecoration;
import com.adealink.baselib.utils.LogUtil;
import com.adealink.fragmentvisibledemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Xuefu_Du on 2018/6/24.
 */
public class RVItemClickDemoAdapter extends BaseLVAdapter<String> {

    private final String URL = "http://img.suv666.com//news/cardTheme/f41964d59fe4f83a40c07edba99b2877.jpg";

    private FragmentActivity mActivity;
    private List<String> mPicList = new ArrayList<>();

    public RVItemClickDemoAdapter(FragmentActivity activity) {
        this.mActivity = activity;
        for (int i = 0; i < 2; i++) {
            mPicList.add(URL);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mActivity).inflate(R.layout.adapter_rv_item_click_demo, null);
            holder = new ViewHolder(convertView, mActivity);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mPicAdapter.updateList(mPicList);
        final String itemStr = getItem(position);
        holder.nameTv.setText(itemStr);
        //列表项点击
        View.OnClickListener itemClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.d("d_slience", "mPicAdapter item click:" + itemStr);
                Toast.makeText(mActivity, itemStr, Toast.LENGTH_LONG).show();
            }
        };
//        holder.parentLayout.setOnClickListener(itemClickListener);
//        holder.mPicAdapter.setOnItemClickListener(itemClickListener);
//        holder.picRv.setBlankAreaClickListener(itemClickListener);

        //RV项的点击监听
        holder.picRv.setOnItemClickListener(new BlankClickRV.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                LogUtil.d("d_slience", "mPicAdapter onItemClick:" + position);
                Toast.makeText(mActivity, "onItemClick:" + position, Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.name_tv)
        TextView nameTv;
        @BindView(R.id.pic_rv)
        BlankClickRV picRv;
        @BindView(R.id.parent_layout)
        LinearLayout parentLayout;

        //图片Adapter
        PicsSquareRVAdapter mPicAdapter;
        private FragmentActivity mActivity;

        ViewHolder(View view, @NonNull FragmentActivity activity) {
            ButterKnife.bind(this, view);
            this.mActivity = activity;
            initPicRV();
        }

        private void initPicRV() {
            int gapH = mActivity.getResources().getDimensionPixelSize(R.dimen.dimen_5dp);
            final int spanCount = 4;//Grid列数
            picRv.addItemDecoration(new GridSpaceItemDecoration(spanCount, gapH));
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(mActivity, spanCount);
            picRv.setLayoutManager(layoutManager);
            mPicAdapter = new PicsSquareRVAdapter(mActivity);
            picRv.setAdapter(mPicAdapter);
        }
    }
}
