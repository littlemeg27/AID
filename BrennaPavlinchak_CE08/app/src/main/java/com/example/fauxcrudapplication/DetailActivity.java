package com.example.fauxcrudapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class DetailActivity extends AppCompatActivity
{
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        item = (Item) getIntent().getSerializableExtra("ITEM");

        if (savedInstanceState == null)
        {
            DetailFragment fragment = new DetailFragment();
            Bundle args = new Bundle();
            args.putSerializable("ITEM", item);
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        int id = menuItem.getItemId();

        if (id == R.id.action_delete)
        {
            new AlertDialog.Builder(this)
                    .setMessage(R.string.delete_prompt)
                    .setPositiveButton(R.string.delete_confirm, (dialog, which) ->
                    {
                        Intent result = new Intent();
                        result.putExtra("ITEM", this.item);
                        setResult(RESULT_OK, result);
                        Snackbar.make(findViewById(android.R.id.content), R.string.item_deleted, Snackbar.LENGTH_SHORT).show();
                        finish();
                    })
                    .setNegativeButton(R.string.cancel, null)
                    .show();
            return true;
        }
        else if (id == R.id.action_share)
        {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, this.item.getName() + ": " + this.item.getCategory() + ", Qty: " + this.item.getQuantity());
            startActivity(Intent.createChooser(shareIntent, "Share Item"));
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
