package main.java.ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    public static char arr[][];
    static int sizeX;
    static int sizeY;
    static int targetWinSum;
    public static char EMPTY_CHAR = '?';
    public static char USER_CHAR = 'X';
    public static char COMP_CHAR = 'X';
    public static int COORD_X = 0;
    public static int COORD_Y = 1;
    public static int USER_WIN = 1;
    public static int COMP_WIN = 2;
    public static int first = 0; //0 - первым ходит человек, 1 - первым ходит компьютер
    static Random rand;
    public static int winner = -1;

    public static void init() {
        scan = new Scanner(System.in);
        System.out.print("Введите размерность поля x: ");
        sizeX = scan.nextInt();
        System.out.print("Введите размерность поля y: ");
        sizeY = scan.nextInt();
        arr = new char[sizeX][sizeY];
        rand = new Random();
        targetWinSum = sizeX;
    }

    public static void fillArea() {
        System.out.println("Поле готово!");
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                arr[i][j] = EMPTY_CHAR;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printArea() {
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
            COMP_CHAR = '0';
        } else {
            System.out.println("Ты шагаешь вторым! Символ - 0");
            USER_CHAR = '0';
        }
    }

    public static void makeStep(int x, int y, char c) {
        arr[x][y] = c;
        printArea();
    }

    public static void stepToEmpty(int n, int coord, int size) {
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

    public static void makeRandomStep() {
        int x = -1;
        int y = -1;
        do {
            x = rand.nextInt(sizeX);
            y = rand.nextInt(sizeY);
        } while (!checkCoords(x, y));
        makeStep(x, y, COMP_CHAR);
        printArea();
    }

    public static void makeFirstCompStep() {
        int x;
        int y;
        int var = rand.nextInt(2);
        if (var == 0) {
            makeRandomStep();
            return;
        } else {
            if (sizeX % 2 > 0)
                x = sizeX / 2 + 1;
            else {
                x = sizeX / 2;
            }
            if (sizeY % 2 > 0)
                y = sizeY / 2 + 1;
            else {
                y = sizeY / 2;
            }
        }
        makeStep(x, y, COMP_CHAR);
    }


    public static boolean checkCoords(int x, int y) {
        return arr[x][y] == '?';
    }


    public static void makeUserStep() {
        int x;
        int y;

        do {
            System.out.print("Введи x: ");
            x = scan.nextInt();
            System.out.println("Введи y: ");
            y = scan.nextInt();
        } while (!checkCoords(x, y));


        makeStep(x, y, USER_CHAR);
        printArea();
    }

    public static void makeCompStep() {

    }

    public static boolean isWin(char[][] arr) {
        int userSteps = 0;
        int compSteps = 0;

        //проверим все горизонтальные линии
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (arr[i][j] == '?')
                    break;
                if (arr[i][j] == COMP_CHAR)
                    compSteps++;
                else
                    userSteps++;
            }
            if (compSteps == sizeX) {
                winner = COMP_WIN;
                return true;
            }
            if (userSteps == sizeX) {
                winner = USER_WIN;
                return true;
            }
            compSteps = 0;
            userSteps = 0;
        }


        //проверим всё по вертикали
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                if (arr[y][x] == '?')
                    break;
                if (arr[y][x] == USER_CHAR)
                    userSteps++;
                else
                    compSteps++;
            }
            if (userSteps == sizeY) {
                winner = USER_WIN;
                return true;
            }
            if (compSteps == sizeY) {
                winner = COMP_WIN;
                return true;
            }
        }
        return false;
    }




    public static void main(String[] args) {
        init();
        fillArea();
        toss();

        int counter = 0;
        int min = Math.min(sizeX, sizeY);
//        if (COMP_CHAR== 'X') {
//            makeFirstCompStep();
//        }
//        do {
//            makeUserStep();
//            makeCompStep();
//        } while (!isWin());

        char[][] arrtest = { {'X',    '?',   'X'},
                            {'?', '?', '?'},
                            {'?', '?', '?'}};
        System.out.println(isWin(arrtest));

        String results = winner == USER_WIN ? "Ты выиграл! Ура!" : "Искусственный интеллект победил! Восстание машин!";
        System.out.println(results);
    }
}

