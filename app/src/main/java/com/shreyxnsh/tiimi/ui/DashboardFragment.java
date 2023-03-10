package com.shreyxnsh.tiimi.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.shreyxnsh.tiimi.R;
import com.shreyxnsh.tiimi.ui.dashboard.NotificationActivity;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;


@SuppressWarnings("ALL")
public class DashboardFragment extends Fragment {

    private PieChart chart;
    private final float i1 = 16.7f;
    private float i2 = 8.3f;
    private float i3 = 8.3f;
    private float i4 = 8.3f;
    private float i5 = 58.3f;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void addToPieChart() {
        chart.addPieSlice(new PieModel("Integer 1", i1, Color.parseColor("#96a5be")));
        chart.addPieSlice(new PieModel("Integer 2", i2, Color.parseColor("#fed931")));
        chart.addPieSlice(new PieModel("Integer 3", i3, Color.parseColor("#f4a13c")));
        chart.addPieSlice(new PieModel("Integer 4", i4, Color.parseColor("#aed585")));
        chart.addPieSlice(new PieModel("Integer 5", i5, Color.parseColor("#346866")));

        chart.startAnimation();
        chart.setClickable(false);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.notification:
                Intent intent = new Intent(getActivity(), NotificationActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        chart = view.findViewById(R.id.pie_chart);

        addToPieChart();

        return view;

    }

}