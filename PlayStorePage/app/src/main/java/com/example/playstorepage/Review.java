package com.example.playstorepage;

// Brenna Pavlinchak
// AID - C202502
// Review

public class Review
{
    private String reviewText;
    private String userName;
    private int rating;
    private String reviewDate;
    private String title;

    // Constructor with all fields
    public Review(String userName, String title, int rating, String reviewDate, String reviewText)
    {
        this.userName = userName;
        this.title = title;
        this.rating = rating;
        this.reviewDate = reviewDate;
        this.reviewText = reviewText;
    }

    public Review(String reviewText, int rating)
    {
        this.reviewText = reviewText;
        this.rating = rating;
        this.userName = "Unknown";
        this.reviewDate = "Unknown";
        this.title = "No Title";
    }

    // Getter methods
    public String getReviewText()
    {
        return reviewText;
    }

    public String getUserName()
    {
        return userName;
    }

    public int getRating()
    {
        return rating;
    }

    public String getReviewDate()
    {
        return reviewDate;
    }

    public String getTitle()
    {
        return title;
    }
}
