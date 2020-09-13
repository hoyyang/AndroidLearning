package com.example.appforgridview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class MyOptionGridAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    private List<String> imageNameList;
    private List<String> imagePhotoList;

    public MyOptionGridAdapter(Context context, List<String> imageNameList, List<String> imagePhotoList) {
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

        return null;
    }
}
