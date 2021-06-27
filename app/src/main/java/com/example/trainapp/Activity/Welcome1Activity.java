package com.example.trainapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trainapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class Welcome1Activity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout welcome1;
    private Timer timer;          //计时器
    private TextView textView;    //显示倒数秒数的文本框控件
    private int i = 5;                     //设置倒数的最大秒数
    public static Welcome1Activity instance = null; //定义静态的闪屏界面用于打开主界面后关闭该界面


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome1);
        welcome1 = (LinearLayout) findViewById(R.id.welcome1);
        welcome1.setOnClickListener(this);

        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        instance = this;              //赋值本界面
        textView = (TextView) findViewById(R.id.text1);     //获取显示倒数秒数的文本框控件
        timer = new Timer();                                 //初始化计时器
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();                //初始化message
                message.what = 1;
                if (i >= 0) {
                    handler.sendMessage(message);               //发送消息给handler
                }
                if (i == 0) {
                    cancel();                                   //清除计时器
                }
            }
        }, 0, 1000);  //每个1秒执行一次该方法

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Welcome1Activity.this, Welcome2Activity.class);
        startActivity(intent);
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1) {                              //消息为1
                i--;        //秒数倒数-1
                textView.setText(""+i);     //将秒数显示在右上角文本框中
                if (i == 0) {                                     //秒数为零时跳转
                    Intent intent = new Intent(Welcome1Activity.this, Welcome2Activity.class);
                    startActivity(intent);                      //启动跳转
                }

            }
            return false;
        }
    });
}
