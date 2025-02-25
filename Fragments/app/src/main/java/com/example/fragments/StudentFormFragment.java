package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class StudentFormFragment extends Fragment
{
    private static final String TAG = "StudentFormFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_student_form, container, false);

        EditText nameInput = view.findViewById(R.id.name_input);
        EditText universityInput = view.findViewById(R.id.university_input);
        EditText idInput = view.findViewById(R.id.id_input);
        EditText gradeInput = view.findViewById(R.id.grade_input);
        Button submitButton = view.findViewById(R.id.submit_button);

        submitButton.setOnClickListener(v ->
        {
            String name = nameInput.getText().toString().trim();
            if (!name.isEmpty() && !universityInput.getText().toString().trim().isEmpty() && !idInput.getText().toString().trim().isEmpty() && !gradeInput.getText().toString().trim().isEmpty())
            {
                Student student = new Student(
                        name,
                        universityInput.getText().toString(),
                        idInput.getText().toString(),
                        gradeInput.getText().toString()
                );
                DataManager.addPerson(student);
                nameInput.setText("");
                universityInput.setText("");
                idInput.setText("");
                gradeInput.setText("");
                refreshList();
            }
        });

        return view;
    }

    private void refreshList()
    {
        Fragment listFragment = getParentFragmentManager().findFragmentById(R.id.list_fragment_container);
        if (listFragment instanceof PeopleListFragment)
        {
            PeopleListFragment peopleListFragment = (PeopleListFragment) listFragment;
            peopleListFragment.refreshList();
        }
    }
}