package com.example.fitify;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {

    Context context;
    List<ExerciseModel> list;

    public ExerciseAdapter(Context context, List<ExerciseModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_exercise, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ExerciseModel model = list.get(position);

        holder.tvName.setText(model.getName());
        holder.tvMuscle.setText("Target Muscle: " + model.getMuscle());
        holder.img.setImageResource(model.getImage());

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(context, ExerciseDetailActivity.class);
            intent.putExtra("name", model.getName());
            intent.putExtra("desc", model.getDesc());
            intent.putExtra("muscle", model.getMuscle());
            intent.putExtra("inst", model.getInstructions());
            intent.putExtra("image", model.getImage());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvMuscle;
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvMuscle = itemView.findViewById(R.id.tvMuscle);
            img = itemView.findViewById(R.id.imgExercise);
        }
    }
}