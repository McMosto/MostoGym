package com.example.loginorsignup;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExerciseViewHolder extends RecyclerView.ViewHolder {
    TextView ExerciseName;

    public ExerciseViewHolder(@NonNull View itemView) {
        super(itemView);
        ExerciseName = itemView.findViewById(R.id.ExerciseName);
    }
}
