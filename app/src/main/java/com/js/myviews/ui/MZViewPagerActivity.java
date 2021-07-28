package com.js.myviews.ui;

// Created by JS on 2021/7/28.

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.js.myviews.R;
import com.js.myviews.databinding.ActivityMzViewpagerBinding;
import com.js.myviews.fragment.MZModeBannerFragment;
import com.js.myviews.fragment.MZModeNotCoverFragment;
import com.js.myviews.fragment.NormalViewPagerFragment;

public class MZViewPagerActivity extends AppCompatActivity {

    private ActivityMzViewpagerBinding binding;

    public static void start(Context context) {
        Intent intent = new Intent(context, MZViewPagerActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMzViewpagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        binding.toolBar.inflateMenu(R.menu.setting);
        binding.toolBar.setOnMenuItemClickListener(item -> {
            if(item.getItemId() ==R.id.banner_mode){
                switchBannerMode();
            }else if(item.getItemId() == R.id.viewPager_mode){
                switchViewPagerMode();
            }else if(item.getItemId() == R.id.remote_mode){
                switchRemoteMode();
            }else if(item.getItemId() == R.id.mz_mode_not_cover){
                switchMZModeNotCover();
            }
            return true;
        });

        Fragment fragment = MZModeBannerFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.home_container,fragment).commit();
    }

    /**
     * banner模式
     */
    public void switchBannerMode(){
        Fragment fragment = MZModeBannerFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.home_container,fragment).commit();
    }

    /**
     * 普通ViewPager模式
     */
    public void switchViewPagerMode(){
        Fragment fragment = NormalViewPagerFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.home_container,fragment).commit();
    }

    /**
     * 从网络获取数据
     */
    public void switchRemoteMode(){
//        Fragment fragment = RemoteTestFragment.newInstance();
//        getSupportFragmentManager().beginTransaction().replace(R.id.home_container,fragment).commit();
    }

    public void switchMZModeNotCover(){
        Fragment fragment = MZModeNotCoverFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.home_container,fragment).commit();
    }
}
