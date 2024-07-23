package ru.emelkrist.math_sections.geom_shapes;

import ru.emelkrist.Calculation;

public abstract class Shape{
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double calcPerimeter();

    public abstract double calcArea();

    public abstract void init();

    public double calcDiagonal() {
        return -1;
    }

    public abstract void printResult();

    public String getName() {
        return name;
    }
}
