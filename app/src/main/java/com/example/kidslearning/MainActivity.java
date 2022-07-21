package com.example.kidslearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView vidView;
    public Button btnGetStart;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        btnGetStart = (Button) findViewById(R.id.btnGetStart);
        vidView = findViewById(R.id.videoview);

        btnGetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, dashboardActivity2.class));
            }
        });
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.mysong);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();


        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bg_video);
        vidView.setVideoURI(uri);
        vidView.start();


        vidView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        vidView.resume();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        vidView.start();
    }
    @Override
    protected void onDestroy(){
        vidView.stopPlayback();
        super.onDestroy();
    }

}

