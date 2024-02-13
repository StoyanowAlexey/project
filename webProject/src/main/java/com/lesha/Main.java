package com.lesha;

import com.lesha.exception.MyWrongEmailException;
import com.lesha.exception.MyWrongIndexException;
import com.lesha.exception.MyWrongLengthException;
import com.lesha.repository.UserRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// 1) скрытый текст
public class Main {
    public static void main(String[] args) throws MyWrongEmailException, MyWrongLengthException, IOException, SQLException {
        Scanner in = new Scanner(System.in);
        UserRepository userRepository = new UserRepository();
        List<Person> personList = userRepository.writeInformationToPersonList();
        List<String> emailList = userRepository.writeInformationToStringList("email");
        List<String> passwordList = userRepository.writeInformationToStringList("password");
        while (true) {
            boolean f = false;
            System.out.println("Enter the number \n 1)Creating new profile\n 2)Enter the profile\n 0)Exit");
            int number = in.nextInt();
            if (number == 0) break;
            if (number == 1) creatingNewProfile(emailList, passwordList, personList);
            else {
                int personalEmailId = 0;
                while (true) {
                    if (!f){
                        personalEmailId = enterTheProfile(emailList, passwordList);
                        if (personalEmailId == -1) break;
                    }
                    //System.out.println("personal_email_id == " + personalEmailId);
                    f = true;
                    System.out.println("""
                            Enter the number\s
                            1) Checked personal information\s
                            2) Get information by id\s
                            3) Update profile\s
                            4) Delete profile\s              
                            0) Back""");
                    int enteringProfileNumber = in.nextInt();
                    if (enteringProfileNumber == 0) break;
                    numberMenu(enteringProfileNumber, emailList, passwordList, personList, personalEmailId);
                    if (enteringProfileNumber == 4) break;
                }
            }
        }
        //System.out.println(emailList);
    }

    public static void numberMenu(int number, List<String> emailList, List<String> passwordList, List<Person> personList, int personEmailId) throws MyWrongEmailException, MyWrongLengthException, SQLException {
        UserRepository userRepository = new UserRepository();
        Scanner in = new Scanner(System.in);
        //System.out.println("number = " + number);
        switch (number) {
            case 1 -> System.out.println(personList.get(personEmailId));
            case 2 -> {
                System.out.println("Enter id ");
                int id = in.nextInt();
                try {
                    if (userRepository.getInformationAboutPersonById(id) == "") throw new MyWrongIndexException();
                    else System.out.println(userRepository.getInformationAboutPersonById(id));
                } catch (MyWrongIndexException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }

            case 3 -> {
                int dataBaseId = userRepository.findPersonByEmail(emailList.get(personEmailId));
                System.out.println("Enter the number \n 1) Update ALL information\n 2) Update one thing\n 0) Back");
                int numberUpdatingMenu = in.nextInt();
                if (numberUpdatingMenu == 0) break;
                switch (numberUpdatingMenu){
                    case 1 -> updateAllInformationAboutPerson(dataBaseId);
                    case 2 -> updatingMenuFunction(emailList, dataBaseId);
                }
            }

            case 4 -> {
                int dataBaseId = userRepository.findPersonByEmail(emailList.get(personEmailId));
                personList.remove(personEmailId);
                emailList.remove(personEmailId);
                passwordList.remove(personEmailId);
                userRepository.deletePersonById(dataBaseId);
                System.out.println("---- Email was successfully deleted ----");
            }
        }
    }

    public static void creatingNewProfile(List<String> emailList, List<String> passwordList, List<Person> personList) throws MyWrongEmailException, MyWrongLengthException, SQLException {
        UserRepository userRepository = new UserRepository();
        boolean f_email = true,f_password = true;
        String email = enteringEmail(emailList);
        if (Objects.equals(email, null)) f_email = false;
        String password = enteringPassword();
        if (!f_email || password == null) f_password = false;
        if (f_email && f_password) {
            Person person = enteringPersonalInformation();
            //System.out.println("Email : " + email);
            emailList.add(email);
            //System.out.println("Emails:  " + emailList);
            passwordList.add(password);
            personList.add(person);
            userRepository.addNewPerson(email, password, person);
        }
    }

    public static void updateAllInformationAboutPerson(int id) throws SQLException {
        UserRepository userRepository = new UserRepository();
        System.out.println("------Write new personal information------");
        Person person = enteringPersonalInformation();
        userRepository.updatePersonalInformationById(person, id);
    }

    public static void updatingMenuFunction(List<String> email, int dataBaseId) throws MyWrongEmailException, MyWrongLengthException, SQLException {
        Scanner in = new Scanner(System.in);
        UserRepository userRepository = new UserRepository();
        System.out.println("""
                Enter the number of data you want to change \s
                1) Email\s
                2) Password\s
                3) Name\s
                4) Age\s
                5) Phone_number\s
                6) Work\s              
                0) Exit""");
        int number = in.nextInt();
        in.nextLine();
        switch (number) {
            case 1 -> {
                String newEmail = enteringEmail(email);
                if (newEmail != null)
                    userRepository.updateOneStringThingInProfileById(newEmail, "email", dataBaseId);
            }
            case 2 -> {
                String newPassword = enteringPassword();
                if (newPassword != null)
                    userRepository.updateOneStringThingInProfileById(newPassword, "password", dataBaseId);
            }
            case 3 -> {
                System.out.println("----Write new name----");
                String newName = in.nextLine();
                userRepository.updateOneStringThingInProfileById(newName,"name",dataBaseId);
            }
            case 4 -> {
                System.out.println("----Write new age----");
                int newAge = in.nextInt();
                userRepository.updateOneStringThingInProfileById(String.valueOf(newAge), "age", dataBaseId);
            }
            case 5 -> {
                System.out.println("----Write new phone number----");
                String newPhoneNumber = in.nextLine();
                userRepository.updateOneStringThingInProfileById(newPhoneNumber, "phone_number", dataBaseId);
            }
            case 6 -> {
                System.out.println("----Write new work----");
                String newWork = in.nextLine();
                userRepository.updateOneStringThingInProfileById(newWork, "work", dataBaseId);
            }
            default -> {
                break;
            }
        }
    }

    public static int enterTheProfile(List<String> emailList, List<String> passwordList) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your email ");
        String email = in.nextLine();
        System.out.println("Enter password ");
        String password = in.nextLine();
        if(emailList.contains(email) && Objects.equals(passwordList .get(emailList.indexOf(email)), password)){
            return emailList.indexOf(email);
        }
        else {
            System.out.println("Exception: False information, please try again!");
            return -1;
        }
    }

    public static String enteringEmail(List<String> emailList) throws MyWrongEmailException {
        Scanner in = new Scanner(System.in);
        String newEmail = null;
        try {
            System.out.println("Enter an email");
            newEmail = in.nextLine();
            if (emailList.contains(newEmail) || !isEmail(newEmail)) {
                newEmail = null;
                throw new MyWrongEmailException();
            }
        } catch (MyWrongEmailException e) {
            System.out.println(e.getMessage());
        }
        return newEmail;
    }

    public static String enteringPassword() throws MyWrongLengthException {
        Scanner in = new Scanner(System.in);
        String newPassword = null;
        try {
            System.out.println("Enter a password (size more or equal 8) ");
            newPassword = in.nextLine();
            if (newPassword.length() < 8) {
                newPassword = null;
                throw new MyWrongLengthException();
            }
        } catch (MyWrongLengthException e) {
            System.out.println(e.getMessage());
        }
        return newPassword;
    }

    public static Person enteringPersonalInformation() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = in.nextLine();
        System.out.println("Enter your age ");
        int age = Integer.parseInt(in.nextLine());
        System.out.println("Enter your phone number ");
        String phoneNumber = in.nextLine();
        System.out.println("Enter your work");
        String work = in.nextLine();

        return new Person(name, age, work, phoneNumber);
    }


    public static boolean isEmail(String email) {
        return email.endsWith("@gmail.com") || email.endsWith("@email.com");
    }
}
