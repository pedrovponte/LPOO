public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea(){
        return Math.pow(this.getSide(), 2);
    }

    @Override
    public void draw() {
        System.out.println("Square");
    }
}
