package com.example.loginorsignup;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExerciseListViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView ExerciseName,BodyPartName,EquiqmentName,LevelName,TypeName;
    public ExerciseListViewHolder(@NonNull View itemView, ExerciseListInterface exerciseListInterface) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        ExerciseName = itemView.findViewById(R.id.ExerciseName);
        BodyPartName = itemView.findViewById(R.id.BodyPartName);
        EquiqmentName = itemView.findViewById(R.id.EquiqmentName);
        LevelName = itemView.findViewById(R.id.LevelName);
        TypeName = itemView.findViewById(R.id.TypeName);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(exerciseListInterface != null) {
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        exerciseListInterface.onItemClick(pos);
                    }
                }
            }
        });

    }
}
