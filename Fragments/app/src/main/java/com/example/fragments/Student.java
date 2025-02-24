package com.example.fragments;

public class Student
{
    private String name;
    private String university;
    private String id;
    private String grade;

    public Student(String name, String university, String id, String grade)
    {
        this.name = name;
        this.university = university;
        this.id = id;
        this.grade = grade;
    }

    // Getters (add setters if needed)
    public String getName() { return name; }
    public String getUniversity() { return university; }
    public String getId() { return id; }
    public String getGrade() { return grade; }

    @Override
    public String toString()
    {
        return name; // For display in PeopleListFragment
    }
}