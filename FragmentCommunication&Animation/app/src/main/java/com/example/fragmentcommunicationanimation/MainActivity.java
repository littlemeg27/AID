package com.example.fragmentcommunicationanimation;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactFormListener, ContactDetailsListener
{
    private FloatingActionButton fab;
    private List<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);

        if (savedInstanceState == null)
        {
            loadInitialFragment();
        }

        fab.setOnClickListener(v ->
        {
            Fragment formFragment = new ContactFormFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.fragment_container, formFragment)
                    .addToBackStack(null)
                    .commit();
            fab.hide();
        });
    }

    public List<Contact> getContacts()
    {
        return contacts;
    }

    private void loadInitialFragment()
    {
        Fragment initialFragment = contacts.isEmpty() ? new EmptyStateFragment() : new ContactListFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, initialFragment)
                .commit();
    }

    @Override
    public void onContactAdded(String firstName, String lastName, String phoneNumber)
    {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contacts.add(contact);
        loadInitialFragment();
        getSupportFragmentManager().popBackStack();
        fab.show();
    }

    @Override
    public void onBackFromDetails()
    {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onBackPressed()
    {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        if (currentFragment instanceof ContactFormFragment || currentFragment instanceof ContactDetailsFragment)
        {
            fab.show();
        }
        super.onBackPressed();
    }
}