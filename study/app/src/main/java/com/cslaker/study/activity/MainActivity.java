package com.cslaker.study.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.cslaker.study.R;
import com.cslaker.study.fragment.GameFragment;
import com.cslaker.study.fragment.HomeFragment;
import com.cslaker.study.fragment.UserFragment;
import java.util.ArrayList;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private ArrayList<Fragment> fragments;
    private Toolbar toolbar;
    private BottomNavigationBar bottomNavigationBar;

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        toolbar = $(R.id.toolbar);
        bottomNavigationBar = $(R.id.bottom_navigation_bar);
        fragments = getFragments();
    }

    @Override
    public void setListener() {

    }

    @Override
    public void doBusiness(Context mContext) {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_book_black_18dp, "学习广场").setActiveColorResource(R.color.navigationBarColor))
                .addItem(new BottomNavigationItem(R.drawable.ic_game_white_24dp, "线下互动").setActiveColorResource(R.color.navigationBarColor))
                .addItem(new BottomNavigationItem(R.drawable.ic_user_black_24dp, "个人中心").setActiveColorResource(R.color.navigationBarColor))
                .setFirstSelectedPosition(0)
                .initialise();
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.layFrame, HomeFragment.newInstance("学习广场"));
        transaction.commit();
    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance("学习广场"));
        fragments.add(GameFragment.newInstance("线下互动"));
        fragments.add(UserFragment.newInstance("个人中心"));
        return fragments;
    }

    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    ft.replace(R.id.layFrame, fragment);
                } else {
                    ft.add(R.id.layFrame, fragment);
                }
                ft.commitAllowingStateLoss();
            }
        }

    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                ft.remove(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menu .findItem(R.id.ab_save).setVisible(false);
        menu .findItem(R.id.ab_search).setVisible(true);
        menu .findItem(R.id.ab_edit).setVisible(false);
        menu .findItem(R.id.ab_share).setVisible(false);
        menu .findItem(R.id.ab_more).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.ab_search) {
            return true;
        } else
        return super.onOptionsItemSelected(item);
    }

}
