package phoneBook.classes;

import javax.sound.sampled.Line;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class HashTable {
    public static void main(String [] args) throws IOException{
        Hashtable<String,String> phone_table = new Hashtable<>();

        File file = new File("project/PhoneBook.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){
            String Name = scanner.nextLine();
            String PhoneNumber = scanner.nextLine();
            phone_table.put(PhoneNumber,Name);
        }
        //System.out.println(phone_table.keys());
        while (true){
            //System.out.println(phone_table.toString());
            System.out.println("Действия: \n 1) Запись в телефонную книгу \n 2) Поиск человека по номеру телефона \n 0) Выход");
            Scanner in = new Scanner(System.in);
            int number = in.nextInt();
            if(number == 0) break;
            numberFunction(number,phone_table);
        }
    }

    public static void numberFunction(int number, Hashtable<String,String> phone_table) throws IOException{
        switch (number){
            case 1:
                if(number == 1) phoneBookEntry(phone_table);
            case 2:
                if(number == 2) printPersonByNumber(phone_table);
        }
    }

    public static void printPersonByNumber(Hashtable <String,String> phone_table){
        System.out.println("Введите номер человека которого хотите найти ");
        Scanner in = new Scanner(System.in);
        String number = in.nextLine();
        System.out.println("Человек с номером "+ number + " это " + phone_table.get(number));
    }

    public static void phoneBookEntry(Hashtable <String,String>phone_table) throws IOException {
        File file = new File("project/PhoneBook.txt");
        FileWriter fileWriter = new FileWriter(file);
        System.out.println("Введите ваше имя ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Введите ваш номер телефона");
        String number = in.nextLine();
        phone_table.put(number,name);
        String [] nameArray =  phone_table.keySet().toArray(new String[phone_table.size()]);


        BufferedWriter out = new BufferedWriter(fileWriter);

        for(int i = 0; i < nameArray.length; i++){
            out.write(phone_table.get(nameArray[i]));
            out.newLine();
            out.write(nameArray[i]);
            out.newLine();
        }

        //out.write(phone_table);
        //out
        out.close();

    }

}
