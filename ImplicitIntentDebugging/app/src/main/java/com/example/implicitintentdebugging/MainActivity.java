package com.example.implicitintentdebugging;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent("com.example.ACTION_ADD_ITEM"); 
        startActivity(intent);
        finish();
    }
}

