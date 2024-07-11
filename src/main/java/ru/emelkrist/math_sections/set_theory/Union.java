package ru.emelkrist.math_sections.set_theory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Объединение
 */
public class Union extends MathSet {

    public Union(List<Integer> setA, List<Integer> setB) {
        super(setA, setB);
    }

    @Override
    public void find() {
        Set<Integer> unionSet = new HashSet<>();
        unionSet.addAll(new HashSet<>(setA));
        unionSet.addAll(new HashSet<>(setB));
        setResult = unionSet.stream().toList();
    }

    @Override
    public void printResult() {
        System.out.println("Объединение множеств: ");
        super.printResult();
    }
}
