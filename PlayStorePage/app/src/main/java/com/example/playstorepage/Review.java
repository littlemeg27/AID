package com.example.playstorepage;

// Brenna Pavlinchak
// AID - C202502
// Review

public class Review
{
    private String userName;
    private int rating;
    private String reviewDate;
    private String title;
    private String reviewText;

    public Review(String userName, int rating, String reviewDate, String title,  String reviewText)
    {
        this.userName = userName;
        this.rating = rating;
        this.reviewDate = reviewDate;
        this.title = title;
        this.reviewText = reviewText;
    }

    public Review(String reviewText, int rating)
    {
        this.userName = "Unknown";
        this.rating = rating;
        this.reviewDate = "Unknown";
        this.title = "No Title";
        this.reviewText = reviewText;
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
