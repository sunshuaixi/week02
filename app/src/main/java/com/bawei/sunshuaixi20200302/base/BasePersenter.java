package com.bawei.sunshuaixi20200302.base;

import java.lang.ref.WeakReference;

/**
 * TIme:2020/3/2
 * Author:孙帅喜
 * Descriotion:
 */
public abstract class BasePersenter<V extends IBaseView> {
    //使用弱引用包裹泛型
    private WeakReference<V> vWeakReference;
    //添加构造方法
    public BasePersenter(V v) {
        vWeakReference = new WeakReference<>(v);
        initModel();
    }
    //创建一个返回M层的方法
    public abstract void initModel();
    //创建一个返回V层的方法
    public V getView(){
        if(vWeakReference !=null){
            return vWeakReference.get();
        }
        return null;
    }

    //创建一个销毁的方法
    public void dtchView(){
        if(vWeakReference!=null){
            //清空
            vWeakReference.clear();
            //置空
            vWeakReference=null;
        }
    }
}
