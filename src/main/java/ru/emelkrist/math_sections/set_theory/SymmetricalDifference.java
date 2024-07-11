package ru.emelkrist.math_sections.set_theory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Симметричная разность
 */
public class SymmetricalDifference extends MathSet {

    public SymmetricalDifference(List<Integer> setA, List<Integer> setB) {
        super(setA, setB);
    }

    @Override
    public void find() {
        // находим общие элементы
        Set<Integer> commonElements = new HashSet<>(setA);
        commonElements.retainAll(setB);

        Set<Integer> uniqueToA = new HashSet<>(setA);
        uniqueToA.removeAll(commonElements);

        Set<Integer> uniqueToB = new HashSet<>(setB);
        uniqueToB.removeAll(commonElements);

        setResult = new ArrayList<>();
        setResult.addAll(uniqueToA);
        setResult.addAll(uniqueToB);
    }

    @Override
    public void printResult() {
        System.out.println("Симметричная разность множеств: ");
        super.printResult();
    }
}
