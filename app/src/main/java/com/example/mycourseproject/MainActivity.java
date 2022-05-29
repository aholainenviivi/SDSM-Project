package com.example.mycourseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    static int prevNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mainButton = findViewById(R.id.main_button);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevNum = startRandomActivity(prevNum);
            }
        });
    }

    protected int startRandomActivity(int prevNum) {
        int randomNum = prevNum;
        int min=1;
        int max=3;
        while (randomNum == prevNum) {
            randomNum = ThreadLocalRandom.current().nextInt(min, max+1);
        }
        //int randomNum = 1;
        //int randomNum = 2;
        //int randomNum = 3;

        Intent intent = null;
        switch (randomNum) {
            case 1:
                intent = new Intent(getApplicationContext(), AppLauncherActivity.class);
                break;
            case 2:
                intent = new Intent(getApplicationContext(), RecipeActivity.class);
                break;
            case 3:
                intent = new Intent(getApplicationContext(), PictureShowActivity.class);
                break;
            default:
                System.out.println("This should not be happening");
                break;
        }
        startActivity(intent);

        return randomNum;
    }

}