package ru.emelkrist.math_sections.set_theory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Пересечение
 */
public class Intersection extends MathSet {

    public Intersection(List<Integer> setA, List<Integer> setB) {
        super(setA, setB);
    }

    @Override
    public void find() {
        setResult = setA.stream()
                .filter(setB::contains)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public void printResult() {
        System.out.println("Пересечение множеств: ");
        super.printResult();
    }
}
