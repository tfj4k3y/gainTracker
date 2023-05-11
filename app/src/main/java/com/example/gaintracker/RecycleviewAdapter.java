package com.example.gaintracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.MyViewholder> {

    String cwiczenia[], parametry[], daty[];
    Context context;

    public RecycleviewAdapter(Context ct, String cw[], String param[], String datyA[]){
        context = ct;
        cwiczenia =cw;
        parametry = param;
        daty = datyA;
    }

    @NonNull
    @Override
    public RecycleviewAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_view, parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleviewAdapter.MyViewholder holder, int position) {
        holder.exercise_text.setText(cwiczenia[position]);
        holder.result_text.setText(parametry[position]);
        holder.dates_text.setText(daty[position]);
    }

    @Override
    public int getItemCount() {
        return cwiczenia.length;
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        TextView exercise_text, result_text, dates_text;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            exercise_text = itemView.findViewById(R.id.exercise_txt);
            result_text = itemView.findViewById(R.id.results_txt);
            dates_text = itemView.findViewById(R.id.date_txt);
        }
    }
}
