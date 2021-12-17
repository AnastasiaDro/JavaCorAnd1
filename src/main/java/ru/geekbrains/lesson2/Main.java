package main.java.ru.geekbrains.lesson2;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;


public class Main {

    public static int       getArrSum(int[] arr)
    {
        int res = 0;
        for (int j : arr) {
            res += j;
        }
        return res;
    }

    public static boolean   checkBalance(int[] arr)
    {
        int fSum = 0;   //сумма первого кусочка
        int sSum = getArrSum(arr);   //сумма второго кусочка

        for (int i = 0; i < arr.length - 1; i++) {
            fSum += arr[i];
            sSum -= arr[i];
            if (fSum == sSum)
            {
                System.out.println("sum = " + sSum);
                return true;
            }

        }
        return false;
    }

//****ex07
    //я хотела сделать одну универсальную функцию для сдвигов в обе стороны
    public static void universeShiftArr(int[] arr, int n)
    {
        int remind;
        int mN = Math.abs(n);
        int first = 0;
        int second = arr.length - 1;
        int coef = -1;

        if (n < 0) {
            first = arr.length - 1;
            coef = 1;
            second = 0;
        }
        for (int i = 0; i < mN; i++) {
            remind = arr[second];
            int j = second;
            while (j != first)
            {
                arr[j] = arr[j + coef];
                j+= coef;
            }
            arr[first] = remind;
        }
    }

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
        System.out.println("canged:  " + Arrays.toString(arr1));
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
        System.out.println("arr2 is: " + Arrays.toString(arr2));
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

        //ex05
        //** Задать одномерный массив и найти в нем
        //   минимальный и максимальный элементы (без помощи интернета);
        System.out.println("\n**ex05");
        int min;
        int max;
        int[] arr5 = { 1, 6, 6, -1, -15, 20, 7};
        System.out.println("arr5 = " + Arrays.toString(arr5));
        min = arr5[0];
        max = arr5[0];
        for (int i = 1; i < arr5.length; i++) {
            if (arr5[i] < min)
                min = arr5[i];
            if (arr5[i] > max)
                max = arr5[i];
        }
        System.out.println("min = " + min + "\nmax =  " + max);

        //ex06 - сам метод на строке 19
        //** Написать метод, в который передается не пустой одномерный целочисленный массив,
        //   метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
        //   части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
        //   checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
        //   эти символы в массив не входят.
        System.out.println("\nex06");
        //test1         true (from subject)
        int[] testArr1 = { 2, 2, 2, 1, 2, 2, 10, 1 };
        System.out.println("testArr1 (expected - true): " + Arrays.toString(testArr1));
        System.out.println(checkBalance(testArr1));
        //test2         true (from subject)
        int[] testArr2 = { 1, 1, 1, 2, 1 };
        System.out.println("testArr2 (expected - true): " + Arrays.toString(testArr2));
        System.out.println(checkBalance(testArr2));
        //test3         true (checking validity of extreme values: index 0 and other)
        int[] testArr3 = { 5, 1, 1, 2, 1 }; //
        System.out.println("testArr3 (expected - true): " + Arrays.toString(testArr3));
        System.out.println(checkBalance(testArr3));
        //test4         true (checking validity of extreme values: last index and other)
        int[] testArr4 = { 2, 1, 1, 0, 2, 6 };
        System.out.println("testArr4 (expected - true): " + Arrays.toString(testArr4));
        System.out.println(checkBalance(testArr4));
        //test5         false
        int[] testArr5 = { 2, 1, 1, 8, 8, 6 };
        System.out.println("testArr5 (expected - false): " + Arrays.toString(testArr5));
        System.out.println(checkBalance(testArr5));
        //test6         false
        int[] testArr6 = { 239, 1, 17, 456356738, 8, 6 };
        System.out.println("testArr6 (expected - false): " + Arrays.toString(testArr6));
        System.out.println(checkBalance(testArr6));


        //ex07 - строка 37
        //**** Написать метод, которому на вход подается одномерный массив и число n
        // (может быть положительным, или отрицательным),
        // при этом метод должен сместить все элементы массива на n позиций.
        // Элементы смещаются циклично.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
        // при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.

        //test1
        System.out.println("\nex07   ...it was hard!");
        System.out.println("test1: n = 1\n[1, 2, 3] - > [3, 1, 2]");
        int[] ex07Arr1 = { 1, 2, 3 };
        universeShiftArr(ex07Arr1, 1);
        System.out.println(Arrays.toString(ex07Arr1));

        //test2
        System.out.println("\ntest2: n = -1\n[1, 2, 3] - > [2, 3, 1]");
        int[] ex07Arr2 = { 1, 2, 3 };
        universeShiftArr(ex07Arr2, 2);
        System.out.println(Arrays.toString(ex07Arr2));

        //test3
        System.out.println("\ntest3: n = 3\n[1, 2, 3, 10, 9, 8, 10, 11, 12] - > [10, 11, 12, 1, 2, 3, 10, 9, 8]");
        int[] ex07Arr3 = { 1, 2, 3, 10, 9, 8, 10, 11, 12 };
        universeShiftArr(ex07Arr3, 3);
        System.out.println(Arrays.toString(ex07Arr3));

        //test4
        System.out.println("\ntest4: n = -3\n[1, 2, 3, 10, 9, 8, 10, 11, 12] - > [10, 9, 8, 10, 11, 12, 1, 2, 3]");
        int[] ex07Arr4 = { 1, 2, 3, 10, 9, 8, 10, 11, 12 };
        universeShiftArr(ex07Arr4, -3);
        System.out.println(Arrays.toString(ex07Arr4));
    }
}
