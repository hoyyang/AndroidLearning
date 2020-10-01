package com.example.mybottombarapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.mybottombarapp.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private MainActivity mainActivity = this;

    // toolbar
    private Toolbar toolbar;
    // bottom bar
//    private BottomNavigationView bottomNavigationView;
    private BottomNavigationViewEx bottomNavigationViewEx;
    private FloatingActionButton floatingActionButton;
<<<<<<< HEAD
    private RelativeLayout calculatorRelativeLayout;
    private RelativeLayout moreRelativeLayout;
=======
>>>>>>> master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize Views
        this.initializeViews();

        initEvent();

    }

    private void initializeViews() {
        this.toolbar = findViewById(R.id.toolbar);
        this.bottomNavigationViewEx = findViewById(R.id.bottom_navigation);
        this.floatingActionButton = findViewById(R.id.fab);
<<<<<<< HEAD
        this.calculatorRelativeLayout = findViewById(R.id.rl_calculator);
        this.moreRelativeLayout = findViewById(R.id.rl_more);
=======
>>>>>>> master
    }


    @Override
    protected void onResume() {
        super.onResume();

        this.displayAllMainActivityViews();

        this.bottom();
<<<<<<< HEAD
    }

    private void bottom() {
        this.bottomNavigationViewEx.enableItemShiftingMode(false);
        this.bottomNavigationViewEx.enableShiftingMode(false);
//        this.bottomNavigationViewEx.setTextVisibility(false);
        this.bottomNavigationViewEx.setIconSize(30, 30);
//        this.bottomNavigationViewEx.enableAnimation(false);
//        this.bottomNavigationViewEx.setIconSizeAt(R.id.ic_virus_check, 150, 150);
    }

    /**
     * init BottomNavigationViewEx envent
     */
    @SuppressLint("ResourceAsColor")
=======
    }

    private void bottom() {
        this.bottomNavigationViewEx.enableItemShiftingMode(false);
        this.bottomNavigationViewEx.enableShiftingMode(false);
//        this.bottomNavigationViewEx.setTextVisibility(false);
        this.bottomNavigationViewEx.setIconSize(30, 30);
//        this.bottomNavigationViewEx.enableAnimation(false);
//        this.bottomNavigationViewEx.setIconSizeAt(R.id.ic_virus_check, 150, 150);
    }

    /**
     * init BottomNavigationViewEx envent
     */
>>>>>>> master
    private void initEvent() {
        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            private int previousPosition = -1;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int position = 0;
                switch (item.getItemId()) {
//                    case R.id.home:
//                        position = 0;
//                        System.out.println("home");
////                        Toast.makeText(mainActivity, "learn1", Toast.LENGTH_SHORT).show();
//                        break;
                    case R.id.ic_learn:
                        position = 1;
                        System.out.println("learn");
//                        Toast.makeText(mainActivity, "learn2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ic_virus_check:
                        position = 2;
//                        Toast.makeText(mainActivity, "learn3", Toast.LENGTH_SHORT).show();
//                    case R.id.ic_calculator:
//                        position = 3;
//                        System.out.println("ca");
////                        Toast.makeText(mainActivity, "check", Toast.LENGTH_SHORT).show();
//                        break;
                    case R.id.ic_toolkit: {
                        position = 4;
                        System.out.println("toolkit");
//                        Toast.makeText(mainActivity, "more", Toast.LENGTH_SHORT).show();
                    }
                    default:
                        break;
                }
                return true;
            }
        });

        floatingActionButton.setOnClickListener(view -> {
            bottomNavigationViewEx.setCurrentItem(1);
        });
<<<<<<< HEAD

        calculatorRelativeLayout.setOnClickListener(v -> {
            v.setActivated(!v.isActivated());
            if (v.isActivated()){
                findViewById(R.id.rl_calculator).setBackground(R.color.colorBlack);
            } else {
                findViewById(R.id.rl_calculator).setBackground(R.color.colorPrimaryDark);
            }
        });

        moreRelativeLayout.setOnClickListener(v -> {
            v.setActivated(!v.isActivated());
            if (v.isActivated()){
                findViewById(R.id.rl_more).setBackgroundColor(R.color.colorBlack);
            } else {
                findViewById(R.id.rl_more).setBackgroundColor(R.color.colorPrimaryDark);
            }
        });
=======
>>>>>>> master
    }



    private void displayAllMainActivityViews() {
        // configure toolbar
        this.configureToolbar();
        // initialize bottom navigation bar
//        this.initializeBottomNavigationView();
    }

    // add toolbar
    private void configureToolbar() {
        setSupportActionBar(this.toolbar);
    }


    // initialize BottomNavigationView and set OnNavigationItemSelectedListener
//    private void initializeBottomNavigationView(){
//        this.bottomNavigationView.setOnNavigationItemSelectedListener(this);
//    }


    private void switchFragments(int itemId) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        // open fragment according to id
        this.switchFragments(id);

        return true;
    }
}
