package com.adealink.fragmentvisibledemo.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.adealink.baselib.framework.RecyclerBaseAdapter;
import com.adealink.baselib.utils.image.GlideUtil;
import com.adealink.fragmentvisibledemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 方形图片列表
 * Created by Xuefu_Du on 2018/6/19.
 */
public class PicsSquareRVAdapter extends RecyclerBaseAdapter<String, PicsSquareRVAdapter.ViewHolder> {

    private FragmentActivity mActivity;
    private View.OnClickListener mOnItemClickListener;

    public PicsSquareRVAdapter(FragmentActivity activity) {
        this.mActivity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pic_square_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GlideUtil.getInstance().loadBitmapCenterCrop(mActivity, getItem(position), holder.perImg);
        if (mOnItemClickListener != null) {
            holder.perImg.setOnClickListener(mOnItemClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.per_img)
        ImageView perImg;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
