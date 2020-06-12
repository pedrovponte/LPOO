public class FiguraComposta extends Figura implements Countable {
    private Figura[] figuras;

    public FiguraComposta(Figura[] figuras) {
        this.figuras = figuras;
    }

    @Override
    public double getArea() {
        double area = 0;
        for(Figura figura : figuras) {
            area += figura.getArea();
        }
        return area;
    }

    @Override
    public double getPerimetro() {
        double perimetro = 0;
        for(Figura figura : figuras) {
            perimetro += figura.getPerimetro();
        }
        return perimetro;
    }

    @Override
    public int count() {
        return figuras.length;
    }
}
