package com.example.framebyframeanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btnStart;
    private ImageView imageView;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart=findViewById(R.id.btnStart);
        imageView=findViewById(R.id.imageView);
        animationDrawable=(AnimationDrawable)(imageView.getBackground());
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(animationDrawable.isRunning()){
                    animationDrawable.stop();
                }
                else{
                    animationDrawable.start();
                }
            }
        });
    }
}
