package com.minhtnn.uniworklab4.foodorderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.minhtnn.uniworklab4.R;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private List<Food> foodList;

    public FoodAdapter(Context context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_food, parent, false);
        }

        Food food = foodList.get(position);

        ImageView imgFood = convertView.findViewById(R.id.imgFood);
        TextView txtFoodName = convertView.findViewById(R.id.txtFoodName);
        TextView txtFoodDescription = convertView.findViewById(R.id.txtFoodDescription);
        TextView txtFoodPrice = convertView.findViewById(R.id.txtFoodPrice);

        imgFood.setImageResource(food.getImageResId());
        txtFoodName.setText(food.getName());
        txtFoodDescription.setText(food.getDescription());
        txtFoodPrice.setText(food.getPrice() + " VND");

        return convertView;
    }
}
