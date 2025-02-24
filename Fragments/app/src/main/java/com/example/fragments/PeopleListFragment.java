package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

public class PeopleListFragment extends ListFragment
{
    private static final String TAG = "PeopleListFragment";

    @Override
    public void onCreate(@NonNull Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_list_item_1,
                DataManager.getPeople());
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if (DataManager.getPeople().isEmpty())
        {
            return inflater.inflate(R.layout.fragment_empty_state, container, false);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void refreshList()
    {
        adapter.notifyDataSetChanged();

        if (DataManager.getPeople().isEmpty())
        {
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.list_fragment_container, new EmptyStateFragment())
                    .commit();
        }
    }
}