package com.bawei.sunshuaixi20200302.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.sunshuaixi20200302.R;

/**
 * TIme:2020/3/2
 * Author:孙帅喜
 * Descriotion:
 */
public abstract class BaseActivity<P extends BasePersenter> extends AppCompatActivity implements IBaseView {

    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(getlayoutID());
        //找控件
        initView();
        //获取数据
        initData();

        presenter = getPresenter();
    }
    //创建一个返回P层的方法
    public abstract P getPresenter();

    //在销毁的生命周期类调用dtchView方法
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.dtchView();
        }

    }

    protected abstract int getlayoutID();

    protected abstract void initView();

    protected abstract void initData();
}
