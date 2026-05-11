package com.example.fitify;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DietPlanActivity extends AppCompatActivity {
    RecyclerView recycler;
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan);

        ivBack = findViewById(R.id.ivBack);
        recycler = findViewById(R.id.recycler);

        ArrayList<DietModel> list = new ArrayList<>();

        list.add(new DietModel(
                "Oatmeal Breakfast",
                "Healthy oats with milk, banana, and honey for energy boost.",
                "350 kcal",
                "Morning"));

        list.add(new DietModel(
                "Boiled Eggs Diet",
                "High protein eggs for muscle building and fat loss.",
                "250 kcal",
                "Morning"));

        list.add(new DietModel(
                "Chicken Salad",
                "Grilled chicken with fresh vegetables and olive oil.",
                "400 kcal",
                "Lunch"));

        list.add(new DietModel(
                "Brown Rice Bowl",
                "Healthy carbs with fiber-rich brown rice and veggies.",
                "450 kcal",
                "Lunch"));

        list.add(new DietModel(
                "Greek Yogurt",
                "Protein-rich yogurt with probiotics for digestion.",
                "180 kcal",
                "Snack"));

        list.add(new DietModel(
                "Protein Shake",
                "Whey protein shake for muscle recovery after workout.",
                "220 kcal",
                "Post Workout"));

        list.add(new DietModel(
                "Grilled Fish",
                "Omega-3 rich fish for heart and brain health.",
                "380 kcal",
                "Dinner"));

        list.add(new DietModel(
                "Fruit Bowl",
                "Mixed fruits for vitamins and natural sugar energy.",
                "200 kcal",
                "Snack"));

        list.add(new DietModel(
                "Avocado Toast",
                "Healthy fats and fiber-rich breakfast option.",
                "300 kcal",
                "Morning"));

        list.add(new DietModel(
                "Quinoa Salad",
                "High-protein plant-based meal with quinoa and veggies.",
                "420 kcal",
                "Lunch"));

        list.add(new DietModel(
                "Chicken Soup",
                "Light and nutritious soup for dinner.",
                "250 kcal",
                "Dinner"));

        list.add(new DietModel(
                "Almond Snack",
                "Healthy fats and energy boosting dry fruits.",
                "180 kcal",
                "Snack"));

        list.add(new DietModel(
                "Sweet Potato",
                "Complex carbs for sustained energy release.",
                "320 kcal",
                "Lunch"));

        list.add(new DietModel(
                "Green Smoothie",
                "Spinach, apple, and banana detox drink.",
                "210 kcal",
                "Morning"));

        list.add(new DietModel(
                "Paneer Bowl",
                "High protein vegetarian meal with paneer cubes.",
                "400 kcal",
                "Dinner"));

        DietAdapter adapter = new DietAdapter(this, list);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);

        ivBack.setOnClickListener(v -> finish());
    }
}