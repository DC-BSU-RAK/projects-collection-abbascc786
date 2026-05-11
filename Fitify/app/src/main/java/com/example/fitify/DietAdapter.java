package com.example.fitify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DietAdapter extends RecyclerView.Adapter<DietAdapter.ViewHolder> {

    Context context;
    List<DietModel> list;

    public DietAdapter(Context context, List<DietModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_diet, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        DietModel model = list.get(position);

        holder.tvName.setText(model.getName());
        holder.tvDesc.setText(model.getDescription());
        holder.tvCalories.setText("Calories: " + model.getCalories());
        holder.tvTiming.setText("Time: " + model.getTiming());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvDesc, tvCalories, tvTiming;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvDietName);
            tvDesc = itemView.findViewById(R.id.tvDietDesc);
            tvCalories = itemView.findViewById(R.id.tvDietCalories);
            tvTiming = itemView.findViewById(R.id.tvDietTiming);
        }
    }
}