package Task10;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Comparator;
import static java.lang.Math.max;

// 12 3 10
// 1 9 6
// 11 4 16
public class Main {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите m (количество строк) (<4)  ");
        int m = in.nextInt();
        System.out.println("Введите n (количество столбцов) (<4)  ");
        int n = in.nextInt();
        int  [][] arr = new int[m][n];
        generation(m,n,arr);
        int [] first = getArrayLineFromTwoDimensionalArray(n,arr,1);
        int [] second = getArrayLineFromTwoDimensionalArray(n,arr,2);
        Comparator<int []> anonimComporator = (first1, second1) -> {
            if(getAmountNotPairedOrPairedValues(first1,0) > getAmountNotPairedOrPairedValues(second1,0)) return 1;
            else if(getAmountNotPairedOrPairedValues(first1,0) == getAmountNotPairedOrPairedValues(second1,0)) return 0;
            else return -1;
        };
        InnerComporator innerComporator = new InnerComporator();
        System.out.println("Array before using methods : ");
        printMassive(arr);
        innerComporator.compare(first,second);
        Arrays.sort(arr,innerComporator);
        System.out.println("Array after using method compare (InnerComporator) ");
        printMassive(arr);
        System.out.println("Array after using method compare (AnonimComporator) ");
        anonimComporator.compare(first,second);
        Arrays.sort(arr,anonimComporator);
        printMassive(arr);
        Outer.LocalInnerComporator localInnerComporator = new Outer.LocalInnerComporator();
        localInnerComporator.compare(first,second);
        System.out.println("Array after using method compare (LocalInnerComporator) ");
        Arrays.sort(arr,localInnerComporator);
        printMassive(arr);
    }

    public static int getAmountNotPairedOrPairedValues(int[] array, int f){
        int kolvo = 0;
        for (int j : array) {
            if (f == 0 && j % 2 != 0) kolvo++;
            if (f == 1 && j % 2 == 0) kolvo++;
        }
        return kolvo;
    }
    public static void generation(int m, int n, int[][] mas){
        Random random = new Random();        // Noncompliant - new instance created with each invocation
        int rValue = random.nextInt(0,1000);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                mas[i][j] = rValue;
            }
        }
    }
    public static int [] getArrayLineFromTwoDimensionalArray(int n, int[][] twoDimensionalArray, int line){
        int[] array = new int[n];
        System.arraycopy(twoDimensionalArray[line], 0, array, 0, n);
        return array;
    }


    public class Outer{
        public static class LocalInnerComporator implements Comparator <int []> {

            @Override
            public int compare(int[] first, int[] second) {
                if(getAmountNotPairedOrPairedValues(first,1) > getAmountNotPairedOrPairedValues(second,1)) return 1;
                else if(getAmountNotPairedOrPairedValues(first,1) == getAmountNotPairedOrPairedValues(second,1)) return 0;
                else return -1;
            }
        }
        LocalInnerComporator getLocalInnerComporator(){
            return new LocalInnerComporator();
        }
    }

    public static class InnerComporator implements Comparator <int[]>{

        @Override
        public int compare(int[] first, int[] second) {
            int sumFirst = Arrays.stream(first).sum();
            int sumSecond = Arrays.stream(second).sum();
            if(sumFirst > sumSecond) return 1;
            else if(sumFirst == sumSecond) return 0;
            else return -1;
        }

    }

    public static void printMassive(int[][] arr){
        for(int [] mas : arr){
            System.out.println(Arrays.toString(mas));
        }
    }

}
