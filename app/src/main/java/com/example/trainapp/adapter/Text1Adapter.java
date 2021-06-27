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
import androidx.recyclerview.widget.RecyclerView;


import com.example.trainapp.Activity.Activity_detailedActivity;
import com.example.trainapp.Activity.Text2Activity;
import com.example.trainapp.R;
import com.example.trainapp.entity.Activity;
import java.util.List;

public class Text1Adapter extends RecyclerView.Adapter<Text1Adapter.ViewHolder> {

    private List<Activity> mActivityList;
    private Context context;


    static class ViewHolder extends RecyclerView.ViewHolder{
        View activityView;
        ImageView activityImage;
        TextView activityTitle;
        public ViewHolder(@NonNull View view) {
            super(view);
            activityView = view;
            activityImage = view.findViewById(R.id.activity_image);
            activityTitle = view.findViewById(R.id.activity_title);

        }
    }

    public Text1Adapter(List<Activity> activityList) {
        mActivityList = activityList;
    }

    public Text1Adapter(Context context, List<Activity> activityList) {
        this.context = context;
        this.mActivityList = activityList;
    }

    @NonNull
    @Override
    public Text1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text1_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.activityView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Activity activity = mActivityList.get(position);

                /* String name, int imageId, int image_detailedID1, int image_detailedID2, int image_detailedID3, String content, String title,
                 String time, String place, String content_detailed */
                Activity Activity_detailed = new Activity(activity.getName(), activity.getImageId(),activity.getImage_detailedID1(),
                        activity.getImage_detailedID2(), activity.getImage_detailedID3(),activity.getContent(), activity.getTitle(),
                        activity.getTime(), activity.getPlace(), activity.getContent_detailed());
                Intent intent = new Intent(context, Activity_detailedActivity.class);
                intent.putExtra("Activity_detailed", Activity_detailed);
                context.startActivity(intent);


                Toast.makeText(v.getContext(),"你点击了View"+activity.getName(),Toast.LENGTH_SHORT).show();

            }
        });
        holder.activityImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Activity activity = mActivityList.get(position);


                /* String name, int imageId, int image_detailedID1, int image_detailedID2, int image_detailedID3, String content, String title,
                 String time, String place, String content_detailed */
                Activity Activity_detailed = new Activity(activity.getName(), activity.getImageId(),activity.getImage_detailedID1(),
                        activity.getImage_detailedID2(), activity.getImage_detailedID3(),activity.getContent(), activity.getTitle(),
                        activity.getTime(), activity.getPlace(), activity.getContent_detailed());
                Intent intent = new Intent(context, Activity_detailedActivity.class);
                intent.putExtra("Activity_detailed", Activity_detailed);
                context.startActivity(intent);

                Toast.makeText(v.getContext(),"你点击了Image"+activity.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Text1Adapter.ViewHolder holder, int position) {
        Activity activity = mActivityList.get(position);
        holder.activityImage.setImageResource(activity.getImageId());
        holder.activityTitle.setText(activity.getTitle());
    }

    @Override
    public int getItemCount() {
        return mActivityList.size();
    }
}
