package com.bawei.sunshuaixi20200302.model;

import com.bawei.sunshuaixi20200302.contract.ISousuoContract;
import com.bawei.sunshuaixi20200302.utils.VolleyUtils;

/**
 * TIme:2020/3/4
 * Author:孙帅喜
 * Descriotion:
 */
public class SousuoModel implements ISousuoContract.IModel{
    @Override
    public void onSousuo(String str, final Callack callack) {
        VolleyUtils.getInstance().doGet(str, new VolleyUtils.Callack() {
            @Override
            public void saccess(String str) {
                callack.onSaccess(str);
            }

            @Override
            public void faliure(String str) {
                callack.onFaliure(str);
            }
        });
    }
}
