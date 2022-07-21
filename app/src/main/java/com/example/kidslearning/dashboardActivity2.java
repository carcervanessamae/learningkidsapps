package com.example.kidslearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class dashboardActivity2 extends AppCompatActivity {
      ImageView imgalpa, imgAnimal, imgColor, imgshape, imgNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);
        getSupportActionBar().hide();



        imgalpa = findViewById(R.id.imgalpa);
        Glide.with(this).load(R.drawable.alphabettt).into(imgalpa);

        imgAnimal = findViewById(R.id.imgAnimal);
        Glide.with(this).load(R.drawable.animal).into(imgAnimal);

        imgColor = findViewById(R.id.imgColor);
        Glide.with(this).load(R.drawable.color).into(imgColor);

        imgshape = findViewById(R.id.imgshape);
        Glide.with(this).load(R.drawable.shp).into(imgshape);

        imgNum = findViewById(R.id.imgNum);
        Glide.with(this).load(R.drawable.numbers).into(imgNum);

    }

    public void bntAlpha(View view) {
        startActivity(new Intent(dashboardActivity2.this,Alphabet.class) );
    }

    public void bntShapes(View view) {
        startActivity(new Intent(dashboardActivity2. this,shapes.class));
    }

    public void bntAnimals(View view) {
        startActivity(new Intent(dashboardActivity2.this,animals.class));
    }

    public void bntColors(View view) {
        startActivity(new Intent(dashboardActivity2.this,color.class));
    }

    public void bntNumbers(View view) {
        startActivity(new Intent(dashboardActivity2.this,numbers.class));
    }

    public void BtnQUIZ(View view) {
        startActivity(new Intent(dashboardActivity2.this,quiz.class));
    }
}
