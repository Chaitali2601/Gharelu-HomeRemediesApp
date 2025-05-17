package com.example.healthdb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {

    private LinearLayout cartItemLayout;
    private Button proceedToCheckoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartItemLayout = findViewById(R.id.cartItemLayout);
        proceedToCheckoutButton = findViewById(R.id.proceedToCheckoutButton);

        // Example Cart Items
        CartItem cartItem1 = new CartItem(R.drawable.honey, "Honey", 579.00);
        CartItem cartItem2 = new CartItem(R.drawable.ghee, "Ghee", 545.00);

        // Add Cart Items to Layout
        addCartItemToLayout(cartItem1);
        addCartItemToLayout(cartItem2);

        // Set click listener for Proceed to Checkout button
        proceedToCheckoutButton.setOnClickListener(v -> {
            // Handle Proceed to Checkout logic here
            // For example, navigate to the checkout screen
        });
    }

    private void addCartItemToLayout(CartItem cartItem) {
        // Create a new Cart Item view dynamically
        View cartItemView = getLayoutInflater().inflate(R.layout.cart_item, null);

        // Bind Views
        ImageView productImage = cartItemView.findViewById(R.id.productImage);
        TextView productName = cartItemView.findViewById(R.id.productName);
        TextView productPrice = cartItemView.findViewById(R.id.productPrice);
        Button removeButton = cartItemView.findViewById(R.id.removeButton);

        // Set data
        productImage.setImageResource(cartItem.getImageResId());
        productName.setText(cartItem.getName());
        productPrice.setText("₹" + cartItem.getPrice());

        // Set Remove button functionality
        removeButton.setOnClickListener(v -> {
            // Remove this item from the cart
            cartItemLayout.removeView(cartItemView);
            // Optionally, update the total price here
        });

        // Add the cart item to the layout
        cartItemLayout.addView(cartItemView);
    }

    // CartItem class to hold data for each cart item
    public static class CartItem {
        private int imageResId;
        private String name;
        private double price;

        public CartItem(int imageResId, String name, double price) {
            this.imageResId = imageResId;
            this.name = name;
            this.price = price;
        }

        public int getImageResId() {
            return imageResId;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}
