package com.js.myviews.ui;

// Created by JS on 2021/7/28.

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.js.myviews.R;
import com.js.myviews.databinding.ActivityGuideBinding;

public class GuideActivity extends AppCompatActivity {

    private ActivityGuideBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnMain.setOnClickListener(v -> {
            MainActivity.start(this);
        });
        binding.btnViewpager.setOnClickListener(v -> {
            MZViewPagerActivity.start(this);
        });
    }
}
