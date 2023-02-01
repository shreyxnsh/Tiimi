package com.shreyxnsh.tiimi.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.shreyxnsh.tiimi.R;
import com.shreyxnsh.tiimi.ui.inbox.MyViewPagerAdapter;
import com.shreyxnsh.tiimi.ui.jobs.JobsViewPagerAdapter;


public class JobsFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private JobsViewPagerAdapter JobsViewPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_jobs, container, false);

        tabLayout = view.findViewById(R.id.tab_layout_jobs);
        viewPager2 = view.findViewById(R.id.view_pager_jobs);

        JobsViewPagerAdapter = new JobsViewPagerAdapter(getActivity());
        viewPager2.setAdapter(JobsViewPagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
        return view;
    }
}