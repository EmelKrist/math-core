package ru.emelkrist.math_sections.geom_shapes;

import ru.emelkrist.Calculation;
import ru.emelkrist.math_sections.MathSection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeomShapes implements MathSection, Calculation {

    private final String name = "Геометрические фигуры";

    private List<Shape> shapes = new ArrayList<>();

    {
        shapes.add(new Circle());
        shapes.add(new Parallelogram());
        shapes.add(new Rectangle());
        shapes.add(new Square());
        shapes.add(new Triangle());
    }

    @Override
    public void run() {
        initShape();
    }

    private void initShape() {
        while (true) {
            try {
                System.out.println("\nВыберите фигуру:");
                printShapes();
                Scanner input = new Scanner(System.in);
                System.out.print("Пункт меню: ");
                int shapeNum = input.nextInt();
                Shape shape = shapes.get(shapeNum - 1);
                shape.init();
                shape.printResult();
                return;
            } catch (Exception e) {
                System.out.println("Некорректно введенный номер пункта! Пожалуйста, попробуйте еще раз...");
            }
        }
    }

    private void printShapes() {
        int i = 1;
        for (Shape shape : shapes) {
            System.out.println(i + ". " + shape.getName() + ".");
            i++;
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
