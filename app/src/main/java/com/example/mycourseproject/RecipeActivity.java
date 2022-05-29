package com.example.mycourseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class RecipeActivity extends AppCompatActivity {

    String[] batterIngredients, batterAmounts;
    String[] icingIngredients, icingAmounts;
    ListView batterListView, icingListView;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Resources res = getResources();

        batterIngredients = res.getStringArray(R.array.recipe_ingredients_batter);
        batterAmounts = res.getStringArray(R.array.recipe_amounts_batter);
        batterListView = findViewById(R.id.recipe_batter_listview);
        BatterAdapter batterAdapter = new BatterAdapter(getApplicationContext(),batterIngredients, batterAmounts);
        batterListView.setAdapter(batterAdapter);
        batterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //Toast toast;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (toast != null) {
                    toast.cancel();
                }
                toast = Toast.makeText(getApplicationContext(), batterIngredients[i], Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        icingIngredients = res.getStringArray(R.array.recipe_ingredients_icing);
        icingAmounts = res.getStringArray(R.array.recipe_amounts_icing);
        icingListView = findViewById(R.id.recipe_icing_listview);
        IcingAdapter icingAdapter = new IcingAdapter(getApplicationContext(), icingIngredients, icingAmounts);
        icingListView.setAdapter(icingAdapter);
        icingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (toast != null) {
                    toast.cancel();
                }
                toast = Toast.makeText(getApplicationContext(), icingIngredients[i], Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

}