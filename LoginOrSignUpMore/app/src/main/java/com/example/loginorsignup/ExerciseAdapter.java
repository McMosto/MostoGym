package com.example.loginorsignup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseViewHolder> {
    Context context;
    List<ExerciseItem> items;

    public ExerciseAdapter(Context context, List<ExerciseItem> items, NewWorkoutActivity newWorkoutActivity) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExerciseViewHolder(LayoutInflater.from(context).inflate(R.layout.exercise_item_view,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        holder.ExerciseName.setText(items.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // Method to update the data set
    public void setItems(List<ExerciseItem> items) {
        this.items = items;
        notifyDataSetChanged(); // Notify the adapter of the data change
    }
}
