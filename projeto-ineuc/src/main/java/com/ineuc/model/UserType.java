package com.ineuc.model;

public class UserType {

    String id;
    String userType; // TODO ENUM with userType values;

    public UserType() {

    }

    public UserType(String id, String userType) {
        this.id = id;
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
