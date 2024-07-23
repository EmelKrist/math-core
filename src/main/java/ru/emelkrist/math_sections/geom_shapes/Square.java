package ru.emelkrist.math_sections.geom_shapes;

import java.util.Scanner;

public class Square extends Shape {
    private double side;

    public Square() {
        super("Квадрат");
    }

    public Square(double side) {
        super("Квадрат");
        this.side = side;
    }

    @Override
    public void init() {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("\nВведите сторону: ");
                this.side = input.nextDouble();
                return;
            } catch (Exception e) {
                System.out.println("Некорректно введенные данные! Пожалуйста, попробуйте еще раз...");
            }
        }
    }

    @Override
    public double calcPerimeter() {
        return 4 * side;
    }

    @Override
    public double calcArea() {
        return side * side;
    }

    @Override
    public double calcDiagonal() {
        return Math.sqrt(2) * side;
    }

    @Override
    public void printResult() {
        System.out.printf("\nПериметр квадрата: %.2f", calcPerimeter());
        System.out.printf("\nПлощадь квадрата: %.2f", calcArea());
        System.out.printf("\nДиагональ квадрата: %.2f", calcDiagonal());
    }
}
