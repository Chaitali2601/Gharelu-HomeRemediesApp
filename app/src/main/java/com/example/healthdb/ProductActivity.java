package com.example.healthdb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {

    // Declare your views
    private GridLayout productGrid;
    private Button cartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product); // Make sure this is the correct XML layout file

        // Initialize the views
        productGrid = findViewById(R.id.productGrid);
        cartButton = findViewById(R.id.cartButton);

        // Set up the product cards and buttons
        setupProductCards();

        // Cart button click listener
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open CartActivity
                Intent intent = new Intent(ProductActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupProductCards() {
        // Loop through all the child views in the GridLayout
        for (int i = 0; i < productGrid.getChildCount(); i++) {
            // Check if the child view is a CardView
            if (productGrid.getChildAt(i) instanceof androidx.cardview.widget.CardView) {
                // Get the CardView at index 'i'
                androidx.cardview.widget.CardView cardView = (androidx.cardview.widget.CardView) productGrid.getChildAt(i);

                // Get the "Add to Cart" button inside the CardView by unique IDs
                Button addToCartButton = null;
                switch (i) {
                    case 0:
                        addToCartButton = cardView.findViewById(R.id.addToCartButton1); // For Product 1
                        break;
                    case 1:
                        addToCartButton = cardView.findViewById(R.id.addToCartButton2); // For Product 2
                        break;
                    case 2:
                        addToCartButton = cardView.findViewById(R.id.addToCartButton3); // For Product 3
                        break;
                    case 3:
                        addToCartButton = cardView.findViewById(R.id.addToCartButton4); // For Product 4
                        break;
                }

                // Set click listener for the "Add to Cart" button
                if (addToCartButton != null) {
                    addToCartButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // You can implement the logic to add the product to the cart
                            // For now, show a toast to indicate the button was clicked
                            Toast.makeText(ProductActivity.this, "Product added to cart", Toast.LENGTH_SHORT).show();

                            // Intent to open CartActivity
                            Intent intent = new Intent(ProductActivity.this, CartActivity.class);
                            startActivity(intent); // Navigate to CartActivity when a product is added
                        }
                    });
                }
            }
        }
    }
}
