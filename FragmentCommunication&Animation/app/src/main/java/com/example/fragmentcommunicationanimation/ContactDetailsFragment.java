package com.example.fragmentcommunicationanimation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ContactDetailsFragment extends Fragment
{
    private static final String ARG_CONTACT = "contact";
    private Contact contact;

    public static ContactDetailsFragment newInstance(Contact contact)
    {
        ContactDetailsFragment fragment = new ContactDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CONTACT, contact);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            contact = (Contact) getArguments().getSerializable(ARG_CONTACT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_contact_details, container, false);

        TextView nameText = view.findViewById(R.id.name_text);
        TextView phoneText = view.findViewById(R.id.phone_text);
        Button backButton = view.findViewById(R.id.back_button);

        String formatString = getString(R.string.contact_name_format);
        nameText.setText(String.format(formatString, contact.getFirstName(), contact.getLastName()));
        phoneText.setText(contact.getPhoneNumber());

        backButton.setOnClickListener(v ->
        {
            if (getActivity() instanceof ContactDetailsListener)
            {
                ContactDetailsListener listener = (ContactDetailsListener) getActivity();
                listener.onBackFromDetails();
            }
        });

        return view;
    }
}