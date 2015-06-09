package com.r1code.d3profile.mainpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by rafael on 1/06/15.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> tittles;
    private float pageWidth = 1;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        tittles = new ArrayList<>();

        addFragment("Profile", new ProfilePage());
        addFragment("Heroes", new HeroesListPage());

        addFragment("Items", new HeroPage());
        addFragment("Profile", new ProfilePage());
        addFragment("Profile", new ProfilePage());
        addFragment("Profile", new ProfilePage());
        addFragment("Profile", new ProfilePage());
        addFragment("Profile", new ProfilePage());
        addFragment("Profile", new ProfilePage());
    }

    public void addFragment(String title, Fragment fragment) {
        tittles.add(title);
        fragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tittles.get(position);
    }

    public void setPageWidth(float pageWidth) {
        this.pageWidth = pageWidth;
    }

    @Override
    public float getPageWidth(int position) {
        return pageWidth;
    }
}
