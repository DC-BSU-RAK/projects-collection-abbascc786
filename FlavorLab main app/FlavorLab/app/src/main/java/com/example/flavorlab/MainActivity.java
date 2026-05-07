package com.example.flavorlab;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText etFood1, etFood2;
    MaterialButton btnCombine, btnInfo;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etFood1 = findViewById(R.id.etFood1);
        etFood2 = findViewById(R.id.etFood2);
        btnCombine = findViewById(R.id.btnCombine);
        btnInfo = findViewById(R.id.btnInfo);
        tvResult = findViewById(R.id.tvResult);

        btnCombine.setOnClickListener(v -> combineFoods());

        btnInfo.setOnClickListener(v -> showInfoDialog());

    }

    private void combineFoods() {

        String food1 = etFood1.getText().toString().trim();
        String food2 = etFood2.getText().toString().trim();

        if (TextUtils.isEmpty(food1) || TextUtils.isEmpty(food2)) {
            Toast.makeText(this, "Please enter both foods!", Toast.LENGTH_SHORT).show();
            return;
        }

        String result = food1 + " + " + food2 + " = " + food1 + " " + food2;

        tvResult.setText(result);
    }

    private void showInfoDialog() {

        Dialog dialog = new android.app.Dialog(this);
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