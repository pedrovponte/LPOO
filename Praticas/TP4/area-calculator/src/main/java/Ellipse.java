public class Ellipse implements Shape {
    private double x_radius;
    private double y_radius;

    public Ellipse(double x_radius, double y_radius) {
        this.x_radius = x_radius;
        this.y_radius = y_radius;

    }

    public double getX_radius() {
        return this.x_radius;
    }

    public double getY_radius() {
        return this.y_radius;
    }

    public void setX_radius(double radius) {
        this.x_radius = radius;
    }

    public void setY_radius(double radius) {
        this.y_radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * this.getX_radius() * this.getY_radius();
    }

    @Override
    public void draw() {
        System.out.println("Elipse");
    }
}
