package com.company;

import java.util.regex.Pattern;

public class Lecturer extends Person {
    private String id;
    private String department;

    public void setId(String id) {
        if (!Pattern.matches("^\\d{8}$", id)){
            throw new IllegalArgumentException("Invalid lecture id");
        }
        this.id = id;
    }

    public void setDepartment(String department) {
        if (!Pattern.matches("^[A-Z][a-z]+$", department)){
            throw new IllegalArgumentException("Invalid Department");
        }
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }


}
