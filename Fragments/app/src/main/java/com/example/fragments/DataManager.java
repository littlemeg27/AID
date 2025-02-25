package com.example.fragments;

import java.util.ArrayList;
import java.util.List;

public class DataManager
{
    private static final List<Person> people = new ArrayList<>();

    public static void addPerson(Person person)
    {
        people.add(person);
    }

    public static List<Person> getPeople()
    {
        return people;
    }

    public static void clear()
    {
        people.clear();
    }
}