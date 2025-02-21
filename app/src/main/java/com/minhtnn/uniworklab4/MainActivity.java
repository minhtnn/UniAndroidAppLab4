package com.minhtnn.uniworklab4;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.minhtnn.uniworklab4.databinding.ActivityMainBinding;
import com.minhtnn.uniworklab4.drinkorderapp.DrinkActivity;
import com.minhtnn.uniworklab4.foodorderapp.FoodActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnChooseFood, btnChooseDrink, btnExit;
    private TextView txtSelectedItems;
    private String selectedFood = "";
    private String selectedDrink = "";

    // Activity Result Launcher cho FoodActivity
    private final ActivityResultLauncher<Intent> foodActivityLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            selectedFood = result.getData().getStringExtra("selectedItem");
                            updateSelectedItems();
                        }
                    });

    // Activity Result Launcher cho DrinkActivity
    private final ActivityResultLauncher<Intent> drinkActivityLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            selectedDrink = result.getData().getStringExtra("selectedItem");
                            updateSelectedItems();
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChooseFood = findViewById(R.id.btnChooseFood);
        btnChooseDrink = findViewById(R.id.btnChooseDrink);
        btnExit = findViewById(R.id.btnExit);
        txtSelectedItems = findViewById(R.id.txtSelectedItems);

        // Mở FoodActivity khi nhấn CHỌN THỨC ĂN
        btnChooseFood.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FoodActivity.class);
            foodActivityLauncher.launch(intent);
        });

        // Mở DrinkActivity khi nhấn CHỌN ĐỒ UỐNG
        btnChooseDrink.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DrinkActivity.class);
            drinkActivityLauncher.launch(intent);
        });

        // Thoát ứng dụng
        btnExit.setOnClickListener(v -> finish());
    }

    // Cập nhật TextView với món ăn và đồ uống đã chọn
    private void updateSelectedItems() {
        txtSelectedItems.setText(selectedFood + " - " + selectedDrink);
    }
}