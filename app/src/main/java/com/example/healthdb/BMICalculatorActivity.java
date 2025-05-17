package com.example.healthdb;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMICalculatorActivity extends AppCompatActivity {

    private EditText weightInput, heightInput; // EditText for weight and height input
    private TextView bmiResult; // TextView to display the BMI result

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator); // Set the layout

        // Initialize the views
        weightInput = findViewById(R.id.weight_input); // Weight input field
        heightInput = findViewById(R.id.height_input); // Height input field
        // Button to calculate BMI
        Button calculateBMIButton = findViewById(R.id.calculate_bmi_btn); // Calculate button
        bmiResult = findViewById(R.id.bmi_result); // TextView to display BMI result

        // Set a click listener for the Calculate BMI button
        calculateBMIButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                // Get the weight and height values
                String weightText = weightInput.getText().toString();
                String heightText = heightInput.getText().toString();

                if (!weightText.isEmpty() && !heightText.isEmpty()) {
                    // Parse the input values
                    double weight = Double.parseDouble(weightText); // Weight in kilograms
                    double heightInches = Double.parseDouble(heightText); // Height in inches

                    // Convert height from inches to meters (1 inch = 0.0254 meters)
                    double heightMeters = heightInches * 0.0254;

                    // Calculate BMI
                    double bmi = weight / (heightMeters * heightMeters);

                    // Display the result rounded to 1 decimal place
                    bmiResult.setText(String.format("Your BMI: %.1f", bmi)); // %.1f ensures 1 decimal place
                } else {
                    // If any field is empty, show a message
                    bmiResult.setText("Please enter valid values.");
                }
            }
        });
    }
}
