package com.bawei.sunshuaixi20200302.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
public class ListAdapter3 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<ListBean.DataBean.GridDataBean> gridData;

    public ListAdapter3(Context context, List<ListBean.DataBean.GridDataBean> gridData) {
        this.context = context;
        this.gridData = gridData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item3, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Glide.with(context).load(gridData.get(position).getImageurl()).error(R.mipmap.ic_launcher).priority(Priority.LOW).into(((ListAdapter3.ViewHolder)holder).iv);
        ((ListAdapter3.ViewHolder)holder).tv1.setText(gridData.get(position).getTitle());
        ((ListAdapter3.ViewHolder)holder).tv2.setText(gridData.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return gridData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv;
        private final TextView tv2;
        private final TextView tv1;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);

        }
    }


}
