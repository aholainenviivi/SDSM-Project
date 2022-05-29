package com.example.mycourseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AppLauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_launcher);

        Button btn1 = findViewById(R.id.launcher_button_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChildrenFallingDown();
            }
        });

        Button btn2 = findViewById(R.id.launcher_button_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCats();
            }
        });

        Button btn3 = findViewById(R.id.launcher_button_3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res = getResources();
                String text = res.getString(R.string.launcher_rick_rolls_toast);
                Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public void showChildrenFallingDown() {
        String URLString = "https://www.reddit.com/r/kidsfallingdown/";
        Uri webPage = Uri.parse(URLString);
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            System.out.println("Cannot open the web page");
            Toast toast = Toast.makeText(getApplicationContext(), "No app found to open this", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void showCats() {
        String URLString = "https://www.youtube.com/watch?v=fW2kl3Cq8IM";
        Uri webPage = Uri.parse(URLString);
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            System.out.println("Cannot open the web page");
            Toast toast = Toast.makeText(getApplicationContext(), "No app found to open this", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}