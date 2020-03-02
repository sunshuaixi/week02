package com.bawei.sunshuaixi20200302.contract;

/**
 * TIme:2020/3/2
 * Author:孙帅喜
 * Descriotion:
 */
public interface IHomeContract {
    //创建一个V层需要实现的接口
    interface IView{
        //成功
        void onSaccess(String str);
        //失败
        void onFailure(String str);
    }
    //创建一个P层需要实现的接口
    interface IPresenter{
        void onList(String url);
    }
    //创建一个M层需要实现的接口
    interface IModel{
        void onList(String url,Callack callack);
        interface Callack{
            void onSaccess(String str);
            void onFailure(String str);
        }
    }
}
