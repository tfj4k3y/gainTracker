package com.example.gaintracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.MyViewholder> {

    List<TreningObject> dates;
            //, daysOfWeek;
    Context context;

    public RecycleviewAdapter(Context ct, List datesA/*, List daysOfWeekA*/){
        context = ct;
        dates = datesA;
        //daysOfWeek = daysOfWeekA;
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
        //holder.datesText.setText(dates.get(position));
        //holder.daysOfWeekText.setText(daysOfWeek.get(position));
        holder.datesText.setText(dates.get(position).getDate());
        holder.daysOfWeekText.setText(dates.get(position).getDayOfWeek());
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        TextView datesText, daysOfWeekText;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            datesText = itemView.findViewById(R.id.dates);
            daysOfWeekText = itemView.findViewById(R.id.days_of_week);

        }
    }
}
