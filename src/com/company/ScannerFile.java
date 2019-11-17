package com.company;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Search for Tokens, delimited
public class ScannerFile {
    public static void main(String[] args) throws Exception {
        //Create a List of Clients. Create all needed classes.

        //Token per Token
        ArrayList<Client> listOfClients = new ArrayList<>();
        String[] line = null;
        try (Scanner input = new Scanner(new BufferedReader(new FileReader("D:\\3rd year\\Java OOP VGU\\Assignment\\src\\com\\company\\Clientes_info.txt")))) {
            //Read file clients_info.txt, in every line there is a client information.
            input.useDelimiter("\\n|\\r|\\r\\n");

            //Each client has name, email and phone. Separated with spaces.
            String name, email, phoneNum;
            while (input.hasNext()) {
                line = input.next().trim().split("\\s", 0);
                for (int i = 0; i < line.length; i++) {
                    System.out.println(line[i]);
                }
//                System.out.println(line.length);
                System.out.println(line[0]);
                System.out.println(line[1]);
                System.out.println(line[2]);
                listOfClients.add(new Client(line[0], line[1], line[2]));
            }

            //Create a Client object and add it to the clients list.
        }

        //Serializable
        try (ObjectOutputStream savecontants = new ObjectOutputStream(new FileOutputStream("D:\\3rd year\\Java OOP VGU\\Assignment\\src\\com\\company\\client_info_backup.txt", false))) {
            //Save the contacts list object on a file named client_info_backup.txt
            savecontants.writeObject(listOfClients);
        }



        //Deserialize
        try (ObjectInputStream restoring = new ObjectInputStream(new FileInputStream("client_info_backup.txt"))) {
            //Restore the Contact List.
            ArrayList<Client> contactListTmp = (ArrayList<Client>) restoring.readObject();

            //Print all the contacts.
            for (Client tmp : contactListTmp) {
                tmp.print();
            }
        }
    }
}

class Client implements Serializable{
    String name;
    String email;
    String phoneNum;

    Client(String name, String email, String phoneNum) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    void print() {
        System.out.println(this.name + " " + this.email + " " + this.phoneNum);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
