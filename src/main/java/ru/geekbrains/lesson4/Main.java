package main.java.ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    static char arr[][];
    static int sizeX;
    static int sizeY;
    public static char EMPTY_CHAR = '?';
    public static char USER_CHAR = 'X';
    public static char COMP_CHAR = 'X';
    public static int COORD_X = 0;
    public static int COORD_Y = 1;
    public static int USER_WIN = 1;
    public static int COMP_WIN = 2;
    public static int first = 0; //0 - первым ходит человек, 1 - первым ходит компьютер
    static Random rand;
    public static int winner;

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

    public static void printArea()
    {
        System.out.println("Поле: ");
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void toss() { //жеребьёвка
        first = rand.nextInt(2);
        if (first == 0) {
            System.out.println("Ты шагаешь первым! Символ - X");
            COMP_CHAR = 'Y';
        } else {
            System.out.println("Ты шагаешь вторым! Символ - 0");
            USER_CHAR = 'Y';
        }
    }

    public static void makeStep(int x, int y, char c) {
        arr[x][y] = c;
        printArea();
    }

    public static void stepToEmpty(int n, int coord, int size)
    {
        int f = 0;
        int s = 0;
        if (coord == COORD_Y)
            s = n;
        else
            f = n;

        while (f < size) {
            if (arr[f][s] == '?')
                makeStep(f, n, COMP_CHAR);
            f++;
        }
    }

    public static void makeRandomStep()
    {
        int x = rand.nextInt(sizeX);
        int y = rand.nextInt(sizeY);
        makeStep(x, y, COMP_CHAR);
    }

    public static void compStep() {
        int winSumX = 0;
        int winSumY = 0;
        int winSumD1 = 0; //диагональ 1
        int winSumD2 = 0; //диагональ 2
        //check horizontal lines and diagonals
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                if (arr[x][y] == 'X')
                {
                    winSumX++;
                    if (x == y)
                        winSumD1++;
                    if (x + y == 4)
                        winSumD2++;
                }
            }
            if (winSumX == 4 || winSumD1 == 4 || winSumD2 == 4) {
                stepToEmpty(y, COORD_Y, sizeX);
                return;
            }
            winSumX = 0;
        }
        //check vertical lines
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                if (arr[x][y] == 'X')
                    winSumY++;
            }
                if (winSumY == 4) {
                    stepToEmpty(x, COORD_X, sizeY);
                    return;
                }
                if (winSumY == sizeY)
                {
                    stepToEmpty(x, COORD_X, sizeY);
                    return;
                }
                winSumY = 0;
        }
        makeRandomStep();
    }

    public static void makeUserStep()
    {
        int x;
        int y;
        while (true) {
            System.out.print("Введите x: ");
            x = scan.nextInt(sizeX);
            System.out.print("Введите y: ");
            y = scan.nextInt(sizeY);
            if (arr[x][y] == EMPTY_CHAR) {
                makeStep(x, y, USER_CHAR);
                break;
            } else {
                System.out.println("Позиция занята! Выберите другую!");
            }
        }
    }
    
    public static boolean checkWin()
    {
        int winSumXU = 0;
        int winSumYU = 0;
        int winSumD1U = 0; //диагональ 1
        int winSumD2U = 0; //диагональ 2

        int winSumXcomp = 0;
        int winSumYcomp = 0;
        int winSumD1comp = 0; //диагональ 1
        int winSumD2comp = 0; //диагональ 2
        //check horizontal lines and diagonals
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                if (arr[x][y] == 'X')
                {
                    winSumXU++;
                    if (x == y)
                        winSumD1U++;
                    if (x + y == 4)
                        winSumD2U++;
                }
                if (arr[x][y] == 'Y')
                {
                    winSumXcomp++;
                    if (x == y)
                        winSumD1comp++;
                    if (x + y == 4)
                        winSumD2comp++;
                }
            }
            if (winSumXU == 5 || winSumD1U == 5 || winSumD2U == 5) {
                winner = USER_WIN;
                return true;
            }
            winSumXU = 0;
            winSumXcomp = 0;
        }
        //check vertical lines
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                if (arr[x][y] == 'X')
                    winSumYU++;
                if (arr[x][y] == 'Y')
                    winSumYcomp++;
            }
            if (winSumYU == 5) {
                winner = USER_WIN;
                return true;
            }
            if (winSumYcomp == 5)
            {
                winner = COMP_WIN;
                return true;
            }
            winSumYU = 0;
            winSumYcomp = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        init();
        fillArea();
        toss();

        int counter = 0;
        int min = Math.min(sizeX, sizeY);
        if (COMP_CHAR== 'X') {
            makeRandomStep();
            printArea();
        }
        while (true) {
            makeUserStep();
            if (counter < min)
                makeRandomStep();
            else
                compStep();
            printArea();
            counter++;
            if (counter < min)
                continue;
            if (checkWin())
                break;
        }
        String results = winner == USER_WIN ? "Ты выиграл! Ура!" : "Искусственный интеллект победил! Восстание машин!";
        System.out.println(results);
    }
}
