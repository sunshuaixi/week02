package com.bawei.sunshuaixi20200302.contionview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.bawei.sunshuaixi20200302.R;

/**
 * TIme:2020/3/4
 * Author:孙帅喜
 * Descriotion:
 */
public class ContionViewGoup extends LinearLayout  {

    private ContionView cv;
    private ImageButton ib;

    public ContionViewGoup(Context context) {
        super(context);
        init(context);
    }

    public ContionViewGoup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        View view = View.inflate(context, R.layout.contionview, null);
        cv = view.findViewById(R.id.cv);
        ib = view.findViewById(R.id.ib);
        ib.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(monSearchClick!=null){
                    monSearchClick.onSearch(cv.getText().toString());
                }
            }
        });

        cv.setOnTextChang(new ContionView.OnTextChang() {
            @Override
            public void setontext(String str) {
                if(monSearchClick!=null){
                    monSearchClick.onSearch(str);
                }
            }
        });
        addView(view);
    }

    public OnSearchClick monSearchClick;
    public void setOnSearch(OnSearchClick onSearch){
        monSearchClick=onSearch;
    }

    public interface OnSearchClick{
        void onSearch(String str);
    }
}
