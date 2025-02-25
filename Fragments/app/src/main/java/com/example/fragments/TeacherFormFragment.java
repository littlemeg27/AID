package com.example.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class TeacherFormFragment extends Fragment
{
    private static final String TAG = "TeacherFormFragment";

    public TeacherFormFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_teacher_form, container, false);

        EditText nameInput = view.findViewById(R.id.name_input);
        EditText universityInput = view.findViewById(R.id.university_input);
        EditText idInput = view.findViewById(R.id.id_input);
        EditText courseInput = view.findViewById(R.id.course_input);
        Button submitButton = view.findViewById(R.id.submit_button);

        submitButton.setOnClickListener(v ->
        {
            String name = nameInput.getText().toString().trim();
            String university = universityInput.getText().toString().trim();
            String id = idInput.getText().toString().trim();
            String course = courseInput.getText().toString().trim();

            if (!name.isEmpty() && !university.isEmpty() && !id.isEmpty() && !course.isEmpty())
            {
                Teacher teacher = new Teacher(name, university, id, course);
                DataManager.addPerson(teacher);
                Log.d(TAG, "Teacher added: " + name);

                nameInput.setText("");
                universityInput.setText("");
                idInput.setText("");
                courseInput.setText("");

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
            ((PeopleListFragment) listFragment).refreshList();
        }
    }
}