package com.example.trainapp.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.trainapp.Activity.Life_buttonActivity;
import com.example.trainapp.R;
import com.example.trainapp.base.BaseFragment;


/*
 * 生活页面的Fragment
 * */

public class LifeFragment extends BaseFragment implements View.OnClickListener{
    private final String TAG = getClass().getSimpleName();

    private Button ABtn1;
    private Button ABtn2;
    private Button ABtn3;
    private Button ABtn4;
    private Button ABtn5;
    private Button ABtn6;
    private Button LBtn1;
    private Button LBtn2;
    private Button LBtn3;
    private Button LBtn4;
    private Button LBtn5;
    private Button LBtn6;
    private Button HBtn1;
    private Button HBtn2;
    private Button HBtn3;
    private Button HBtn4;
    private Button HBtn5;
    private Button HBtn6;



    @Override
    public View initView() {

        View view = View.inflate(mContext, R.layout.life_fragment, null);


        ABtn1 = (Button) view.findViewById(R.id.A_btn1);
        ABtn2 = (Button) view.findViewById(R.id.A_btn2);
        ABtn3 = (Button) view.findViewById(R.id.A_btn3);
        ABtn4 = (Button) view.findViewById(R.id.A_btn4);
        ABtn5 = (Button) view.findViewById(R.id.A_btn5);
        ABtn6 = (Button) view.findViewById(R.id.A_btn6);
        LBtn1 = (Button) view.findViewById(R.id.L_btn1);
        LBtn2 = (Button) view.findViewById(R.id.L_btn2);
        LBtn3 = (Button) view.findViewById(R.id.L_btn3);
        LBtn4 = (Button) view.findViewById(R.id.L_btn4);
        LBtn5 = (Button) view.findViewById(R.id.L_btn5);
        LBtn6 = (Button) view.findViewById(R.id.L_btn6);
        HBtn1 = (Button) view.findViewById(R.id.H_btn1);
        HBtn2 = (Button) view.findViewById(R.id.H_btn2);
        HBtn3 = (Button) view.findViewById(R.id.H_btn3);
        HBtn4 = (Button) view.findViewById(R.id.H_btn4);
        HBtn5 = (Button) view.findViewById(R.id.H_btn5);
        HBtn6 = (Button) view.findViewById(R.id.H_btn6);

        ABtn1.setOnClickListener(this);
        ABtn2.setOnClickListener(this);
        ABtn3.setOnClickListener(this);
        ABtn4.setOnClickListener(this);
        ABtn5.setOnClickListener(this);
        ABtn6.setOnClickListener(this);
        LBtn1.setOnClickListener(this);
        LBtn2.setOnClickListener(this);
        LBtn3.setOnClickListener(this);
        LBtn4.setOnClickListener(this);
        LBtn5.setOnClickListener(this);
        LBtn6.setOnClickListener(this);
        HBtn1.setOnClickListener(this);
        HBtn2.setOnClickListener(this);
        HBtn3.setOnClickListener(this);
        HBtn4.setOnClickListener(this);
        HBtn5.setOnClickListener(this);
        HBtn6.setOnClickListener(this);

        return view;
    }



    @Override
    public void onClick(View v) {

        Button b = (Button)v;
        Intent intent = new Intent(mContext, Life_buttonActivity.class);
        intent.putExtra("title", b.getText().toString());
        mContext.startActivity(intent);
    }
}
