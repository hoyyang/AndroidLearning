package com.example.appforgridview1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioButton;
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
    private MyOptionGridAdapter myOptionGridAdapter;
    private Button submitButton;

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
        // set SingleButton OnClickListener
        this.setSingleButtonOnClickListener();

        // set submit Button OnClickListener
        this.setSubmitButtonOnClickListener();

        return this.view;
    }

    // initialize Data
    private void initializeData() {
        this.optionList = new ArrayList<>();
        this.optionList.add("option1");
        this.optionList.add("option2");
        this.optionList.add("option3");
        this.optionList.add("option4");
        this.optionList.add("option5");

        this.imageList = new ArrayList<>();
        this.imageList.add(R.drawable.img_g);
        this.imageList.add(R.drawable.img_g);
        this.imageList.add(R.drawable.img_g);
        this.imageList.add(R.drawable.img_g);
        this.imageList.add(R.drawable.img_g);
    }

    private void initializeViews() {
        this.gridView = view.findViewById(R.id.grid_view);
        this.submitButton = view.findViewById(R.id.btn_submit);
    }

    private void showGrid() {
        myOptionGridAdapter = new MyOptionGridAdapter(requireContext(), optionList, imageList);
        gridView.setAdapter(myOptionGridAdapter);
    }

    private void setSingleButtonOnClickListener() {
        this.myOptionGridAdapter.setOnSingleButtonOnClickListenerClickListener(position -> {
            // set all radio button checked false
            setCheckedRadioButtonFalse();
            // test
            System.out.println("[ click position: ] " + position);
            // set clicked radio button checked true
            List<RadioButton> itemRadioButtonList = myOptionGridAdapter.getItemRadioButtonList();
            if ((itemRadioButtonList != null) || (!itemRadioButtonList.isEmpty())){
                RadioButton radioButton = itemRadioButtonList.get(position);
                radioButton.setChecked(true);
            }
        });
    }

    private void setCheckedRadioButtonFalse() {
        for (RadioButton rb : myOptionGridAdapter.getItemRadioButtonList()) {
            if (rb.isChecked()){
                rb.setChecked(false);
            }
        }
    }

    private void setSubmitButtonOnClickListener() {
        this.submitButton.setOnClickListener(view -> {
            String optionText = "";
            for (RadioButton rb : myOptionGridAdapter.getItemRadioButtonList()) {
                if (rb.isChecked()){
                    optionText = rb.getText().toString();
                }
            }
            if (optionText.isEmpty()){
                Toast.makeText(requireContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
            } else {
                for (int i = 0; i < optionList.size(); i++) {
                    if (optionList.get(i).equals(optionText)){
                        Toast.makeText(requireContext(), "option no: [" + i + "]", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
