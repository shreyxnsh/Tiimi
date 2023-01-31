package com.shreyxnsh.tiimi.ui.inbox;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.shreyxnsh.tiimi.R;
import com.shreyxnsh.tiimi.ui.InboxFragment;

public class ApplicantActivity extends AppCompatActivity {

    private ImageView backArrow;
    private InboxFragment inboxFragment;
    private int selectedTabNumber = 1;
    private TextView emailTV, whatsappTV;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant);

        backArrow = findViewById(R.id.back);
        emailTV = findViewById(R.id.emailTV);
        whatsappTV = findViewById(R.id.whatsappTV);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ApplicantActivity.this, InboxFragment.class);
                startActivity(intent);
            }
        });

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, EmailFragment.class, null)
                .commit();
        emailTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectTab(1);
            }
        });

        whatsappTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(2);
            }
        });
    }

    private void selectTab(int tabNumber) {
        TextView selectedTV, nonSelectedTV;
        if (tabNumber==1){
            selectedTV = emailTV;
            nonSelectedTV = whatsappTV;

            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, EmailFragment.class, null)
                    .commit();
        }
        else {
            selectedTV = whatsappTV;
            nonSelectedTV = emailTV;

            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, WhatsappFragment.class, null)
                    .commit();
        }
        float slideTo = (tabNumber - selectedTabNumber) * selectedTV.getWidth();
        TranslateAnimation translateAnimation = new TranslateAnimation(0,slideTo,0,0);
        translateAnimation.setDuration(100);
        if (selectedTabNumber == 1){
            emailTV.startAnimation(translateAnimation);
        }else {
            whatsappTV.startAnimation(translateAnimation);
        }
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                selectedTV.setBackgroundResource(R.drawable.round_back_selected);
                selectedTV.setTextColor(Color.BLACK);
                nonSelectedTV.setBackgroundResource(R.drawable.round_back_white);
                nonSelectedTV.setTextColor(Color.GRAY);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}