package com.example.fauxcrudapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ListActivity extends AppCompatActivity
{
    private static final int REQUEST_ADD = 1;
    private static final int REQUEST_DELETE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        findViewById(R.id.fab).setOnClickListener(v -> startFormActivity());

        if (savedInstanceState == null)
        {
            updateFragment();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null)
        {
            if (requestCode == REQUEST_ADD)
            {
                Item item = (Item) data.getSerializableExtra("ITEM");
                if (item != null)
                {
                    DataManager.addItem(item);
                }
            }
            else if (requestCode == REQUEST_DELETE)
            {
                Item item = (Item) data.getSerializableExtra("ITEM");
                if (item != null)
                {
                    DataManager.deleteItem(item);
                }
            }
            updateFragment();
        }
    }

    public void startFormActivity()
    {
        Intent intent = new Intent(this, FormActivity.class);
        startActivityForResult(intent, REQUEST_ADD);
    }

    public void startDetailActivity(Item item)
    {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("ITEM", item);
        startActivityForResult(intent, REQUEST_DELETE);
    }

    private void updateFragment()
    {
        Fragment fragment = DataManager.getItems().isEmpty() ?
                new EmptyFragment() : new ItemListFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}