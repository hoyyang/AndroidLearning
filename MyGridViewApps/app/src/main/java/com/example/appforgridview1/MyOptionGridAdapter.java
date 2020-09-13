package com.example.appforgridview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyOptionGridAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    private List<String> imageNameList;
    private List<Integer> imagePhotoList;

    private TextView nameTextView;
    private ImageView imageView;

    public MyOptionGridAdapter(Context context, List<String> imageNameList, List<Integer> imagePhotoList) {
        this.context = context;
        this.imageNameList = imageNameList;
        this.imagePhotoList = imagePhotoList;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imagePhotoList.size();
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

        nameTextView = convertView.findViewById(R.id.tv_grid_item);
        imageView = convertView.findViewById(R.id.img_grid_item);

        nameTextView.setText(imageNameList.get(position));
        imageView.setImageResource(imagePhotoList.get(position));

        return convertView;
    }
}
