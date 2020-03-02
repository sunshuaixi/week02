package com.bawei.sunshuaixi20200302.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.sunshuaixi20200302.base.App;

import java.util.HashMap;
import java.util.Map;

/**
 * TIme:2020/3/2
 * Author:孙帅喜
 * Descriotion:
 */
public class VolleyUtils {
    //创建队列
    private final RequestQueue requestQueue;
    //创建私有的构造方法

    private VolleyUtils() {
        requestQueue = Volley.newRequestQueue(App.getAppContext());
    }
    //创建静态内部类
    private static class Sing{
       static VolleyUtils INTEXT= new VolleyUtils();
    }
    //创建静态方法返回实例
    public static VolleyUtils getInstance(){
        return Sing.INTEXT;
    }
    //创建GET请求方法
    public void doGet(String url, final Callack callack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callack.saccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callack.faliure(error.getMessage());
            }
        });
        //添加到队列
        requestQueue.add(stringRequest);
    }

    //创建post请求方法
    public void doPost(String url, final HashMap<String,String> map, final Callack callack){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callack.saccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callack.faliure(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        //添加到队列
        requestQueue.add(stringRequest);
    }

    //判断网络
    public boolean isWock(Context context){
       ConnectivityManager conn= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = conn.getActiveNetworkInfo();
        if(activeNetworkInfo!=null){
            return true;
        }
        return false;
    }



        //创建接口
    public interface Callack{
        void saccess(String str);
        void faliure(String str);
    }
}
