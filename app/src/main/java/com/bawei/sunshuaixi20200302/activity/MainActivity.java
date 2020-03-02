package com.bawei.sunshuaixi20200302.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bawei.sunshuaixi20200302.R;
import com.bawei.sunshuaixi20200302.adapter.ListAdapter1;
import com.bawei.sunshuaixi20200302.adapter.ListAdapter2;
import com.bawei.sunshuaixi20200302.adapter.ListAdapter3;
import com.bawei.sunshuaixi20200302.base.BaseActivity;
import com.bawei.sunshuaixi20200302.base.BasePersenter;
import com.bawei.sunshuaixi20200302.bean.ListBean;
import com.bawei.sunshuaixi20200302.contract.IHomeContract;
import com.bawei.sunshuaixi20200302.presenter.HomePresenter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity implements IHomeContract.IView {


    private RecyclerView rl1;
    private RecyclerView rl2;
    private RecyclerView rl3;

    @Override
    public BasePersenter getPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected int getlayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //找控件
        rl1 = findViewById(R.id.rlv1);
        rl2 = findViewById(R.id.rlv2);
        rl3 = findViewById(R.id.rlv3);
    }

    @Override
    protected void initData() {
        String url="http://blog.zhaoliang5156.cn/api/shop/jingdong.json";
        BasePersenter presenter = getPresenter();
        if(presenter!=null&&presenter instanceof IHomeContract.IPresenter){
            ((IHomeContract.IPresenter) presenter).onList(url);
        }
    }


    @Override
    public void onSaccess(String str) {
       //创建gson解析
        Gson gson = new Gson();
        ListBean listBean = gson.fromJson(str, ListBean.class);
        ListBean.DataBean data = listBean.getData();
        //线性横向布局
        List<ListBean.DataBean.HorizontalListDataBean> horizontalListData = data.getHorizontalListData();
        RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rl1.setLayoutManager(layoutManager1);
        //创建适配器
        ListAdapter1 listAdapter1 = new ListAdapter1(this, horizontalListData);
        //设置适配器
        rl1.setAdapter(listAdapter1);

        //线性纵向布局
        final List<ListBean.DataBean.VerticalListDataBean> verticalListData = data.getVerticalListData();
        RecyclerView.LayoutManager layoutManager2=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rl2.setLayoutManager(layoutManager2);
        //创建适配器
        ListAdapter2 listAdapter2 = new ListAdapter2(this, verticalListData);
        //设置适配器
        rl2.setAdapter(listAdapter2);
        //条目点击事件
        listAdapter2.setOnitemClickListener(new ListAdapter2.OnitemClickListener() {
            @Override
            public void Onclick(int i) {
                Toast.makeText(MainActivity.this, verticalListData.get(i).getPrice(), Toast.LENGTH_SHORT).show();
            }
        });

        //网格布局
        List<ListBean.DataBean.GridDataBean> gridData = data.getGridData();
        RecyclerView.LayoutManager layoutManager3=new GridLayoutManager(this,2);
        rl3.setLayoutManager(layoutManager3);
        //创建适配器
        ListAdapter3 listAdapter3 = new ListAdapter3(this, gridData);
        //设置适配器
        rl3.setAdapter(listAdapter3);
    }

    @Override
    public void onFailure(String str) {
        Log.i("xxx",str);
    }
}
