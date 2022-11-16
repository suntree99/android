package com.example.myaudiosong;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private double startTime = 0;
    private double endTime = 0;
    private int forwardTime = 5000;
    private int backwardTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final Button play = (Button) findViewById(R.id.play_button);
       final Button pause = (Button) findViewById(R.id.pause_button);
       final Button forward = (Button) findViewById(R.id.forward_button);
       final Button backward = (Button) findViewById(R.id.backward_button);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.davissong);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                endTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        finish();
                        Toast.makeText(getApplicationContext(),"I'm done", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                pause.setEnabled(true);
                forward.setEnabled(true);
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;
                if((temp + forwardTime)  <= endTime){
                    startTime = startTime + forwardTime;
                    mediaPlayer.seekTo((int)startTime);
                }
            }
        });

        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;
                if((temp - backwardTime) > 0){
                    startTime = startTime - backwardTime;
                    mediaPlayer.seekTo((int)startTime);
                }
            }
        });



    }
}
