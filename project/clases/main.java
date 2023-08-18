package project.clases;

import java.io.ObjectOutput;
import java.util.Scanner;
import java.util.Formatter;
//

public class main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        Worker [] arr;
        arr = new Worker[10];
        arr[0] = new HR("Stoyanow Alexey",14,0,2);
        arr[1] = new HR("Stoyanow Mykhailo", 21,1000,5);
        arr[2] = new Ispecialist("Sakerbey Andrey",20,500,1);
        arr[3] = new Recruiter("Kalendula Grigoriy",22,1500,3);
        //printArray(arr,"sd");
        /*for(int i = 0; i < 2; i++){
            System.out.println(arrHr[i]);
        }*/
        while(true){
            System.out.println("Enter number: \n 1) Print specialists \n 0) Exit");
            int in = sc.nextInt();
            if(in == 0) {
                System.out.println("Ydachi!!");
                break;
            }
            else {
                while(true){
                    System.out.println("Enter number: \n 1) HR \n 2) Ispecialist \n 3) Recruiter \n 0) back");
                    in = sc.nextInt();
                    if(in == 0) break;
                    else NumberFunction(in,arr);
                }

            }
        }
    }
    public static void NumberFunction(int number, Worker[] arr){
        switch (number){
            case 1:
                if(number == 1)printArray(arr,1);
            case 2:
                if(number == 2)printArray(arr,2);
            case 3:
                if(number == 3)printArray(arr,3);
        }
    }
    public static void printArray(Worker [] arr, int number){
        int f = 0,kolvo = 0;

        //System.out.println("\t \t Name \t \t \t TypeWork \t Experience \t Age \t Salary ");
        for(int i = 0; i < arr.length; i++){
            switch (number){
                case 1:
                    if(arr[i] instanceof HR && number == 1) {
                        kolvo++;
                        f = 1;
                        System.out.println(PrintTable(kolvo));
                        System.out.println(ObjectOutput(arr[i],"HR"));

                    }
                case 2:
                    if(arr[i] instanceof Ispecialist && number == 2) {
                        kolvo++;
                        f = 1;
                        System.out.println(PrintTable(kolvo));
                        System.out.println(ObjectOutput(arr[i],"Ispecialist"));

                    }
                case 3:
                    if(arr[i] instanceof Recruiter && number == 3){
                        kolvo++;
                        f = 1;
                        System.out.println(PrintTable(kolvo));
                        System.out.println(ObjectOutput(arr[i],"Recruiter"));
                    }
            }
        }
        // System.out.println("f = " + f);
        //if(kolvo == 0) f = 10;
        if(f == 0)  System.out.println("\n Takih rabotnikov seychas net :( \n");
    }
    public static String PrintTable(int f){
        String format = "| %-17s | %-10s | %-6s | %-10s | %-10s |%n";
        String header = String.format(format, "Worker Name", "Type", "Experience", "Age", "Salary");
        if(f == 1)  return header;
        else return "";
    }
    public static String ObjectOutput(Worker obj, String type){
        String format = "| %-17s | %-10s | %-10f | %-10d | %-10f |%n";
        //return obj.name + "   " + type + "   " + obj.experience + "   " + obj.age + "    " + obj.salary;
        return String.format(format, obj.name, type, obj.experience, obj.age, obj.salary);
    }
    //
    //рефлексия
    // main menu
    // 1) Print specialist
    //    1) HR
    //    2) Ispecialist
    //    0) back
    // 0) Exit
}
