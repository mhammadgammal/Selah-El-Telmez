package com.example.adpters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.database.LectureModel;

import java.util.ArrayList;
import java.util.List;

public class LectureAdapter extends RecyclerView.Adapter<LectureAdapter.LectureViewHolder> {
    List<LectureModel> lecture = new ArrayList<>();
    OnLectureClickListener onLectureClickListener;

    public LectureAdapter(OnLectureClickListener onLectureClickListener) {
        this.onLectureClickListener = onLectureClickListener;
    }

    @NonNull
    @Override
    public LectureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lecture_item, parent, false);
        return new LectureViewHolder(view, onLectureClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LectureViewHolder holder, int position) {
        holder.lectureNameTV.setText(lecture.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return lecture.size();
    }

    public void setLectures(List<LectureModel> lecture) {
        this.lecture = lecture;
    }

    class LectureViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView lectureNameTV;
        OnLectureClickListener onLectureClickListener;
        CardView lecCardView;
        public LectureViewHolder(@NonNull View itemView, OnLectureClickListener onLectureClickListener) {
            super(itemView);
            lectureNameTV = itemView.findViewById(R.id.lectureNameTV);
            lecCardView = itemView.findViewById(R.id.lecCardView);
            this.onLectureClickListener = onLectureClickListener;
            lecCardView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            onLectureClickListener.onLectureClickListener(getAdapterPosition());
        }
    }

public interface OnLectureClickListener{
    void onLectureClickListener(int pos);
}
}

