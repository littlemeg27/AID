package com.example.implicitintentdebugging;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView nameText = findViewById(R.id.name_text);
        TextView descriptionText = findViewById(R.id.description_text);
        TextView quantityText = findViewById(R.id.quantity_text);

        Intent intent = getIntent();
        if (intent != null)
        {
            Bundle extras = intent.getExtras();
            if (extras != null)
            {
                for (String key : extras.keySet())
                {
                    android.util.Log.d("DetailActivity", "Extra key: " + key + ", value: " + extras.get(key));
                }
            }

            // Placeholder keys, to be updated
            String name = intent.getStringExtra("EXTRA_NAME");
            String description = intent.getStringExtra("EXTRA_DESCRIPTION");
            int quantity = intent.getIntExtra("EXTRA_QUANTITY", -1);

            nameText.setText(name != null ? name : "Unknown");
            descriptionText.setText(description != null ? description : "Unknown");
            quantityText.setText(quantity != -1 ? String.valueOf(quantity) : "Unknown");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.action_delete)
        {
            Intent result = new Intent();
            Intent originalIntent = getIntent();
            result.putExtras(originalIntent.getExtras());
            setResult(RESULT_OK, result);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}