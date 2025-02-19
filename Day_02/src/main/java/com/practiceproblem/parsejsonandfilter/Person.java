package com.practiceproblem.parsejsonandfilter;

public class Person {

    private String name;
    private String email;
    private int age;

    // Constructor (needed for object creation)
    public Person() {}

    // Getters (required for Jackson)
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
}
