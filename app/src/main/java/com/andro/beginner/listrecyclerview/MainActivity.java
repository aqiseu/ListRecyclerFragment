package com.andro.beginner.listrecyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.andro.beginner.listrecyclerview.adapter.TabAdapter;
import com.andro.beginner.listrecyclerview.fragment.ListViewFragment;
import com.andro.beginner.listrecyclerview.fragment.RecyclerFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    MenuItem prevMenuItem;
    RecyclerFragment recyclerView;
    ListViewFragment listView;
    @BindView(R.id.fragment_container)
    ViewPager fragmentContainer;
    @BindView(R.id.navigation_main)
    BottomNavigationView navigationMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setTab();

    }

    private void setTab() {
        navigationMain.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                fragmentContainer.setCurrentItem(0);
                                break;
                            case R.id.navigation_profile:
                                fragmentContainer.setCurrentItem(1);
                                break;
                        }
                        return false;
                    }
                });

        fragmentContainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    navigationMain.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: " + position);
                navigationMain.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigationMain.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(fragmentContainer);
    }


    public void setupViewPager(ViewPager frameLayout) {
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        listView = new ListViewFragment();
        recyclerView = new RecyclerFragment();

        adapter.addFragment(listView);
        adapter.addFragment(recyclerView);

        frameLayout.setAdapter(adapter);
    }

}
