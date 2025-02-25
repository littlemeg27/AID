package com.example.fragments;

import android.os.Bundle;
import android.util.Log; // Added for debugging
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.ListFragment;

public class PeopleListFragment extends ListFragment
{
    private ArrayAdapter<Person> adapter;
    private TextView emptyText;

    @Override
    public void onCreate(Bundle savedInstanceState)
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
        return inflater.inflate(R.layout.fragment_people_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        emptyText = view.findViewById(R.id.empty_text);
        updateEmptyState();
    }

    public void refreshList()
    {
        adapter.notifyDataSetChanged();
        updateEmptyState();
        Log.d("PeopleList", "List refreshed, size: " + DataManager.getPeople().size());
    }

    private void updateEmptyState()
    {
        if (emptyText != null)
        {
            if (DataManager.getPeople().isEmpty())
            {
                emptyText.setVisibility(View.VISIBLE);
                getListView().setVisibility(View.GONE);
            }
            else
            {
                emptyText.setVisibility(View.GONE);
                getListView().setVisibility(View.VISIBLE);
            }
        }
    }
}