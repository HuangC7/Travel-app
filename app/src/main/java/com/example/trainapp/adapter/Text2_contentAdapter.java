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

public class Text2_contentAdapter extends RecyclerView.Adapter<Text2_contentAdapter.ViewHolder> {

    private List<Activity> mActivityList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View text2_contentView;
        TextView text2_contentContent, text2_contentTitle, text2_contentTime, text2_contentAbstract;
        public ViewHolder(@NonNull View view) {
            super(view);
            text2_contentView = view;
            text2_contentContent = view.findViewById(R.id.text2_content);
            text2_contentTitle = view.findViewById(R.id.text2_title);
            text2_contentAbstract = view.findViewById(R.id.text2_abstract);
            text2_contentTime = view.findViewById(R.id.text2_time);

        }
    }

    public Text2_contentAdapter(List<Activity> activityList) {
        mActivityList = activityList;
    }

    @NonNull
    @Override
    public Text2_contentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text2_content_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Text2_contentAdapter.ViewHolder holder, int position) {
        Activity activity = mActivityList.get(position);
        holder.text2_contentContent.setText(activity.getContent_detailed());
        holder.text2_contentTitle.setText(activity.getTitle());
        holder.text2_contentTime.setText(activity.getTime());
        holder.text2_contentAbstract.setText(activity.getT_abstract());
    }

    @Override
    public int getItemCount() {
        return mActivityList.size();
    }
}
