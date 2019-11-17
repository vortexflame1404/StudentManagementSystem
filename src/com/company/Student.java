package com.company;

import java.util.regex.Pattern;

class Student extends Person {
    private String id;
    private String batch;

    boolean setId(String id){
        String regexId = "^(GT|GC)\\d{5}$";
        if (!Pattern.matches(regexId, id)){
            System.err.println("Invalid ID.");
            return false;
        }
        this.id = id;
        return true;
    }

    boolean setBatch(String batch) {
        String regexBatch = "^(CS|ME|FA|BA|EEIT)\\d{4}$";
        if (!Pattern.matches(regexBatch, batch)) {
            System.err.println("Invalid batch.");
            return false;
        }
        this.batch = batch;
        return true;
    }

    String getId() {
        return id;
    }

    String getBatch() {
        return batch;
    }

    void printInfo(){
        String output = String.format("%1$-30s|%2$-30s|%3$-30s|%4$-30s|%5$-30s|%6$-30s|%7$-30s\n",
                this.getId(), this.getName(), this.getDateOfBirth(), this.getEmail(),
            this.getPhoneNumber(), this.getAddress(), this.getBatch());
        System.out.print(output);
    }
}
