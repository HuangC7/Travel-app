package com.example.trainapp.fun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import com.example.trainapp.R;


public class FunActivity extends Activity implements View.OnClickListener {
    fun_TestView tView = null;

    private ImageButton fun_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fun_main);
        tView = (fun_TestView)findViewById(R.id.testview);
        tView.setOnTouchListener(new mOnTouch());

        fun_back = (ImageButton) findViewById(R.id.train_back);
        fun_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        FunActivity.this.finish();
    }

    class mOnTouch implements View.OnTouchListener

    {
        @Override
        public boolean onTouch(View v,MotionEvent event){
            int x1,y1;
            x1 = (int) event.getX();
            y1 = (int) event.getY();
            if (event.getAction() ==MotionEvent.ACTION_DOWN)
            {
                tView.getXY(x1,y1);
                tView.invalidate();
                return true;
            }
            else if(event.getAction()==MotionEvent.ACTION_MOVE)
            {
                tView.getXY(x1,y1);
                tView.invalidate();
                return true;
            }
            return tView.onTouchEvent(event);
        }
    }
}
