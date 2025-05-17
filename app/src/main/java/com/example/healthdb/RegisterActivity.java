package com.example.healthdb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    // Define member variables for your views
    private EditText usernameInput;
    private EditText fullNameInput;
    private EditText emailInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // Ensure this matches your layout file name

        // Initialize views
        usernameInput = findViewById(R.id.username_input);
        fullNameInput = findViewById(R.id.Username); // Adjust the ID if needed
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        Button registerButton = findViewById(R.id.register_btn2);

        // Set an OnClickListener for the register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        // Get user input values
        String username = usernameInput.getText().toString().trim();
        String fullName = fullNameInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        // Basic validation
        if (username.isEmpty() || fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create an instance of the Database class
        Database db = new Database(getApplicationContext(), "healthcare", null, 1);

        // Save the user data into the database
        db.register(username, email, password);

        // Notify the user
        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();

        // Navigate to MainActivity
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);

        // Optionally, finish this activity
        finish();
    }
}
