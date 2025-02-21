package com.minhtnn.uniworklab4.foodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.minhtnn.uniworklab4.R;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {
    private ListView lvFood;
    private List<Food> foodList;
    private FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        lvFood = findViewById(R.id.lvFood);
        foodList = new ArrayList<>();

        foodList.add(new Food("Phở Hà Nội", "Món phở truyền thống của Hà Nội", 50000, R.drawable.pho));
        foodList.add(new Food("Bún Bò Huế", "Món ăn đặc sản Huế", 60000, R.drawable.bun_bo_hue));
        foodList.add(new Food("Mì Quảng", "Món ăn đặc sản Quảng Nam", 55000, R.drawable.mi_quang));
        foodList.add(new Food("Hủ Tíu Sài Gòn", "Món ăn đặc sản miền Nam", 45000, R.drawable.hu_tiu));

        adapter = new FoodAdapter(this, foodList);
        lvFood.setAdapter(adapter);

        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food selectedFood = foodList.get(position);
                Intent intent = new Intent();
                intent.putExtra("selectedItem", selectedFood.getName() + " - " + selectedFood.getPrice() + " VND");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}