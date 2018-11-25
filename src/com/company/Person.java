package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

abstract class Person {
    private String name;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;

    private static Scanner scanner = new Scanner(System.in);
    public void setName(String name) {
        String regexName = "^[A-Z][a-z]+ [A-Z][a-z]+$";
//        String name = scanner.nextLine();
//
//        while (true) {
//            try{
//               if (!Pattern.matches(regexName, name)) {
//                    throw new IllegalArgumentException("Invalid name");
//                }
//                this.name = name;
//                break;
//            }catch (IllegalArgumentException e){
//                System.err.println(e.getMessage());
//                System.out.println("Name: ");
//                name = scanner.nextLine();
//            }
//        }
        if (!Pattern.matches(regexName, name)) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        //Set preferred date format
        //e.g. MM-dd-yyyy, MM.dd.yyyy ...
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        //create Date object
        //parse the string into date
        try {
            Date date = simpleDateFormat.parse(dateOfBirth);
        }catch (ParseException e){
            throw new IllegalArgumentException("Invalid date");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        String regexEmail = "^\\w+[-_.]?\\w*@([a-zA-Z-]+\\.)+[a-zA-Z]+$";
        if (!Pattern.matches(regexEmail, email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;

    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

}
