package com.example.fauxcrudapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((DetailActivity) requireActivity()).setSupportActionBar(toolbar);

        Item item = null;
        Bundle args = getArguments();
        if (args != null)
        {
            item = (Item) args.getSerializable("ITEM");
        }

        if (item != null)
        {
            TextView nameText = view.findViewById(R.id.name_text);
            TextView categoryText = view.findViewById(R.id.category_text);
            TextView quantityText = view.findViewById(R.id.quantity_text);

            nameText.setText(item.getName());
            categoryText.setText(item.getCategory());
            quantityText.setText(String.valueOf(item.getQuantity()));
        }

        return view;
    }
}