package com.example.progressbarapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    //init XML Views
    ProgressBar progressBar,progressBar_circular;
    MaterialButton addMeBtn;
    MaterialButton minusMeBtn;

    //int variable for update progress by 20
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //finding views and connecting to Java Code
        progressBar = findViewById(R.id.progressBar);
       progressBar_circular = findViewById(R.id.progressBar2);
        addMeBtn = findViewById(R.id.addMeBtn);
        minusMeBtn = findViewById(R.id.minusMeBtn);

        //Handle click event on addMeBtn
        addMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                update progress by 20
                progress = progress+20;
                //setting progress to ProgressBar
                progressBar.setProgress(progress);

                //setting visibility as VISIBLE
                progressBar_circular.setVisibility(View.VISIBLE);
            }
        });

        //Handle click event on addMeBtn
        minusMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // update progress by 20
                progress = progress-20;
                //setting progress to ProgressBar
                progressBar.setProgress(progress);

                //setting visibility as GONE
                progressBar_circular.setVisibility(View.GONE);
            }
        });
    }
}