package com.letran.football_player.views;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.letran.football_player.R;
import com.letran.football_player.fragments.Charts_Fragment;
import com.letran.football_player.fragments.Main_Fragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Base_Activity implements ActionBar.TabListener {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabsPagerAdapter mAdapter;

    private Main_Fragment main_fragment;
    private Charts_Fragment charts_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        contentView = inflater.inflate(R.layout.activity_main,null,false);
        constraintLayout.addView(contentView);

        Initiate();
        setupViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }

    private void Initiate(){
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout)contentView.findViewById(R.id.tablayout);

        viewPager.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View arg0, MotionEvent arg1) {
                return true;
            }
        });
    }

    private void setupViewPager() {
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        mAdapter.addFragment(new Main_Fragment(), "Cho bạn");
        mAdapter.addFragment(new Charts_Fragment(), "Bảng xếp hạng");
        viewPager.setAdapter(mAdapter);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        //viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public class TabsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public TabsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
