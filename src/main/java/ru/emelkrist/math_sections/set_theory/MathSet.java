package ru.emelkrist.math_sections.set_theory;

import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактный класс математического множества.
 */
public abstract class MathSet {
    protected List<Integer> setA;
    protected List<Integer> setB;
    protected List<Integer> setResult;

    public MathSet(List<Integer> setA, List<Integer> setB) {
        this.setA = setA;
        this.setB = setB;
    }

    public abstract void find();
    public void printResult() {
        System.out.println(setResult);
    }
}
