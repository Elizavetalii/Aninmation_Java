package com.example.rabbit;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class TweenAnimation extends AppCompatActivity {
    private ImageView animationTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);

        animationTV = findViewById(R.id.animImageView);
        Animation AnimationB = AnimationUtils.loadAnimation(this, R.anim.blink_animation);
        animationTV.startAnimation(AnimationB);

        // Устанавливаем анимацию появления
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        findViewById(R.id.tween_animation_layout).startAnimation(fadeInAnimation);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
