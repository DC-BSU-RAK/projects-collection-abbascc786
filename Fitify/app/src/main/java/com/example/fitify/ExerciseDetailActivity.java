package com.example.fitify;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseDetailActivity extends AppCompatActivity {
    ImageView ivBack, img;
    TextView name, muscle, desc, inst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);

        ivBack = findViewById(R.id.ivBack);
        img = findViewById(R.id.img);
        name = findViewById(R.id.tvName);
        muscle = findViewById(R.id.tvMuscle);
        desc = findViewById(R.id.tvDesc);
        inst = findViewById(R.id.tvInst);

        name.setText(getIntent().getStringExtra("name"));
        muscle.setText("Target Muscle: " + getIntent().getStringExtra("muscle"));
        desc.setText("Description: " + getIntent().getStringExtra("desc"));
        inst.setText("Instructions: " + getIntent().getStringExtra("inst"));
        img.setImageResource(getIntent().getIntExtra("image", 0));

        ivBack.setOnClickListener(v -> finish());

    }
}