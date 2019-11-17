package com.company;

import java.util.regex.Pattern;

class Lecturer extends Person {
    private String id;
    private String department;

    boolean setId(String id) {
        if (!Pattern.matches("^\\d{8}$", id)){
            System.err.println("Invalid lecturer's ID.");
            return false;
        }
        this.id = id;
        return true;
    }

    boolean setDepartment(String department) {
        if (!Pattern.matches("^[A-Z][a-z]+$", department)){
            System.err.println("Invalid department.");
            return false;
        }
        this.department = department;
        return true;
    }

    String getId() {
        return id;
    }

    String getDepartment() {
        return department;
    }

    void printInfo(){
        String output = String.format("%1$-40s|%2$-40s|%3$-40s|%4$-40s|%5$-40s|%6$-40s|%7$-40s\n",this.getId(), this.getName(), this.getDateOfBirth(), this.getEmail(),
                this.getPhoneNumber(), this.getAddress(), this.getDepartment());
        System.out.print(output);
    }
}
