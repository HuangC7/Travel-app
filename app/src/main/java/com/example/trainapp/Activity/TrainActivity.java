package com.example.trainapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.trainapp.fragment.HomeFragment;
import com.example.trainapp.fragment.HotFragment;
import com.example.trainapp.fragment.LocalFragment;
import com.example.trainapp.fragment.NewsFragment;
import com.example.trainapp.fragment.LifeFragment;
import com.example.trainapp.fragment.ActivityFragment;
import com.example.trainapp.fragment.MyFragment;
import com.example.trainapp.R;
import com.example.trainapp.fragment.SpecialFragment;


public class TrainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView1,imageView2,imageView3,imageView4,imageView5;



    HomeFragment hf=new HomeFragment();//首页页面
    NewsFragment nf = new NewsFragment();//新问页面
    LifeFragment lf =  new LifeFragment();//生活页面
    ActivityFragment af = new ActivityFragment();//活动页面
    MyFragment mf = new MyFragment();//我页面


//    HotFragment hotf = new HotFragment();//热点页面
//    LocalFragment localf = new LocalFragment();//本地页面
//    SpecialFragment sf = new SpecialFragment();//专题页面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_activity);
        initView();
        replaceFragment(hf);
        imageView1.setImageResource(R.drawable.fm_home1);

    }

    private void initView() {
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);

    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_content,fragment);
        ft.commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView1:
                replaceFragment(hf);
                imageView1.setImageResource(R.drawable.fm_home1);
                imageView2.setImageResource(R.drawable.fm_news);
                imageView3.setImageResource(R.drawable.fm_life);
                imageView4.setImageResource(R.drawable.fm_activity);
                imageView5.setImageResource(R.drawable.fm_my);
                Toast.makeText(TrainActivity.this,"home",Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView2:
                replaceFragment(nf);
                imageView1.setImageResource(R.drawable.fm_home);
                imageView2.setImageResource(R.drawable.fm_news1);
                imageView3.setImageResource(R.drawable.fm_life);
                imageView4.setImageResource(R.drawable.fm_activity);
                imageView5.setImageResource(R.drawable.fm_my);
                Toast.makeText(TrainActivity.this,"news",Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView3:
                replaceFragment(lf);
                imageView1.setImageResource(R.drawable.fm_home);
                imageView2.setImageResource(R.drawable.fm_news);
                imageView3.setImageResource(R.drawable.fm_life1);
                imageView4.setImageResource(R.drawable.fm_activity);
                imageView5.setImageResource(R.drawable.fm_my);
                Toast.makeText(TrainActivity.this,"life",Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView4:
                replaceFragment(af);
                imageView1.setImageResource(R.drawable.fm_home);
                imageView2.setImageResource(R.drawable.fm_news);
                imageView3.setImageResource(R.drawable.fm_life);
                imageView4.setImageResource(R.drawable.fm_activity1);
                imageView5.setImageResource(R.drawable.fm_my);
                Toast.makeText(TrainActivity.this,"activity",Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView5:
                replaceFragment(mf);
                imageView1.setImageResource(R.drawable.fm_home);
                imageView2.setImageResource(R.drawable.fm_news);
                imageView3.setImageResource(R.drawable.fm_life);
                imageView4.setImageResource(R.drawable.fm_activity);
                imageView5.setImageResource(R.drawable.fm_my1);
                Toast.makeText(TrainActivity.this,"my",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}
