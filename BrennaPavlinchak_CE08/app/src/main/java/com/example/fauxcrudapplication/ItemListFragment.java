package com.example.fauxcrudapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

public class ItemListFragment extends ListFragment
{
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter<Item> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_list_item_1, DataManager.getItems());
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id)
    {
        ArrayAdapter<Item> adapter = (ArrayAdapter<Item>) getListAdapter();
        if (adapter != null)
        {
            Item item = adapter.getItem(position);
            if (item != null)
            {
                ((ListActivity) requireActivity()).startDetailActivity(item);
            }
        }
    }
}