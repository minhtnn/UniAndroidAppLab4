package com.minhtnn.uniworklab4.drinkorderapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.minhtnn.uniworklab4.R;

import java.util.ArrayList;
import java.util.List;
public class DrinkActivity extends AppCompatActivity {
    private ListView lvDrink;
    private List<Drink> drinkList;
    private DrinkAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        lvDrink = findViewById(R.id.lvDrink);
        drinkList = new ArrayList<>();

        drinkList.add(new Drink("Pepsi", "Nước giải khát có gas", 15000, R.drawable.pepsi));
        drinkList.add(new Drink("Heineken", "Bia nhập khẩu", 25000, R.drawable.heineken));
        drinkList.add(new Drink("Tiger", "Bia Tiger thơm ngon", 20000, R.drawable.tiger));
        drinkList.add(new Drink("Sài Gòn Đỏ", "Bia Sài Gòn hương vị đặc trưng", 18000, R.drawable.saigon_do));

        adapter = new DrinkAdapter(this, drinkList);
        lvDrink.setAdapter(adapter);

        lvDrink.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drink selectedDrink = drinkList.get(position);
                Intent intent = new Intent();
                intent.putExtra("selectedItem", selectedDrink.getName() + " - " + selectedDrink.getPrice() + " VND");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
