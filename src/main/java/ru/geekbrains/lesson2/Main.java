package main.java.ru.geekbrains.lesson2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
    //Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arr = new int[10];
        //заполним массив случайными числами
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = rand.nextInt(2);
        }
        System.out.print("arr is: ");
        System.out.println(Arrays.toString(arr));
    // using ternar operator
        for (int i = 0; i < 10; i++) {
            arr[i] = arr[i] == 0? (arr[i] = 1) : (arr[i] = 0);
        }
        System.out.print("canged: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("Done!");

    }
}
