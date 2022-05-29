package com.example.mycourseproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class IcingAdapter extends BaseAdapter {

    String[] ingredients, amounts;
    LayoutInflater layoutInflater;

    public IcingAdapter(Context context, String[] ingredients, String[] amounts) {
        this.ingredients = ingredients;
        this.amounts = amounts;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return ingredients.length;
    }

    @Override
    public Object getItem(int i) {
        return ingredients[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = layoutInflater.inflate(R.layout.recipe_list_item_layout, null);
        TextView ingredientTextView = v.findViewById(R.id.recipe_ingredient);
        TextView amountTextView = v.findViewById(R.id.recipe_amount);
        ingredientTextView.setText(ingredients[i]);
        amountTextView.setText(amounts[i]);
        return v;
    }
}
