package com.example.practical10;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewTween = findViewById(R.id.textViewTween);
        TextView textViewProperty = findViewById(R.id.textViewProperty);

        // Tween Animation
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        textViewTween.startAnimation(fadeIn);

        // Property Animation
        textViewProperty.animate().translationX(-100).setDuration(5000);
        textViewProperty.animate().translationX(100).setDuration(5000);

    }
}
