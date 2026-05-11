package com.example.fitify;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class ProfileActivity extends AppCompatActivity {
    ImageView ivBack;
    TextInputEditText etName, etEmail, etPassword;
    MaterialButton btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSave = findViewById(R.id.btnSave);
        ivBack = findViewById(R.id.ivBack);

        SharedPreferences pref = getSharedPreferences("FitifyUser", MODE_PRIVATE);

        etName.setText(pref.getString("name", ""));
        etEmail.setText(pref.getString("email", ""));
        etPassword.setText(pref.getString("pass", ""));

        ivBack.setOnClickListener(v -> finish());

        btnSave.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            pref.edit()
                    .putString("name", name)
                    .putString("email", email)
                    .putString("pass", pass)
                    .apply();

            Toast.makeText(this, "Profile Updated!", Toast.LENGTH_SHORT).show();
        });
    }
}