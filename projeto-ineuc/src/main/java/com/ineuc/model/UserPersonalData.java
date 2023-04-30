package com.ineuc.model;

public class UserPersonalData {

    String id;
    String Name;
    String lastName;
    String DateOfBirth;

    public UserPersonalData() {

    }

    public UserPersonalData(String id, String name, String lastName, String dateOfBirth) {
        this.id = id;
        Name = name;
        this.lastName = lastName;
        DateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

}
