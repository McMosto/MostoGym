package com.example.loginorsignup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListViewHolder> {


    Context context;
    List<ExerciseListItem> items;

    public ExerciseListAdapter(Context context, List<ExerciseListItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ExerciseListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExerciseListViewHolder(LayoutInflater.from(context).inflate(R.layout.exercise_list_item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseListViewHolder holder, int position) {
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
