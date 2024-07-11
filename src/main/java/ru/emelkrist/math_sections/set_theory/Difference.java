package ru.emelkrist.math_sections.set_theory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Разность
 */
public class Difference extends MathSet {

    public Difference(List<Integer> setA, List<Integer> setB) {
        super(setA, setB);
    }

    @Override
    public void find() {
        setResult = setA.stream().filter(element -> !setB.contains(element)).distinct().collect(Collectors.toList());
    }

    @Override
    public void printResult() {
        System.out.println("Разность множеств: ");
        super.printResult();
    }
}
