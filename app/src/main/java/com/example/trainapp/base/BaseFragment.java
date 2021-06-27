package com.example.trainapp.base;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

/*
* 作用:基本类
* 首页：HomeFragment
* 分类：TypeFragment
* 发现： CommunityFragment
* 购物车：ShoppingCartFragment
* 用户中心：UserFragment
* 都要继承该类
* */

public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    /*
    * 当该类被系统创建时，会被回调
    * */
    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable
                                     Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater,
                             @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return initView();
    }
    /*
    * 抽象类，由孩子实现
    * */
    public abstract View initView();


    /*
    * 当Activity被创建的时候回调这个方法
    * */
    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /*
    *当子类需要联网请求数据的时候，可以重写该方法，在该方法中联网请求
    * */
    public  void initData() {}
}
