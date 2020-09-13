package com.example.appforgridview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MyOptionGridAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    private List<String> optionList;
    private List<Integer> imagePhotoList;

    private ImageView imageView;
    private RadioButton radioButton;

    private MyOptionGridAdapter.SingleButtonOnClickListener singleButtonOnClickListener;

    // test
    private List<RadioButton> itemRadioButtonList;

    public MyOptionGridAdapter(Context context, List<String> optionList, List<Integer> imagePhotoList) {
        this.context = context;
        this.optionList = optionList;
        this.imagePhotoList = imagePhotoList;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemRadioButtonList = new ArrayList<>();
    }

    public interface SingleButtonOnClickListener{
        void onSingleButtonClick(int position);
    }
    public void setOnSingleButtonOnClickListenerClickListener(MyOptionGridAdapter.SingleButtonOnClickListener singleButtonOnClickListener){
        this.singleButtonOnClickListener = singleButtonOnClickListener;
    }

    @Override
    public int getCount() {
        return optionList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_item, parent, false);
        }

        imageView = convertView.findViewById(R.id.img_grid_item);
        imageView.setImageResource(imagePhotoList.get(position));

        // set radio Button
        radioButton = convertView.findViewById(R.id.rb_grid_item);
        radioButton.setText(optionList.get(position));
        radioButton.setOnClickListener(v -> singleButtonOnClickListener.onSingleButtonClick(position));
        if ((position != 0) || itemRadioButtonList.isEmpty()){
            itemRadioButtonList.add(radioButton);
        }


        return convertView;
    }

    public List<RadioButton> getItemRadioButtonList() {
        return itemRadioButtonList;
    }
}
