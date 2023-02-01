package com.shreyxnsh.tiimi.ui.jobs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class JobsViewPagerAdapter extends FragmentStateAdapter {
    public JobsViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ActiveFragment();
            case 1:
                return new InactiveFragment();
            default:
                return new ActiveFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
