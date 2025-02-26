package com.example.playstorepage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

// Brenna Pavlinchak
// AID - C202502
// ReviewAdapter

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>
{
    private List<Review> reviewList;

    public ReviewAdapter(List<Review> reviewList)
    {
        this.reviewList = reviewList;
    }

    public void setReviews(List<Review> reviews)
    {
        this.reviewList = reviews;
        notifyDataSetChanged();
    }

    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_review, parent, false);
        return new ReviewViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ReviewViewHolder holder, int position)
    {
        Review review = reviewList.get(position);
        holder.userNameTextView.setText(review.getUserName());
        holder.ratingTextView.setText(String.valueOf(review.getRating()));
        holder.reviewDateTextView.setText(review.getReviewDate());
        holder.reviewTitleTextView.setText(review.getTitle());
        holder.reviewTextTextView.setText(review.getReviewText());
    }

    @Override
    public int getItemCount()
    {
        return reviewList.size();
    }

    public static class ReviewViewHolder extends RecyclerView.ViewHolder
    {
        TextView userNameTextView;
        TextView ratingTextView;
        TextView reviewDateTextView;
        TextView reviewTitleTextView;
        TextView reviewTextTextView;

        public ReviewViewHolder(View itemView)
        {
            super(itemView);
            userNameTextView = itemView.findViewById(R.id.review_user);
            ratingTextView = itemView.findViewById(R.id.review_rating);
            reviewDateTextView = itemView.findViewById(R.id.review_date);
            reviewTitleTextView = itemView.findViewById(R.id.review_title);
            reviewTextTextView = itemView.findViewById(R.id.review_summary);
        }
    }
}