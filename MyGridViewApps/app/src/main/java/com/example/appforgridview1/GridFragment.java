package com.example.appforgridview1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class GridFragment extends Fragment {
    private View view;

    private List<String> nameList;
    private List<Integer> imageList;

    GridView gridView;

    public GridFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the View for this fragment
        this.view = inflater.inflate(R.layout.fragment_grid, container, false);

        // initialize Data
        this.initializeData();
        // initialize Views
        this.initializeViews();

        // show grid
        this.showGrid();

        return this.view;
    }

    // initialize Data
    private void initializeData() {
        this.nameList = new ArrayList<>();
        this.nameList.add("name1");
        this.nameList.add("name2");
        this.nameList.add("name3");

        this.imageList = new ArrayList<>();
        this.imageList.add(R.drawable.ic_image_black_24dp);
        this.imageList.add(R.drawable.ic_image_black_24dp);
        this.imageList.add(R.drawable.ic_image_black_24dp);
    }

    private void initializeViews() {
        gridView = view.findViewById(R.id.grid_view);
    }

    private void showGrid() {
        MyOptionGridAdapter myOptionGridAdapter = new MyOptionGridAdapter(requireContext(), nameList, imageList);
        gridView.setAdapter(myOptionGridAdapter);
    }
}
