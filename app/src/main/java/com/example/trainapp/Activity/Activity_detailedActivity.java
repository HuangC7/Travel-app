package com.example.trainapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainapp.R;
import com.example.trainapp.adapter.Activity_detailedAdapter;
import com.example.trainapp.adapter.Text2_contentAdapter;
import com.example.trainapp.entity.Activity;

import java.util.ArrayList;
import java.util.List;

public class Activity_detailedActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton activity_detailed_back;
    private RecyclerView fl_activity_detailed;
    private List<Activity> activityList = new ArrayList<>();
    private Activity activity_detailed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);


        fl_activity_detailed = (RecyclerView)findViewById(R.id.fl_activity_detailed);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        fl_activity_detailed.setLayoutManager(layoutManager);
        activity_detailed = (Activity) getIntent().getSerializableExtra("Activity_detailed");
        activityList.add(activity_detailed);

        Activity_detailedAdapter  activity_detailedAdapter = new  Activity_detailedAdapter(activityList);
        fl_activity_detailed.setAdapter(activity_detailedAdapter);



        activity_detailed_back = (ImageButton) findViewById(R.id.activity_detailed_back);
        activity_detailed_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        Activity_detailedActivity.this.finish();
    }
}
