package com.example.mycourseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PictureShowActivity extends AppCompatActivity {

    int picId = 0;
    ImageView imageView;
    Button nextBtn, prevBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_show);

        nextBtn = findViewById(R.id.gallery_button_next);
        prevBtn = findViewById(R.id.gallery_button_previous);
        prevBtn.setVisibility(View.GONE);

        int pictures[] = {R.drawable.swans_img, R.drawable.pizza_img, R.drawable.boat_img,
            R.drawable.overalls_img, R.drawable.valheim_img};

        imageView = findViewById(R.id.gallery_imageview);
        imageView.setImageResource(pictures[picId]);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (picId < pictures.length - 1) {
                    ++picId;
                    imageView.setImageResource(pictures[picId]);
                    if (picId == pictures.length - 1) {
                        nextBtn.setVisibility(View.GONE);
                    }
                    if (prevBtn.getVisibility() == View.GONE) {
                        prevBtn.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        Button prevBtn = findViewById(R.id.gallery_button_previous);
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (picId > 0) {
                    --picId;
                    imageView.setImageResource(pictures[picId]);
                    if (picId == 0) {
                        prevBtn.setVisibility(View.GONE);
                    }
                    if (nextBtn.getVisibility() == View.GONE) {
                        nextBtn.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

    }

}