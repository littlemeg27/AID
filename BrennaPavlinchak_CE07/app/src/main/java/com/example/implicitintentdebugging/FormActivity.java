package com.example.implicitintentdebugging;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FormActivity extends AppCompatActivity
{
    private EditText nameInput, descriptionInput, quantityInput;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameInput = findViewById(R.id.name_input);
        descriptionInput = findViewById(R.id.description_input);
        quantityInput = findViewById(R.id.quantity_input);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.form_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.action_save)
        {
            String name = nameInput.getText().toString().trim();
            String description = descriptionInput.getText().toString().trim();
            String quantityStr = quantityInput.getText().toString().trim();

            if (!name.isEmpty() && !description.isEmpty() && !quantityStr.isEmpty())
            {
                Intent result = new Intent();
                result.putExtra("EXTRA_NAME", name);
                result.putExtra("EXTRA_DESCRIPTION", description);
                result.putExtra("EXTRA_QUANTITY", Integer.parseInt(quantityStr));
                setResult(RESULT_OK, result);
                finish();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
