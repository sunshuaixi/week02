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
public class ListAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<ListBean.DataBean.VerticalListDataBean> verticalListData;

    public ListAdapter2(Context context, List<ListBean.DataBean.VerticalListDataBean> verticalListData) {
        this.context = context;
        this.verticalListData = verticalListData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item2, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        //赋值
        Glide.with(context).load(verticalListData.get(position).getImageurl()).error(R.mipmap.ic_launcher).priority(Priority.HIGH).into(((ViewHolder)holder).iv);
        ((ViewHolder)holder).tv1.setText(verticalListData.get(position).getTitle());
        ((ViewHolder)holder).tv2.setText(verticalListData.get(position).getPrice());
        ((ViewHolder)holder).ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(monitemClickListener!=null){
                    monitemClickListener.Onclick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return verticalListData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv;
        private final TextView tv2;
        private final TextView tv1;
        private final LinearLayout ll;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            ll = itemView.findViewById(R.id.ll);
        }
    }

    //接口回调
    public  OnitemClickListener monitemClickListener;

    public  void setOnitemClickListener(OnitemClickListener onitemClickListener){
        monitemClickListener=onitemClickListener;
    }

    public interface OnitemClickListener{
        void Onclick(int i);
    }
}
