package com.lesha;

import com.lesha.exception.MyWrongEmailException;
import com.lesha.exception.MyWrongEnterInformationException;
import com.lesha.exception.MyWrongLengthException;
import com.lesha.repository.UserRepository;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
// 1) скрытый текст
public class Main {
    public static void main(String [] args) throws MyWrongEmailException, MyWrongLengthException, IOException, SQLException {
        Scanner in = new Scanner(System.in);
        UserRepository userRepository = new UserRepository();
        List<Person> personList = userRepository.writeInformationToPersonList();
        List<String> emailList = userRepository.writeInformationToStringList("email");
        List<String> passwordList = userRepository.writeInformationToStringList("password");
        while (true){
            System.out.println("""
                    Enter the number\s
                    1) Creating new profile\s
                    2) Checked personal information\s
                    3) Delete profile\s
                    0) Exit""");
            int number = in.nextInt();
            if(number == 0) break;
            numberMenu(number,emailList,passwordList,personList);
        }
        //System.out.println(emailList);
    }

    public static void numberMenu(int number, List<String> emailList, List<String> passwordList, List<Person> personList) throws MyWrongEmailException, MyWrongLengthException, SQLException {
        UserRepository userRepository = new UserRepository();
        switch (number){
            case 1 -> {
                String email = enteringEmail(emailList);
                String password = enteringPassword();
                Person person = enteringPersonalInformation();
                //System.out.println("Email : " + email);
                emailList.add(email);
                //System.out.println("Emails:  " + emailList);
                passwordList.add(password);
                personList.add(person);
                userRepository.addNewPerson(email,password,person);

            }
            case 2 ->{
                int personEmailId = enterTheProfile(emailList,passwordList);
                System.out.println(personList.get(personEmailId));
            }
            case 3-> {
                int personEmailId = enterTheProfile(emailList,passwordList);
                int dataBaseId = userRepository.foundPersonByEmail(emailList.get(personEmailId));
                personList.remove(personEmailId);
                emailList.remove(personEmailId);
                passwordList.remove(personEmailId);
                userRepository.deletePersonById(dataBaseId);
                System.out.println("---- Email was successfully deleted ----");
            }
        }
    }

    public static int enterTheProfile(List <String> emailList, List<String> passwordList){
        int personEmailId = 0;
        boolean f;
        Scanner in = new Scanner(System.in);
        while (true){
            f = true;
            System.out.println("Enter your email ");
            String email = in.nextLine();
            System.out.println("Enter password ");
            String password = in.nextLine();
            if (emailList.contains(email)){
                f = false;
                personEmailId = emailList.indexOf(email);
            }
            if (!f && Objects.equals(passwordList.get(personEmailId), password)) break;
            System.out.println("Error : False email or password, please write correct information");
        }
        return personEmailId;
    }

    public static String enteringEmail(List<String> emailList) throws MyWrongEmailException {
        Scanner in = new Scanner(System.in);
        boolean isEmailValid = true;
        String newEmail = "";
        try {
            System.out.println("Enter an email");
            newEmail = in.nextLine();
            if (emailList.contains(newEmail) || !isEmail(newEmail)) {
                isEmailValid = false;
                throw new MyWrongEmailException();
            }
        } catch (MyWrongEmailException e) {
            System.out.println(e.getMessage());
        }
        if (!isEmailValid) {
            do {
                System.out.println("Please write another email ");
                newEmail = in.nextLine();
            } while (emailList.contains(newEmail) || !isEmail(newEmail));
        }
        return newEmail;
    }

    public static String enteringPassword() throws MyWrongLengthException{
        Scanner in = new Scanner(System.in);
        boolean f = true;
        String newPassword = null;
        try {
            System.out.println("Enter a password (size more or equal 8) ");
            newPassword = in.nextLine();
            if (newPassword.length() < 8) {
                f = false;
                throw new MyWrongLengthException();
            }
        } catch (MyWrongLengthException e) {
            System.out.println(e.getMessage());
        }
        if (!f) {
            do {
                System.out.println("Enter password (size more or equal 8) ");
                newPassword = in.nextLine();
            } while (newPassword.length() <= 7);
        }
        return newPassword;
    }

    public static Person enteringPersonalInformation(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = in.nextLine();
        System.out.println("Enter your age ");
        int age = Integer.parseInt(in.nextLine());
        System.out.println("Enter your phone number ");
        String phoneNumber = in.nextLine();
        System.out.println("Enter your work");
        String work = in.nextLine();

        return new Person(name,age,work,phoneNumber);
    }



    public static boolean isEmail(String email){
        return email.endsWith("@gmail.com") || email.endsWith("@email.com");
    }
}
