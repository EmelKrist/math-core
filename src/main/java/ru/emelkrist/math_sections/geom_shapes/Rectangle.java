package ru.emelkrist.math_sections.geom_shapes;

import java.util.Scanner;

public class Rectangle extends Shape {

    private double sideA;
    private double sideB;

    public Rectangle() {
        super("Прямоугольник");
    }

    public Rectangle(double sideA, double sideB) {
        super("Прямоугольник");
        this.sideA = sideA;
        this.sideB = sideB;
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
                return;
            } catch (Exception e) {
                System.out.println("Некорректно введенные данные! Пожалуйста, попробуйте еще раз...");
            }
        }
    }

    @Override
    public double calcPerimeter() {
        return sideA * 2 + sideB * 2;
    }

    @Override
    public double calcArea() {
        return sideA * sideB;
    }

    public double calcDiagonal() {
        return Math.sqrt(sideA * sideA + sideB * sideB);
    }

    @Override
    public void printResult() {
        System.out.printf("\nПериметр прямоугольника: %.2f", calcPerimeter());
        System.out.printf("\nПлощадь прямоугольника: %.2f", calcArea());
        System.out.printf("\nДиагональ прямоугольника: %.2f", calcDiagonal());
    }
}
