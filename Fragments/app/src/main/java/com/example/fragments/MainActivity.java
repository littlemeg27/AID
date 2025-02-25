package com.example.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity
{
    private static final String[] CATEGORIES =
            {
            "Student", "Teacher", "Administrator"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spinner = findViewById(R.id.category_spinner);
        Button refreshButton = findViewById(R.id.refresh_button);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, CATEGORIES);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.list_fragment_container, new PeopleListFragment())
                .replace(R.id.form_fragment_container, new StudentFormFragment())
                .commit();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Fragment formFragment;
                switch (position)
                {
                    case 0:
                        formFragment = new StudentFormFragment();
                        break;
                    case 1:
                        formFragment = new TeacherFormFragment();
                        break;
                    case 2:
                        formFragment = new AdministratorFormFragment();
                        break;
                    default:
                        return;
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.form_fragment_container, formFragment)
                        .commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // No action needed
            }
        });

        refreshButton.setOnClickListener(v ->
        {
            PeopleListFragment listFragment = (PeopleListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.list_fragment_container);
            if (listFragment != null)
            {
                listFragment.refreshList();
            }
        });
    }
}