package com.example.myonboardingapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager slideViewPager;
    private LinearLayout dotButtonsLinearLayout;
    private TextView[] bottomDotsTextViewArray;
    private Button backButton;
    private Button nextButton;

    private SlideAdapter slideAdapter;
    private int currentPagePosition;

    private Button launchAppButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize Views
        this.initializeViews();

        // initialize SlideAdapter and ViewPager
        this.initializeSlideAdapterAndViewPager();

        // add dots
        this.addDotsIndicator(0);
        // add dots listener
        this.slideViewPager.addOnPageChangeListener(this.viewPagerListener);

        this.nextButton.setVisibility(View.VISIBLE);
        this.nextButton.setText("Next");

        // set buttons' listeners
        this.setBackButtonOnClickListener();
        this.setNextButtonOnClickListener();

        // open

    }

    private void openPasswordActivity() {
        Intent intent = new Intent(MainActivity.this, PasswordActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.activity_open, 0);
    }

    private void initializeViews() {
        this.slideViewPager = findViewById(R.id.slide_view_pager);
        this.dotButtonsLinearLayout = findViewById(R.id.ll_dot_button);
        this.backButton = findViewById(R.id.btn_back);
        this.nextButton = findViewById(R.id.btn_next);
        this.launchAppButton = findViewById(R.id.btn_launch_app);
    }

    private void initializeSlideAdapterAndViewPager() {
        this.slideAdapter = new SlideAdapter(this);
        this.slideViewPager.setAdapter(this.slideAdapter);
    }

    private void addDotsIndicator(int position) {

        this.bottomDotsTextViewArray = new TextView[3];
        this.dotButtonsLinearLayout.removeAllViews();

        for (int i = 0; i < this.bottomDotsTextViewArray.length; i++) {
            this.bottomDotsTextViewArray[i] = new TextView(this);
            this.bottomDotsTextViewArray[i].setText(Html.fromHtml("&#8226"));
            this.bottomDotsTextViewArray[i].setTextSize(35);
            this.bottomDotsTextViewArray[i].setTextColor(getResources().getColor(R.color.colorGreyForDots));

            dotButtonsLinearLayout.addView(this.bottomDotsTextViewArray[i]);
        }

        if (this.bottomDotsTextViewArray.length > 0) {
            bottomDotsTextViewArray[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewPagerListener = new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            currentPagePosition = position;

            // control the buttons
            if (position == 0) {
                backButton.setEnabled(false);
                backButton.setVisibility(View.INVISIBLE);
                backButton.setText("");

                nextButton.setEnabled(true);
                nextButton.setVisibility(View.VISIBLE);
                nextButton.setText("Next");

                launchAppButton.setVisibility(View.VISIBLE);
                launchAppButton.setAlpha(0);
            } else if (position == bottomDotsTextViewArray.length - 1) {
                backButton.setEnabled(true);
                backButton.setVisibility(View.VISIBLE);
                backButton.setText("BACK");

                nextButton.setEnabled(false);
                nextButton.setVisibility(View.INVISIBLE);
                nextButton.setText("");

                launchAppButton.animate()
                        .alpha(1f)
                        .setDuration(1000)
                        .setListener(null);
                setLaunchAppButtonOnClickListener();

            } else {
                backButton.setEnabled(true);
                backButton.setVisibility(View.VISIBLE);
                backButton.setText("BACK");

                nextButton.setEnabled(true);
                nextButton.setVisibility(View.VISIBLE);
                nextButton.setText("NEXT");

                launchAppButton.setVisibility(View.VISIBLE);
                launchAppButton.setAlpha(0);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void setBackButtonOnClickListener() {
        this.backButton.setOnClickListener(view -> {
            slideViewPager.setCurrentItem(currentPagePosition - 1);
        });
    }

    private void setNextButtonOnClickListener() {
        this.nextButton.setOnClickListener(view -> {
            slideViewPager.setCurrentItem(currentPagePosition + 1);
        });
    }

    private void setLaunchAppButtonOnClickListener() {
        this.launchAppButton.setOnClickListener(view -> {
            openPasswordActivity();
        });
    }
}
