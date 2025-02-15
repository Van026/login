package com.example.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;
import com.example.login.R;


public class DashboardActivity extends AppCompatActivity {
    TextView tvWelcome;
    Button btnProfile, btnSettings, btnLogout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Retrieve username from Intent
        tvWelcome = findViewById(R.id.tvWelcome);
        String username = getIntent().getStringExtra("USERNAME");
        tvWelcome.setText("Welcome, " + username + "!");

        // Initialize buttons
        btnProfile = findViewById(R.id.btnProfile);
        btnSettings = findViewById(R.id.btnSettings);
        btnLogout = findViewById(R.id.btnLogout);

        // Button click listeners
        btnProfile.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, ProfileActivity.class)));
        btnSettings.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, SettingsActivity.class)));

        // Logout button
        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
