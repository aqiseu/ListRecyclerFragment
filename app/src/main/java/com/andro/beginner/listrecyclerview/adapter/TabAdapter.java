package com.andro.beginner.listrecyclerview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amaliaqis on 3/9/2018.
 */

public class TabAdapter extends FragmentPagerAdapter

    {
        private final List<Fragment> mFragmentList = new ArrayList<>();

    public TabAdapter(FragmentManager manager) {
        super(manager);
    }

        @Override
        public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

        @Override
        public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }

}
