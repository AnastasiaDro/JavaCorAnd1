package main.java.ru.geekbrains.lesson2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
    //ex01
    //Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arr1   = new int[10];
        Random rand = new Random();

        System.out.println("ex01");
    //заполним массив случайными числами
        for (int i = 0; i < 10; i++) {
            arr1[i] = rand.nextInt(2);
        }
        System.out.println("arr1 is: " + Arrays.toString(arr1));
    //Хочу попробовать тернарный оператор
        for (int i = 0; i < 10; i++) {
            arr1[i] = arr1[i] == 0? (arr1[i] = 1) : (arr1[i] = 0);
        }
        System.out.println("canged: " + Arrays.toString(arr1));
        System.out.println("Done!");

    //ex02
        System.out.println("\nex02");
        int[] arr2 = new int[8];
        int coef = 0;
        for (int i = 0; i < 8; i++) {
            arr2[i] = coef;
            coef += 3;
        }
        System.out.print("arr2 is: " + Arrays.toString(arr2));
        System.out.println(" Done!");

    //ex03
        System.out.println("\nex03");
        int[] arr3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("arr3 is: " + Arrays.toString(arr3));
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6)
                arr3[i] *= 2;
        }
        System.out.print("canged:  " + Arrays.toString(arr3));
    }
}
