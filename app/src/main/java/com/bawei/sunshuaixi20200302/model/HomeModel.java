package com.bawei.sunshuaixi20200302.model;

import com.bawei.sunshuaixi20200302.contract.IHomeContract;
import com.bawei.sunshuaixi20200302.utils.VolleyUtils;

/**
 * TIme:2020/3/2
 * Author:孙帅喜
 * Descriotion:
 */
public class HomeModel implements IHomeContract.IModel {

    @Override
    public void onList(String url, final Callack callack) {
        VolleyUtils.getInstance().doGet(url, new VolleyUtils.Callack() {
            @Override
            public void saccess(String str) {
                callack.onSaccess(str);
            }

            @Override
            public void faliure(String str) {
                callack.onFailure(str);
            }
        });
    }
}
