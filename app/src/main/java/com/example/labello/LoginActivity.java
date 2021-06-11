package com.example.labello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    float v=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    tabLayout = findViewById(R.id.tab_layout);
    viewPager = findViewById(R.id.view_pager);

    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager());
    adapter.addFragment(new LogFragment(),"Log In");
    adapter.addFragment(new Register(),"Sign Up");
    adapter.getItem(tabLayout.getTabCount());
    viewPager.setAdapter(adapter);
    tabLayout.setupWithViewPager(viewPager);


    tabLayout.setTranslationY(300);
    tabLayout.setAlpha(v);
    tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400);

    }




}