package com.r1code.d3profile;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.r1code.d3profile.mainpager.MainPagerAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.tabs)
    TabLayout tabs;

    @InjectView(R.id.viewpager)
    ViewPager viewPager;

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @InjectView(R.id.navigation_drawer)
    DrawerLayout drawer;

    private DrawerToggle drawerToggle;
    private MainPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setSupportActionBar(toolbar);

        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        configurePagerAdapter();

        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);

        toolbar.setNavigationIcon(R.mipmap.ic_drawer);

        drawerToggle = new DrawerToggle(this, drawer, toolbar, R.string.hello_world, R.string.hello_world);
        drawer.setDrawerListener(drawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class DrawerToggle extends ActionBarDrawerToggle {

        public DrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
            super(activity, drawerLayout, toolbar, openDrawerContentDescRes, closeDrawerContentDescRes);
        }
    }

    private void configurePagerAdapter() {
        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            pagerAdapter.setPageWidth(0.4f);
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            pagerAdapter.setPageWidth(1);
        }
    }
}
