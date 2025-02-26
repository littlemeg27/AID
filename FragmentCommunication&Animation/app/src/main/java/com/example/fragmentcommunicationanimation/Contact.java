package com.example.fragmentcommunicationanimation;

import java.io.Serializable;

public class Contact implements Serializable
{
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhoneNumber() { return phoneNumber; }

    @Override
    public String toString()
    {
        return firstName + " " + lastName;
    }
}