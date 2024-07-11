package ru.emelkrist;

import ru.emelkrist.math_problems.DiningPhilosophers;
import ru.emelkrist.math_problems.Solable;
import ru.emelkrist.math_sections.MathSection;
import ru.emelkrist.math_sections.set_theory.SetTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private List<Solable> problems = new ArrayList<>();
    private List<MathSection> mathSections = new ArrayList<>();

    {
        problems.add(new DiningPhilosophers());
    }

    {
        mathSections.add(new SetTheory());
    }

    /**
     * Метод для управления вводом входных данных.
     */
    public void manageInput() {
        Scanner input;
        boolean inProgress = true;
        while (inProgress) {
            input = new Scanner(System.in);
            System.out.println("\nВыберите задачу для решения:");
            System.out.println("1. Решить математическую проблему;");
            System.out.println("2. Выполнить вычисления;");
            System.out.println("3. Выход.");
            System.out.print("Пункт меню: ");
            try {
                int taskNum = input.nextInt();
                switch (taskNum) {
                    case 1 -> {
                        solveProblem();
                        inProgress = false;
                    }
                    case 2 -> {
                        runMathSection();
                        inProgress = false;
                    }
                    case 3 -> {
                        System.out.println("Работа программы завершена.");
                        System.exit(0);
                    }
                    default -> System.out.println("Такого пункта меню нет! Пожалуйста, попробуйте еще раз...");
                }
            } catch (Exception e) {
                System.out.println("Введенный пункт меню должен быть просто числом без пробелов и других символов! " +
                        "\nПожалуйста, попробуйте еще раз...");
            }
        }
    }

    /**
     * Метод для решения математической проблемы,
     * указанной пользователем.
     */
    private void solveProblem() {
        Scanner input;
        while (true) {
            input = new Scanner(System.in);
            try {
                System.out.println("\nСписок доступных математических проблем: ");
                printCalculation(problems);
                System.out.print("Пункт меню: ");
                int problemNum = input.nextInt();
                Solable problem = problems.get(problemNum - 1);
                problem.solve();
                break;
            } catch (ClassCastException e) {
                System.out.println("Ошибка работы раздела!");
                break;
            } catch (Exception e) {
                System.out.println("Некорректно введенные данные! Пожалуйста, попробуйте еще раз...");
            }
        }
    }

    /**
     * Метод для запуска выполнения вычислений математической секции,
     * указанной пользователем.
     */
    private void runMathSection() {
        Scanner input;
        while (true) {
            input = new Scanner(System.in);
            try {
                System.out.println("\nСписок доступных вычислений: ");
                printCalculation(mathSections);
                System.out.print("Пункт меню: ");
                int sectionNum = input.nextInt();
                MathSection section = mathSections.get(sectionNum - 1);
                section.run();
                break;
            } catch (ClassCastException e) {
                System.out.println("Ошибка работы раздела!");
                break;
            } catch (Exception e) {
                System.out.println("Некорректно введенные данные! Пожалуйста, попробуйте еще раз...");
            }
        }
    }

    /**
     * Универсальный метод для вывода списка типа вычислительных задач,
     * выбранных пользователем.
     *
     * @param inputCalculations список задач.
     * @throws ClassCastException ошибка приведения.
     */
    private void printCalculation(List<?> inputCalculations) throws ClassCastException {
        List<Calculation> calculations = (List<Calculation>) inputCalculations;
        int i = 1;
        for (Calculation calculation : calculations) {
            System.out.println(i + ". " + calculation.getName());
        }
    }
}
