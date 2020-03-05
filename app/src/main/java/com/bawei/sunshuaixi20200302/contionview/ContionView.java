package com.bawei.sunshuaixi20200302.contionview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.bawei.sunshuaixi20200302.R;

/**
 * TIme:2020/3/4
 * Author:孙帅喜
 * Descriotion:
 */
@SuppressLint("AppCompatCustomView")
public class ContionView extends EditText {


    private String s1;
    Handler handler=new Handler();

    public ContionView(Context context) {
        super(context);
        init(context);
    }

    public ContionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
     addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {

         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {

         }

         @Override
         public void afterTextChanged(Editable s) {
             s1 = s.toString();
             handler.removeCallbacks(runnable);
             handler.postDelayed(runnable,1000);
         }
     });
    }
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            if(monTextChang!=null){
             monTextChang.setontext(s1);
            }
        }
    };


    public OnTextChang monTextChang;
    public void setOnTextChang(OnTextChang onTextChang){
        monTextChang=onTextChang;
    }
    public interface OnTextChang{
        void setontext(String str);
    }

}
