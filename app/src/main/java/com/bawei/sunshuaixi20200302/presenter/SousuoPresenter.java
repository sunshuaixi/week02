package com.bawei.sunshuaixi20200302.presenter;

import com.bawei.sunshuaixi20200302.base.BasePersenter;
import com.bawei.sunshuaixi20200302.base.IBaseView;
import com.bawei.sunshuaixi20200302.contract.ISousuoContract;
import com.bawei.sunshuaixi20200302.model.SousuoModel;

/**
 * TIme:2020/3/4
 * Author:孙帅喜
 * Descriotion:
 */
public class SousuoPresenter extends BasePersenter implements ISousuoContract.IPresenter {

    private SousuoModel sousuoModel;

    public SousuoPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    public void initModel() {
        sousuoModel = new SousuoModel();
    }

    @Override
    public void onSousuo(String url) {
        sousuoModel.onSousuo(url, new ISousuoContract.IModel.Callack() {
            @Override
            public void onSaccess(String str) {
                IBaseView view = getView();
                if(view instanceof ISousuoContract.IView){
                    ((ISousuoContract.IView) view).onSaccess(str);
                }
            }

            @Override
            public void onFaliure(String str) {
                IBaseView view = getView();
                if(view instanceof ISousuoContract.IView){
                    ((ISousuoContract.IView) view).onFaliure(str);
                }
            }
        });
    }
}
