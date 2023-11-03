package Task12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyWrongParamException, MyEmptyContainerException, MyWrongIndexException, MyFullContainerException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the capacity ");
        int capacity = in.nextInt();
        try {
            if (capacity < 5) throw new MyWrongParamException(capacity);
        } catch (MyWrongParamException e) {
            System.out.println(e.getMessage());
            while (capacity < 5) {
                System.out.println("Enter another capacity (more or equal 5) ");
                capacity = in.nextInt();
            }
        }
        System.out.println("---- Creating array with capacity " + capacity + "...  ------");
        MySimpleContainer container = new MySimpleContainer(capacity);
        System.out.println("---- Array was successfully created. ------");
        while (true) {
            System.out.println("Enter the number \n" + "1) Method toString() \n" + "2) Method size() \n" + "3) Method get(int index) \n" + "4) Method set(int index, int newValue) \n" + "5) Method add(int newValue) \n" + "6) Method remove() \n" + "0) Exit ");
            int number = in.nextInt();
            if (number == 0) {
                System.out.println("Exiting...");
            }
            NumberFunction(number, container, capacity);
        }
    }

    public static void NumberFunction(int number, MySimpleContainer mySimpleContainer, int capacity) throws MyWrongIndexException, MyFullContainerException, MyEmptyContainerException {
        Scanner in = new Scanner(System.in);
        switch (number) {
            case 1 -> System.out.print("Array : " + mySimpleContainer.toString());
            case 2 -> System.out.println("Size = " + mySimpleContainer.size());
            case 3 -> {

                System.out.println("Enter the index ");
                int index = in.nextInt();
                index = indexChecking(mySimpleContainer, index, capacity);
                System.out.println("------ Searching... ------");
                System.out.println("Value on " + index + " index is " + mySimpleContainer.get(index));
            }
            case 4 -> {

                System.out.println("Enter the value ");
                int value = in.nextInt();
                System.out.println("Enter the index ");
                int index = in.nextInt();
                index = indexChecking(mySimpleContainer, index, capacity);
                System.out.println("------ Putting into ... ------");
                mySimpleContainer.set(index, value);
                System.out.println("Value " + value + " was successfully putted in " + index + " index. ");
            }
            case 5 -> {
                int f = 0;
                try {
                    if (mySimpleContainer.size() == capacity) throw new MyFullContainerException();
                } catch (MyFullContainerException e) {
                    System.out.println(e.getMessage());
                    f = 1;
                }
                if (f == 0) {
                    System.out.println("Enter a new value ");
                    int newValue = in.nextInt();
                    System.out.println("------ Adding to array ------");
                    mySimpleContainer.add(newValue);
                    System.out.println("------ Value was successfully added ------");
                }
            }
            case 6 -> {
                int f = 0;
                try {
                    if (mySimpleContainer.size() == 0) throw new MyEmptyContainerException();
                } catch (MyEmptyContainerException e) {
                    System.out.println(e.getMessage());
                    f = 1;
                }
                if (f == 0) {
                    System.out.println("------ Removing last added value ------ ");
                    mySimpleContainer.remove();
                    System.out.println("------ Value was removed ------ ");
                }
            }
            default -> System.out.println();
        }
        System.out.println();
        System.out.println();
    }


    public static int indexChecking(MySimpleContainer container,int index, int capacity) throws MyWrongIndexException {
        Scanner in = new Scanner(System.in);
        try {
            if (index < 0 || index >= capacity) throw new MyWrongIndexException();
        } catch (MyWrongIndexException e) {
            System.out.println(e.getMessage(index));
            while (index < 0 || index >= capacity) {
                System.out.println("Please, enter another index (more or equal 0, and less than " + capacity + ") .");
                index = in.nextInt();
            }
        }
        return index;
    }

}
