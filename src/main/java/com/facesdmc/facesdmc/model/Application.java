package com.facesdmc.facesdmc.model;

public class Application {
    private String name;
    private String surname;
    private String email;
    private int age;
    private String homeAddress;
    private String universityApplied;
    private double budget;
    private String dateOfArrival;
    private String countryOfResidence;

    public Application() {}

    // Getters and setters for each field
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getHomeAddress() { return homeAddress; }
    public void setHomeAddress(String homeAddress) { this.homeAddress = homeAddress; }
    public String getUniversityApplied() { return universityApplied; }
    public void setUniversityApplied(String universityApplied) { this.universityApplied = universityApplied; }
    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }
    public String getDateOfArrival() { return dateOfArrival; }
    public void setDateOfArrival(String dateOfArrival) { this.dateOfArrival = dateOfArrival; }
    public String getCountryOfResidence() { return countryOfResidence; }
    public void setCountryOfResidence(String countryOfResidence) { this.countryOfResidence = countryOfResidence; }
}
