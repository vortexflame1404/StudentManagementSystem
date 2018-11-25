package com.company;

import java.util.Scanner;

public class ManageStudent {

    public void addNewStudent(){
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();

        while (true){
            String input = scanner.nextLine();
            try {
                student.setName(input);
                break;
            }catch (Exception e){
                System.err.println(e.getMessage());
                input = scanner.nextLine();
            }
        }


    }


    public void viewAllStudent(){

    }

    public void searchStudent(){

    }

    public void deleteStudent(){

    }


}
