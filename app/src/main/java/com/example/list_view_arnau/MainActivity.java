package com.example.list_view_arnau;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView logo1;
    private ImageView logo2;
    private TextView title_store;
    private TextView subtitle_store;
    private RelativeLayout relative_main;

    ObjectAnimator objectAnimator1;
    ObjectAnimator objectAnimator2;
    ObjectAnimator objectAnimator3;
    ObjectAnimator objectAnimator4;
    ObjectAnimator objectAnimator5;
    ObjectAnimator objectAnimator6;
    ObjectAnimator objectAnimator7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo1 = findViewById(R.id.logo1);
        logo2 = findViewById(R.id.logo2);
        title_store = findViewById(R.id.title_store);
        subtitle_store = findViewById(R.id.subtitle_store);
        relative_main = findViewById(R.id.relative_main);

        objectAnimator1 = ObjectAnimator.ofFloat(logo1, "translationX", -250f, 0f);
        objectAnimator1.setDuration(2000);
        objectAnimator2 = ObjectAnimator.ofFloat(logo1, "alpha", 0f, 1f);
        objectAnimator2.setDuration(2000);

        objectAnimator3 = ObjectAnimator.ofFloat(title_store, "translationX", -250f, 0f);
        objectAnimator3.setDuration(2000);
        objectAnimator4 = ObjectAnimator.ofFloat(title_store, "alpha", 0f, 1f);
        objectAnimator4.setDuration(2000);

        objectAnimator5 = ObjectAnimator.ofFloat(subtitle_store, "translationX", -250f, 0f);
        objectAnimator5.setDuration(2000);
        objectAnimator6 = ObjectAnimator.ofFloat(subtitle_store, "alpha", 0f, 1f);
        objectAnimator6.setDuration(2000);

        objectAnimator7 = ObjectAnimator.ofFloat(logo2, "alpha", 0f, 1f);
        objectAnimator7.setStartDelay(2000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1, objectAnimator2, objectAnimator3, objectAnimator4,
                objectAnimator5, objectAnimator6, objectAnimator7);
        animatorSet.start();

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(logo1, "image_origen");
                pairs[1] = new Pair<View, String>(title_store, "title_origen");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        MainActivity.this,
                        pairs[0],
                        pairs[1]
                );
                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent, options.toBundle());
            }
        });
    }
}

