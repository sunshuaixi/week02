package com.bawei.sunshuaixi20200302.contract;

import com.bawei.sunshuaixi20200302.base.IBaseView;

/**
 * TIme:2020/3/4
 * Author:孙帅喜
 * Descriotion:
 */
public interface ISousuoContract {

    interface IView extends IBaseView {
        void onSaccess(String str);
        void onFaliure(String str);
    }

    interface IPresenter{
        void onSousuo(String url);
    }

    interface IModel{
        void onSousuo(String str,Callack callack);
        interface Callack{
            void onSaccess(String str);
            void onFaliure(String str);
        }
    }
}
