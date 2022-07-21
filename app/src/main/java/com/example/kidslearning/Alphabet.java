package com.example.kidslearning;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Alphabet extends AppCompatActivity {
       ImageView apple,bats;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        getSupportActionBar().hide();

        apple = findViewById(R.id.apple);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.plas);
        apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();


               }
        });

        bats = findViewById(R.id.bats);
        MediaPlayer mediaPlayer1 = MediaPlayer.create(this,R.raw.batss);
        bats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1.start();


            }
        });

    }

}
