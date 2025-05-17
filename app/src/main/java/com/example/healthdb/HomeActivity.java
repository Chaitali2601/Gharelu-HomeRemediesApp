package com.example.healthdb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize ImageViews
        ImageView imageBMICalculator = findViewById(R.id.image_bmi_calculator);
        ImageView imageHelpSuggestions = findViewById(R.id.image_help_suggestions);
        ImageView imageProduct = findViewById(R.id.image_product);

        // Set Click Listener for BMI Calculator Image
        imageBMICalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to BMI Calculator Activity
                Intent intent = new Intent(HomeActivity.this, BMICalculatorActivity.class);
                startActivity(intent);
            }
        });

        // Set Click Listener for Help Suggestions Image
        imageHelpSuggestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Home Remedies Activity
                Intent intent = new Intent(HomeActivity.this, HomeremediesActivity.class);

                // Optionally, pass any extra data to the next activity (e.g., health tip)
                String healthTip = getHelpSuggestions();
                intent.putExtra("health_tip", healthTip);

                // Start the activity
                startActivity(intent);
            }
        });

        // Set Click Listener for Product Image
        imageProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Product Activity (you need to create this activity)
                Intent intent = new Intent(HomeActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        });

        // Initialize Log Out Button
        Button logoutButton = findViewById(R.id.logout_button);

        // Set Click Listener for Log Out Button
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Login Activity or Home Screen (you need to create this activity)
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);

                // Optionally, finish the current activity if you don't want to return to it
                finish();
            }
        });
    }

    // Method to get a health suggestion (you can replace this with more dynamic suggestions if needed)
    private String getHelpSuggestions() {
        return "Health Tip: Drink at least 8 glasses of water daily!";
    }
}
