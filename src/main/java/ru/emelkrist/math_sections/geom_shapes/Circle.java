package ru.emelkrist.math_sections.geom_shapes;

import java.util.Scanner;

public class Circle extends Shape {

    private double radius;

    public Circle() {
        super("Круг");
    }

    public Circle(double radius) {
        super("Круг");
        this.radius = radius;
    }

    @Override
    public void init() {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("\nВведите радиус круга: ");
                this.radius = input.nextDouble();
                return;
            } catch (Exception e) {
                System.out.println("Некорректно введенные данные! Пожалуйста, попробуйте еще раз...");
            }
        }
    }

    @Override
    public void printResult() {
        System.out.printf("\nПериметр круга: %.2f", calcPerimeter());
        System.out.printf("\nПлощадь круга: %.2f",calcArea());
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }
}
