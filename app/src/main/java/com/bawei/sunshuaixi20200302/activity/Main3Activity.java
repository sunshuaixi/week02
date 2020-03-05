package com.bawei.sunshuaixi20200302.activity;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.bawei.sunshuaixi20200302.R;
import com.bawei.sunshuaixi20200302.base.BaseActivity;
import com.bawei.sunshuaixi20200302.base.BasePersenter;
import com.bumptech.glide.Glide;

public class Main3Activity extends BaseActivity {


    private Button bt;
    private ImageView iv;

    @Override
    public BasePersenter getPresenter() {
        return null;
    }

    @Override
    protected int getlayoutID() {
        //加载布局
        return R.layout.activity_main3;
    }

    @Override
    protected void initView() {
        //找控件
        bt = findViewById(R.id.bt);
        iv = findViewById(R.id.iv);

    }

    @Override
    protected void initData() {
        //加载图片
        Glide.with(this).load(R.mipmap.ic_launcher).into(iv);
        //按钮点击事件
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建平移属性动画
                ObjectAnimator translationY = ObjectAnimator.ofFloat(iv, "translationY", 0, 1435f);
                //设置时间为4秒
                translationY.setDuration(4000);
                translationY.setInterpolator(new AccelerateInterpolator());
                //开始动画
                translationY.start();
            }
        });
    }
}
