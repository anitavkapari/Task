package com.example.dell.task.model;

public class Users {

    private  String members;
    private  String description;
    private  String name;


    public Users(String members, String description, String name) {
        this.members = members;
        this.description = description;
        this.name = name;
    }
    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
