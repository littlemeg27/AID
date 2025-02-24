package com.example.fragments;

import com.example.fragments.model.Student;
import java.util.ArrayList;
import java.util.List;

public class DataManager
{
    private static final List<Student> people = new ArrayList<>();

    public static void addPerson(Student student)
    {
        people.add(student);
    }

    public static List<Student> getPeople()
    {
        return people;
    }
}