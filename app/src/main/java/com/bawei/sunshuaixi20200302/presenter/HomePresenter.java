package com.bawei.sunshuaixi20200302.presenter;

import com.bawei.sunshuaixi20200302.base.BasePersenter;
import com.bawei.sunshuaixi20200302.base.IBaseView;
import com.bawei.sunshuaixi20200302.contract.IHomeContract;
import com.bawei.sunshuaixi20200302.model.HomeModel;

/**
 * TIme:2020/3/2
 * Author:孙帅喜
 * Descriotion:
 */
public class HomePresenter extends BasePersenter implements IHomeContract.IPresenter {

    private HomeModel homeModel;

    public HomePresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    public void onList(String url) {
       homeModel.onList(url, new IHomeContract.IModel.Callack() {
           @Override
           public void onSaccess(String str) {
               IBaseView view = getView();
               if(view instanceof IHomeContract.IView){
                   ((IHomeContract.IView) view).onSaccess(str);
               }
           }

           @Override
           public void onFailure(String str) {
               IBaseView view = getView();
               if(view instanceof IHomeContract.IView){
                   ((IHomeContract.IView) view).onFailure(str);
               }
           }
       });
    }

    @Override
    public void initModel() {
        homeModel = new HomeModel();
    }
}
