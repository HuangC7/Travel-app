package com.example.trainapp.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trainapp.Activity.AboutActivity;
import com.example.trainapp.Activity.ContactorActivity;
import com.example.trainapp.R;
import com.example.trainapp.base.BaseFragment;
import com.example.trainapp.login.LoginActivity;
import com.example.trainapp.login.RegisterActivity;


/*
 * 我的页面的Fragment
 * */

public class MyFragment extends BaseFragment implements View.OnClickListener{
    private final String TAG = getClass().getSimpleName();

    private TextView setting;
    private TextView Vipcenter;
    private TextView communitycenter;
    private TextView feedback;
    private TextView contactour;
    private TextView aboutour;
    private TextView Logout;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.my_fragment, null);

        setting = (TextView) view.findViewById(R.id.setting);
        Vipcenter = (TextView) view.findViewById(R.id.Vipcenter);
        communitycenter = (TextView) view.findViewById(R.id.communitycenter);
        feedback = (TextView) view.findViewById(R.id.feedback);
        contactour = (TextView) view.findViewById(R.id.contactour);
        aboutour = (TextView) view.findViewById(R.id.aboutour);
        Logout = (TextView) view.findViewById(R.id.Logout);

        setting.setOnClickListener(this);
        Vipcenter.setOnClickListener(this);
        communitycenter.setOnClickListener(this);
        feedback.setOnClickListener(this);
        contactour.setOnClickListener(this);
        aboutour.setOnClickListener(this);
        Logout.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting:

                Toast.makeText(v.getContext(),"你点击了安全设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Vipcenter:

                Toast.makeText(v.getContext(),"你点击了会员中心", Toast.LENGTH_SHORT).show();
                break;
            case R.id.communitycenter:

                Toast.makeText(v.getContext(),"你点击了社区中心", Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedback:

                Toast.makeText(v.getContext(),"你点击了用户反馈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contactour:
                Intent intentc=new Intent(mContext, ContactorActivity.class);
                mContext.startActivity(intentc);
                break;
            case R.id.aboutour:
                Intent intenta=new Intent(mContext, AboutActivity.class);
                mContext.startActivity(intenta);
                break;
            case R.id.Logout:
                Intent intentl=new Intent(mContext, LoginActivity.class);
                mContext.startActivity(intentl);
                break;
        }

    }
}
