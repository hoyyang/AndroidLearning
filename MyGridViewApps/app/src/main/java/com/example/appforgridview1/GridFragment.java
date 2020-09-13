package com.example.appforgridview1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

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
        //set Grid Item On Click Listener
        this.setGridItemOnClickListener();

        return this.view;
    }

    // initialize Data
    private void initializeData() {
        this.nameList = new ArrayList<>();
        this.nameList.add("name1");
        this.nameList.add("name2");
        this.nameList.add("name3");
        this.nameList.add("name4");

        this.imageList = new ArrayList<>();
        this.imageList.add(R.drawable.img_g);
        this.imageList.add(R.drawable.img_g);
        this.imageList.add(R.drawable.img_g);
        this.imageList.add(R.drawable.img_g);
    }

    private void initializeViews() {
        gridView = view.findViewById(R.id.grid_view);
    }

    private void showGrid() {
        MyOptionGridAdapter myOptionGridAdapter = new MyOptionGridAdapter(requireContext(), nameList, imageList);
        gridView.setAdapter(myOptionGridAdapter);
    }

    private void setGridItemOnClickListener() {
        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(requireContext(), "the name is : " + nameList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
