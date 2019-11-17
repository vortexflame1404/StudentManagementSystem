package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        new MainMenu().setVisible(true);
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.print(
                    "=======================\n" +
                            "1.\tManage Students\n" +
                            "2.\tManage Lecturers\n" +
                            "3.\tExit\n" +
                            "=======================\n" +
                            "Please choose: "
            );

            String opt = scanner.nextLine();
            switch (opt) {
                case "1":
                    try {
                        menu_ManageStudent();
                        break;
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                case "2":
                    try {
                        menu_ManageLecturer();
                        break;
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                case "3":
                    return;
                default:
                    System.err.println("Please choose a valid option.");
                    break;
            }
        }
    }

    private static void menu_ManageLecturer() {
        ManageLecturer manageLecturer = new ManageLecturer();
        manageLecturer.readFile();
        while (true) {
            System.out.print(
                    "=======================\n" +
                            "1.\tAdd new lecturer\n" +
                            "2.\tView all lecturers\n" +
                            "3.\tSearch lecturers\n" +
                            "4.\tDelete lecturers\n" +
                            "5.\tUpdate lecturer\n" +
                            "6.\tBack to main menu\t\n" +
                            "=======================\n" +
                            "Please choose: "
            );

            String opt = scanner.nextLine();
            switch (opt) {
                case "1":
                    manageLecturer.addNew();
                    break;
                case "2":
                    try {
                        manageLecturer.viewAll();
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "3":
                    try {
                        manageLecturer.searchFor();
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "4":
                    manageLecturer.delete();
                    break;
                case "5":
                    manageLecturer.update();
                    break;
                case "6":
                    manageLecturer.saveToFile();
                    return;
                default:
                    System.err.println("Please choose a valid option.");
            }
        }
    }

    private static void menu_ManageStudent() {
        ManagePerson manageStudent = new ManageStudent();
        manageStudent.readFile();
        while (true) {
            System.out.print(
                    "=======================\n" +
                            "1.\tAdd new student\n" +
                            "2.\tView all students\n" +
                            "3.\tSearch students\n" +
                            "4.\tDelete students\n" +
                            "5.\tUpdate student\n" +
                            "6.\tBack to main menu\n" +
                            "=======================\n" +
                            "Please choose: "
            );

            String opt = scanner.nextLine();
            switch (opt) {
                case "1":
                    manageStudent.addNew();
                    break;
                case "2":
                    try {
                        manageStudent.viewAll();
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "3":
                    try {
                        manageStudent.searchFor();
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "4":
                    manageStudent.delete();
                    break;
                case "5":
                    manageStudent.update();
                    break;
                case "6":
                    manageStudent.saveToFile();
                    return;
                default:
                    System.err.println("Please choose a valid option.");
            }
        }
    }
}
