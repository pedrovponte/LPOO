package com.aor.refactoring.example2;

public class Circle extends Shape {
    private double radius;

    public Circle(double x, double y,double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }

    public void draw(GraphicFramework graphics){
        graphics.drawCircle(x, y, radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
