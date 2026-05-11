package com.example.fitify;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WorkoutActivity extends AppCompatActivity {
    RecyclerView recycler;
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        ivBack = findViewById(R.id.ivBack);
        recycler = findViewById(R.id.recycler);

        ArrayList<ExerciseModel> list = new ArrayList<>();

        list.add(new ExerciseModel(
                "Push Ups",
                "A classic upper body exercise that builds strength in the chest, shoulders, and triceps while also engaging the core for stability.",
                "Chest",
                "Start in a plank position with hands under shoulders. Lower your body slowly until your chest nearly touches the floor, then push back up. Keep your body straight and core tight throughout.",
                R.drawable.pushup));

        list.add(new ExerciseModel(
                "Squats",
                "A powerful lower body exercise that targets the quadriceps, hamstrings, and glutes while improving balance and mobility.",
                "Legs",
                "Stand with feet shoulder-width apart. Lower your hips down as if sitting in a chair, keeping your back straight. Push through your heels to return to standing.",
                R.drawable.squat));

        list.add(new ExerciseModel(
                "Plank",
                "An isometric core exercise that improves stability, posture, and endurance by engaging abdominal and back muscles.",
                "Abs",
                "Position your body on your forearms and toes. Keep your body straight from head to heels. Hold the position while tightening your core and avoiding sagging.",
                R.drawable.plank));

        list.add(new ExerciseModel(
                "Burpees",
                "A high-intensity full-body exercise that improves strength, endurance, and cardiovascular fitness.",
                "Full Body",
                "Begin standing, drop into a squat, kick your feet back into a plank, perform a push-up, then jump back up explosively.",
                R.drawable.burpee));

        list.add(new ExerciseModel(
                "Jumping Jacks",
                "A simple cardio exercise that increases heart rate and warms up the body.",
                "Full Body",
                "Jump your feet out while raising your arms overhead, then return to the starting position. Repeat continuously.",
                R.drawable.jumping));

        list.add(new ExerciseModel(
                "Bicep Curls",
                "An isolation exercise that targets the biceps and improves arm strength.",
                "Arms",
                "Hold dumbbells in each hand, curl them upward toward your shoulders while keeping elbows close to your body, then lower slowly.",
                R.drawable.bicep));

        list.add(new ExerciseModel(
                "Tricep Dips",
                "An upper body exercise focusing on the triceps and shoulders.",
                "Arms",
                "Use a bench or chair. Lower your body by bending your elbows, then push back up until arms are straight.",
                R.drawable.tricep));

        list.add(new ExerciseModel(
                "Shoulder Press",
                "A strength exercise that targets the shoulders and upper arms.",
                "Shoulders",
                "Hold weights at shoulder height and press them upward until arms are fully extended, then lower slowly.",
                R.drawable.shoulder));

        list.add(new ExerciseModel(
                "Leg Raises",
                "A core exercise that strengthens the lower abdominal muscles.",
                "Abs",
                "Lie flat on your back and raise your legs upward while keeping them straight. Slowly lower them without touching the ground.",
                R.drawable.legraise));

        list.add(new ExerciseModel(
                "High Knees",
                "A cardio exercise that improves endurance and coordination.",
                "Full Body",
                "Run in place while lifting your knees as high as possible, maintaining a fast pace.",
                R.drawable.highknees));

        list.add(new ExerciseModel(
                "Wall Sit",
                "An isometric exercise that builds endurance in the legs.",
                "Legs",
                "Lean against a wall and slide down until your knees are at 90 degrees. Hold the position as long as possible.",
                R.drawable.wallsit));

        ExerciseAdapter adapter = new ExerciseAdapter(this, list);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);

        ivBack.setOnClickListener(v -> finish());

    }
}