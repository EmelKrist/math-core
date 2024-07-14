package ru.emelkrist.math_sections.linear_algebra;

import ru.emelkrist.Calculation;
import ru.emelkrist.math_sections.MathSection;

import java.util.Arrays;
import java.util.Scanner;

public class Vectors implements MathSection, Calculation {
    private final String name = "Векторы линейной алгебры";
    private float[] vectorA;
    private float[] vectorB;
    private double _aAbs;
    private double _bAbs;
    private double cosL;
    private double scalarProduct;
    private double[] vectorProduct;

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
        vectorProduct = calcVectorProduct();
        printResult();
    }

    /**
     * Метод для вычисления векторного произведения.
     *
     * @return вектор векторного произведения
     */
    private double[] calcVectorProduct() {
        try {
            if (vectorA.length != 3) return null;
            vectorProduct = new double[3];
            double x = vectorA[1] * vectorB[2] - vectorA[2] * vectorB[1];
            vectorProduct[0] = x;
            double y = vectorA[2] * vectorB[0] - vectorA[0] * vectorB[2];
            vectorProduct[1] = y;
            double z = vectorA[0] * vectorB[1] - vectorA[1] * vectorB[0];
            vectorProduct[2] = z;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vectorProduct;
    }

    /**
     * Метод для форматированного вывода результатов вычислений в консоль.
     */
    private void printResult() {
        System.out.printf("\nМодуль А = %.2f", _aAbs);
        System.out.printf("\nМодуль B = %.2f", _bAbs);
        System.out.printf("\nКосинус угла = %.2f", cosL);
        System.out.printf("\nСкалярное произведение = %.2f", scalarProduct);
        if (vectorProduct == null) {
            System.out.println("\nДля вычисления векторного произведения вектора должны иметь размер 3.");
            return;
        }
        System.out.println("\nВекторное произведение = " + Arrays.toString(vectorProduct));
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
