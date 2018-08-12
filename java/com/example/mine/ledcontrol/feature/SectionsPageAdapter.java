package com.example.mine.ledcontrol.feature;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionsPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentListTitle = new ArrayList<>();

    public void addFragment(Fragment fragment, String title){

        mFragmentList.add(fragment);
        mFragmentListTitle.add(title);
    }

    public SectionsPageAdapter(FragmentManager fm){

        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position){

        return mFragmentListTitle.get(position);
    }

    @Override
    public Fragment getItem(int position){

        return mFragmentList.get(position);
    }

    @Override
    public int getCount(){

        return mFragmentList.size();
    }
}
