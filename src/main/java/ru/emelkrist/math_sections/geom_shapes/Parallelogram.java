package ru.emelkrist.math_sections.geom_shapes;

import java.util.Scanner;

public class Parallelogram extends Shape {

    private double sideA;
    private double sideB;
    private double height;

    public Parallelogram() {
        super("Параллелограмм");
    }

    public Parallelogram(double sideA, double sideB, double height) {
        super("Параллелограмм");
        this.sideA = sideA;
        this.sideB = sideB;
        this.height = height;
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
                System.out.print("Введите высоту: ");
                this.height = input.nextDouble();
                return;
            } catch (Exception e) {
                System.out.println("Некорректно введенные данные! Пожалуйста, попробуйте еще раз...");
            }
        }
    }

    @Override
    public void printResult() {
        System.out.printf("\nПериметр параллелограмма: %.2f", calcPerimeter());
        System.out.printf("\nПлощадь параллелограмма: %.2f", calcArea());
    }

    @Override
    public double calcPerimeter() {
        return (sideA + sideB) * 2;
    }

    @Override
    public double calcArea() {
        return sideA * height;
    }
}
