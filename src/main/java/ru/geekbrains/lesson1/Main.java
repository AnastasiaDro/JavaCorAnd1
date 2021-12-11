package main.java.ru.geekbrains.lesson1;

public class Main {
//3. part
    public static float floatsCalc(float a, float b, float c, float d)
    {
        return (a * (b + (c / d)));
    }

//4. part
    public static boolean twoDigits(int one, int two)
    {
        int sum = one + two;
        if (sum >= 10 && sum <= 20)
            return true;
        return false;
    }

//5. part
    public static void isPositive(int a)
    {
        if (a >= 0)
            System.out.println("a is positive");
        else
            System.out.println("a is negative");
    }

//6. part
    public static boolean isNegative(int a)
    {
        return a < 0;
    }

//7. part
    public static void helloName(String name)
    {
        System.out.println("Привет, " + name + "!");
    }


//*8. part
    public static void isYearLeap(int y)
    {
        if (y % 4 == 0) {
            if (y % 100 == 0 && y % 400 != 0)
            {
                System.out.println("Not leap");
                return;
            }
            System.out.println("Leap");
            return;
        }
        System.out.println("Not leap");
    }

    public static void main(String[] args) {
//2. part
        byte    by = -128;          // 8 bit
        short   sh = 32767;         // 16 bit
        int     in = 5;             // 32 bit
        long    lo = 9223372036L;   // 64 bit
        float   fl = 23.3f;         // 32 bit
        double  db = 12.6532423;    // 64 bit
        char    ch = 'a';           // 16 bit
        boolean bo = true;          // 32 bit

/* tests */

//3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
//где a, b, c, d – аргументы этого метода, имеющие тип float.

        System.out.println("TESTS 3 - 8");

        System.out.println("\n3-е задание, a * (b + (c / d))");
        System.out.println("2 * (1 + (5 / 2.5)))     " + floatsCalc(2f, 1f, 5f, 2.5f));
        System.out.println("2.3 * (1.1 + (4.6 / 2))) " + floatsCalc(2.3f, 1.1f, 4.6f, 2f));
//4. Написать метод, принимающий на вход два целых числа и проверяющий,
//что их сумма лежит в пределах от 10 до 20 (включительно),
// если да – вернуть true, в противном случае – false.
        System.out.println("\n4-е задание, cумма чисел от 10 до 20");
        System.out.println("числа  10 и 5 " + twoDigits(10, 5));
        System.out.println("числа  20 и 1 " + twoDigits(20, 1));
        System.out.println("числа  3 и 1  " + twoDigits(20, 1));
        System.out.println("числа -1 и 1  " + twoDigits(-1, 1));

//5. Написать метод, которому в качестве параметра передается целое число, метод должен
// напечатать в консоль, положительное ли число передали или отрицательное.
// Замечание: ноль считаем положительным числом.
        System.out.println("\n5-е задание, вывести положительное число");
        System.out.print("число 80  "); isPositive(80);
        System.out.print("число 0   "); isPositive(0);
        System.out.print("число -90 "); isPositive(90);

//6.  Написать метод, которому в качестве параметра передается целое число.
// Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
        System.out.println("\n6-е задание, отрицательно ли число");
        System.out.println("число  6         " + isNegative(6));
        System.out.println("число  0         " + isNegative(0));
        System.out.println("число -35235435 " + isNegative(-35235435));

//7. Написать метод, которому в качестве параметра передается строка,
// обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
        System.out.println("\n7-е задание, вывести привет + имя!");
        helloName("Настя");

//8. Написать метод, который определяет, является ли год високосным, и выводит
// сообщение в консоль.
// Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный
        System.out.println("\n8-е задание, вывести високосные года");
        System.out.print("100  "); isYearLeap(100);
        System.out.print("200  "); isYearLeap(200);
        System.out.print("400  "); isYearLeap(400);  //Високосный
        System.out.print("2021 "); isYearLeap(2021);
        System.out.print("2000 "); isYearLeap(2000); //Високосный
    }
}
