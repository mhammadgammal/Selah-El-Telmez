package com.example.selahel_telmez.adpters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.database.LectureModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder> {
    List<LectureModel> lecture = new ArrayList<>();
    OnDeleteIcClickListener onDeleteIcClickListener;

    public DashboardAdapter(OnDeleteIcClickListener onDeleteIcClickListener) {
        this.onDeleteIcClickListener = onDeleteIcClickListener;
    }

    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_item, parent, false);
        return new DashboardViewHolder(view, onDeleteIcClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {

        holder.lectureNameTV.setText(lecture.get(position).getName());

        holder.lectureLinkTV.setText(lecture.get(position).getLink());
    }

    @Override
    public int getItemCount() {
        return lecture.size();
    }

    public void setLecture(List<LectureModel> lecture) {
        this.lecture = lecture;
    }

    static class DashboardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView lectureNameTV;
        TextView lectureLinkTV;
        ImageView deleteIc;
        OnDeleteIcClickListener onDeleteIcClickListener;
        public DashboardViewHolder(@NonNull View itemView, OnDeleteIcClickListener onDeleteIcClickListener) {
            super(itemView);
            lectureLinkTV = itemView.findViewById(R.id.lectLinkTV);
            this.onDeleteIcClickListener = onDeleteIcClickListener;
            lectureNameTV = itemView.findViewById(R.id.lecNameTV);
            deleteIc = itemView.findViewById(R.id.deleteLectureIC);
            deleteIc.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onDeleteIcClickListener.onDeleteIcClickListener(getAdapterPosition());
        }
    }
    public interface OnDeleteIcClickListener{
        void onDeleteIcClickListener(int position);
    }
}
