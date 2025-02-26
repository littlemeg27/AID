package com.example.fragments;

// Brenna Pavlinchak
// AID - C202502
// Administrator

public class Administrator extends Person
{
    private final String program;

    public Administrator(String name, String university, String id, String program)
    {
        super(name, university, id);
        this.program = program;
    }

    @Override
    public String getType()
    {
        return "Administrator";
    }
}