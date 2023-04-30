package com.ineuc.model;

public class Activity {

    String id;
    String description;
    Integer timeSpent;

    /* TODO ADD relations with ActivityType and User */

    public Activity() {

    }

    public Activity(String id, String description, Integer timeSpent) {
        this.id = id;
        this.description = description;
        this.timeSpent = timeSpent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Integer timeSpent) {
        this.timeSpent = timeSpent;
    }

}
