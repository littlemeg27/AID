package com.example.fragmentcommunicationanimation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class ContactFormFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_contact_form, container, false);

        EditText firstNameInput = view.findViewById(R.id.first_name_input);
        EditText lastNameInput = view.findViewById(R.id.last_name_input);
        EditText phoneInput = view.findViewById(R.id.phone_input);
        Button submitButton = view.findViewById(R.id.submit_button);

        submitButton.setOnClickListener(v ->
        {
            String firstName = firstNameInput.getText().toString().trim();
            String lastName = lastNameInput.getText().toString().trim();
            String phoneNumber = phoneInput.getText().toString().trim();

            if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty())
            {
                Toast.makeText(getContext(), R.string.form_incomplete, Toast.LENGTH_SHORT).show();
            }
            else
            {
                ContactFormListener listener = (ContactFormListener) getActivity();
                listener.onContactAdded(firstName, lastName, phoneNumber);
            }
        });

        return view;
    }
}
