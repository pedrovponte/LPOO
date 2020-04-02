package com.aor.refactoring.example2;

public abstract class Shape {

    protected double x;
    protected double y;

    public double getArea() throws Exception {
        throw new Exception("Shape with no type");
    }

    public double getPerimeter() throws Exception {
        throw new Exception("Shape with no type");
    }

    public abstract void draw(GraphicFramework graphics);

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
