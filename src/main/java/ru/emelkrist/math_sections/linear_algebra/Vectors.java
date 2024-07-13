package ru.emelkrist.math_sections.linear_algebra;

import ru.emelkrist.Calculation;
import ru.emelkrist.math_sections.MathSection;

import java.util.Scanner;

public class Vectors implements MathSection, Calculation {
    private final String name = "Векторы линейной алгебры";
    private float[] vectorA;
    private float[] vectorB;
    private double _aAbs;
    private double _bAbs;
    private double cosL;
    private double scalarProduct;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        init();
        _aAbs = calcVectorAbs(vectorA);
        _bAbs = calcVectorAbs(vectorB);
        cosL = calcCosOfAngle(_aAbs, _bAbs);
        scalarProduct = calcScalarProduct();
        printResult();
    }

    /**
     * Метод для форматированного вывода результатов вычислений в консоль.
     */
    private void printResult() {
        System.out.printf("\nМодуль А = %.2f", _aAbs);
        System.out.printf("\nМодуль B = %.2f", _bAbs);
        System.out.printf("\nКосинус угла = %.2f", cosL);
        System.out.printf("\nСкалярное произведение = %.2f", scalarProduct);
    }

    /**
     * Метод для вычисления скалярного произведения векторов.
     *
     * @return значение скалярного произведения
     */
    private double calcScalarProduct() {
        double product = 0;
        for (int i = 0; i < vectorA.length; i++) {
            product += vectorA[i] * vectorB[i];
        }
        return product;
    }

    /**
     * Метод для вычисления косинуса угла между векторами.
     *
     * @param _aAbs модуль вектора А
     * @param _bAbs модуль вектора B
     * @return значение косинуса угла
     */
    private double calcCosOfAngle(double _aAbs, double _bAbs) {
        double numerator = 0;
        for (int i = 0; i < vectorA.length; i++) {
            numerator += vectorA[i] * vectorB[i];
        }
        double denominator = _aAbs * _bAbs;
        return numerator / denominator;
    }

    /**
     * Метод для вычисления модуля вектора.
     *
     * @param vector вектор
     * @return значение модуля
     */
    private double calcVectorAbs(float[] vector) {
        float _a = 0;
        for (int i = 0; i < vector.length; i++) {
            _a += vector[i] * vector[i];
        }
        return Math.sqrt(_a);
    }

    /**
     * Метод для инициализации входных данных.
     */
    private void init() {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("\nВведите размер векторов: ");
                int vectorsSize = input.nextInt();
                vectorA = new float[vectorsSize];
                vectorB = new float[vectorsSize];
                initVector(vectorA, "A");
                initVector(vectorB, "B");
                break;
            } catch (Exception e) {
                System.out.println("Некорректно введенный размер! Пожалуйста, попробуйте еще раз...");
            }
        }
    }

    /**
     * Метод для инициализации вектора входными данными.
     *
     * @param vector     вектор
     * @param vectorName имя вектора
     */
    private void initVector(float[] vector, String vectorName) {
        System.out.println("Последовательно вводите содержимое вектора " + vectorName + ":");
        Scanner input;
        for (int i = 0; i < vector.length; ) {
            try {
                input = new Scanner(System.in);
                System.out.print(vectorName + "[1" + (i + 1) + "] = ");
                float num = input.nextFloat();
                vector[i] = num;
                i++;
            } catch (Exception e) {
                System.out.println("Число введено некорректно! Попробуйте снова...");
            }
        }
    }
}
