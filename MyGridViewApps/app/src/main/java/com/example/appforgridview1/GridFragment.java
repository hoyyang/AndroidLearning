package com.example.appforgridview1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class GridFragment extends Fragment {
    private View view;

    private List<String> optionList;
    private List<Integer> imageList;

    private GridView gridView;

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
        this.optionList = new ArrayList<>();
        this.optionList.add("option1");
        this.optionList.add("option2");
        this.optionList.add("option3");
        this.optionList.add("option4");

        this.imageList = new ArrayList<>();
        this.imageList.add(R.drawable.img_g);
        this.imageList.add(R.drawable.img_g);
        this.imageList.add(R.drawable.img_g);
        this.imageList.add(R.drawable.img_g);
    }

    private void initializeViews() {
        this.gridView = view.findViewById(R.id.grid_view);
    }

    private void showGrid() {
        MyOptionGridAdapter myOptionGridAdapter = new MyOptionGridAdapter(requireContext(), optionList, imageList);
        gridView.setAdapter(myOptionGridAdapter);
    }

    private void setGridItemOnClickListener() {
        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(requireContext(), "the option is : " + optionList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
