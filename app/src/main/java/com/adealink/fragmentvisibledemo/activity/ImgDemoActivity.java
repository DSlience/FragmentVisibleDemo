package com.adealink.fragmentvisibledemo.activity;

import android.widget.ImageView;
import android.widget.LinearLayout;

import com.adealink.baselib.framework.BaseActivity;
import com.adealink.baselib.utils.ScreenUtil;
import com.adealink.baselib.utils.image.GlideUtil;
import com.adealink.fragmentvisibledemo.R;

import butterknife.BindView;

/**
 * Created by Xuefu_Du on 2018/6/24.
 */
public class ImgDemoActivity extends BaseActivity {

    private final String URL_ONE = "http://img.suv666.com//news/cardTheme/f41964d59fe4f83a40c07edba99b2877.jpg";
    private final String URL_TWO = "http://img.suv666.com//news/cardTheme/e4bdd306048bc928654ce44eb2340b4b.jpg";

    @BindView(R.id.one_img)
    ImageView mOneImg;
    @BindView(R.id.two_img)
    ImageView mTwoImg;

    @Override
    protected void setUpViewAndData() {
        setContentView(R.layout.activity_img_demo);

        initView();
    }

    private void initView() {
        int idealWidth = (int) (ScreenUtil.getScreenW(this) / 2f);
        updateImgView(mOneImg, idealWidth, URL_ONE);
        updateImgView(mTwoImg, idealWidth, URL_TWO);
    }

    private void updateImgView(ImageView img, int idealWidth, String url) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) img.getLayoutParams();
        params.width = idealWidth;
        int height = (int) (1f * idealWidth * 152f / 375f);
        params.height = height;
        img.setLayoutParams(params);
        img.setMaxWidth(idealWidth);
        img.setMaxHeight(height);

        GlideUtil.getInstance().loadBitmap(this, url, img);
    }

}
