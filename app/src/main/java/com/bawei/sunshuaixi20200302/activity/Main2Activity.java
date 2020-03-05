package com.bawei.sunshuaixi20200302.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bawei.sunshuaixi20200302.R;
import com.bawei.sunshuaixi20200302.base.BaseActivity;
import com.bawei.sunshuaixi20200302.base.BasePersenter;
import com.bawei.sunshuaixi20200302.contionview.ContionView;
import com.bawei.sunshuaixi20200302.contionview.ContionViewGoup;
import com.bawei.sunshuaixi20200302.contract.ISousuoContract;
import com.bawei.sunshuaixi20200302.presenter.SousuoPresenter;

/**
 * 搜索页
 */
public class Main2Activity extends BaseActivity implements ISousuoContract.IView {


    private ContionViewGoup cvg;

    @Override
    public BasePersenter getPresenter() {
        return new SousuoPresenter(this);
    }

    @Override
    protected int getlayoutID() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {
        cvg = findViewById(R.id.cvg);
    }

    @Override
    protected void initData() {



       cvg.setOnSearch(new ContionViewGoup.OnSearchClick() {
           @Override
           public void onSearch(String str) {
               Toast.makeText(Main2Activity.this, ""+str, Toast.LENGTH_SHORT).show();
//http://mobile.bwstudent.com/small/commodity/v1/findCommodityByKeyword?page=1&count=5
               String url="http://mobile.bwstudent.com/small/commodity/v1/findCommodityByKeyword";
               url = url + "?keyword=" + str +"&page=1&count=5";
               BasePersenter presenter = getPresenter();
               if(presenter!=null&&presenter instanceof ISousuoContract.IPresenter){
                   ((ISousuoContract.IPresenter) presenter).onSousuo(url);
               }
           }
       });
    }


    @Override
    public void onSaccess(String str) {
        Log.i("xxx",str);
    }

    @Override
    public void onFaliure(String str) {
       // Log.i("xxx",str);
    }
}
