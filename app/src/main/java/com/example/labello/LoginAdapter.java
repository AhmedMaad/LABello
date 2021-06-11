package com.example.labello;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class LoginAdapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> tittles = new ArrayList<>();

    public LoginAdapter(FragmentManager fm, Context context, int totalTabs){
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    public LoginAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public CharSequence getPageTitle(int position){
        return tittles.get(position) ;
    }

    public void addFragment(Fragment fragment,String Tittles){
        fragmentList.add(fragment);
        tittles.add(Tittles);
    }


}
