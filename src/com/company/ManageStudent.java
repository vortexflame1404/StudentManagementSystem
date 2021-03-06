package com.company;

import java.io.*;
import java.util.*;

class ManageStudent extends ManagePerson{
    private static String path_student= "D:\\3rd year\\Java OOP VGU\\Assignment\\src\\com\\company\\data\\student.ser";
    private HashMap<String, Student> setOfStudent = new HashMap<>();
    
    @Override
    void viewAll(){
        for (String person_name : setOfStudent.keySet()){
            setOfStudent.get(person_name).printInfo();
        }
    }

    @Override
    void addNew(){
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        String input;

        //input id \w validation
        System.out.print("ID: ");
        input = scanner.nextLine();
        while (setOfStudent.containsKey(input)){
            System.err.println("ID already exists. Enter again.");
            System.out.print("ID: ");
            input = scanner.nextLine();
        }
        while (!student.setId(input)){
            System.out.print("ID: ");
            input = scanner.nextLine();
        }

        //input name \w validation
        System.out.print("Name: ");
        input = scanner.nextLine();
        while (!student.setName(input)){
            System.out.print("Name: ");
            input = scanner.nextLine();
        }

        //input date of birth \w validation
        System.out.print("Date of birth (dd/mm/yyyy): ");
        input = scanner.nextLine();
        while (!student.setDateOfBirth(input)){
            System.out.print("Date of birth (dd/mm/yyyy): ");
            input = scanner.nextLine();
        }

        //input email \w validation
        System.out.print("Email: ");
        input = scanner.nextLine();
        while (!student.setEmail(input)){
            System.out.print("Email: ");
            input = scanner.nextLine();
        }

        //input phone, address and batch
        System.out.print("Phone: ");
        input = scanner.nextLine();
        while (!student.setPhoneNumber(input)){
            System.out.print("Phone: ");
            input = scanner.nextLine();
        }
        System.out.print("Address: ");
        student.setAddress(scanner.nextLine());

        System.out.print("Batch: ");
        input = scanner.nextLine();
        while (!student.setBatch(input)){
            System.out.print("Batch: ");
            input = scanner.nextLine();
        }

        //add to set after input info
        setOfStudent.put(student.getId(), student);
        System.out.println(student.getName() + " have been added to current list.");
    }

    @Override
    void saveToFile(){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path_student, false))){
            out.writeObject(setOfStudent);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    void readFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path_student))){
            setOfStudent = (HashMap<String, Student>) in.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.err.print(e.getMessage());
        }
    }

    @Override
    void update(){
        //prompt user to input ID and check if key exists
        System.out.print("Enter ID: ");
        Scanner scanner = new Scanner(System.in);
        String updateID = scanner.nextLine();
        Student tmp_student = setOfStudent.remove(updateID);
        while (tmp_student == null){
            System.err.println("Student/Lecturer with such id doesn't exist.");
            System.out.print("Enter ID: ");
            updateID = scanner.nextLine();
            tmp_student = setOfStudent.remove(updateID);
        }

        tmp_student.printInfo();
        System.out.println("Type in new data to update. Press Enter to keep the current data.");

        System.out.print("ID: ");
        String inputData = scanner.nextLine();
        while (!inputData.equals("") && !tmp_student.setId(inputData)){
            System.out.print("ID: ");
            inputData = scanner.nextLine();
        }

        System.out.print("Name: ");
        inputData = scanner.nextLine();
        while (!inputData.equals("") && !tmp_student.setName(inputData)){
            System.out.print("Name: ");
            inputData = scanner.nextLine();
        }

        System.out.print("Date of birth (dd/mm/yyyy): ");
        inputData = scanner.nextLine();
        while (!inputData.equals("") && !tmp_student.setDateOfBirth(inputData)){
            System.out.print("Date of birth (dd/mm/yyyy): ");
            inputData = scanner.nextLine();
        }

        System.out.print("Email: ");
        inputData = scanner.nextLine();
        while (!inputData.equals("") && !tmp_student.setEmail(inputData)){
            System.out.print("Email: ");
            inputData = scanner.nextLine();
        }

        System.out.print("Phone: ");
        inputData = scanner.nextLine();
        while (!inputData.equals("") && !tmp_student.setPhoneNumber(inputData)){
            System.out.print("Phone: ");
            inputData = scanner.nextLine();
        }

        System.out.print("Address: ");
        inputData = scanner.nextLine();
        if (!inputData.equals(""))
            tmp_student.setAddress(inputData);

        System.out.print("Batch: ");
        inputData = scanner.nextLine();
        while (!inputData.equals("") && !tmp_student.setBatch(inputData)){
            System.out.print("Batch: ");
            inputData = scanner.nextLine();
        }

        setOfStudent.put(tmp_student.getId(), tmp_student);
    }

    @Override
    void delete(){
        System.out.print("Enter ID: ");
        String deleteID = new Scanner(System.in).nextLine();

        Person deletedPerson = setOfStudent.remove(deleteID);
        if (deletedPerson == null){
            System.err.println("Student/Lecturer with such id doesn't exist.");
        }else {
            System.out.println(deletedPerson.getName() + " has been deleted from the system.");
        }
    }
    
    @Override
    void searchFor(){
        //create new map with name as key
        SortedMap<String, Person> setOfStudent_nameAsKey = new TreeMap<>();
        for (String key : setOfStudent.keySet()){
            setOfStudent_nameAsKey.put(setOfStudent.get(key).getName(), setOfStudent.get(key));
        }

        //https://www.geeksforgeeks.org/trie-insert-and-search/
        System.out.print("Enter name: ");
        String searchName = new Scanner(System.in).nextLine();
        for (Map.Entry<String, Person> entry : this.filterPrefix(setOfStudent_nameAsKey, searchName).entrySet()){
            entry.getValue().printInfo();
        }
    }
}
