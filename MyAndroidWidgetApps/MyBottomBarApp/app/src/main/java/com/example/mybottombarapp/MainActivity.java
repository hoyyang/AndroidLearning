package com.example.virussafeagro;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

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

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private MainActivity mainActivity = this;

    // toolbar
    private Toolbar toolbar;
    // bottom bar
    private BottomAppBar bottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // initialize Views
        this.initializeViews();

    }

    private void initializeViews() {
        this.toolbar = findViewById(R.id.toolbar);
        this.bottomAppBar = findViewById(R.id.bottom_app_bar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.displayAllMainActivityViews();

    }

    private void displayAllMainActivityViews() {
        // configure toolbar
        this.configureToolbar();
        // initialize bottom navigation bar
        this.initializeBottomNavigationView();
    }

    // add toolbar
    private void configureToolbar() {
        setSupportActionBar(this.toolbar);
    }


    // initialize BottomNavigationView and set OnNavigationItemSelectedListener
    private void initializeBottomNavigationView(){
//        this.bottomNavigationView.setOnNavigationItemSelectedListener(this);
        this.bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                // open fragment according to id
                switchFragments(id);
                return true;
            }
        });
    }


    private void switchFragments(int itemId) {

    }

}
