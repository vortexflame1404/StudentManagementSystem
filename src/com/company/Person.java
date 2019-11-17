package com.company;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

abstract class Person implements Serializable {
    private String name;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;

    boolean setName(String name) {
        String regexName = "^[A-Z][a-z]+ [A-Z][a-z]+$";
        if (!Pattern.matches(regexName, name)) {
            System.err.println("Invalid name.");
            return false;
        }
        this.name = name;
        return true;
    }

    boolean setDateOfBirth(String dateOfBirth) {
        try {
            //Set preferred date format
            //e.g. MM-dd-yyyy, MM.dd.yyyy ...
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            simpleDateFormat.setLenient(false);
            //create Date object
            //parse the string into date
            Date date = simpleDateFormat.parse(dateOfBirth);
        }catch (ParseException e){
            System.err.println("Invalid date.");
            return false;
        }
        this.dateOfBirth = dateOfBirth;
        return true;
    }

    boolean setEmail(String email) {
        String regexEmail = "^\\w+[-_.]?\\w*@([a-zA-Z-]+\\.)+[a-zA-Z]+$";
        if (!Pattern.matches(regexEmail, email)) {
            System.err.println("Invalid email.");
            return false;
        }
        this.email = email;
        return true;
    }

    boolean setPhoneNumber(String phoneNumber) {
        String regexPhone = "^\\d+$";
        if (!Pattern.matches(regexPhone, phoneNumber)){
            System.err.println("Invalid phone.");
            return false;
        }
        this.phoneNumber = phoneNumber;
        return true;
    }

    void setAddress(String address) {
        this.address = address;
    }

    String getEmail() {
        return email;
    }

    String getName() {
        return name;
    }

    String getAddress() {
        return address;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    String getDateOfBirth() {
        return dateOfBirth;
    }

    abstract void printInfo();

}
