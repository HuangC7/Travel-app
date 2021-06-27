package com.example.trainapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.trainapp.Activity.Text2Activity;
import com.example.trainapp.R;
import com.example.trainapp.entity.Activity;
import com.example.trainapp.login.LoginActivity;
import com.example.trainapp.login.RegisterActivity;

import java.util.ArrayList;
import java.util.List;

public class Text2Adapter extends RecyclerView.Adapter<Text2Adapter.ViewHolder> {

    private List<Activity> mActivityList;
    private Context context;



    static class ViewHolder extends RecyclerView.ViewHolder{
        View activityView;
        ImageView activityImage;
        TextView activityContent, activityTitle;
        public ViewHolder(@NonNull View view) {
            super(view);
            activityView = view;
            activityImage = view.findViewById(R.id.activity_image);
            activityContent = view.findViewById(R.id.activity_content);
            activityTitle = view.findViewById(R.id.activity_title);

        }
    }

    public Text2Adapter(List<Activity> activityList) {
        this.mActivityList = activityList;
    }
    public Text2Adapter(Context context, List<Activity> activityList) {
        this.context = context;
        this.mActivityList = activityList;
    }
    @NonNull
    @Override
    public Text2Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text2_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.activityView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Activity activity = mActivityList.get(position);

                Activity text2_content = new Activity(activity.getName(), activity.getImageId(),activity.getContent(), activity.getTitle(),
                        activity.getTime(), activity.getT_abstract(), activity.getContent_detailed());
                Intent intent = new Intent(context, Text2Activity.class);
                intent.putExtra("text2_content", text2_content);
                context.startActivity(intent);

                Toast.makeText(v.getContext(),"你点击了View"+activity.getName(),Toast.LENGTH_SHORT).show();

            }
        });
        holder.activityImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Activity activity = mActivityList.get(position);

                Activity text2_content = new Activity(activity.getName(), activity.getImageId(),activity.getContent(), activity.getTitle(),
                        activity.getTime(), activity.getT_abstract(), activity.getContent_detailed());

                Intent intent = new Intent(context, Text2Activity.class);

                intent.putExtra("text2_content", text2_content);
                context.startActivity(intent);

                Toast.makeText(v.getContext(),"你点击了Image"+activity.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Text2Adapter.ViewHolder holder, int position) {
        Activity activity = mActivityList.get(position);
        holder.activityImage.setImageResource(activity.getImageId());
        holder.activityContent.setText(activity.getContent());
        holder.activityTitle.setText(activity.getTitle());
    }

    @Override
    public int getItemCount() {
        return mActivityList.size();
    }
}

