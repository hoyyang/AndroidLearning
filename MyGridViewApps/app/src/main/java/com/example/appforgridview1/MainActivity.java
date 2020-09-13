package com.example.appforgridview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button = findViewById(R.id.btn_open);
    }

    public void openFragment(View view){
        this.button.setVisibility(View.INVISIBLE);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragments, new GridFragment(), "grid").commit();
    }
}
