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

        reviewList.add(new Review("Jordan Michaels", 5,"2024-02-10", "Exceptional Experience!","Absolutely loved everything about this! The quality exceeded my expectations, and I will definitely return."));
        reviewList.add(new Review("Alexis Rivera", 3,"2023-11-23","Decent but Needs Improvement","It was okay overall. Some aspects were great, but there were a few noticeable flaws."));
        reviewList.add(new Review("Dwayne Carter", 4,"2024-01-15","Very Good, Almost Perfect", "Had a great experience! Just a few minor tweaks could make it even better."));
        reviewList.add(new Review("Samantha Lee", 2,"2023-09-05","Not What I Expected", "I had higher hopes, but unfortunately, this didn’t meet my expectations."));
        reviewList.add(new Review("Brian Thompson", 1,"2024-03-02","Very Disappointed", "Unfortunately, this was a letdown. I wouldn’t recommend it to others."));
        reviewList.add(new Review("Olivia Martinez", 5,"2023-12-18","Absolutely Amazing!", "Exceeded my expectations in every way! Highly recommend to everyone."));

        reviewAdapter.notifyDataSetChanged(); // Notify adapter of data changes
    }
}