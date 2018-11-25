package com.company;

import java.util.regex.Pattern;

public class Student extends Person {
    private String id;
    private String batch;

    public void setId(String id){
        String regexId = "^(GT|GC)\\d{5}$";
        if (!Pattern.matches(regexId, id)){
            throw new IllegalArgumentException("Invalid student id");
        }
        this.id = id;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getId() {
        return id;
    }

    public String getBatch() {
        return batch;
    }

    //TODO: modify with output stream
    public void printInfo(){
        System.out.printf("ID: %s\t|\tName: %s\t|\tDate of birth: %s\t|\tEmail: %s\t|\tPhone: %s\t|\tAddress: %s\t|\tBatch: %s\n",
                this.getId(), this.getName(), this.getDateOfBirth(), this.getDateOfBirth(), this.getEmail(),
                this.getPhoneNumber(), this.getAddress(), this.getBatch());
    }
}
