package com.example.trainapp.fragment;

import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.trainapp.R;
import com.example.trainapp.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;


/*
 * 新闻页面的Fragment
 * */

public class NewsFragment extends BaseFragment implements View.OnClickListener{

    ImageView imageView1,imageView2,imageView3;

    private ViewPager mViewPager;
    private List<Fragment> fragmentList;
    private VpAdapter mAdapter;

    HotFragment hotf = new HotFragment();//热点页面
    LocalFragment localf = new LocalFragment();//本地页面
    SpecialFragment sf = new SpecialFragment();//专题页面


    @Override
    public View initView() {

        View view = View.inflate(mContext, R.layout.content_news, null);
        mViewPager = view.findViewById(R.id.news_fragment_content);
        imageView1 = view.findViewById(R.id.top_imageView1);
        imageView2 = view.findViewById(R.id.top_imageView2);
        imageView3 = (ImageView) view.findViewById(R.id.top_imageView3);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);


        fragmentList = new ArrayList<>();
        fragmentList.add(hotf);
        fragmentList.add(localf);
        fragmentList.add(sf);

        mAdapter = new VpAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);

        mViewPager.setCurrentItem(0);
        imageView1.setImageResource(R.drawable.fm_hot1);


        return view;
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_imageView1:
                mViewPager.setCurrentItem(0);
                imageView1.setImageResource(R.drawable.fm_hot1);
                imageView2.setImageResource(R.drawable.fm_local);
                imageView3.setImageResource(R.drawable.fm_special);
                break;
            case R.id.top_imageView2:
                mViewPager.setCurrentItem(1);
                imageView1.setImageResource(R.drawable.fm_hot);
                imageView2.setImageResource(R.drawable.fm_local1);
                imageView3.setImageResource(R.drawable.fm_special);

                break;
            case R.id.top_imageView3:
                mViewPager.setCurrentItem(2);
                imageView1.setImageResource(R.drawable.fm_hot);
                imageView2.setImageResource(R.drawable.fm_local);
                imageView3.setImageResource(R.drawable.fm_special1);
                break;
            default:
                break;
        }
    }



    class VpAdapter extends FragmentPagerAdapter {

        VpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return fragmentList.get(position);
        }

        @Override
        public int getCount() {

            return fragmentList.size();
        }
    }


}
