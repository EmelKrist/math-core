package ru.emelkrist;

import ru.emelkrist.math_problems.DiningPhilosophers;
import ru.emelkrist.math_problems.Solable;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Solable> problems = new ArrayList<>();

    static {
        problems.add(new DiningPhilosophers());
    }

    public static void main(String[] args) {
        System.out.println("Выберите задачу для решения.");
        printProblems();
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Номер задачи: ");
                int num = input.nextInt();
                Solable problem = problems.get(num - 1);
                problem.solve();
                break;
            } catch (Exception e) {
                System.out.println("Некорректно введенные данные! Пожалуйста, попробуйте еще раз...");
            }
        }
    }

    private static void printProblems() {
        int i = 1;
        for (Solable problem : problems) {
            System.out.println(i + "." + problem.getProblemName());
        }
    }
}