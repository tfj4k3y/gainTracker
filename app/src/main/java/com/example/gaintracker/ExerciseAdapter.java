package com.example.gaintracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.MyExerciseViewholder>{

    List<ExerciseObject> exerciseObjects;
    Context context;

    public ExerciseAdapter(Context ct, List exerciseObjects){
        context = ct;
        this.exerciseObjects = exerciseObjects;
    }

    @NonNull
    @Override
    public ExerciseAdapter.MyExerciseViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_exercises_view, parent, false);
        return new MyExerciseViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseAdapter.MyExerciseViewholder holder, int position) {
        holder.exrciseNameText.setText(exerciseObjects.get(position).getExerciseName());
        holder.setsCountText.setText(exerciseObjects.get(position).getSetsCount());
        holder.repsCountText.setText(exerciseObjects.get(position).getRepsCount());
        holder.weightText.setText(exerciseObjects.get(position).getWeight());
    }

    @Override
    public int getItemCount() {
        return exerciseObjects.size();
    }

    public class MyExerciseViewholder extends RecyclerView.ViewHolder {

        TextView exrciseNameText, setsCountText, repsCountText, weightText;
        public MyExerciseViewholder(@NonNull View itemView) {
            super(itemView);
            exrciseNameText = itemView.findViewById(R.id.exercise_preview_name);
            setsCountText = itemView.findViewById(R.id.sets_preview_count);
            repsCountText = itemView.findViewById(R.id.reps_preview_count);
            weightText = itemView.findViewById(R.id.weight_preview);
        }
    }

}
