package com.example.androidlayouts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

// Brenna Pavlinchak
// AID - C202502
// MainActivity 


public class MainActivity extends AppCompatActivity
{
    Button buttonToggle;
    private View linearLayout;
    private View constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout);
        constraintLayout = findViewById(R.id.constraintLayout);

        Button buttonToggleLayout = findViewById(R.id.buttonToggleLayout);
        buttonToggleLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                toggleLayout();
            }
        });

        buttonToggle = findViewById(R.id.buttonToggleLayout);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);

        buttonToggleLayout.setOnClickListener(view ->
        {
            if (linearLayout.getVisibility() == View.VISIBLE)
            {
                linearLayout.setVisibility(View.GONE);
                constraintLayout.setVisibility(View.VISIBLE);
                buttonToggleLayout.setText("Linear Layout");
            }
            else
            {
                linearLayout.setVisibility(View.VISIBLE);
                constraintLayout.setVisibility(View.GONE);
                buttonToggleLayout.setText("Constraint Layout");
            }
        });
    }

    private void toggleLayout()
    {
        if (linearLayout.getVisibility() == View.VISIBLE)
        {
            linearLayout.setVisibility(View.GONE);
            constraintLayout.setVisibility(View.VISIBLE);
        }
        else
        {
            linearLayout.setVisibility(View.VISIBLE);
            constraintLayout.setVisibility(View.GONE);
        }
    }
}