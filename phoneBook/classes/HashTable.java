package phoneBook.classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTable {
    Hashtable<String,String> phoneTalbe = new Hashtable<>();
    HashTable(Hashtable<String,String> phoneTable) {
        this.phoneTalbe = phoneTable;
    }

    public static void selectionMenu(int number, Hashtable<String, String> phoneTable) throws IOException {
        Hashtable<String,String> result = new Hashtable<>();
        Scanner in = new Scanner(System.in);
        switch (number) {//TODO: renmae method to - selectionMenu or smth like that, numberFunction isn`t show its job
            case 1:
                if (number == 1) phoneBookEntry(phoneTable);
            case 2:
                if (number == 2) printPersonByPhoneNumber(phoneTable);
            case 3:
                if(number == 3) {
                    String name = in.nextLine();
                    result = searchNumberByName(phoneTable,name);
                    if(result.size() == 0) System.out.println("Людей с похожим именем нету в книге");
                    else printHashTable(result);
                }
        }
    }

    public static void printHashTable(Hashtable<String,String> hashtable){
        String [] numbers = hashtable.keySet().toArray(new String[hashtable.size()]);
        for(int i = 0; i < numbers.length; i++){
            System.out.println(hashtable.get(numbers[i]) + "   " + numbers[i]);
        }
    }

    public static Hashtable<String,String> searchNumberByName(Hashtable<String, String> phoneTable,String keyword){
        Hashtable<String,String> result = new Hashtable<>();
        for(Map.Entry<String,String> value : phoneTable.entrySet()){
            //System.out.println(phoneTable.values());
            if(value.getValue().contains(keyword)) {
                //System.out.println(phoneTable.contains(keyword));
                result.put(value.getKey(),value.getValue());
            }
        }
        return result;
    }

    public static void printPersonByPhoneNumber(Hashtable<String, String> phoneTable) {
        System.out.println("Введите номер человека которого хотите найти ");
        Scanner in = new Scanner(System.in);//TODO: renmae method to - printPersonByPhoneNumber, thee maybe other numbers, for example id.
        String number = in.nextLine();
        System.out.println("Человек с номером " + number + " это " + phoneTable.get(number));
    }

    public static void phoneBookEntry(Hashtable<String, String> phoneTable) throws IOException {
        //TODO:phone_table - is VERY VERY BAD. Naming for variables - phoneTable. (small letter at beggining, every new word from a capital letter).
        //TODO: It's very important!!!!!
        File file = new File("phoneBook/classes/PhoneBook.txt");
        FileWriter fileWriter = new FileWriter(file);
        System.out.println("Введите ваше имя ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Введите ваш номер телефона");
        String number = in.nextLine();
        phoneTable.put(number, name);
        String[] nameArray = phoneTable.keySet().toArray(new String[phoneTable.size()]);

        BufferedWriter out = new BufferedWriter(fileWriter);

        for (int i = 0; i < nameArray.length; i++) {
            out.write(phoneTable.get(nameArray[i]));
            out.newLine();
            out.write(nameArray[i]);
            out.newLine();
        }

        out.close();

    }

}
