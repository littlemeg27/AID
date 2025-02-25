package com.example.fragments;

public class Student extends Person
{
    private final String grade;

    public Student(String name, String university, String id, String grade)
    {
        super(name, university, id);
        this.grade = grade;
    }

    @Override
    public String getType()
    {
        return "Student";
    }
}