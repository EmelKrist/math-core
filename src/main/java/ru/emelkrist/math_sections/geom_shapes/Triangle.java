package ru.emelkrist.math_sections.geom_shapes;

import java.util.Scanner;

public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private double angleDegrees;

    public Triangle() {
        super("Треугольник");
    }

    public Triangle(double sideA, double sideB, double angleDegrees) {
        super("Треугольник");
        this.sideA = sideA;
        this.sideB = sideB;
        this.angleDegrees = angleDegrees;
        this.sideC = calcSideC();
    }

    @Override
    public void init() {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("\nВведите сторону А: ");
                this.sideA = input.nextDouble();
                System.out.print("Введите сторону B: ");
                this.sideB = input.nextDouble();
                System.out.print("Введите угол между ними (градусы): ");
                this.angleDegrees = input.nextDouble();
                this.sideC = calcSideC();
                return;
            } catch (Exception e) {
                System.out.println("Некорректно введенные данные! Пожалуйста, попробуйте еще раз...");
            }
        }
    }

    @Override
    public void printResult() {
        System.out.printf("\nСторона С: %.2f", sideC);
        System.out.printf("\nПериметр треугольника: %.2f", calcPerimeter());
        System.out.printf("\nПлощадь треугольника: %.2f", calcArea());
    }

    private double calcSideC() {
        double angleRadians = Math.toRadians(angleDegrees);
        double c = Math.sqrt(sideA * sideA + sideB * sideB
                - 2 * sideA * sideB * Math.cos(angleRadians));
        return c;
    }

    @Override
    public double calcPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calcArea() {
        double angleRadians = Math.toRadians(angleDegrees);
        double S = 0.5 * sideA * sideB * Math.sin(angleRadians);
        return S;
    }
}
