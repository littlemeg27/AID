package com.example.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class StudentFormFragment extends Fragment
{
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
            String university = universityInput.getText().toString().trim();
            String id = idInput.getText().toString().trim();
            String grade = gradeInput.getText().toString().trim();

            if (!name.isEmpty() && !university.isEmpty() && !id.isEmpty() && !grade.isEmpty())
            {
                Student student = new Student(name, university, id, grade);
                DataManager.addPerson(student);
                Log.d("StudentForm", "Added student: " + student.toString());
                nameInput.setText("");
                universityInput.setText("");
                idInput.setText("");
                gradeInput.setText("");
                refreshList();
            }
            else
            {
                Log.d("StudentForm", "Empty fields detected");
            }
        });

        return view;
    }

    private void refreshList()
    {
        Fragment listFragment = getParentFragmentManager().findFragmentById(R.id.list_fragment_container);
        if (listFragment instanceof PeopleListFragment)
        {
            ((PeopleListFragment) listFragment).refreshList();
            Log.d("StudentForm", "Refresh called");
        }
        else
        {
            Log.d("StudentForm", "ListFragment not found");
        }
    }
}