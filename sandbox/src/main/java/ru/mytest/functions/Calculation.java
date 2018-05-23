package ru.mytest.functions;

public class Calculation {
    public static void main (String[] args) {
        Point p1 = new Point();
        p1.x = 5.0;
        p1.y = 5.0;
        Point p2 = new Point();
        p2.x = 2.0;
        p2.y = 1.0;
        System.out.println("Расстояние между точками с координатами " + "(" + p1.x + "," + p1.y + ") и (" + p2.x + "," + p2.y + ") равно = " + distance(p1, p2));

    }

}
