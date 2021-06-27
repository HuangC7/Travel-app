package com.example.trainapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainapp.R;
import com.example.trainapp.adapter.Text2_contentAdapter;
import com.example.trainapp.entity.Activity;
import com.example.trainapp.login.RegisterActivity;

import java.util.ArrayList;
import java.util.List;

public class Text2Activity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView flText2_content;
    private List<Activity> activityList = new ArrayList<>();
    private Activity text2_content;
    private ImageButton text2Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text2_content);

        flText2_content = (RecyclerView)findViewById(R.id.fl_text2_content);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        flText2_content.setLayoutManager(layoutManager);
        text2_content = (Activity) getIntent().getSerializableExtra("text2_content");
        activityList.add(text2_content);
        Text2_contentAdapter text2_contentAdapter = new Text2_contentAdapter(activityList);
        flText2_content.setAdapter(text2_contentAdapter);

        text2Back = (ImageButton) findViewById(R.id.text2_back);
        text2Back.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        Text2Activity.this.finish();
    }
}
