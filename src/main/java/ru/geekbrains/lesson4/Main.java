package main.java.ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    static char arr[][];
    static int sizeX;
    static int sizeY;
    public static char EMPTY_CHAR = '?';
    public static int USER_CHAR = 'U';
    public static int COMP_CHAR = 'C';
    public static int first = 0; //0 - первым ходит человек, 1 - первым ходит компьютер
    static Random rand;

    public static void init()
    {
        scan = new Scanner(System.in);
        System.out.print("Введите размерность поля x: ");
        sizeX = scan.nextInt();
        System.out.print("Введите размерность поля y: ");
        sizeY = scan.nextInt();
        arr = new char[sizeX][sizeY];
        rand = new Random();
    }

    public static void fillArea()
    {
        System.out.println("Поле готово!");
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                arr[i][j] = EMPTY_CHAR;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void toss() { //жеребьёвка

    }


    public static void main(String[] args) {
        init();
        fillArea();

    }
}
