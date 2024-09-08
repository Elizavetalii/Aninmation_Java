package com.example.rabbit;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.view.animation.AnimationUtils;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button goToFrameAnimation;
    private Button goToTweenAnimation;
    private TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToFrameAnimation = findViewById(R.id.button_frame_animation);
        goToTweenAnimation = findViewById(R.id.button_tween_animation);
        welcomeText = findViewById(R.id.textView);

        goToFrameAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FrameAnimation.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        goToTweenAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TweenAnimation.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Анимация текстового блока
        Animation scaleInAnimation = AnimationUtils.loadAnimation(this, R.anim.text);
        welcomeText.startAnimation(scaleInAnimation);

        // Анимация кнопки 1
        Animation slideInRightAnimation = AnimationUtils.loadAnimation(this, R.anim.button1);
        goToFrameAnimation.startAnimation(slideInRightAnimation);

        // Анимация кнопки 2
        Animation slideInLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.button2);
        goToTweenAnimation.startAnimation(slideInLeftAnimation);
    }
}
