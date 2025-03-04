package com.example.fauxcrudapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class FormFragment extends Fragment
{
    private EditText nameInput, quantityInput;
    private CheckBox checkboxVegetarian, checkboxGlutenFree, checkboxVegan, checkboxPescatarian;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((FormActivity) requireActivity()).setSupportActionBar(toolbar);

        nameInput = view.findViewById(R.id.name_input);
        quantityInput = view.findViewById(R.id.quantity_input);
        checkboxVegetarian = view.findViewById(R.id.checkbox_vegetarian);
        checkboxGlutenFree = view.findViewById(R.id.checkbox_gluten_free);
        checkboxVegan = view.findViewById(R.id.checkbox_vegan);
        checkboxPescatarian = view.findViewById(R.id.checkbox_pescatarian);

        return view;
    }

    public void saveItem()
    {
        String name = nameInput.getText().toString().trim();
        String quantityStr = quantityInput.getText().toString().trim();

        // Get selected category (only one checkbox can be selected for simplicity)
        String category = "";
        if (checkboxVegetarian.isChecked())
        {
            category = getString(R.string.category_vegetarian);
        }
        else if (checkboxGlutenFree.isChecked())
        {
            category = getString(R.string.category_gluten_free);
        }
        else if (checkboxVegan.isChecked())
        {
            category = getString(R.string.category_vegan);
        } else if (checkboxPescatarian.isChecked())
        {
            category = getString(R.string.category_pescatarian);
        }

        if (!name.isEmpty() && !category.isEmpty() && !quantityStr.isEmpty())
        {
            try
            {
                int quantity = Integer.parseInt(quantityStr);
                Item item = new Item(name, category, quantity);
                Intent result = new Intent();
                result.putExtra("ITEM", item);
                requireActivity().setResult(android.app.Activity.RESULT_OK, result);
                Log.d("FormFragment", "Saved item: " + item); // Removed toString()
                requireActivity().finish();
            }
            catch (NumberFormatException e)
            {
                Log.e("FormFragment", "Invalid quantity: " + quantityStr, e);
            }
        } else {
            Log.w("FormFragment", "Empty fields detected");
        }
    }
}