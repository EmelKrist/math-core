package ru.emelkrist.math_sections.set_theory;

import ru.emelkrist.Calculation;
import ru.emelkrist.math_sections.MathSection;

import java.util.*;

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
                System.out.println("Введите через пробел целые числа множества " + setName + ": ");
                String setData = input.nextLine().trim().replaceAll("\\s{2,}", " ");
                set = parseSetData(setData);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Множества могут состоять только из целых чисел! Пожалуйста, попробуйте еще раз...");
            } catch (Exception e) {
                System.out.println("Некорректно введенные данные! Пожалуйста, попробуйте еще раз...");
            }
        }

        if (set == null) {
            set = Collections.emptyList();
        }

        return set;
    }

    /**
     * Метод для парсинга строковых входных данных множества.
     * @param setData строковые данные множества
     * @return список данных множества
     * @throws NumberFormatException исключение формата данных (если введено что-то, кроме целого числа.
     */
    private List<Integer> parseSetData(String setData) throws NumberFormatException {
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
