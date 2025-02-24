package com.example.playstorepage;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

// Brenna Pavlinchak
// AID - C202502
// MainActivity

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private ReviewAdapter reviewAdapter;
    private List<Review> reviewList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        reviewList = new ArrayList<>();
        reviewAdapter = new ReviewAdapter(reviewList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(reviewAdapter);

        // Add reviews directly; no need to call setReviews again
        reviewList.add(new Review("User 1", "Awesome app", 5, "2025-02-16", "I love using this app!"));
        reviewList.add(new Review("User 2", "Not bad", 3, "2025-02-15", "It works fine, but could be better."));
        reviewList.add(new Review("User 3", "Terrible", 1, "2025-02-14", "App crashes all the time!"));

        reviewAdapter.notifyDataSetChanged(); // Notify adapter of data changes
    }
}