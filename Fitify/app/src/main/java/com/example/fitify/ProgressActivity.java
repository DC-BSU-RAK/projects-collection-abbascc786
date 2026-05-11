package com.example.fitify;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieData;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class ProgressActivity extends AppCompatActivity {
    ImageView ivBack;
    TextInputEditText etWeight, etReps, etDays;
    TextView tvResult;
    BarChart chart;
    PieChart pieChart;
    MaterialButton btnSave;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        ivBack = findViewById(R.id.ivBack);
        etWeight = findViewById(R.id.etWeight);
        etReps = findViewById(R.id.etReps);
        etDays = findViewById(R.id.etDays);
        tvResult = findViewById(R.id.tvResult);
        chart = findViewById(R.id.chart);
        pieChart = findViewById(R.id.pieChart);
        btnSave = findViewById(R.id.btnSave);

        pref = getSharedPreferences("FitifyProgress", MODE_PRIVATE);

        String weight = pref.getString("weight", "");
        String reps = pref.getString("reps", "");
        String days = pref.getString("days", "");

        if (!weight.isEmpty()) {
            tvResult.setText("Weight: " + weight + "kg\nReps: " + reps + "\nDays: " + days);
            setBarChart(weight, reps, days);
            setPieChart(weight, reps, days);
        }

        ivBack.setOnClickListener(v -> finish());

        btnSave.setOnClickListener(v -> {
            setProgress();
        });
    }

    private void setProgress() {
        String weight = etWeight.getText().toString();
        String reps = etReps.getText().toString();
        String days = etDays.getText().toString();

        if (TextUtils.isEmpty(weight) || TextUtils.isEmpty(reps) || TextUtils.isEmpty(days)) {
            Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        pref.edit()
                .putString("weight", weight)
                .putString("reps", reps)
                .putString("days", days)
                .apply();

        tvResult.setText("Weight: " + weight + "kg\nReps: " + reps + "\nDays: " + days);

        setBarChart(weight, reps, days);
        setPieChart(weight, reps, days);

        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }

    void setBarChart(String weight, String reps, String days) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1, Float.parseFloat(weight)));
        entries.add(new BarEntry(2, Float.parseFloat(reps)));
        entries.add(new BarEntry(3, Float.parseFloat(days)));

        BarDataSet dataSet = new BarDataSet(entries, "Fitness Stats");

        dataSet.setColors(
                Color.parseColor("#4CAF50"),
                Color.parseColor("#FF9800"),
                Color.parseColor("#03A9F4")
        );

        dataSet.setValueTextSize(14f);
        dataSet.setValueTextColor(Color.BLACK);

        BarData data = new BarData(dataSet);
        chart.setData(data);

        chart.getDescription().setEnabled(false);
        chart.animateY(1200);
        chart.setFitBars(true);

        chart.invalidate();
    }

    void setPieChart(String weight, String reps, String days) {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        pieEntries.add(new PieEntry(Float.parseFloat(weight), ""));
        pieEntries.add(new PieEntry(Float.parseFloat(reps), ""));
        pieEntries.add(new PieEntry(Float.parseFloat(days), ""));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#4CAF50"));
        colors.add(Color.parseColor("#FF9800"));
        colors.add(Color.parseColor("#03A9F4"));

        pieDataSet.setColors(colors);
        pieDataSet.setValueTextSize(14f);
        pieDataSet.setValueTextColor(Color.WHITE);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);

        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Fitness");
        pieChart.setCenterTextSize(18f);
        pieChart.animateY(1400);
        pieChart.setEntryLabelColor(Color.BLACK);

        Legend legend = pieChart.getLegend();

        List<String> labels = Arrays.asList(
                "Weight",
                "Reps",
                "Days"
        );

        List<Integer> listOfColors = pieDataSet.getColors();

        ArrayList<LegendEntry> legendEntries = new ArrayList<>();

        for (int i = 0; i < labels.size(); i++) {
            LegendEntry entry = new LegendEntry();
            entry.formColor = listOfColors.get(i);
            entry.label = labels.get(i);
            legendEntries.add(entry);
        }

        legend.resetCustom();
        legend.setCustom(legendEntries);

        pieChart.notifyDataSetChanged();
        pieChart.invalidate();
    }

}