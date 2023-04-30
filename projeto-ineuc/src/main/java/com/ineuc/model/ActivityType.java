package com.ineuc.model;

public class ActivityType {

    String id;
    String name;
    
    /* ADD relation with Activity */

    public ActivityType() {

    }

    public ActivityType(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
