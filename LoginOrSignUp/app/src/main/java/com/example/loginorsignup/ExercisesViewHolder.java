package com.example.loginorsignup;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExercisesViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView ExerciseName,BodyPartName,EquiqmentName,LevelName,TypeName;
    public ExercisesViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        ExerciseName = itemView.findViewById(R.id.ExerciseName);
        BodyPartName = itemView.findViewById(R.id.BodyPartName);
        EquiqmentName = itemView.findViewById(R.id.EquiqmentName);
        LevelName = itemView.findViewById(R.id.LevelName);
        TypeName = itemView.findViewById(R.id.TypeName);

    }
}
