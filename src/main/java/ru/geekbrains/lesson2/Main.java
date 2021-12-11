package main.java.ru.geekbrains.lesson2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //ex01
        //Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arr1 = new int[10];
        Random rand = new Random();

        System.out.println("ex01");
        //заполним массив случайными числами
        for (int i = 0; i < 10; i++) {
            arr1[i] = rand.nextInt(2);
        }
        System.out.println("arr1 is: " + Arrays.toString(arr1));
        //Хочу попробовать тернарный оператор
        for (int i = 0; i < 10; i++) {
            arr1[i] = arr1[i] == 0 ? (arr1[i] = 1) : (arr1[i] = 0);
        }
        System.out.println("canged: " + Arrays.toString(arr1));
        System.out.println("Done!");

        //ex02
        //Задать пустой целочисленный массив размером 8.
        //С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
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
        //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        // пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("\nex03");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("arr3 is: " + Arrays.toString(arr3));
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6)
                arr3[i] *= 2;
        }
        System.out.print("canged:  " + Arrays.toString(arr3));


        //ex04
        //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

        System.out.println("\nex04");
        int[][] squareArr = new int[9][9];
        //заполним массив и сразу при переборе будем ставить единицы
        //и печатать сразу, чтобы не вызывать отдельно потом перебором
        for (int i = 0; i < squareArr.length; i++) {
            for (int j = 0; j < squareArr.length; j++) {
                if ((i == j) || (i + j == squareArr.length - 1))
                    squareArr[i][j] = 1;
                else
                    squareArr[i][j] = rand.nextInt(7) + 2; //for not 1 values
            }
            System.out.println(Arrays.toString(squareArr[i]));
        }
    }
}
