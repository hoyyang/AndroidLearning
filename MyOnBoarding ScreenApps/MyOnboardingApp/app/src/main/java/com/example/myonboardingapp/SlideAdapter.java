package com.example.myonboardingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private View view;

    private ImageView slideImageView;
    private TextView slideHeadingTextView;
    private TextView slideDescriptionTextView;

    // icon id Arrays
    public int[] slide_images = {
            R.drawable.icon1,
            R.drawable.icon2,
            R.drawable.icon3
    };
    // String heading Arrays
    public String[] slide_headings = {
            "First Heading",
            "Second Heading",
            "Third Heading"
    };
    // String description Arrays
    public String[] slide_descriptions = {
            "First - This this description 1\n This this description 1 This this description 1 \n This this description 1",
            "Second - This this description 2\n This this description 2 This this description 2 \n This this description 2",
            "Third - This this description 3\n This this description 3 This this description 3 \n This this description 3"
    };

    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        this.view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        this.initiateViews();
        this.setContentOfViewsByPosition(position);
        container.addView(this.view);

        return this.view;
    }

    private void initiateViews() {
        this.slideImageView = view.findViewById(R.id.img_page1);
        this.slideHeadingTextView = view.findViewById(R.id.tv_heading1);
        this.slideDescriptionTextView = view.findViewById(R.id.tv_desc1);
    }

    private void setContentOfViewsByPosition(int position) {
        this.slideImageView.setImageResource(this.slide_images[position]);
        this.slideHeadingTextView.setText(this.slide_headings[position]);
        this.slideDescriptionTextView.setText(this.slide_descriptions[position]);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
