package com.example.fragments;

// Brenna Pavlinchak
// AID - C202502
// Teacher

public class Teacher extends Person
{
    private final String course;

    public Teacher(String name, String university, String id, String course)
    {
        super(name, university, id);
        this.course = course;
    }

    @Override
    public String getType()
    {
        return "Teacher";
    }
}