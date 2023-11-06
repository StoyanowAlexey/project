package Task11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во строк (меньше 4) ");
        int m = in.nextInt();
        System.out.println("Введите кол-во столбцов (меньше 4) ");
        int n = in.nextInt();
        int [][] arr = new int[m][n];
        generation(m,n,arr);
        System.out.println("Масив : ");
        printArray(arr);
        int [] first = getLineFromMatrix(arr,n,0);
        int [] second = getLineFromMatrix(arr,n,1);

        System.out.println("Array after sorting by kolvo paired values");
        Comparator<int[]> comp1 = (a,b) -> getKolvoPairedOrNotPairedValuesFromArray(a,0) - getKolvoPairedOrNotPairedValuesFromArray(b,0);
        Arrays.sort(arr,comp1);
        printArray(arr);

        System.out.println("Array after sorting by sum values");
        Comparator<int[]> comp = (a,b) -> getSumArray(a) - getSumArray(b);
        Arrays.sort(arr,comp);
        printArray(arr);

        System.out.println("SumEven = " + sum(arr,Main::isEven));
        System.out.println("SumPositive = "+ sum(arr,Main::isPositive));
        System.out.println("SumNegative = " + sum(arr,Main::isNegative));
    }
    static boolean isEven(int n){
        return n % 2 == 0;
    }

    static boolean isPositive(int n){
        return n > 0;
    }

    static boolean isNegative(int n){
        return n < 0;
    }

    public static int getKolvoPairedOrNotPairedValuesFromArray(int [] array, int f){
        int kolvo = 0;
        for(int i = 0; i < array.length; i++){
            if(f == 0 && array[i] % 2 == 0) kolvo++;
            if(f == 1 && array[i] % 2 != 0) kolvo++;
        }
        return kolvo;
    }

    private static int sum(int [][] array, MyCheck func){
        int sum = 0;
        for (int[] ints : array) {
            for (int j = 0; j < ints.length; j++) {
                if (func.isRight(ints[j])) sum = sum + ints[j];
            }
        }
        return sum;
    }

    public static void generation(int m, int n, int [][] array){
        Random random = new Random();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                array[i][j] = random.nextInt(-100,100);
            }
        }
    }

    public static int getSumArray(int [] array){
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum = sum + array[i];
        }
        return sum;
    }

    public static int[] getLineFromMatrix(int [][] array, int n, int line){
        int [] vr = new int[n];
        for(int j = 0; j < n; j++){
            vr[j] = array[line][j];
        }
        return vr;
    }

    public static void printArray(int [][] array){
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
