package com.example.rabbit;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class FrameAnimation extends AppCompatActivity {
    private ImageView animationTV;
    private AnimationDrawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        animationTV = findViewById(R.id.animImageView);
        animationTV.setBackgroundResource(R.drawable.anim_rabbit);
        frameAnimation = (AnimationDrawable) animationTV.getBackground();

        // Начинаем фреймовую анимацию
        frameAnimation.start();

        // Устанавливаем анимацию появления
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_inf);
        findViewById(R.id.frame_animation_layout).startAnimation(fadeInAnimation);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Остановите анимацию, если Activity приостановлена
        if (frameAnimation.isRunning()) {
            frameAnimation.stop();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
