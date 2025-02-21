package com.minhtnn.uniworklab4.drinkorderapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.minhtnn.uniworklab4.R;

import java.util.List;

public class DrinkAdapter extends BaseAdapter {
    private Context context;
    private List<Drink> drinkList;

    public DrinkAdapter(Context context, List<Drink> drinkList) {
        this.context = context;
        this.drinkList = drinkList;
    }

    @Override
    public int getCount() { return drinkList.size(); }

    @Override
    public Object getItem(int position) { return drinkList.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_drink, parent, false);
        }

        Drink drink = drinkList.get(position);

        ImageView imgDrink = convertView.findViewById(R.id.imgDrink);
        TextView txtDrinkName = convertView.findViewById(R.id.txtDrinkName);
        TextView txtDrinkDescription = convertView.findViewById(R.id.txtDrinkDescription);
        TextView txtDrinkPrice = convertView.findViewById(R.id.txtDrinkPrice);

        imgDrink.setImageResource(drink.getImageResId());
        txtDrinkName.setText(drink.getName());
        txtDrinkDescription.setText(drink.getDescription());
        txtDrinkPrice.setText(drink.getPrice() + " VND");

        return convertView;
    }
}

