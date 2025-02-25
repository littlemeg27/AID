package com.example.fragments;

public abstract class Person
{
    private final String name;
    private final String university;
    private final String id;

    public Person(String name, String university, String id)
    {
        this.name = name;
        this.university = university;
        this.id = id;
    }

    @Override
    public String toString()
    {
        return name + " | " + getType(); // Ensure name is included
    }

    public abstract String getType();
}