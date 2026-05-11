package com.example.fitify;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    TextView tvName, tvSuggestion;
    CardView cardWorkout, cardDietPlan, cardProgress, cardProfile;
    SharedPreferences pref;
    MaterialButton btnInfo, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvSuggestion = findViewById(R.id.tvSuggestion);
        cardWorkout = findViewById(R.id.cardWorkout);
        cardDietPlan = findViewById(R.id.cardDietPlan);
        cardProgress = findViewById(R.id.cardProgress);
        cardProfile = findViewById(R.id.cardProfile);
        btnInfo = findViewById(R.id.btnInfo);
        btnLogout = findViewById(R.id.btnLogout);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.click);

        pref = getSharedPreferences("FitifyUser", MODE_PRIVATE);

        cardWorkout.setOnClickListener(v -> {
            v.startAnimation(anim);
            startActivity(new Intent(this, WorkoutActivity.class));
        });

        cardDietPlan.setOnClickListener(v -> {
            v.startAnimation(anim);
            startActivity(new Intent(this, DietPlanActivity.class));
        });

        cardProgress.setOnClickListener(v -> {
            v.startAnimation(anim);
            startActivity(new Intent(this, ProgressActivity.class));
        });

        cardProfile.setOnClickListener(v -> {
            v.startAnimation(anim);
            startActivity(new Intent(this, ProfileActivity.class));
        });

        btnInfo.setOnClickListener(v -> showDialog());
        btnLogout.setOnClickListener(v -> {
            Intent intent =
                    new android.content.Intent(MainActivity.this, LoginActivity.class);

            intent.setFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK |
                    android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        });

    }

    private void showSuggestion() {
        SharedPreferences pref = getSharedPreferences("FitifyProgress", MODE_PRIVATE);
        String days = pref.getString("days", "0");

        int d = Integer.parseInt(days);

        if (d < 3) {
            tvSuggestion.setText("''Start slow! Try 3 days a week 💪''");
        } else if (d < 5) {
            tvSuggestion.setText("''Great! Increase intensity 🔥''");
        } else {
            tvSuggestion.setText("''Excellent consistency! Keep pushing 🚀''");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (pref != null) {
            String name = pref.getString("name", "User");
            tvName.setText(name);
        }
        showSuggestion();
    }

    private void showDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_info);

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        MaterialButton btnClose =
                dialog.findViewById(R.id.btnClose);

        btnClose.setOnClickListener(v -> dialog.dismiss());

        dialog.show();

        if (dialog.getWindow() != null) {
            int margin = 20;

            int width = getResources().getDisplayMetrics().widthPixels;
            int marginPx = (int) (margin * getResources().getDisplayMetrics().density);

            dialog.getWindow().setLayout(
                    width - (marginPx * 2),
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
        }
    }
}