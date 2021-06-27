package com.example.trainapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trainapp.R;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton About_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutour_main);

        About_back = (ImageButton) findViewById(R.id.train_back);
        About_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        AboutActivity.this.finish();
    }
}
