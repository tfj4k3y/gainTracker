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

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.MyViewholder>{

    List<TreningObject> dates;
    Context context;
    ButtonInterface buttonInterface;

    public TrainingAdapter(Context ct, List datesA, ButtonInterface buttonInterface){
        context = ct;
        dates = datesA;
        this.buttonInterface = buttonInterface;
    }

    @NonNull
    @Override
    public TrainingAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_view, parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingAdapter.MyViewholder holder, int position) {
        holder.datesText.setText(dates.get(position).getDate());
        holder.daysOfWeekText.setText(dates.get(position).getDayOfWeek());
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        TextView datesText, daysOfWeekText;
        Button buttonOnClick;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            datesText = itemView.findViewById(R.id.dates);
            daysOfWeekText = itemView.findViewById(R.id.days_of_week);
            Button buttonOnClick = itemView.findViewById(R.id.expandBButton);

            buttonOnClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = getAdapterPosition();
                    buttonInterface.buttonOnClick(dates.get(id));

                }
            });


        }
    }
}
