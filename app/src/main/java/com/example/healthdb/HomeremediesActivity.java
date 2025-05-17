package com.example.healthdb;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class HomeremediesActivity extends AppCompatActivity {

    private EditText symptomInput;
    private TextView solutionText;

    private Map<String, String> remediesMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeremedies);

        // Initialize views
        symptomInput = findViewById(R.id.symptom_input);
        solutionText = findViewById(R.id.solution_text);

        // Load remedies from the dataset (simple example)
        remediesMap = new HashMap<>();
        remediesMap.put("indigestion", "5 gm. crushed rhizome with salt or jaggery twice daily before meal.");
        remediesMap.put("headache", "Apply a warm paste over the forehead 3 times a day.");
        remediesMap.put("fever", "20 ml. decoction from 5 gm. powder with sugar 3-4 times a day.");
        remediesMap.put("cold", "Use steam inhalation with eucalyptus oil.");

        // Handle the "Find Solution" button click
        findViewById(R.id.find_solution_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String symptom = symptomInput.getText().toString().trim().toLowerCase(); // Convert to lowercase
                if (symptom.isEmpty()) {
                    Toast.makeText(HomeremediesActivity.this, "Please enter a symptom", Toast.LENGTH_SHORT).show();
                } else {
                    String remedy = remediesMap.get(symptom); // Look for the symptom in the map
                    if (remedy != null) {
                        solutionText.setText(remedy);
                    } else {
                        solutionText.setText("No solution found for this symptom.");
                    }
                }
            }
        });
    }
}
