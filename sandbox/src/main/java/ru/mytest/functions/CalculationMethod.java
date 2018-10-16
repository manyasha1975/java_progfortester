package ru.mytest.functions;

public class CalculationMethod {
    public static void main (String[] args) {
        Point p = new Point(10.0, 5.0, 25.0, 1.0);
        System.out.println("Расстояние между точками с координатами " + "(" + p.x1 + "," + p.y1 + ") и (" + p.x2 + "," + p.y2 + ") равно = " + p.distance());

    }

}
