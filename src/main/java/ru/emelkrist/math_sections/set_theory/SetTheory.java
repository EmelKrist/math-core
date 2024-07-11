package ru.emelkrist.math_sections.set_theory;

import ru.emelkrist.Calculation;
import ru.emelkrist.math_sections.MathSection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTheory implements MathSection, Calculation {
    private final String name = "Теория множеств";
    private final List<MathSet> sets = new ArrayList<>();

    /**
     * Метод для инициализации входных данных.
     */
    public void init() {
        List<Integer> setA = initSet("A");
        List<Integer> setB = initSet("B");

        sets.add(new Difference(setA, setB));
        sets.add(new Intersection(setA, setB));
        sets.add(new Union(setA, setB));
        sets.add(new SymmetricalDifference(setA, setB));
    }

    /**
     * Метод для инициализации множества.
     *
     * @param setName название множества
     * @return данные множества
     */
    private List<Integer> initSet(String setName) {
        List<Integer> set = null;
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Введите через пробел числа множества " + setName + ": ");
                String setData = input.nextLine().trim();
                set = parseSetData(setData);
                break;
            } catch (Exception e) {
                System.out.println("Некорректно введенные данные! Пожалуйста, попробуйте еще раз...");
            }
        }
        return set;
    }

    /**
     * Метод для парсинга строковых входных данных множества.
     * @param setData строковые данные множества
     * @return список данных множества
     */
    private List<Integer> parseSetData(String setData) {
        // todo обработку исключений
        return Arrays.stream(setData.split(" ")).map(Integer::valueOf).toList();
    }

    @Override
    public void run() {
        init();
        for (int i = 0; i < 4; i++) {
            MathSet set = sets.get(i);
            new Thread(() -> {
                set.find();
                set.printResult();
            }).start();
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
