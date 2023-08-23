package project.clases;

import project.enums.TypeWork;

import java.io.ObjectOutput;
import java.util.Scanner;
import java.util.Formatter;
//

public class main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        Worker [] arr;
        arr = new Worker[5];
        arr[0] = new HR("Stoyanow Alexey",14,0,2);
        arr[1] = new HR("Stoyanow Mykhailo", 21,1000,5);
        arr[2] = new Ispecialist("Sakerbey Andrey",20,500,1);
        arr[3] = new Recruiter("Kalendula Grigoriy",22,1500,3);
        arr[4] = new ProjectManager("Sayrat Bayraktar ",25,3,1000);
        //printArray(arr,"sd");
        /*for(int i = 0; i < 2; i++){
            System.out.println(arrHr[i]);
        }*/
        while(true){
            System.out.println("Enter number: \n 1) Print specialists \n 2) Print specialists by salary \n 0) Exit");
            int in = sc.nextInt();
            if(in == 0) break;
            switch (in){
                case 1:
                    while(true) {
                        System.out.println("Enter number: \n 1) HR \n 2) Ispecialist \n 3) Recruiter \n 4) ProjectManager \n 4) All Workers \n 0) back");
                        in = sc.nextInt();
                        if (in == 0) break;
                        else printArray(arr,in);;
                    }
                    if(in == 0) break;
                case 2:
                    while (true) {
                        System.out.println("Enter number: \n 1) Print ALL workers \n 2) Print workers > amount entered \n 3) Print workers < amount entered \n 0) Back");
                        in = sc.nextInt();
                        if (in == 0) break;
                        else SalaryFunction(arr, in);
                    }
                    if(in == 0) break;
            }

        }
    }
    public static void SalaryFunction(Worker arr[], int number ){
        Scanner sc = new Scanner(System.in);
        if(number != 1 && number != 0) PrintTable(1);
        switch (number){

            case 1:
                if(number == 1)PrintAllWorkers(arr);
            case 2:
                if(number == 2){
                    double sum = sc.nextDouble();
                    PrintPersonWithBiggerOrSmallerSalary(arr,sum,1);
                }

            case 3:
                if(number == 3){
                    double sum = sc.nextDouble();
                    PrintPersonWithBiggerOrSmallerSalary(arr,sum,0);
                }


        }

    }
    public static void PrintPersonWithBiggerOrSmallerSalary(Worker arr[] , double sum , int BiggerOrSmaller){
        for(int i = 0; i < arr.length; i++){
            if(BiggerOrSmaller == 1 && arr[i].salary > sum) System.out.println(ObjectOutput(arr[i],arr[i].typeWork));
            if(BiggerOrSmaller == 0 && arr[i].salary < sum) System.out.println(ObjectOutput(arr[i],arr[i].typeWork));
        }

    }
    /*public static void NumberFunction(int number, Worker[] arr){
        printArray(arr,number);
    }*/
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
                        System.out.println(ObjectOutput(arr[i],TypeWork.HR));

                    }
                case 2:
                    if(arr[i] instanceof Ispecialist && number == 2) {
                        kolvo++;
                        f = 1;
                        System.out.println(PrintTable(kolvo));
                        System.out.println(ObjectOutput(arr[i],TypeWork.Ispecialist));

                    }
                case 3:
                    if(arr[i] instanceof Recruiter && number == 3){
                        kolvo++;
                        f = 1;
                        System.out.println(PrintTable(kolvo));
                        System.out.println(ObjectOutput(arr[i],TypeWork.Recruiter));
                    }
                case 4:
                    if(arr[i] instanceof ProjectManager && number == 4){
                        kolvo++;
                        f = 1;
                        System.out.println(PrintTable(kolvo));
                        System.out.println(ObjectOutput(arr[i],TypeWork.ProjectManager));
                    }
            }

        }
        // System.out.println("f = " + f);
        //if(kolvo == 0) f = 10;
        if(number == 5) {
            f = 1;
            PrintAllWorkers(arr);
        }
        if(f == 0)  System.out.println("\n Takih rabotnikov seychas net :( \n");
    }
    public static String PrintTable(int f){
        String format = "| %-17s | %-10s | %-6s | %-10s | %-10s |%n";
        String header = String.format(format, "Worker Name", "Type", "Experience", "Age", "Salary");
        if(f == 1)  return header;
        else return "";
    }
    public static String ObjectOutput(Worker obj, TypeWork type){
        String format = "| %-17s | %-10s | %-10f | %-10d | %-10f |%n";
        //return obj.name + "   " + type + "   " + obj.experience + "   " + obj.age + "    " + obj.salary;
        return String.format(format, obj.name, type, obj.experience, obj.age, obj.salary);
    }
    public static void PrintAllWorkers(Worker arr[]){
        String format_table = "| %-17s | %-10s | %-6s | %-10s | %-10s |%n";
        TypeWork typeWork;
        String header = String.format(format_table, "Worker Name", "Type", "Experience", "Age", "Salary");
        System.out.println(header);
        for(int i = 0; i < arr.length; i++){
            typeWork = arr[i].typeWork;
            System.out.println(ObjectOutput(arr[i],typeWork));
        }
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
