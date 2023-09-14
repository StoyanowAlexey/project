package phoneBook.classes;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        //TODO:phone_table - is VERY, VERY BAD. Naming for variables - phoneTable. (small letter at beggining, every new word from a capital letter).
        //TODO: It's very important!!!!!
        Hashtable<String, String> phoneTable = new Hashtable<>();
        HashTable phoneBook = new HashTable(phoneTable);
        File PHONEBOOK_PATH = new File("phoneBook/classes/PhoneBook.txt"); //TODO: make constants file. Set this path to it. Name it - PHONEBOOK_PATH
        Scanner scanner = new Scanner(PHONEBOOK_PATH);        //TODO: use Ctrl + Alt + L to make your code looks better. I've already done it.
        //TODO: use Ctrl + Alt + O to delete unused imports. I've done it too.
        while (scanner.hasNextLine()) {
            String Name = scanner.nextLine();
            String PhoneNumber = scanner.nextLine();
            phoneTable.put(PhoneNumber, Name);
        }
        //System.out.println(phone_table.keys());
        while (true) {
            //System.out.println(phone_table.toString());
            System.out.println("Действия: \n 1) Запись в телефонную книгу \n 2) Поиск человека по номеру телефона \n 3) Поиск номера человека по его имени \n 0) Выход");
            Scanner in = new Scanner(System.in);
            int number = in.nextInt();
            if (number == 0) break;
            phoneBook.selectionMenu(number, phoneTable);
        }
    }
}
