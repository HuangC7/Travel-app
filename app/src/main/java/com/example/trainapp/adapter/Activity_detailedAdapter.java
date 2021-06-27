package com.example.trainapp.adapter;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.trainapp.R;
import com.example.trainapp.entity.Activity;
import java.util.List;

public class  Activity_detailedAdapter extends RecyclerView.Adapter<Activity_detailedAdapter.ViewHolder> {

    private List<Activity> mActivityList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View text2_contentView;
        TextView Activity_detailedContent, Activity_detailedplace, Activity_detailedTime;
        ImageView Activity_detailedImage, Activity_detailedImage1, Activity_detailedImage2, Activity_detailedImage3;

        public ViewHolder(@NonNull View view) {
            super(view);
            text2_contentView = view;
            Activity_detailedContent = view.findViewById(R.id.activity_detailed_content);
            Activity_detailedplace = view.findViewById(R.id.activity_detailed_place);
            Activity_detailedTime = view.findViewById(R.id.activity_detailed_time);
            Activity_detailedImage = view.findViewById(R.id.activity_detailed_image);
            Activity_detailedImage1 = view.findViewById(R.id.activity_detailed_image1);
            Activity_detailedImage2 = view.findViewById(R.id.activity_detailed_image2);
            Activity_detailedImage3 = view.findViewById(R.id.activity_detailed_image3);

        }
    }

    public  Activity_detailedAdapter(List<Activity> activityList) {
        mActivityList = activityList;
    }

    @NonNull
    @Override
    public Activity_detailedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_detailed_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Activity_detailedAdapter.ViewHolder holder, int position) {
        Activity activity = mActivityList.get(position);
        holder.Activity_detailedContent.setText(activity.getContent_detailed());
        holder.Activity_detailedplace.setText(activity.getPlace());
        holder.Activity_detailedTime.setText(activity.getTime());
        holder.Activity_detailedImage.setImageResource(activity.getImageId());
        holder.Activity_detailedImage1.setImageResource(activity.getImage_detailedID1());
        holder.Activity_detailedImage2.setImageResource(activity.getImage_detailedID2());
        holder.Activity_detailedImage3.setImageResource(activity.getImage_detailedID3());
    }

    @Override
    public int getItemCount() {
        return mActivityList.size();
    }
}

