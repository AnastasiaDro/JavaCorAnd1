package main.java.ru.geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner         sc;
        StringBuilder   code;
        String          answer;
        int             cycleIter;
        Random          rand;
        int             r;
        char            c;

        rand = new Random();
        sc = new Scanner(System.in);
        //Для экономии памяти, чтобы не создавать каждый раз новую строку
        //Использую StringBuilder
        //Подскажите, уместно ли это тут? Правильное ли использование? Как сделать лучше?
        code = new StringBuilder("###############");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        r    = rand.nextInt(words.length);
        System.out.print("Guess the word game is starting!");
        System.out.println("For exit type: \"EXIT\"");
        System.out.println("The variants:\n\"apple\", \"orange\", \"lemon\", \"banana\",\n\"apricot\", \"avocado\", \"broccoli\", \"carrot\"\n\"cherry\", \"garlic\", \"grape\", \"melon\"\n\"leak\", \"kiwi\", \"mango\", \"mushroom\"\n\"nut\", \"olive\", \"pea\", \"peanut\"\n\"pear\", \"pepper\", \"pineapple\", \"pumpkin\"\n\"potato\"");

        //Так легче проверить код
        System.out.println("DEBUG: " + words[r]);
        while(true) {
            System.out.print("Your answer: ");
            answer = sc.nextLine();
            if (answer.equals(words[r]) || answer.equals("EXIT"))
                break;
            cycleIter = Math.min(answer.length(), words[r].length());
            for (int i = 0; i < cycleIter; i++) {
                c = answer.charAt(i);
                if (c == words[r].charAt(i))
                    code.setCharAt(i, c);
            }
            System.out.println("Current status: " + code);
        }
        System.out.print("YOU ARE WIN!");
        sc.close();
    }
}
