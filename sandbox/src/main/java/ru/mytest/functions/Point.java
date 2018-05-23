package ru.mytest.functions;

public class Point {

    public double x;
    public double y;

    public double distance() {
        return Math.sqrt((p2.x-this.x)*(p2.x-this.x) + (p2.y-this.y)*(p2.y-this.y));
    }
}
