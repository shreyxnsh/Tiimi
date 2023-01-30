package com.shreyxnsh.tiimi.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shreyxnsh.tiimi.R;
import com.shreyxnsh.tiimi.ui.dashboard.TodayFragment;


public class DashboardFragment extends Fragment {

    private TextView todayTV, completedTV;
    private int selectedTabNumber = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getActivity().getSupportFragmentManager().beginTransaction()
//                .setReorderingAllowed(true)
//                .replace(R.id.fragmentContainer, TodayFragment.class, null)
//                .commit();
//
//        todayTV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        completedTV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


    }

    private void selectedTab(int tabNumber) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        todayTV = view.findViewById(R.id.todayTV);
        completedTV = view.findViewById(R.id.completedTV);
        return view;

    }
}