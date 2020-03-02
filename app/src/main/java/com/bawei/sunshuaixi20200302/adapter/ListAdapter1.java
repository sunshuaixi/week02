package com.bawei.sunshuaixi20200302.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.sunshuaixi20200302.R;
import com.bawei.sunshuaixi20200302.activity.MainActivity;
import com.bawei.sunshuaixi20200302.bean.ListBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

import java.util.List;

/**
 * TIme:2020/3/2
 * Author:孙帅喜
 * Descriotion:
 */
public class ListAdapter1 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<ListBean.DataBean.HorizontalListDataBean> horizontalListData;

    public ListAdapter1(Context context, List<ListBean.DataBean.HorizontalListDataBean> horizontalListData) {
        this.context = context;
        this.horizontalListData = horizontalListData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item1, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //加载图片
        Glide.with(context).load(horizontalListData.get(position).getImageurl()).error(R.mipmap.ic_launcher).priority(Priority.HIGH).into(((ViewHolder)holder).iv);

    }

    @Override
    public int getItemCount() {
        return horizontalListData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv;


        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
