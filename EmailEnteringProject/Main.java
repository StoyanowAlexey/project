package EmailEnteringProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws MyWrongEmailException, MyWrongLengthException {
        Scanner in = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alex",15,"Programer","0682841303"));
        personList.add(new Person("Michael",20,"Backend","0682841304"));
        List<String> emailList = new ArrayList<>();
        emailList.add("bestg202@gmail.com");
        emailList.add("mishastoyanow@gmail.com");
        List<String> passwordList = new ArrayList<>();
        passwordList.add("buriruri");
        passwordList.add("rapunchel1234");

        while (true){
            System.out.println("Enter the number \n" + "1) Creating new profile \n" + "2) Checked personal information \n" + "3) Delete profile \n" + "0) Exit");
            int number = in.nextInt();
            if(number == 0) break;
            numberMenu(number,emailList,passwordList,personList);
        }
    }

    public static void numberMenu(int number, List<String> emailList, List<String> passwordList, List<Person> personList) throws MyWrongEmailException, MyWrongLengthException {
        Scanner in = new Scanner(System.in);
        switch (number){
            case 1 -> {
                String email = enteringEmail(emailList);
                String password = enteringPassword();
                Person person = enteringPersonalInformation();
                emailList.add(email);
                passwordList.add(password);
                personList.add(person);
            }
            case 2 ->{
                int personEmailId = enterTheProfile(emailList,passwordList);
                System.out.println(personList.get(personEmailId));
            }
            case 3-> {
                int personEmailId = enterTheProfile(emailList,passwordList);
                personList.remove(personEmailId);
                emailList.remove(personEmailId);
                passwordList.remove(personEmailId);
            }
        }
    }

    public static int enterTheProfile(List <String> emailList, List<String> passwordList){
        int personEmailId = 0,f = 0;
        Scanner in = new Scanner(System.in);
        while (true){
            f = 0;
            System.out.println("Enter your email ");
            String email = in.nextLine();
            System.out.println("Enter password ");
            String password = in.nextLine();
            if (emailList.contains(email)){
                f = 1;
                personEmailId = emailList.indexOf(email);
            }
            if (f == 1 && Objects.equals(passwordList.get(personEmailId), password)) break;
            System.out.println("Error : False email or password, please write correct information");
        }
        return personEmailId;
    }

    public static String enteringEmail(List<String> emailList) throws MyWrongEmailException {
        Scanner in = new Scanner(System.in);
        boolean f = true;
        try {
            System.out.println("Enter an email");
            String newEmail = in.nextLine();
            if (emailList.contains(newEmail) || !isEmail(newEmail)) {
                f = false;
                throw new MyWrongEmailException();
            }
        } catch (MyWrongEmailException e) {
            System.out.println(e.getMessage());
        }
        String newEmail = "";
        if (!f) {
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
        try {
            System.out.println("Enter a password (size more or equal 8) ");
            String password = in.nextLine();
            if (password.length() < 8) {
                f = false;
                throw new MyWrongLengthException();
            }
        } catch (MyWrongLengthException e) {
            System.out.println(e.getMessage());
        }
        String newPassword = null;
        if (!f) {
            do {
                System.out.println("Enter password (SIZE MORE OR EQUAL 8) ");
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
        int age = in.nextInt();
        System.out.println("Enter your work");
        String work = in.nextLine();
        System.out.println("Enter your phone number ");
        String phoneNumber = in.nextLine();

        return new Person(name,age,work,phoneNumber);
    }



    public static boolean isEmail(String email){
        return email.contains("@gmail.com") || email.contains("@email.com");
    }
}
