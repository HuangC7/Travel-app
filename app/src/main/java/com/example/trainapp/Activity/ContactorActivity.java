package com.example.trainapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trainapp.R;
import com.example.trainapp.finalassignment.WeatherActivity;

public class ContactorActivity extends AppCompatActivity implements View.OnClickListener{


    private ImageButton Contactor_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactour_main);

        Contactor_back = (ImageButton) findViewById(R.id.train_back);
        Contactor_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        ContactorActivity.this.finish();
    }
}
