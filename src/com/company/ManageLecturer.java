package com.company;

import java.io.*;
import java.util.*;

class ManageLecturer extends ManagePerson{
    private static String path_lecturer = "D:\\3rd year\\Java OOP VGU\\Assignment\\src\\com\\company\\data\\lecturer.ser";
    private HashMap<String, Lecturer> setOfLecturer = new HashMap<>();

    @Override
    void viewAll(){
        for (String person_name : setOfLecturer.keySet()){
            setOfLecturer.get(person_name).printInfo();
        }
    }

    @Override
    void addNew() {
        Scanner scanner = new Scanner(System.in);
        Lecturer lecturer = new Lecturer();
        String input;

        //input id \w validation
        System.out.print("ID: ");
        input = scanner.nextLine();
        while (setOfLecturer.keySet().contains(input)){
            System.err.println("ID already exists. Enter again.");
            System.out.print("ID: ");
            input = scanner.nextLine();
        }
        while (!lecturer.setId(input)){
            System.out.print("ID: ");
            input = scanner.nextLine();
        }

        //input name \w validation
        System.out.print("Name: ");
        input = scanner.nextLine();
        while (!lecturer.setName(input)){
            System.out.print("Name: ");
            input = scanner.nextLine();
        }

        //input date of birth \w validation
        System.out.print("Date of birth (dd/mm/yyyy): ");
        input = scanner.nextLine();
        while (!lecturer.setDateOfBirth(input)){
            System.out.print("Date of birth (dd/mm/yyyy): ");
            input = scanner.nextLine();
        }

        //input email \w validation
        System.out.print("Email: ");
        input = scanner.nextLine();
        while (!lecturer.setEmail(input)){
            System.out.print("Email: ");
            input = scanner.nextLine();
        }

        //input phone, address and batch
        System.out.print("Phone: ");
        input = scanner.nextLine();
        while (!lecturer.setPhoneNumber(input)){
            System.out.print("Phone: ");
            input = scanner.nextLine();
        }
        System.out.print("Address: ");
        lecturer.setAddress(scanner.nextLine());

        System.out.print("Department: ");
        input = scanner.nextLine();
        while (!lecturer.setDepartment(input)){
            System.out.print("Department: ");
            input = scanner.nextLine();
        }

        //add to set after input info
        setOfLecturer.put(lecturer.getId(), lecturer);
        System.out.println(lecturer.getName() + " have been added to current list.");
    }

    @Override
    void saveToFile(){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path_lecturer, false))){
            out.writeObject(setOfLecturer);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    void readFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path_lecturer))){
            setOfLecturer = (HashMap<String, Lecturer>) in.readObject();
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
        Lecturer tmp_lecturer = setOfLecturer.remove(updateID);
        while (tmp_lecturer == null){
            System.err.println("Student/Lecturer with such id doesn't exist.");
            System.out.print("Enter ID: ");
            updateID = scanner.nextLine();
            tmp_lecturer = setOfLecturer.remove(updateID);
        }

        tmp_lecturer.printInfo();
        System.out.println("Type in new data to update. Press Enter to keep the current data.");

        System.out.print("ID: ");
        String inputData = scanner.nextLine();
        while (!inputData.equals("") && !tmp_lecturer.setId(inputData)){
            System.out.print("ID: ");
            inputData = scanner.nextLine();
        }

        System.out.print("Name: ");
        inputData = scanner.nextLine();
        while (!inputData.equals("") && !tmp_lecturer.setName(inputData)){
            System.out.print("Name: ");
            inputData = scanner.nextLine();
        }

        System.out.print("Date of birth (dd/mm/yyyy): ");
        inputData = scanner.nextLine();
        while (!inputData.equals("") && !tmp_lecturer.setDateOfBirth(inputData)){
            System.out.print("Date of birth (dd/mm/yyyy): ");
            inputData = scanner.nextLine();
        }

        System.out.print("Email: ");
        inputData = scanner.nextLine();
        while (!inputData.equals("") && !tmp_lecturer.setEmail(inputData)){
            System.out.print("Email: ");
            inputData = scanner.nextLine();
        }

        System.out.print("Phone: ");
        inputData = scanner.nextLine();
        while (!inputData.equals("") && !tmp_lecturer.setPhoneNumber(inputData)){
            System.out.print("Phone: ");
            inputData = scanner.nextLine();
        }

        System.out.print("Address: ");
        inputData = scanner.nextLine();
        if (!inputData.equals(""))
            tmp_lecturer.setAddress(inputData);

        System.out.print("Department: ");
        inputData = scanner.nextLine();
        while (!inputData.equals("") && !tmp_lecturer.setDepartment(inputData)){
            System.out.print("Department: ");
            inputData = scanner.nextLine();
        }

        setOfLecturer.put(tmp_lecturer.getId(), tmp_lecturer);
    }
    
    @Override
    void searchFor(){
        //create new map with name as key
        SortedMap<String, Person> setOfLecturer_nameAsKey = new TreeMap<>();
        for (String key : setOfLecturer.keySet()){
            setOfLecturer_nameAsKey.put(setOfLecturer.get(key).getName(), setOfLecturer.get(key));
        }

        //https://www.geeksforgeeks.org/trie-insert-and-search/
        System.out.print("Enter name: ");
        String searchName = new Scanner(System.in).nextLine();
        for (Map.Entry<String, Person> entry : this.filterPrefix(setOfLecturer_nameAsKey, searchName).entrySet()){
            entry.getValue().printInfo();
        }
    }
    
    @Override
    void delete(){
        System.out.print("Enter ID: ");
        String deleteID = new Scanner(System.in).nextLine();

        Person deletedPerson = setOfLecturer.remove(deleteID);
        if (deletedPerson == null){
            System.err.println("Student/Lecturer with such id doesn't exist.");
        }else {
            System.out.println(deletedPerson.getName() + " has been deleted from the system.");
        }
    }
}
