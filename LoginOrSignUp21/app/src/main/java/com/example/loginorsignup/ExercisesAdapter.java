package com.example.loginorsignup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesViewHolder> {


    Context context;
    List<ExerciseListItem> items;

    public ExercisesAdapter(Context context, List<ExerciseListItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ExercisesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExercisesViewHolder(LayoutInflater.from(context).inflate(R.layout.exercise_list_item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExercisesViewHolder holder, int position) {
        holder.ExerciseName.setText(items.get(position).getName());
        holder.BodyPartName.setText(items.get(position).getBodyPart());
        holder.EquiqmentName.setText(items.get(position).getEquiqment());
        holder.LevelName.setText(items.get(position).getLevel());
        holder.TypeName.setText(items.get(position).getType());
        holder.imageView.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
